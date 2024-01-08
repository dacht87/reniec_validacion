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
 
@Path("/hello")
public class GreetingResource {

    @Inject
    private ConnectionFactory connectionFactory;

    @ConfigProperty(name = "app.jms.queue-start")
    private String queue;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() throws JMSException {

        try(var conn = connectionFactory.createConnection()){
            try(var session = conn.createSession(false, Session.AUTO_ACKNOWLEDGE)){
                var destination = session.createQueue(queue);
                try(var producer = session.createProducer(destination)){

                    var message = session.createTextMessage("00020128000000023000                      0000000002RENIECPERURENIECDE2116    RENIEC001 0000INS00070600648  HOST000000          706006481                     ");
                    
                    
                    message.setStringProperty("_Destination", destination.toString());


                    producer.send(message);

                    return "Message send it " + message;
                }
            }
        }
    }
}
