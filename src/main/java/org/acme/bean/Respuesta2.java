package org.acme.bean;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Bean usado para enviar la consulta al endpoint de obtener data
* */
@Getter
@Setter
@NoArgsConstructor
public class Respuesta2 {

   
    /*version*/
    private String version;

    /*longitud de la cabecera*/
    private String lonCabecera;

    /*tipo de servicio*/
    private String tipoServicio;

    /*longitud total de la trama*/
    private String longTotalTrama;

    /*fragmentacion*/
    private String fragmentacion;

    /*tiempo de vida del mensaje en la cola de respuesta*/
    private String ttl;

    /*tipo de consulta*/
    private String tipoConsulta;

    /*caracteres de verificacion*/
    private String caractVerif;

    /*codigo de institucion solicitante*/
    private String codInstitucion;

    /*codigo de servidor reniec*/
    private String codServerReniec;

    /*agencia de la institucion solicitante*/
    private String agenciaInstSolic;

    /*usuario final de la institucion solicitante*/
    private String usuarioFinalInst;

    /*host final de la institucion solicitante*/
    private String hostFinalInst;

    /*reservado*/
    private String reservado;

    /*dni*/
    private String nroDNI;

    /*tipo de subconsulta*/
    private String tipoSubConsulta;

    /*formato de firma*/
    private String formatoFirma;

    /*reservado*/
    private String reservadoSubTrama;


    /**
     * Constructor que genera una Respuesta2 con todos sus campos llenos
     * */
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
    

}
