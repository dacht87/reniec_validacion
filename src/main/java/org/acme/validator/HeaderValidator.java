package org.acme.validator;

import org.acme.bean.header.Header;
import org.acme.utils.Constants;
import org.acme.utils.ErrorCodes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/*Esta clase contiene las validaciones de Header*/
@Getter
@Setter
@AllArgsConstructor
public class HeaderValidator  implements Validator {
	private Header header;
	// Logger para registrar información
    private Logger logger = LoggerFactory.getLogger(HeaderValidator.class);
    //constructor
    public HeaderValidator(Header element) {
		this.header = element;
	}
  //validate version
  	public void validateVersion() {
  		if(this.header.getVersion()!= null) {
  			if (this.header.getVersion().length() > Constants.VERSION_LENGTH) {
  	  			throw new IllegalArgumentException(ErrorCodes.INVALID_VERSION);
  	  	    }
  		}
  		else {
  			throw new IllegalArgumentException(ErrorCodes.INVALID_VERSION);
  		}
  	}
  	
  	//validate longitud de la cabecera
    public void validateLongCabecera() {
    	if(this.header.getLonCabecera()!= null) {
    		 if (this.header.getLonCabecera().length() != Constants.TRAMA_HEADER_LENGTH) {
    	            throw new IllegalArgumentException(ErrorCodes.INVALID_HEADER_LENGTH);
    	        }
    	}
    	else {
    		throw new IllegalArgumentException(ErrorCodes.INVALID_HEADER_LENGTH);
    	}
    }

    //validate tipo de servicio
    public void validateTipoServicio() {
    	if(this.header.getTipoServicio()!= null) {
    		if (this.header.getTipoServicio().length() != Constants.TIPO_SERVICIO_LENGTH) {
                throw new IllegalArgumentException(ErrorCodes.INVALID_SERVICE_CHAR);
            }
    	}
    	else {
    		throw new IllegalArgumentException(ErrorCodes.INVALID_SERVICE_CHAR);
    	}
        
    }
    
    //validate total de la trama
    public void validatelongTotalTrama() {
    	if(this.header.getLongTotalTrama()!= null) {
    		if (this.header.getLongTotalTrama().length() != Constants.TOTAL_TRAMA_LENGTH) {
                throw new IllegalArgumentException("La longitud del total de la trama debe ser " + Constants.TOTAL_TRAMA_LENGTH);
            }
    	}
    	else {
    		throw new IllegalArgumentException("La longitud del total de la trama debe ser " + Constants.TOTAL_TRAMA_LENGTH);
    	}
    }
    
    //validate fragmentacion
    public void validateFragmentacion() {
    	if(this.header.getFragmentacion()!= null) {
    		if (this.header.getFragmentacion().length() != Constants.FRAGMENTACION_LENGTH) {
                throw new IllegalArgumentException(ErrorCodes.INVALID_HEADER_LENGTH);
            }
    	}
    	else {
    		throw new IllegalArgumentException(ErrorCodes.INVALID_HEADER_LENGTH);
    	}
    }
    
    //validate tiempo de vida del mensaje en la cola de respuesta
    public void validateTtl() {
    	if(this.header.getTtl()!= null) {
    		if (this.header.getTtl().length() != Constants.TTL_LENGTH) {
                throw new IllegalArgumentException(ErrorCodes.INVALID_HEADER_LENGTH);
            }
    	}
    	else {
    		throw new IllegalArgumentException(ErrorCodes.INVALID_HEADER_LENGTH);
    	}
        
    }
    
    //validate tipo de consulta
    public void validateTipoConsulta() {
    	if(this.header.getTipoConsulta()!= null) {
    		if (this.header.getTipoConsulta().length() != Constants.TIPO_CONSULTA_LENGTH) {
                throw new IllegalArgumentException(ErrorCodes.INVALID_REQUEST);
            }
            if (!this.header.getTipoConsulta().equals(Constants.BUSQUEDA_POR_DNI_CONSULTA_LENGTH) &&
                    !this.header.getTipoConsulta().equals(Constants.BUSQUEDA_POR_NOMBRES_CONSULTA_LENGTH)) {
                    throw new IllegalArgumentException(ErrorCodes.INVALID_REQUEST);
            }
    	}
    	else {
    		throw new IllegalArgumentException(ErrorCodes.INVALID_HEADER_LENGTH);
    	}
    	
    }
    
