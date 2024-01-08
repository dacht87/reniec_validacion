package org.acme.bean;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Respuesta2 {

   
    private String version;

    private String lonCabecera;

    private String tipoServicio;

    private String longTotalTrama;

    private String fragmentacion;

    private String ttl;

    private String tipoConsulta;

    private String caractVerif;

    private String codInstitucion;

    private String codServerReniec;

    private String agenciaInstSolic;

    private String usuarioFinalInst;

    private String hostFinalInst;

    private String reservado;

    private String nroDNI;

    private String tipoSubConsulta;

    private String formatoFirma;

    private String reservadoSubTrama;


    public Respuesta2(String version,
    String lonCabecera,
    String tipoServicio,
    String longTotalTrama,
    String fragmentacion,
    String ttl,
    String tipoConsulta,
    String caractVerif,
    String codInstitucion,
    String codServerReniec,
    String agenciaInstSolic,
    String usuarioFinalInst,
    String hostFinalInst,
    String reservado,
    String nroDNI,
    String tipoSubConsulta,
    String formatoFirma,
    String reservadoSubTrama
    ){
        this.version = version;
        this.lonCabecera = lonCabecera;
        this.tipoServicio = tipoServicio;
        this.longTotalTrama = longTotalTrama;
        this.fragmentacion = fragmentacion;
        this.ttl = ttl;
        this.tipoConsulta = tipoConsulta;
        this.caractVerif = caractVerif;
        this.codInstitucion = codInstitucion;
        this.codServerReniec = codServerReniec;
        this.agenciaInstSolic = agenciaInstSolic;
        this.usuarioFinalInst = usuarioFinalInst;
        this.hostFinalInst = hostFinalInst;
        this.reservado = reservado;
        this.nroDNI = nroDNI;
        this.tipoSubConsulta = tipoSubConsulta;
        this.formatoFirma = formatoFirma;
        this.reservadoSubTrama = reservadoSubTrama;        
    }
    
    public Respuesta2(){
    }

    @Override
    public String toString() {
        return "";
    }


}
