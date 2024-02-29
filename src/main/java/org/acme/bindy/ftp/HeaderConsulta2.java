package org.acme.bindy.ftp;

import org.apache.camel.dataformat.bindy.annotation.FixedLengthRecord;
import org.apache.camel.dataformat.bindy.annotation.DataField;

/**
 * Clase que mapea una consulta en la cola de inicio y separa la subtrama en
 * parametros
 */
@FixedLengthRecord
public class HeaderConsulta2 {

    /* version */
    @DataField(pos = 1, length = 4)
    public String header2Version;

    /* longitud de la cabecera */
    @DataField(pos = 5, length = 4)
    public String header2LonCabecera;

    /* tipo de servicio */
    @DataField(pos = 9, length = 3)
    public String header2TipoServicio;

    /* longitud total de la trama */
    @DataField(pos = 12, length = 9)
    public String header2LongTotalTrama;

    /* fragmentacion */
    @DataField(pos = 21, length = 22)
    public String header2Fragmentacion;

    /* tiempo de vida del mensaje en la cola de respuesta */
    @DataField(pos = 43, length = 9)
    public String header2Ttl;

    /* tipo de consulta */
    @DataField(pos = 52, length = 1)
    public String header2TipoConsulta;

    /* caracteres de verificacion */
    @DataField(pos = 53, length = 16)
    public String header2CaractVerif;

    /* codigo de institucion solicitante */
    @DataField(pos = 69, length = 10)
    public String header2CodInstitucion;

    /* codigo de servidor reniec */
    @DataField(pos = 79, length = 10)
    public String header2CodServerReniec;

    /* agencia de la institucion solicitante */
    @DataField(pos = 89, length = 10)
    public String header2AgenciaInstSolic;

    /* usuario final de la institucion solicitante */
    @DataField(pos = 99, length = 10)
    public String header2UsuarioFinalInst;

    /* host final de la institucion solicitante */
    @DataField(pos = 109, length = 10)
    public String header2HostFinalInst;

    /* reservado */
    @DataField(pos = 119, length = 10)
    public String header2Reservado;

    /* Numero de coincidencias solicitadas */
    @DataField(pos = 129, length = 4)
    public String header2Coincidencias;

    /* incio de grupo () */
    @DataField(pos = 133, length = 4)
    public String header2Grupo;

    /* apellido paterno */
    @DataField(pos = 137, length = 40)
    public String header2ApellidoPaterno;

    /* apellido materno */
    @DataField(pos = 177, length = 40)
    public String header2ApellidoMaterno;

    /* Primer o segundo prenombre */
    @DataField(pos = 217, length = 60)
    public String header2Prenombres;

    /* Reservado para uso futuro */
    @DataField(pos = 277, length = 5)
    public String header2ReservadoSubConsulta;

    /**
     * Concatena los campos de la consulta para ser ingresado en la cola de inicio
     * 
     * @return La cadena de campos concatenados
     */
    public String getTramaHeader() {
        return header2Version + header2LonCabecera + header2TipoServicio + header2LongTotalTrama + header2Fragmentacion
                + header2Ttl + header2TipoConsulta + header2CaractVerif
                + header2CodInstitucion + header2CodServerReniec + header2AgenciaInstSolic + header2UsuarioFinalInst
                + header2HostFinalInst + header2Reservado;
    }

}
