
package org.acme.processor;

import org.apache.camel.Processor;
import org.apache.log4j.Logger;
import org.apache.camel.Exchange;
import org.acme.bindy.ftp.Header;

/**
 * Clase que se encarga de transformar la consulta a la clase Respuesta2 para
 * ser enviada al proyecto de obtencion de data
 */
public class ValidationProcessor5 implements Processor {

    /* Clase que permite generar los logs */
    private static Logger logger = Logger.getLogger(ValidationProcessor5.class);

    /**
     * Metodo que se encarga de transformar la consulta a la clase Header para
     * ser enviada al proyecto de obtencion de data
     * 
     * @param exchange: data proveniente del paso anterior en el flujo de bindy
     *                  (ValidationProcessor) dentro de una clase Header
     * @throws Exception en caso de un error al convertir el Header en una
     *                   Respuesta2
     */
    @Override
    public void process(Exchange exchange) throws Exception {
        logger.info("=====GET INFOR VALIDATOR5");
        // extrae la consulta en una clase Header del exchange
        Header query = exchange.getIn().getBody(Header.class);
        // inserta la respuesta en el body
        exchange.getIn().setBody(query.getTramaHeader2());

    }

}