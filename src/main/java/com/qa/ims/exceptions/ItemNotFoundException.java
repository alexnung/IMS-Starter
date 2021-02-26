package com.qa.ims.exceptions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.sql.SQLException;

public class ItemNotFoundException extends RuntimeException {
	
	private static final Logger LOGGER = LogManager.getLogger();

	private static final long serialVersionUID = -1319030538360418254L;
	

}
