package org.acme.bean.consultanombres;


import org.acme.bean.ClassWithValidation;
import org.acme.bean.header.Header;
import org.acme.utils.Constants;
import org.acme.validator.Validator;
import org.acme.validator.consultanombres.ConsultaNombresResponseValidator;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ConsultaNombresResponse implements ClassWithValidation{
	/*Header*/
	private Header headers;
	
	/*numero de coincidencia solitadas 
	 		*Debe ser menor o igual a 30	*/
	private int numCoincidenciasSolicitadas;
	
	/*inicio de grupo 
 			*Si se solicitan los registros por grupos, este campo sirve para indicar en que registro comienza el siguiente grupo */
	private int inicioGrupo;
	
	/*apellido paterno
 			*apellido paterno	*/
	private String apellidoPaterno;
	
	/*apellido materno
 			*apellido materno*/
	private String apellidoMaterno;
	
	/*prenombres
 			*primer o segundo prenombre 	*/
	private String prenombres;
	
	/*reservado
 			*Reservado para uso futuro 	*/
	private int reservadoSubTrama = Constants.RESERVADO_REQUEST_BY_NAME_SUB_TRAMA_LENGTH;

	@Override
	public void validate() {
		try {
			//valida los atributos
			Validator validator = new ConsultaNombresResponseValidator(this);
			validator.validate();
		} catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(e.getMessage(), e); //e.getMessage() contiene el codigo de error
        }
	}
}
