package org.acme.utils;

public class ErrorCodes {
	private ErrorCodes() {
		// This constructor will prevent the class from being instantiated
        // as it is marked private and has no implementation
	}
	// Success Codes
	public static final String  SUCCESS_CODE = "0000";
	// Error Codes
    public static final String  INVALID_VERSION = "5002";
    public static final String  INVALID_HEADER_LENGTH = "5003";
    public static final String  INVALID_SERVICE_CHAR = "5004";
    public static final String  INVALID_SERVER = "5008";
    public static final String  INVALID_REQUEST = "5009";
    public static final String  NOT_ALLOWED_REQEST = "5010";
    public static final String  NOT_ALLOWED_TYPE_OF_REQUEST = "5011";
    public static final String  NO_COMPANY_EXIST = "5020";
    public static final String  COMPANY_IS_NOT_AVAILABLE = "5021";
    public static final String  NO_INFO_ABOUT_USER = "5031";
    public static final String  CANCELED_BY_RUIPN = "5032";
    public static final String  RESTRINGED_BY_RUIPN = "5033";
    public static final String  OBSERVED_BY_RUIPN = "5034";
    public static final String  TEMPORALY_UNAVAILABLE = "5036";
    public static final String  PERMANENTLY_UNAVAILABLE = "5037";
    public static final String  INVALID_TRAMA_REQUEST_LEGNTH = "5100";
    public static final String  ERROR_IN_NUMBER_OF_MATCHES= "5101";
    public static final String  MATCHES_EXCEED_ESTABLISH_LIMIT = "5102";
    public static final String  DATABASE_ERROR = "5103";
    public static final String  INVALID_PATERNAL_SURNAME = "5108";
    public static final String  INVALID_MATERNAL_SURNAME = "5109";
    public static final String  INVALID_NAMES = "5110";
    public static final String  CANCELED_BY_MAGNETIC_FILE_RUIPN = "5111";
    public static final String  RESTRINGED_BY_MAGNETIC_FILE_RUIPN = "5112";
    public static final String  OBSERVED_BY_MAGNETIC_FILE_RUIPN = "5113";
    public static final String  INVALID_DNI = "5114";
    public static final String  NO_REQUESTED_DATA_EXIST = "5200";
    public static final String  ERROR_PHOTO = "5202";
    public static final String  ERROR_SIGNATURE = "5203";
    
    public static boolean isValidErrorCode(String errorCode) {
    	switch (errorCode) {
        case ErrorCodes.SUCCESS_CODE:
        case ErrorCodes.INVALID_VERSION:
        case ErrorCodes.INVALID_HEADER_LENGTH:
        case ErrorCodes.INVALID_SERVICE_CHAR:
        case ErrorCodes.INVALID_SERVER:
        case ErrorCodes.INVALID_REQUEST:
        case ErrorCodes.NOT_ALLOWED_REQEST:
        case ErrorCodes.NOT_ALLOWED_TYPE_OF_REQUEST:
        case ErrorCodes.NO_COMPANY_EXIST:
        case ErrorCodes.COMPANY_IS_NOT_AVAILABLE:
        case ErrorCodes.NO_INFO_ABOUT_USER:
        case ErrorCodes.CANCELED_BY_RUIPN:
        case ErrorCodes.RESTRINGED_BY_RUIPN:
        case ErrorCodes.OBSERVED_BY_RUIPN:
        case ErrorCodes.TEMPORALY_UNAVAILABLE:
        case ErrorCodes.PERMANENTLY_UNAVAILABLE:
        case ErrorCodes.INVALID_TRAMA_REQUEST_LEGNTH:
        case ErrorCodes.ERROR_IN_NUMBER_OF_MATCHES:
        case ErrorCodes.MATCHES_EXCEED_ESTABLISH_LIMIT:
        case ErrorCodes.DATABASE_ERROR:
        case ErrorCodes.INVALID_PATERNAL_SURNAME:
        case ErrorCodes.INVALID_MATERNAL_SURNAME:
        case ErrorCodes.INVALID_NAMES:
        case ErrorCodes.CANCELED_BY_MAGNETIC_FILE_RUIPN:
        case ErrorCodes.RESTRINGED_BY_MAGNETIC_FILE_RUIPN:
        case ErrorCodes.OBSERVED_BY_MAGNETIC_FILE_RUIPN:
        case ErrorCodes.INVALID_DNI:
        case ErrorCodes.NO_REQUESTED_DATA_EXIST:
        case ErrorCodes.ERROR_PHOTO:
        case ErrorCodes.ERROR_SIGNATURE:
        // Add more valid error codes here...
            return true;
        default:
            return false;
    }
    }
}
