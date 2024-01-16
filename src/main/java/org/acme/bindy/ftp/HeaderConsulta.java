package org.acme.bindy.ftp;

import org.apache.camel.dataformat.bindy.annotation.FixedLengthRecord;
import org.apache.camel.dataformat.bindy.annotation.DataField;

/**
 * Clase que mapea una consulta en la cola de inicio y separa la subtrama en parametros
 * */
@FixedLengthRecord
public class HeaderConsulta {

    /*version*/
    @DataField(pos = 1, length=4)
    public String version;

    /*longitud de la cabecera*/
    @DataField(pos = 5, length=4)
    public String lonCabecera;

    /*tipo de servicio*/
    @DataField(pos = 9, length=3)
    public String tipoServicio;

    /*longitud total de la trama*/
    @DataField(pos = 12, length=9)
    public String longTotalTrama;

    /*fragmentacion*/
    @DataField(pos = 21, length=22)
    public String fragmentacion;

    /*tiempo de vida del mensaje en la cola de respuesta*/
    @DataField(pos = 43, length=9)
    public String ttl;

    /*tipo de consulta*/
    @DataField(pos = 52, length=1)
    public String tipoConsulta;

    /*caracteres de verificacion*/
    @DataField(pos = 53, length=16)
    public String caractVerif;

    /*codigo de institucion solicitante*/
    @DataField(pos = 69, length=10)
    public String codInstitucion;

    /*codigo de servidor reniec*/
    @DataField(pos = 79, length=10)
    public String codServerReniec;

    /*agencia de la institucion solicitante*/
    @DataField(pos = 89, length=10)
    public String agenciaInstSolic;

    /*usuario final de la institucion solicitante*/
    @DataField(pos = 99, length=10)
    public String usuarioFinalInst;

    /*host final de la institucion solicitante*/
    @DataField(pos = 109, length=10)
    public String hostFinalInst;

    /*reservado*/
    @DataField(pos = 119, length=10)
    public String reservado;

    /*dni*/
    @DataField(pos = 129, length=8)
    public String nroDNI;

    /*tipo de subconsulta*/
    @DataField(pos = 137, length=5)
    public String tipoSubConsulta;

    /*formato de firma*/
    @DataField(pos = 142, length=1)
    public String formatoFirma;

    /*reservado*/
    @DataField(pos = 143, length=16)
    public String reservadoSubTrama;

    
    /**
     * Concatena los campos de la consulta para ser ingresado en la cola de inicio
     * @return La cadena de campos concatenados
     * */
    public String getTramaHeader() {
        return version + lonCabecera + tipoServicio + longTotalTrama + fragmentacion + ttl + tipoConsulta + caractVerif + codInstitucion + codServerReniec + agenciaInstSolic + usuarioFinalInst + hostFinalInst + reservado;
    }


}
