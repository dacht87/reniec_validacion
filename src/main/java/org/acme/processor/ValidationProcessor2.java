package org.acme.processor;
import org.apache.camel.Processor;
import org.apache.camel.Exchange;
import org.acme.bean.Respuesta;
import io.quarkus.logging.Log;

public class ValidationProcessor2 implements Processor{


    @Override
    public void process(Exchange exchange) throws Exception {


        Log.info("=====GET INFOR VALIDATOR2");  
        String query = exchange.getIn().getBody(String.class);

        int longuitud = query.length();

        if (longuitud >= 128) {

            Log.info("=====ok");  
            exchange.getIn().setBody(query);
            
        } else {

            Log.info("===============ERROR Longuitud incorrecta:" + longuitud);  
            exchange.getIn().setBody(new Respuesta(query + "5003"));
            
        }


    }
}