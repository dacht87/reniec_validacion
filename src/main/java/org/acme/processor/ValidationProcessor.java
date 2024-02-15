
package org.acme.processor;

import org.apache.camel.Processor;
import org.apache.camel.Exchange;

import org.acme.bean.Respuesta1;
import org.acme.bindy.ftp.Header;

/**
 * Clase que se encarga de validar el tipo de consulta
 * */
public class ValidationProcessor implements Processor{
	
    /**
     * Metodo que se encarga de validar el tipo de consulta y devuelve una cadena con los datos de la consulta o un objeto Respuesta si la validacion es incorrecta
     * @param exchange: data proveniente del paso anterior en el flujo de bindy (ValidationProcessor2) dentro de una clase Header 
     * */
     @Override
    public void process(Exchange exchange) throws Exception {
    	//extrae el Header del exchange
        Header query = exchange.getIn().getBody(Header.class);
        Respuesta1 rpta= procesarData(query);
        //inserta la respuesta en el body si existe un error, de lo contrario inserta el header completo
        exchange.getIn().setBody(rpta==null?query.getTramaHeader2():rpta);
    }

     /**
  	 * Metodo que se encarga de validar el tipo de consulta y devuelve una respuesta en caso de error
  	 * @param query: clase que contiene la consulta a validar
  	 * @return: Respuesta que contiene el mensaje de respuesta en caso de error
  	 * */
     public Respuesta1 procesarData(Header query){
         var cantidadLimite = 0;
         var cantTotalSubTram = 0;

         String tipoCons = query.headTipoConsulta.trim();

         //obtiene la cantidad limite de la subtrama segun el tipo de consulta
         switch (tipoCons) {
             case "1":
                 cantidadLimite = 153;
                 break;
             case "2":
                 cantidadLimite = 30;
                 break;
             default:
                 return new Respuesta1(query.getTramaHeader() + "5010");
         }
         cantTotalSubTram = query.headSubTramaConsulta.length();

         //valida la cantidad limite de la subtrama de la consulta
         if(cantTotalSubTram != cantidadLimite ) {
            return new Respuesta1(query.getTramaHeader() + (cantTotalSubTram == 0 ? "5011" : "5100"));
         }
         return null;
     }

}