package org.acme;

/**
 * Clase que define la cadena de conexion a la cola de respuesta
 * */
public class DynamicRouter {
    
    /**
     * Metodo que define la cadena de conexion a la cola de respuesta
     * @return la cadena de conexion a la cola de respuesta
     * */
    String route(){
        return String.format("jms:queue:%s","DEV.QUEUE.RESPUESTA.CLI1");
    }
}
