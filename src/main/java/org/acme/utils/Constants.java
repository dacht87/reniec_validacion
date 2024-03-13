package org.acme.utils;

public class Constants {
	
	private Constants() {
		// This constructor will prevent the class from being instantiated
        // as it is marked private and has no implementation
	}
	//------------ Constants for RequestHeaders
	/*version*/
	public static final int VERSION_LENGTH = 4;
	
	/*longitud de la cabecera*/
	public static final int TRAMA_HEADER_LENGTH = 4;
	
	/*tipo de servicio*/
	public static final int TIPO_SERVICIO_LENGTH = 3;
	
	/*longitud total de la trama*/
	public static final int TOTAL_TRAMA_LENGTH = 9;
	
	/*fragmentacion*/
	public static final int FRAGMENTACION_LENGTH = 22;
	
	/*tiempo de vida del mensaje en la cola de respuesta*/
	public static final int TTL_LENGTH = 9;
	
	/*tipo de consulta de nombres*/
	public static final int TIPO_CONSULTA_LENGTH = 1;
	public static final String BUSQUEDA_POR_NOMBRES_CONSULTA_LENGTH = "1";
	public static final String BUSQUEDA_POR_DNI_CONSULTA_LENGTH = "2";
	
	/*caracteres de verificacion*/
	public static final int CARACTERES_VERIFICACION_LENGTH = 16;
	
	/*codigo de institucion solicitante*/
	public static final int CODIGO_INSTITUCION_LENGTH = 10;
	
	/*codigo de servidor reniec*/
	public static final int CODIGO_SERVIDOR_LENGTH = 10;
	
	/*agencia de la institucion solicitante*/
	public static final int AGENCIA_INSTITUCION_LENGTH = 10;
	
	/*usuario final de la institucion solicitante*/
	public static final int USUARIO_FINAL_LENGTH = 10;
	
	/*host final de la institucion solicitante*/
	public static final int HOST_FINAL_LENGTH = 10;
	
	/*reservado*/
	public static final int RESERVADO_HEADER_LENGTH = 10;
	
	//------------ Constants for ResponseHeaders
    public static final int MAX_NUM_RESULTS = 250;
    

	//------------ Constants for requestBody
	
    // Constants for RequestConsultaPorNombresValidator
    public static final int MAX_NUM_COINCIDENCIAS = 30;
    public static final int MAX_LENGTH_LASTNAMES = 40;
    public static final int MAX_LENGTH_NAMES = 60;
    public static final int RESERVADO_REQUEST_BY_NAME_SUB_TRAMA_LENGTH = 5;
    
    
    //------------ Constants for responseBody
        
    // Constants for RequestConsultaPorNombresValidator
    public static final int RESERVADO_RESPONSE_BY_NAME_SUB_TRAMA_LENGTH = 8;
    //------------ Constants for PersonaCoincidenciaPorNombres
    public static final int RESERVADO_PERSONA_BY_NAME_SUB_TRAMA_LENGTH = 10;
    // Add more constants as needed...
}
