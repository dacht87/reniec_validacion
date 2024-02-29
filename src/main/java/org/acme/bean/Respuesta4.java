package org.acme.bean;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Bean usado para enviar la consulta al endpoint de obtener data
 */
@Getter
@Setter
@NoArgsConstructor
public class Respuesta4 {

    /* version */
    private String rptaVersion;

    /* longitud de la cabecera */
    private String rptaLonCabecera;

    /* tipo de servicio */
    private String rptaTipoServicio;

    /* longitud total de la trama */
    private String rptaLongTotalTrama;

    /* fragmentacion */
    private String rptaFragmentacion;

    /* tiempo de vida del mensaje en la cola de respuesta */
    private String rptaTtl;

    /* tipo de consulta */
    private String rptaTipoConsulta;

    /* caracteres de verificacion */
    private String rptaCaractVerif;

    /* codigo de institucion solicitante */
    private String rptaCodInstitucion;

    /* codigo de servidor reniec */
    private String rptaCodServerReniec;

    /* agencia de la institucion solicitante */
    private String rptaAgenciaInstSolic;

    /* usuario final de la institucion solicitante */
    private String rptaUsuarioFinalInst;

    /* host final de la institucion solicitante */
    private String rptaHostFinalInst;

    /* reservado */
    private String rptaReservado;

    /* dni */
    private String rptaCoincidencias;

    /* incio de grupo () */
    private String rptaGrupo;

    /* apellido paterno */
    private String rptaApellidoPaterno;

    /* apellido materno */
    private String rptaApellidoMaterno;

    /* Primer o segundo prenombre */
    private String rptaPrenombres;

    /* Reservado para uso futuro */
    private String rptaReservadoSubConsulta;

    /**
     * Constructor que genera una Respuesta4 con todos sus campos llenos
     */
    public Respuesta4(String version,
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
            String coincidencias,
            String grupo,
            String apellidoPaterno,
            String apellidoMaterno,
            String prenombres,
            String reservadoSubConsulta) {
        this.rptaVersion = version;
        this.rptaLonCabecera = lonCabecera;
        this.rptaTipoServicio = tipoServicio;
        this.rptaLongTotalTrama = longTotalTrama;
        this.rptaFragmentacion = fragmentacion;
        this.rptaTtl = ttl;
        this.rptaTipoConsulta = tipoConsulta;
        this.rptaCaractVerif = caractVerif;
        this.rptaCodInstitucion = codInstitucion;
        this.rptaCodServerReniec = codServerReniec;
        this.rptaAgenciaInstSolic = agenciaInstSolic;
        this.rptaUsuarioFinalInst = usuarioFinalInst;
        this.rptaHostFinalInst = hostFinalInst;
        this.rptaReservado = reservado;
        this.rptaCoincidencias = coincidencias;
        this.rptaGrupo = grupo;
        this.rptaApellidoPaterno = apellidoPaterno;
        this.rptaApellidoMaterno = apellidoMaterno;
        this.rptaPrenombres = prenombres;
        this.rptaReservadoSubConsulta = reservadoSubConsulta;

    }

}
