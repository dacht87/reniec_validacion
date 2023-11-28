
package org.acme.processor;

import org.apache.camel.Processor;
import org.apache.camel.CamelContext;
import org.apache.camel.Exchange;

import org.acme.bean.Respuesta2;
import org.acme.bindy.ftp.HeaderConsulta;

public class ValidationProcessor3 implements Processor{

    private static Object respuesta2usuario = null;
    CamelContext camelContext;
        
    public ValidationProcessor3(CamelContext camelContext){
        this.camelContext = camelContext;
        
    }

   
    @Override
    public void process(Exchange exchange) throws Exception {

        System.out.println("=====GET INFOR VALIDATOR");  

        HeaderConsulta query = exchange.getIn().getBody(HeaderConsulta.class);
        
        //exchange.getIn().setBody(new Respuesta(query.getTramaHeaderToken()));
        //exchange.getIn().setBody(query);

        exchange.getIn().setBody(new Respuesta2(query.version,
                query.lonCabecera,
                query.tipoServicio,
                query.longTotalTrama,
                query.fragmentacion,
                query.TTL,
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

        // respuesta2usuario  = new Respuesta2(query.version,
        //         query.lonCabecera,
        //         query.tipoServicio,
        //         query.longTotalTrama,
        //         query.fragmentacion,
        //         query.TTL,
        //         query.tipoConsulta,
        //         query.caractVerif,
        //         query.codInstitucion,
        //         query.codServerReniec,
        //         query.agenciaInstSolic,
        //         query.usuarioFinalInst,
        //         query.hostFinalInst,
        //         query.reservado,
        //         query.nroDNI,
        //         query.tipoSubConsulta,
        //         query.formatoFirma,
        //         query.reservadoSubTrama
        //         );

        
        // camelContext.createProducerTemplate().sendBody("direct:respuestaValidacion",respuesta2usuario);

        return;
         

    }

}