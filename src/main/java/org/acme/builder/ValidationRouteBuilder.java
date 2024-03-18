package org.acme.builder;

import org.eclipse.microprofile.config.inject.ConfigProperty;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.jackson.JacksonDataFormat;
import org.apache.camel.dataformat.bindy.fixed.BindyFixedLengthDataFormat;
import org.apache.log4j.Logger;

import jakarta.enterprise.context.ApplicationScoped;

import org.acme.bean.Respuesta2;
import org.acme.bean.Respuesta4;
import org.acme.bean.Respuesta1;
import org.acme.processor.ValidationProcessor;
import org.acme.processor.ValidationProcessor2;
import org.acme.processor.ValidationProcessor3;
import org.acme.processor.ValidationProcessor4;
import org.acme.processor.ValidationProcessor5;
import org.acme.bindy.ftp.Header;
import org.acme.bindy.ftp.HeaderConsulta;
import org.acme.bindy.ftp.HeaderConsulta2;

/**
 * Clase que define las acciones a realizar al encontrar un nuevo mensaje en la
 * cola de inicio
 */
@ApplicationScoped
public class ValidationRouteBuilder extends RouteBuilder {

    /* Clase que permite generar los logs */
    private static Logger logger = Logger.getLogger(ValidationRouteBuilder.class);

    /* Formateador de json a la clase Respuesta */
    private JacksonDataFormat formatRpta = new JacksonDataFormat(Respuesta1.class);

    /* Formateador de json a la clase Respuesta2 */
    private JacksonDataFormat format2 = new JacksonDataFormat(Respuesta2.class);

    /* Formateador de json a la clase Respuesta2 */
    private JacksonDataFormat format3 = new JacksonDataFormat(Respuesta4.class);

    /* Formateador de trama posicional a la clase Header */
    private BindyFixedLengthDataFormat camelDataFormat = new BindyFixedLengthDataFormat(Header.class);
    /* Formateador de trama posicional a la clase HeaderConsulta */
    private BindyFixedLengthDataFormat camelDataFormat2 = new BindyFixedLengthDataFormat(HeaderConsulta.class);

    private BindyFixedLengthDataFormat camelDataFormat3 = new BindyFixedLengthDataFormat(HeaderConsulta2.class);

    /* cola de inicio */
    @ConfigProperty(name = "app.jms.queue-start")
    private String queueIn;

    /* cola de fin */
    @ConfigProperty(name = "app.jms.queue-processed")
    private String queueOutEnd;

    /* url del endpoint donde se obtendrán los datos de la consulta */
    @ConfigProperty(name = "app.camel.rest.route.get-info")
    private String routeGetInfo;
    
    /* url del endpoint donde se obtendrán los datos de la consulta */
    @ConfigProperty(name = "app.camel.rest.route.get-info-by-names")
    private String routeGetInfoByNames;

    /**
     * Metodo que define las acciones a realizar al encontrar un nuevo mensaje en la
     * cola de inicio
     */
    @Override
    public void configure() throws Exception {

        logger.info("=====INIT VALIDATION");

        // escucha la cola de inicio
        from(String.format("jms:queue:%s?concurrentConsumers=1", queueIn))
                // y ejecuta el ValidationProcessor2 al llegar un mensaje
                .process(new ValidationProcessor2())
                .choice()
	                // si la el resultado es de tipo Respuesta significa que la validacion falló lo
	                // convierte en formato json
	                .when(body().isInstanceOf(Respuesta1.class))
	                .marshal(formatRpta)
	                // y lo envía a la cola de fin
	                .to(String.format("jms:queue:%s", queueOutEnd))
	                // de lo contrario lo convierte en una clase Header
	                .otherwise()
	                .unmarshal(camelDataFormat)
	                // y ejecuta el ValidationProcessor para ser validado
	                .process(new ValidationProcessor())
	                .choice()
		                // si la el resultado es de tipo Respuesta significa que la validacion falló lo
		                // convierte en formato json
		                .when(body().isInstanceOf(Respuesta1.class))
		                .marshal(formatRpta)
		                // y lo envía a la cola de fin
		                .to(String.format("jms:queue:%s", queueOutEnd))
		                // si la el resultado es de tipo Header significa que la consulta es por nombres
		                .when(body().isInstanceOf(Header.class))
		                // y ejecuta el ValidationProcessor5 para ser validado
		                .process(new ValidationProcessor5())
		                .unmarshal(camelDataFormat3)
		                // y ejecuta el ValidationProcessor4 para ser validado
		                .process(new ValidationProcessor4())
		                // al terminar lo convierte en un json de Respuesta4
		                .marshal(format3)
		                .to(routeGetInfoByNames)
		                // de lo contrario lo convierte en una clase HeaderConsulta
		                .otherwise()
		                // y ejecuta el ValidationProcessor3 para ser validado
		                .unmarshal(camelDataFormat2)
		                .process(new ValidationProcessor3())
		                // al terminar lo convierte en un json de Respuesta2
		                .marshal(format2)
		                // y lo envia al endpoint del proyecto de obtener data
		                .to(routeGetInfo)
	                .endChoice()
                .endChoice();

    }

}