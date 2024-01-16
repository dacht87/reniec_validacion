package org.acme.bindy.ftp;

import org.apache.camel.dataformat.bindy.annotation.FixedLengthRecord;
import org.apache.camel.dataformat.bindy.annotation.DataField;

/**
 * Clase que mapea una consulta en la cola de inicio
 * */
@FixedLengthRecord
public class Header {

    /*version*/
    @DataField(pos = 1, length=4)
    public String headVersion;

    /*longitud de la cabecera*/
    @DataField(pos = 5, length=4)
    public String headLonCabecera;

    /*tipo de servicio*/
    @DataField(pos = 9, length=3)
    public String headTipoServicio;

    /*longitud total de la trama*/
    @DataField(pos = 12, length=9)
    public String headLongTotalTrama;

    /*fragmentacion*/
    @DataField(pos = 21, length=22)
    public String headFragmentacion;

    /*tiempo de vida del mensaje en la cola de respuesta*/
    @DataField(pos = 43, length=9)
    public String headTtl;

    /*tipo de consulta*/
    @DataField(pos = 52, length=1)
    public String headTipoConsulta;

    /*caracteres de verificacion*/
    @DataField(pos = 53, length=16)
    public String headCaractVerif;

    /*codigo de institucion solicitante*/
    @DataField(pos = 69, length=10)
    public String headCodInstitucion;

    /*codigo de servidor reniec*/
    @DataField(pos = 79, length=10)
    public String headCodServerReniec;

    /*agencia de la institucion solicitante*/
    @DataField(pos = 89, length=10)
    public String headAgenciaInstSolic;

    /*usuario final de la institucion solicitante*/
    @DataField(pos = 99, length=10)
    public String headUsuarioFinalInst;

    /*host final de la institucion solicitante*/
    @DataField(pos = 109, length=10)
    public String headHostFinalInst;

    /*reservado*/
    @DataField(pos = 119, length=10)
    public String headReservado;

    /*subtrama de de la consulta*/
    @DataField(pos = 129, length=1000)
    public String headSubTramaConsulta;

    
    /**
     * Concatena los campos de la consulta para ser enviado al endpoint de respuesta
     * @return La cadena de campos concatenados
     * */
    public String getTramaHeader() {
        return headVersion + headLonCabecera + headTipoServicio + headLongTotalTrama + headFragmentacion + headTtl + headTipoConsulta + headCaractVerif + headCodInstitucion + headCodServerReniec + headAgenciaInstSolic + headUsuarioFinalInst + headHostFinalInst + headReservado;
    }


    /**
     * Concatena los campos de la consulta para ser enviado al endpoint de obtencion de data (incluye la subtrama)
     * @return La cadena de campos concatenados
     * */
    public String getTramaHeader2() {
        return headVersion + headLonCabecera + headTipoServicio + headLongTotalTrama + headFragmentacion + headTtl + headTipoConsulta + headCaractVerif + headCodInstitucion + headCodServerReniec + headAgenciaInstSolic + headUsuarioFinalInst + headHostFinalInst + headReservado + headSubTramaConsulta;
    }



}
