package org.acme.builder;

import org.eclipse.microprofile.config.inject.ConfigProperty;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.jackson.JacksonDataFormat;
import org.apache.camel.dataformat.bindy.fixed.BindyFixedLengthDataFormat;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import org.acme.bean.RespuestaToken;
import org.acme.bean.Respuesta;
import org.acme.processor.ValidationProcessor;
import org.acme.processor.ValidationProcessor2;
import org.acme.processor.ValidationProcessor3;
import org.acme.bindy.ftp.Header;
import org.acme.bindy.ftp.HeaderConsulta;
import org.acme.interfaces.IjwtConfig;

@ApplicationScoped
public class ValidationRouteBuilder extends RouteBuilder {

    private JacksonDataFormat formatRpta = new JacksonDataFormat(Respuesta.class);
    private JacksonDataFormat formatToken = new JacksonDataFormat(RespuestaToken.class);
    private BindyFixedLengthDataFormat camelDataFormat = new BindyFixedLengthDataFormat(Header.class);
    private BindyFixedLengthDataFormat camelDataFormat2 = new BindyFixedLengthDataFormat(HeaderConsulta.class);
    //private BindyFixedLengthDataFormat camelDataFormatToken = new JacksonDataFormat(RespuestaToken.class);
    
    @ConfigProperty(name = "app.jms.queue-start")
    private String queue_in;

    @ConfigProperty(name = "app.jms.queue-validated")
    private String queue_out;

    @ConfigProperty(name = "app.jms.queue-processed")
    private String queue_out_end;

    @Inject
    IjwtConfig jwtConfig;


    @Override
    public void configure() throws Exception {

        System.out.println("=====INICIO VALIDATION COLA");  
        System.out.println(jwtConfig.getSecretKey()); 

        from(String.format("jms:queue:%s",queue_in))
            .log("Received a message - ${body} - sending to First validation")
            .process(new ValidationProcessor2())
            .choice()
                .when(body().isInstanceOf(Respuesta.class))
                    .marshal(formatRpta)
                    .to(String.format("jms:queue:%s",queue_out_end))
                .otherwise()
                    .log("Received a message - ${body} - sending to Second validation")
                    .unmarshal(camelDataFormat) 
                    .process(new ValidationProcessor(jwtConfig))
                    .choice()
                        .when(body().isInstanceOf(Respuesta.class))
                            .log("Received a message - ${body} - sending to End")
                            .marshal(formatRpta)
                            .to(String.format("jms:queue:%s",queue_out_end))
                        .otherwise()
                            .log("Received a message - ${body} - sending to Processed")
                            //.marshal(camelDataFormat2)
                            //.marshal(formatRpta)
                            //.marshal(formatToken)
                            //.marshal(formatToken)
                            .unmarshal(camelDataFormat2)
                            .process(new ValidationProcessor3())
                            .marshal(formatToken)
                            .to(String.format("jms:queue:%s",queue_out))
                    .endChoice()
            .endChoice()
            ;


    }

}
