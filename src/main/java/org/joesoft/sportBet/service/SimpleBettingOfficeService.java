package org.joesoft.sportBet.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.joesoft.sportBet.BettingOffice;

public class SimpleBettingOfficeService implements BettingOfficeService {

	private List<BettingOffice> offices;

	public SimpleBettingOfficeService(File initFile) {
		offices = new ArrayList<BettingOffice>();
		processFile(initFile);
	}

	private void processFile(File initFile) {
		Scanner scanner = null;
		try {
			scanner = new Scanner(initFile);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		while(scanner.hasNext()) {
			processLine(scanner.nextLine());
		}
	}

	private void processLine(String nextLine) {
		if (! isComment(nextLine)) {
			String[] splitLine = nextLine.split("#");
//			if (isValid(splitLine)) {
				
//			}
		}
	}

	private boolean isComment(String nextLine) {
		return nextLine.startsWith("//");
	}

	public List<Integer> startBettingOffices() {
		return null;
	}

}
