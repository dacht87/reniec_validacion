package org.acme;

public class DynamicRouter {
    
    String route(){
        return String.format("jms:queue:%s","DEV.QUEUE.RESPUESTA.CLI1");
    }
}
