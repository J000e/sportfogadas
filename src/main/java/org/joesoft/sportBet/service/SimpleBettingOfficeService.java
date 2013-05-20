package org.joesoft.sportBet.service;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.joesoft.sportBet.BettingOffice;
import org.joesoft.sportBet.SimpleBettingOffice;

public class SimpleBettingOfficeService extends SimpleAbstractBaseService implements BettingOfficeService {

	private static final int NAME_COLUMN = 0;
	private static final int PORTNUMBER_COLUMN = 1;
	private static final int MAXIMUM_BET_COLUMN = 2;
	private static final int P_COLUMN = 3;
	private List<BettingOffice> offices;

	public SimpleBettingOfficeService(InputStream initFile) {
		offices = new ArrayList<BettingOffice>();
		processFile(initFile);
	}

	public List<Integer> startBettingOffices() {
		return null;
	}

	@Override
	protected void storeInformation(String[] line) {
		String name = getStringFromArray(line, NAME_COLUMN);
		int portNumber = getIntFromArray(line, PORTNUMBER_COLUMN);
		int maximumBet = getIntFromArray(line, MAXIMUM_BET_COLUMN);
		int p = getIntFromArray(line, P_COLUMN);
		
		offices.add(new SimpleBettingOffice(name, portNumber, maximumBet, p));
	}

}
