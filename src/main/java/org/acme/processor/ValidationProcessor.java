
package org.acme.processor;

import org.apache.camel.Processor;
import org.apache.camel.Exchange;

import org.acme.bean.Respuesta;
import org.acme.bindy.ftp.Header;
import io.quarkus.logging.Log;

public class ValidationProcessor implements Processor{

     @Override
    public void process(Exchange exchange) throws Exception {

        Log.info("=====GET INFOR VALIDATOR");  

        var cantidadLimite = 0;
        var cantTotalSubTram = 0;
        Header query = exchange.getIn().getBody(Header.class);
        
        Log.info("=====GET INFOR VALIDATOR111111" + query);  

        String tipoCons = query.tipoConsulta.trim();

        Log.info("=====GET INFOR VALIDATOR3333" + query.subTramaConsulta);  

        switch (tipoCons) {
            case "1":

                cantidadLimite = 153;

                break;
            case "2":

                cantidadLimite = 30;

                break;
            default:
                exchange.getIn().setBody(new Respuesta(query.getTramaHeader() + "5010"));
                return;
                
        }

        cantTotalSubTram = query.subTramaConsulta.length();

        if(cantTotalSubTram != cantidadLimite )
        {
            
            Log.info("=====ERROR en cantidad limite:" + cantTotalSubTram );  
            Log.info("=====ERROR en cantidad limite2:" + cantidadLimite );  

            exchange.getIn().setBody(new Respuesta(query.getTramaHeader() + (cantTotalSubTram == 0 ? "5011" : "5100")));

            return;
        }

        exchange.getIn().setBody(query.getTramaHeader2());

    }

}