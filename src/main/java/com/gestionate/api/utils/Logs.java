package com.gestionate.api.utils;

import org.jboss.logging.Logger;

public class Logs {

	private static final Logger LOGGER = Logger.getLogger(Logger.class);
	
	public static void logInfo(String nombreClase, String nombreMetodo, String parametros, String concatenacion) {		
		LOGGER.info(nombreClase + "::" + nombreMetodo + "(" +parametros+ ") - " + concatenacion);		
	}
	
	public static void logInfo(String nombreClase, String nombreMetodo, long parametros, String concatenacion) {		
		LOGGER.info(nombreClase + "::" + nombreMetodo + "(" +parametros+ ") - " + concatenacion);		
	}
	
}
