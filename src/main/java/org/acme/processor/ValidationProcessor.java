
package org.acme.processor;

import org.apache.camel.Processor;
import org.apache.log4j.Logger;
import org.apache.camel.Exchange;

import org.acme.bean.Respuesta;
import org.acme.bindy.ftp.Header;

/**
 * Clase que se encarga de validar el tipo de consulta
 */
public class ValidationProcessor implements Processor {

    /* Clase que permite generar los logs */
    private static Logger logger = Logger.getLogger(ValidationProcessor.class);

    /**
     * Metodo que se encarga de validar el tipo de consulta y devuelve una cadena
     * con los datos de la consulta o un objeto Respuesta si la validacion es
     * incorrecta
     * 
     * @param exchange: data proveniente del paso anterior en el flujo de bindy
     *                  (ValidationProcessor2) dentro de una clase Header
     */
    @Override
    public void process(Exchange exchange) throws Exception {
        // extrae el Header del exchange
        Header query = exchange.getIn().getBody(Header.class);
        Respuesta rpta = procesarData(query);

        if (rpta == null) {

            switch (query.headTipoConsulta.trim()) {
                // Búsqueda por nombres
                case "1":
                    // exchange.getIn().setBody(new Respuesta3(query.getTramaHeader2()));
                    exchange.getIn().setBody(query);
                    break;
                // Búsqueda por DNI
                case "2":
                    exchange.getIn().setBody(query.getTramaHeader2());
                    break;
            }

        } else {

            exchange.getIn().setBody(rpta);

        }

    }

    /**
     * Metodo que se encarga de validar el tipo de consulta y devuelve una respuesta
     * en caso de error
     * 
     * @param query: clase que contiene la consulta a validar
     * @return: Respuesta que contiene el mensaje de respuesta en caso de error
     */
    public Respuesta procesarData(Header query) {
        var cantidadLimite = 0;
        var cantTotalSubTram = 0;
        var rptaAdicional = "";

        String tipoCons = query.headTipoConsulta.trim();
        String version = query.headVersion.trim();
        String verif = query.headCaractVerif.trim();
        String servidor = query.headCodServerReniec.trim();
        String agencia = query.headAgenciaInstSolic.trim();

        // Tipo de consulta no permitida
        if (tipoCons.length() == 0) {
            return new Respuesta(query.getTramaHeader() + "5010");
        }

        // obtiene la cantidad limite de la subtrama segun el tipo de consulta
        switch (tipoCons) {
            // Búsqueda por nombres
            case "1":
                cantidadLimite = 153;
                rptaAdicional = "0000        ";
                break;
            // Búsqueda por DNI
            case "2":
                cantidadLimite = 30;
                break;
            default:
                // Tipo de consulta inválido
                return new Respuesta(query.getTramaHeader() + "5009");
        }

        cantTotalSubTram = query.headSubTramaConsulta.length();

        // valida la cantidad limite de la subtrama de la consulta
        if (cantTotalSubTram != cantidadLimite) {
            return new Respuesta(query.getTramaHeader() + (cantTotalSubTram == 0 ? "5011" : "5100") + rptaAdicional);
        }
        // Valida la versión del header según estandar Reniec
        else if (!version.equals("0002")) {
            logger.info("=====version:" + version);
            return new Respuesta(query.getTramaHeader() + "5002" + rptaAdicional);
        }
        // Valida Caracteres de verificación incorrectos
        else if (!verif.equals("RENIECPERURENIEC")) {
            return new Respuesta(query.getTramaHeader() + "5004" + rptaAdicional);
        }
        // Valida Servidor no válido
        else if (!servidor.equals("RENIEC001")) {
            return new Respuesta(query.getTramaHeader() + "5008" + rptaAdicional);
        }
        // No existe la empresa ingresada para usar el servicio
        else if (agencia.length() == 0) {
            return new Respuesta(query.getTramaHeader() + "5020" + rptaAdicional);
        }

        return null;
    }

    // A partir del código error 5021 se debe implementar en Obtención

}