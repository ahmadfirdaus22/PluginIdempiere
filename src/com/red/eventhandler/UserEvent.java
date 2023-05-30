package com.red.eventhandler;

import java.util.logging.Logger;
import java.util.Map;


public class UserEvent  {

	private static final Logger logger = Logger.getLogger(null);

	public void handleRequest(String endpoint, Map<String, String> headers, String payload) {
		   	logger.info("Received API request:");
	        logger.info("Endpoint: " + endpoint);
	        logger.info("Headers: " + headers.toString());
	        logger.info("Payload: " + payload);
	}
}