    //validate caracteres de verificacion
    public void validateCaractVerif() {
    	if(this.header.getCaractVerif()!= null) {
    		if (this.header.getCaractVerif().length() != Constants.CARACTERES_VERIFICACION_LENGTH) {
                throw new IllegalArgumentException(ErrorCodes.INVALID_HEADER_LENGTH);
            }
    	}
    	else {
    		throw new IllegalArgumentException(ErrorCodes.INVALID_HEADER_LENGTH);
    	}
        
    }
    
    //validate codigo de institucion solicitante
    public void validateCodInstitucion() {
    	if(this.header.getCodInstitucion()!= null) {
    		if (this.header.getCodInstitucion().length() != Constants.CODIGO_INSTITUCION_LENGTH) {
                throw new IllegalArgumentException(ErrorCodes.INVALID_HEADER_LENGTH);
            }
    	}
    	else {
    		throw new IllegalArgumentException(ErrorCodes.INVALID_HEADER_LENGTH);
    	}
        
    }
    
    //validate codigo de servidor reniec
    public void validateCodServerReniec() {
    	if(this.header.getCodServerReniec()!= null) {
    		if (this.header.getCodServerReniec().length() != Constants.CODIGO_SERVIDOR_LENGTH) {
                throw new IllegalArgumentException(ErrorCodes.INVALID_SERVER);
            }
    	}
    	else {
    		throw new IllegalArgumentException(ErrorCodes.INVALID_SERVER);
    	}
        
    }
    
    //validate agencia de la institucion solicitante
    public void validateAgenciaInstSolic() {
    	if(this.header.getAgenciaInstSolic()!= null) {
    		if (this.header.getAgenciaInstSolic().length() != Constants.AGENCIA_INSTITUCION_LENGTH) {
                throw new IllegalArgumentException(ErrorCodes.NO_COMPANY_EXIST);
            }
    	}
    	else {
    		 throw new IllegalArgumentException(ErrorCodes.NO_COMPANY_EXIST);
		 }
    }
    
    //validate usuario final de la institucion solicitante
    public void validateUsuarioFinalInst() {
    	if(this.header.getUsuarioFinalInst()!= null) {
    		if (this.header.getUsuarioFinalInst().length() != Constants.USUARIO_FINAL_LENGTH) {
                throw new IllegalArgumentException(ErrorCodes.INVALID_HEADER_LENGTH);
            }
    	}
    	else {
    		throw new IllegalArgumentException(ErrorCodes.INVALID_HEADER_LENGTH);
    	}
    }
    
    //validate host final de la institucion solicitante
    public void validateHostFinalInst() {
    	if(this.header.getHostFinalInst()!=null) {
    		if (this.header.getHostFinalInst().length() != Constants.HOST_FINAL_LENGTH) {
                throw new IllegalArgumentException(ErrorCodes.INVALID_HEADER_LENGTH);
            }
    	}
    	else {
    		throw new IllegalArgumentException(ErrorCodes.INVALID_HEADER_LENGTH);
    	}
    }
    
    //validate reservado
    public void validateEspacioReservadoHeader() {
        if (this.header.getEspacioReservadoHeader() != Constants.RESERVADO_HEADER_LENGTH) {
            throw new IllegalArgumentException(ErrorCodes.INVALID_HEADER_LENGTH);
        }
    }
    
	@Override
	public void validate() {
		this.validateVersion();
		this.validateLongCabecera();
		this.validateTipoServicio();
		this.validatelongTotalTrama();
		this.validateFragmentacion();
		this.validateTtl();
		this.validateTipoConsulta();
		this.validateCaractVerif();
		this.validateCodInstitucion();
		this.validateCodServerReniec();
		this.validateAgenciaInstSolic();
		this.validateUsuarioFinalInst();
		this.validateHostFinalInst();
		this.validateEspacioReservadoHeader();
	}
}
