package org.acme.bean;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Bean usado para enviar una respuesta a la cola de fin
* */
@Getter
@Setter
@NoArgsConstructor
public class Respuesta {
    /*mensaje de respuesta*/
    private String respuesta;

    /**
     * Constructor que genera una Respuesta con sus campos llenos
     * */
    public Respuesta(String respuesta){
        this.respuesta=respuesta;
    }

}
