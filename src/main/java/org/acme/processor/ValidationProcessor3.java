
package org.acme.processor;

import org.apache.camel.Processor;
import org.apache.camel.Exchange;
import org.acme.bean.Respuesta2;
import org.acme.bindy.ftp.HeaderConsulta;

/**
 * Clase que se encarga de transformar la consulta a la clase Respuesta2 para ser enviada al proyecto de obtencion de data
 * */
public class ValidationProcessor3 implements Processor{

    /**
     * Metodo que se encarga de transformar la consulta a la clase Respuesta2 para ser enviada al proyecto de obtencion de data
     * @param exchange: data proveniente del paso anterior en el flujo de bindy (ValidationProcessor) dentro de una clase HeaderConsulta 
     * @throws Exception en caso de un error al convertir el HeaderConsulta en una Respuesta2
     * */
    @Override
    public void process(Exchange exchange) throws Exception {
    	//extrae la consulta en una clase HeaderConsulta del exchange
        HeaderConsulta query = exchange.getIn().getBody(HeaderConsulta.class);
        //inserta la respuesta en el body
        exchange.getIn().setBody(procesarData(query));
    }

    /**
     * Metodo que se encarga de transformar la consulta de HeaderConsulta a la clase Respuesta2
     * @param query: data en formato HeaderConsulta 
     * @return la data en formato Respuesta2
     * */
    public Respuesta2 procesarData(HeaderConsulta query) {
    	return new Respuesta2(query.version,
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
                query.nroDNI,
                query.tipoSubConsulta,
                query.formatoFirma,
                query.reservadoSubTrama
                );
    }

}