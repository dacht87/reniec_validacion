
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
        return new Respuesta4(query.header2Version,
                query.header2LonCabecera,
                query.header2TipoServicio,
                query.header2LongTotalTrama,
                query.header2Fragmentacion,
                query.header2Ttl,
                query.header2TipoConsulta,
                query.header2CaractVerif,
                query.header2CodInstitucion,
                query.header2CodServerReniec,
                query.header2AgenciaInstSolic,
                query.header2UsuarioFinalInst,
                query.header2HostFinalInst,
                query.header2Reservado,
                query.header2Coincidencias,
                query.header2Grupo,
                query.header2ApellidoPaterno,
                query.header2ApellidoMaterno,
                query.header2Prenombres,
                query.header2ReservadoSubConsulta);
    }

}