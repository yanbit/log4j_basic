package com.yanbit;

import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.Marker;
import org.apache.logging.log4j.MarkerManager;
import org.omg.CosNaming.NamingContextExtPackage.AddressHelper;

public class Log4jMarker {
	private Logger logger = LogManager.getLogger(Log4jMarker.class.getName());
	private static final Marker SQL_MARKER = MarkerManager.getMarker("SQL");
	private static final Marker UPDATE_MARKER = MarkerManager.getMarker("SQL_UPDATE").setParents(SQL_MARKER);
	private static final Marker QUERY_MARKER = MarkerManager.getMarker("SQL_QUERY").setParents(SQL_MARKER);

	public static void main(String[] args) {
		Log4jMarker log = new Log4jMarker();
		HashMap<String, String> col = new HashMap<String, String>();
		col.put("key", "value");
		log.doQuery("table");
		log.doUpdate("table", col);
	}

	public String doQuery(String table) {
		logger.entry(table);

		logger.debug(QUERY_MARKER, "SELECT * FROM {}", table);

		return logger.exit(table);
	}

	public String doUpdate(String table, Map<String, String> params) {
		logger.entry(table, params);

		if (logger.isDebugEnabled()) {
			logger.debug(UPDATE_MARKER, "UPDATE {} SET {}", table, params);
		}
		return logger.exit(new StringBuffer().append(table).append(params).toString());
	}
}
