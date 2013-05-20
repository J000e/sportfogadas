package org.joesoft.sportBet.service;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.joesoft.sportBet.SimpleSportEvent;
import org.joesoft.sportBet.SportEvent;

public class SimpleSportEventService extends SimpleAbstractBaseService implements SportEventService {
	
	private static final int EVENT_ENDS_AT_COLUMN = 5;
	private static final int EVENT_STARTS_AT_COLUMN = 4;
	private static final int PERCENT_X_COLUMN = 3;
	private static final int PERCENT_2_COLUMN = 2;
	private static final int PERCENT_1_COLUMN = 1;
	private static final int EVENT_NAME_COLUMN = 0;
	private List<Integer> portNumbers;
	private List<SportEvent> sportEvents;

	public SimpleSportEventService(InputStream file) {
		sportEvents = new ArrayList<SportEvent>();
		processFile(file);
	}

	public void setOfficePorts(List<Integer> portNumbers) {
		this.portNumbers = portNumbers;
	}

	@Override
	protected void storeInformation(String[] line) {
		String evetName = getStringFromArray(line, EVENT_NAME_COLUMN);
		int percent1 = getIntFromArray(line, PERCENT_1_COLUMN);
		int percent2 = getIntFromArray(line, PERCENT_2_COLUMN);
		int percentX = getIntFromArray(line, PERCENT_X_COLUMN);
		long startsAt = getLongFromArray(line, EVENT_STARTS_AT_COLUMN);
		long endsAt = getLongFromArray(line, EVENT_ENDS_AT_COLUMN);
		
		sportEvents.add(new SimpleSportEvent(evetName, percent1, percent2, percentX, startsAt, endsAt));
	}

}
