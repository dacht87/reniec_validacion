package org.acme.bean;

public class Respuesta2 {

   
    public String version;

    public String lonCabecera;

    public String tipoServicio;

    public String longTotalTrama;

    public String fragmentacion;

    public String TTL;

    public String tipoConsulta;

    public String caractVerif;

    public String codInstitucion;

    public String codServerReniec;

    public String agenciaInstSolic;

    public String usuarioFinalInst;

    public String hostFinalInst;

    public String reservado;

    public String nroDNI;

    public String tipoSubConsulta;

    public String formatoFirma;

    public String reservadoSubTrama;

    // public String token;

    public Respuesta2(String version,
    String lonCabecera,
    String tipoServicio,
    String longTotalTrama,
    String fragmentacion,
    String TTL,
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
    // ,
    // String token
    ){
        this.version = version;
        this.lonCabecera = lonCabecera;
        this.tipoServicio = tipoServicio;
        this.longTotalTrama = longTotalTrama;
        this.fragmentacion = fragmentacion;
        this.TTL = TTL;
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
        //this.token = token;
        
    }
    public Respuesta2(){
    }

    @Override
    public String toString() {
        return "";
    }


}
