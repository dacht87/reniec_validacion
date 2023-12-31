
package org.acme.processor;

import org.apache.camel.Processor;

import org.apache.camel.Exchange;

import org.acme.bean.Respuesta2;
import org.acme.bindy.ftp.HeaderConsulta;
import io.quarkus.logging.Log;

public class ValidationProcessor3 implements Processor{

   
    @Override
    public void process(Exchange exchange) throws Exception {

        Log.info("=====GET INFOR VALIDATOR");  

        HeaderConsulta query = exchange.getIn().getBody(HeaderConsulta.class);
        
        exchange.getIn().setBody(new Respuesta2(query.version,
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
                ));
         

    }

}