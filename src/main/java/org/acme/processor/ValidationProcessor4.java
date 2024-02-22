
package org.acme.processor;

import org.apache.camel.Processor;
import org.apache.log4j.Logger;
import org.apache.camel.Exchange;
import org.acme.bean.Respuesta4;
import org.acme.bindy.ftp.HeaderConsulta2;

/**
 * Clase que se encarga de transformar la consulta a la clase HeaderConsulta2
 * para
 * ser enviada al proyecto de obtencion de data
 */
public class ValidationProcessor4 implements Processor {

    /* Clase que permite generar los logs */
    private static Logger logger = Logger.getLogger(ValidationProcessor4.class);

    /**
     * Metodo que se encarga de transformar la consulta a la clase HeaderConsulta2
     * para
     * ser enviada al proyecto de obtencion de data
     * 
     * @param exchange: data proveniente del paso anterior en el flujo de bindy
     *                  (ValidationProcessor) dentro de una clase HeaderConsulta2
     * @throws Exception en caso de un error al convertir el HeaderConsulta2 en una
     *                   Respuesta2
     */
    @Override
    public void process(Exchange exchange) throws Exception {
        logger.info("=====GET INFOR VALIDATOR");
        // extrae la consulta en una clase HeaderConsulta del exchange
        HeaderConsulta2 query = exchange.getIn().getBody(HeaderConsulta2.class);
        // inserta la respuesta en el body
        exchange.getIn().setBody(procesarData(query));
    }

    /**
     * Metodo que se encarga de transformar la consulta de HeaderConsulta2 a la
     * clase
     * Respuesta2
     * 
     * @param query: data en formato HeaderConsulta2
     * @return la data en formato Respuesta4
     */
    public Respuesta4 procesarData(HeaderConsulta2 query) {
        return new Respuesta4(query.version,
                query.lonCabecera,
                query.tipoServicio,
                query.longTotalTrama,
                query.fragmentacion,
                query.ttl,
                query.tipoConsulta,
                query.caractVerif,
                query.codInstitucion,
                query.codServerReniec,
                query.agenciaInstSolic,
                query.usuarioFinalInst,
                query.hostFinalInst,
                query.reservado,
                query.coincidencias,
                query.grupo,
                query.apellidoPaterno,
                query.apellidoMaterno,
                query.prenombres,
                query.reservadoSubConsulta);
    }

}