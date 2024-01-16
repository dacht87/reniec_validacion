package org.acme;


import org.eclipse.microprofile.config.inject.ConfigProperty;

import jakarta.inject.Inject;
import jakarta.jms.ConnectionFactory;
import jakarta.jms.JMSException;
import jakarta.jms.Session;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
 
/**
 * Clase que tiene el endpoint de prueba para insertar un mensaje en la cola de inicio
 * */
@Path("/hello")
public class GreetingResource {

	/**
	 * Clase de Conexion a la cola de mq
	 * */
    @Inject
    private ConnectionFactory connectionFactory;

	/**
	 * nombre de la cola de inicio
	 * */
    @ConfigProperty(name = "app.jms.queue-start")
    private String queue;

    /**
     * Endpoint de prueba para insertar un mensaje en la cola de inicio
     * @return cadena con la respuesta de la data enviada a la cola
     * @throws JMSException en caso haya una excepción al registrar el mensaje en la cola
     * */
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() throws JMSException {
        try(var conn = connectionFactory.createConnection()){
            try(var session = conn.createSession(false, Session.AUTO_ACKNOWLEDGE)){
                //abre una conexion en la cola de inicio
                var destination = session.createQueue(queue);
                try(var producer = session.createProducer(destination)){
                	//mensaje de prueba con tipo de consulta 2
                    var message = session.createTextMessage("00020128000000023000                      0000000002RENIECPERURENIECDE2116    RENIEC001 0000INS00070600648  HOST000000          706006481                     ");
                    message.setStringProperty("_Destination", destination.toString());
                    producer.send(message);
                    return "Message send it " + message;
                }
            }
        }
    }
}
