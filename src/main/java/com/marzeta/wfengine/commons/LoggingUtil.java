package com.marzeta.wfengine.commons;

import java.util.logging.ConsoleHandler;
import java.util.logging.Formatter;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

public class LoggingUtil {

	public static void setupLogger(Logger LOG) {
		LOG.setLevel(Level.INFO);
		LOG.setUseParentHandlers(false);
		Handler conHdlr = new ConsoleHandler();
		conHdlr.setFormatter(new Formatter() {
			@Override
			public String format(LogRecord record) {
				return record.getLevel() 
						+ " -:- " + record.getSourceClassName() + "." + record.getSourceMethodName() 
						+ " -:- " + record.getMessage()	+ "\n";
			}
		});
		for (Handler handler : LOG.getHandlers()){
			LOG.removeHandler(handler);
		}
		LOG.addHandler(conHdlr);
	}
}
