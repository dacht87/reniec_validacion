
package org.acme.processor;

import org.apache.camel.Processor;
import org.apache.camel.Exchange;

import org.acme.bean.Respuesta;
import org.acme.bindy.ftp.Header;

public class ValidationProcessor implements Processor{

     @Override
    public void process(Exchange exchange) throws Exception {

        System.out.println("=====GET INFOR VALIDATOR");  

        int cantidadLimite = 0;
        int cantTotalSubTram = 0;
        Header query = exchange.getIn().getBody(Header.class);
        
        System.out.println("=====GET INFOR VALIDATOR111111" + query);  

        String tipoCons = query.tipoConsulta.trim();

        System.out.println("=====GET INFOR VALIDATOR3333" + query.subTramaConsulta);  

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
            
            System.out.println("=====ERROR en cantidad limite:" + cantTotalSubTram );  
            System.out.println("=====ERROR en cantidad limite2:" + cantidadLimite );  

            exchange.getIn().setBody(new Respuesta(query.getTramaHeader() + (cantTotalSubTram == 0 ? "5011" : "5100")));

            return;
        }

        exchange.getIn().setBody(query.getTramaHeader2());

        return ;

    }

}