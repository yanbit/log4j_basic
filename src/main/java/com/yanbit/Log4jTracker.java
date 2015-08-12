package com.yanbit;

import java.util.Random;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


/**
 * @author yanbit
 *
 *	tracker var 
 */
public class Log4jTracker {
	private static Logger logger = LogManager.getLogger(Log4jTracker.class.getName());
	
	public static void main(String[] args) {
		printMsg("yankun");
	}
	
	public static void printMsg(String msg){
		logger.entry(msg);
		try {
			System.out.println("hello "+msg);
			//throw new NullPointerException();
		} catch (Exception e) {
			e.printStackTrace();
			//logger.catching(e);
		}
		logger.exit(msg);
	}
}
