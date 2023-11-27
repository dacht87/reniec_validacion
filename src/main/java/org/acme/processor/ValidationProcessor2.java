package org.acme.processor;
import org.apache.camel.Processor;
import org.apache.camel.Exchange;
import org.acme.bean.Respuesta;

public class ValidationProcessor2 implements Processor{


    @Override
    public void process(Exchange exchange) throws Exception {


        System.out.println("=====GET INFOR VALIDATOR2");  
        String query = exchange.getIn().getBody(String.class);

        int longuitud = query.length();

        if (longuitud >= 128) {

            System.out.println("=====ok");  
            exchange.getIn().setBody(query);
            
        } else {

            System.out.println("===============ERROR Longuitud incorrecta:" + longuitud);  
            exchange.getIn().setBody(new Respuesta(query + "5003"));
            return;
            
        }

        // if (longuitud != 128) {

        //     System.out.println("===============ERROR Longuitud incorrecta:" + longuitud);  
        //     exchange.getIn().setBody(new Respuesta(query + "5003"));
        //     return;
            
        // } else {
        //     System.out.println("=====ok");  
        //     exchange.getIn().setBody(query);
        // }

    }
}