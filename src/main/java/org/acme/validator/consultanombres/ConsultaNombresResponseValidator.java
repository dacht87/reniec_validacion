package org.acme.validator.consultanombres;

import java.util.regex.Pattern;

import org.acme.bean.consultanombres.ConsultaNombresResponse;
import org.acme.utils.Constants;
import org.acme.utils.ErrorCodes;
import org.acme.validator.HeaderValidator;
import org.acme.validator.Validator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ConsultaNombresResponseValidator implements Validator {
	// Regex para validar que todos sean caracteres alfabeticos
    private static final Pattern ALPHABETIC_PATTERN = Pattern.compile("^[a-zA-Z]+$");
    
    // Regex para validar que todos sean caracteres alfabéticos con espacios entre nombres
    private static final Pattern ALPHABETIC_PATTERN_WITH_SPACES = Pattern.compile("^[a-zA-Z]+[\\s[a-zA-Z]+]*$");
	
	// Logger para registrar información
    private Logger logger = LoggerFactory.getLogger(ConsultaNombresResponseValidator.class);
    
	private ConsultaNombresResponse classObject;
	
	public ConsultaNombresResponseValidator(ConsultaNombresResponse element) {
		this.classObject = element;
	}
	
	// validate headers
	public void validateHeaders() {
		Validator validator = new HeaderValidator(this.classObject.getHeaders());
    	validator.validate();
	}
	
	//validate numCoincidenciasSolicitadas
	public void validateNumCoincidenciasSolicitadas() {
		if (this.classObject.getNumCoincidenciasSolicitadas() > 30 || 
				this.classObject.getNumCoincidenciasSolicitadas() <= 0) {
	        throw new IllegalArgumentException(ErrorCodes.ERROR_IN_NUMBER_OF_MATCHES);
	    }
	}
	//validate inicioGrupo
	public void validateInicioGrupo() {
		if (this.classObject.getInicioGrupo() < 0) {
			throw new IllegalArgumentException(ErrorCodes.ERROR_IN_NUMBER_OF_MATCHES);
		}
	}
	
	//validate apellido paterno
	public void validateApellidoPaterno() {
		if (this.classObject.getApellidoPaterno()== null || this.classObject.getApellidoPaterno().equals("") ||
				!ALPHABETIC_PATTERN.matcher(this.classObject.getApellidoPaterno()).matches() ||
				this.classObject.getApellidoPaterno().length() > Constants.MAX_LENGTH_LASTNAMES) {
			throw new IllegalArgumentException(ErrorCodes.INVALID_PATERNAL_SURNAME);
	    }
	}
	
	//validate apellido materno
	public void validateApellidoMaterno() {
		if (this.classObject.getApellidoMaterno()== null || this.classObject.getApellidoMaterno().equals("") ||
				!ALPHABETIC_PATTERN.matcher(this.classObject.getApellidoMaterno()).matches() ||
				this.classObject.getApellidoMaterno().length() > Constants.MAX_LENGTH_LASTNAMES) {
			throw new IllegalArgumentException(ErrorCodes.INVALID_MATERNAL_SURNAME);
	    }
	}
	
	//validate prenombres
	public void validateNombres() {
		if (this.classObject.getPrenombres()== null || this.classObject.getPrenombres().equals("") || 
				!ALPHABETIC_PATTERN_WITH_SPACES.matcher(this.classObject.getPrenombres()).matches() || 
				this.classObject.getPrenombres().length() > Constants.MAX_LENGTH_NAMES) {
			throw new IllegalArgumentException(ErrorCodes.INVALID_NAMES);
	    }
	}
	
	//validate reservado
	public void validatereservadoSubTrama() {
		if (this.classObject.getReservadoSubTrama()!= Constants.RESERVADO_REQUEST_BY_NAME_SUB_TRAMA_LENGTH ) {
	        throw new IllegalArgumentException(ErrorCodes.INVALID_TRAMA_REQUEST_LEGNTH);
	    }
	}
	@Override
	public void validate() {
		//validate headers
		this.validateHeaders();
		//validate attributes
		this.validateNumCoincidenciasSolicitadas();
		this.validateInicioGrupo();
		this.validateApellidoPaterno();
		this.validateApellidoMaterno();
		this.validateNombres();
		this.validatereservadoSubTrama();
	}

}
