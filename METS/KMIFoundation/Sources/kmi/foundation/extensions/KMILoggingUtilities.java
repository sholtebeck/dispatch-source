package kmi.foundation.extensions;

import org.apache.log4j.Logger;

public class KMILoggingUtilities {

	public static void logStatement(Logger log, String message) {
		log.error(KMIStringUtilities.ERROR_STRING_DIVIDER);
		log.error(message);
		log.error(KMIStringUtilities.ERROR_STRING_DIVIDER);
	}
	
}
