package org.acme.bean.header;


import org.acme.bean.ClassWithValidation;
import org.acme.utils.Constants;
import org.acme.validator.HeaderValidator;
import org.acme.validator.Validator;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * clase que contendrá todos los atributos correspondientes al header
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Header implements ClassWithValidation{
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
    private int espacioReservadoHeader = Constants.RESERVADO_HEADER_LENGTH;

	@Override
	public void validate() {
		try {
			Validator validator = new HeaderValidator(this);
			validator.validate();
		} catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(e.getMessage(), e); //e.getMessage() contiene el codigo de error
        }
	}
}
