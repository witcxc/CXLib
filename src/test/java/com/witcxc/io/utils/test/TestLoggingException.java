package com.witcxc.io.utils.test;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.logging.Logger;

class LoggingException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 8525854387182764559L;
	private static Logger logger = Logger.getLogger("LoggingException");
	public LoggingException(){
		StringWriter trace = new StringWriter();
		printStackTrace(new PrintWriter(trace));
		logger.severe(trace.toString());
	}
}
public class TestLoggingException {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{
			throw new LoggingException();
		}catch(LoggingException e){
			System.err.println("Caught "+e);
		}
		System.out.println();
		try{
			throw new LoggingException();
		}catch(LoggingException e){
			System.err.println("Caught "+e);
		}
		
	}

}
