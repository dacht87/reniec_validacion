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
import io.quarkus.logging.Log;

@ApplicationScoped
public class ValidationRouteBuilder extends RouteBuilder {

    private JacksonDataFormat formatRpta = new JacksonDataFormat(Respuesta.class);
    private JacksonDataFormat format2 = new JacksonDataFormat(Respuesta2.class);
    private BindyFixedLengthDataFormat camelDataFormat = new BindyFixedLengthDataFormat(Header.class);
    private BindyFixedLengthDataFormat camelDataFormat2 = new BindyFixedLengthDataFormat(HeaderConsulta.class);
    
    @ConfigProperty(name = "app.jms.queue-start")
    private String queueIn;

    @ConfigProperty(name = "app.jms.queue-processed")
    private String queueOutEnd;

     @ConfigProperty(name = "app.camel.rest.route.get-info")
    private String routeGetInfo;

    @Override
    public void configure() throws Exception {

        Log.info("=====GET INFOR VALIDATORXXX2");  

        from(String.format("jms:queue:%s?concurrentConsumers=50",queueIn))
            .log("Received a message - ${body} - sending to First validation")
            .process(new ValidationProcessor2())
            .choice()
                .when(body().isInstanceOf(Respuesta.class))
                    .marshal(formatRpta)
                    .to(String.format("jms:queue:%s",queueOutEnd))
                .otherwise()
                    .log("Received a message - ${body} - sending to Second validation")
                    .unmarshal(camelDataFormat) 
                    .process(new ValidationProcessor())
                    .choice()
                        .when(body().isInstanceOf(Respuesta.class))
                            .log("Received a message - ${body} - sending to End")
                            .marshal(formatRpta)
                            .to(String.format("jms:queue:%s",queueOutEnd))
                        .otherwise()
                            .log("Received a message - ${body} - sending to Processed")
                            .unmarshal(camelDataFormat2)
                            .process(new ValidationProcessor3())
                            .marshal(format2)
                            .to(routeGetInfo)
                    .endChoice()
            .endChoice()
            ;

    }

}