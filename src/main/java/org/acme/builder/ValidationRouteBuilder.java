package org.acme.builder;

import org.eclipse.microprofile.config.inject.ConfigProperty;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.jackson.JacksonDataFormat;
import org.apache.camel.dataformat.bindy.fixed.BindyFixedLengthDataFormat;

import jakarta.enterprise.context.ApplicationScoped;

import org.acme.bean.Respuesta2;
import org.acme.bean.Respuesta;
import org.acme.processor.ValidationProcessor;
import org.acme.processor.ValidationProcessor2;
import org.acme.processor.ValidationProcessor3;
import org.acme.bindy.ftp.Header;
import org.acme.bindy.ftp.HeaderConsulta;

@ApplicationScoped
public class ValidationRouteBuilder extends RouteBuilder {

    private JacksonDataFormat formatRpta = new JacksonDataFormat(Respuesta.class);
    private JacksonDataFormat format2 = new JacksonDataFormat(Respuesta2.class);
    private BindyFixedLengthDataFormat camelDataFormat = new BindyFixedLengthDataFormat(Header.class);
    private BindyFixedLengthDataFormat camelDataFormat2 = new BindyFixedLengthDataFormat(HeaderConsulta.class);
    
    @ConfigProperty(name = "app.jms.queue-start")
    private String queue_in;

    @ConfigProperty(name = "app.jms.queue-processed")
    private String queue_out_end;

     @ConfigProperty(name = "app.camel.rest.route.get-info")
    private String route_get_info;

    @Override
    public void configure() throws Exception {

        System.out.println("=====GET INFOR VALIDATORXXX2");  

        from(String.format("jms:queue:%s?transacted=false",queue_in))
            .log("Received a message - ${body} - sending to First validation")
            .process(new ValidationProcessor2())
            .choice()
                .when(body().isInstanceOf(Respuesta.class))
                    .marshal(formatRpta)
                    .to(String.format("jms:queue:%s",queue_out_end))
                .otherwise()
                    .log("Received a message - ${body} - sending to Second validation")
                    .unmarshal(camelDataFormat) 
                    .process(new ValidationProcessor())
                    .choice()
                        .when(body().isInstanceOf(Respuesta.class))
                            .log("Received a message - ${body} - sending to End")
                            .marshal(formatRpta)
                            .to(String.format("jms:queue:%s",queue_out_end))
                        .otherwise()
                            .log("Received a message - ${body} - sending to Processed")
                            .unmarshal(camelDataFormat2)
                            .process(new ValidationProcessor3())
                            .marshal(format2)
                            .to(route_get_info)
                    .endChoice()
            .endChoice()
            ;

    }

}