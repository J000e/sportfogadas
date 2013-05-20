package org.joesoft.sportBet;

import java.io.InputStream;
import java.util.List;

import org.joesoft.sportBet.service.BetMakerService;
import org.joesoft.sportBet.service.BettingOfficeService;
import org.joesoft.sportBet.service.SimpleBetMakerService;
import org.joesoft.sportBet.service.SimpleBettingOfficeService;
import org.joesoft.sportBet.service.SimpleSportEventService;
import org.joesoft.sportBet.service.SportEventService;

public class App {
	
	private static final String INIT_FILE_FOR_BET_MAKERS = "betMakers.txt";
	private static final String INIT_FILE_FOR_SPORT_EVENTS = "sportEvents.txt";
	private static final String INIT_FILE_FOR_BETTING_OFFICES = "bettingOffices.txt";
	private BettingOfficeService bettingOfficeService;
	private SportEventService sportEventService;
	private BetMakerService betMakerService; 
	
    public static void main( String[] args ) {
        new App();
    }
    
    private App() {
    	initServices();
    	
    	List<Integer> portNumbers = bettingOfficeService.startBettingOffices();
    	sportEventService.setOfficePorts(portNumbers);
    	betMakerService.setOfficePorts(portNumbers);
    	
    	providePortsForEvents(portNumbers);
    	providePortsForBetMakers(portNumbers);
    	
    }

	private void initServices() {
		bettingOfficeService = new SimpleBettingOfficeService(getInputStreamFromClassPath("/" + INIT_FILE_FOR_BETTING_OFFICES));
		sportEventService = new SimpleSportEventService(getInputStreamFromClassPath("/" + INIT_FILE_FOR_SPORT_EVENTS));
		betMakerService = new SimpleBetMakerService(getInputStreamFromClassPath("/" + INIT_FILE_FOR_BET_MAKERS));
	}

	private InputStream getInputStreamFromClassPath(String initFileForBettingOffices) {
		return this.getClass().getResourceAsStream(initFileForBettingOffices);
	}

	private void providePortsForBetMakers(List<Integer> portNumbers) {
		
	}

	private void providePortsForEvents(List<Integer> portNumbers) {
		
	}

}
