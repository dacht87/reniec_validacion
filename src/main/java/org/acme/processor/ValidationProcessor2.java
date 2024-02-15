package org.acme.processor;
import org.apache.camel.Processor;
import org.apache.camel.Exchange;
import org.acme.bean.Respuesta1;

/**
 * Clase que se encarga de validar el tamño de la cadena de la consulta obtenida
 * */
public class ValidationProcessor2 implements Processor{
	
    /**
     * Metodo que se encarga de validar el tamaño de la cadena de la consulta obtenida
     * @param exchange: data proveniente de la cola de inicio dentro de una clase String 
     * */
    @Override
    public void process(Exchange exchange) throws Exception {
    	//extrae la consulta en string del exchange
        String query = exchange.getIn().getBody(String.class);
        Respuesta1 rpta= procesarData(query);
        //inserta la respuesta en el body si existe un error, de lo contrario inserta la query completa
        exchange.getIn().setBody(rpta==null?query:rpta);
    }

    /**
     * Metodo que se encarga de validar el tamaño de la cadena de la consulta obtenida
     * @param query: consulta obtenida de la cola de inicio
     * @return respuesta de error en caso de error o null si la validación fue correcta 
     * */
    public Respuesta1 procesarData(String query) {
    	int longuitud = query.length();

        //valida la logitud de la consulta
        if (longuitud >= 128) {
            return null;
        } else { 
            return new Respuesta1(query + "5003");
        }
    }
}