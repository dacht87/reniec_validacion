package org.acme.bean;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Respuesta {
    private String respuesta;

    public Respuesta(String respuesta){
        this.respuesta=respuesta;
    }
    public Respuesta(){
    }

}
