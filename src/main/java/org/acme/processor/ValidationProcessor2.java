package org.acme.processor;
import org.apache.camel.Processor;
import org.apache.log4j.Logger;
import org.apache.camel.Exchange;
import org.acme.bean.Respuesta;

/**
 * Clase que se encarga de validar el tamño de la cadena de la consulta obtenida
 * */
public class ValidationProcessor2 implements Processor{

    /*Clase que permite generar los logs*/
	private static Logger logger = Logger.getLogger(ValidationProcessor2.class);
	
    /**
     * Metodo que se encarga de validar el tamaño de la cadena de la consulta obtenida
     * @param exchange: data proveniente de la cola de inicio dentro de una clase String 
     * */
    @Override
    public void process(Exchange exchange) throws Exception {

    	logger.info("=====GET INFOR VALIDATOR2");  
    	//extrae la consulta en string del exchange
        String query = exchange.getIn().getBody(String.class);
        Respuesta rpta= procesarData(query);
        //inserta la respuesta en el body si existe un error, de lo contrario inserta la query completa
        exchange.getIn().setBody(rpta==null?query:rpta);
    }

    /**
     * Metodo que se encarga de validar el tamaño de la cadena de la consulta obtenida
     * @param query: consulta obtenida de la cola de inicio
     * @return respuesta de error en caso de error o null si la validación fue correcta 
     * */
    public Respuesta procesarData(String query) {
    	int longuitud = query.length();

        //valida la logitud de la consulta
        if (longuitud >= 128) {
        	logger.info("=====ok");  
            return null;
        } else {
        	logger.info("===============ERROR Longuitud incorrecta:" + longuitud);  
            return new Respuesta(query + "5003");
        }
    }
}