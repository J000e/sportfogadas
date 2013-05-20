package org.joesoft.sportBet.service;

import java.io.InputStream;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class SimpleAbstractBaseService {

	private static final Logger logger = LoggerFactory.getLogger(SimpleAbstractBaseService.class);

	protected static final String ERROR_STRING = "###";
	protected static final int ERROR_INT = -1;
	private static final long ERROR_LONG = -1L;
	
	protected abstract void storeInformation(String[] line);
	
	protected void processFile(InputStream initFile) {
		Scanner scanner = null;
		scanner = new Scanner(initFile);
		
		while(scanner.hasNext()) {
			processLine(scanner.nextLine());
		}
	}
	
	protected void processLine(String nextLine) {
		if (! isComment(nextLine)) {
			String[] splitLine = nextLine.split("#");
			storeInformation(splitLine);
		}
	}
	
	protected boolean isComment(String nextLine) {
		return nextLine.startsWith("//");
	}
	
	protected String getStringFromArray(final String[] array, final int index) {
		String result = ERROR_STRING;
		try {
			result = array[index];
		} catch (ArrayIndexOutOfBoundsException e) {
			logger.error("Overindexed array: ", e);
		}
		
		return result;
	}
	
	protected int getIntFromArray(final String[] array, final int index) {
		int result = ERROR_INT;
		try {
			result = Integer.parseInt(array[index]);
		} catch (ArrayIndexOutOfBoundsException e) {
			logger.error("Overindexed array: ", e);
		} catch (NumberFormatException e) {
			logger.error("Malformed input: ", e);
		}
		
		return result;
	}
	
	protected long getLongFromArray(final String[] array, final int index) {
		long result = ERROR_LONG;
		try {
			result = Long.parseLong(array[index]);
		} catch (ArrayIndexOutOfBoundsException e) {
			logger.error("Overindexed array: ", e);
		} catch (NumberFormatException e) {
			logger.error("Malformed input: ", e);
		}
		
		return result;
	}
}
