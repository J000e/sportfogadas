package org.joesoft.sportBet;

import java.util.ArrayList;
import java.util.List;

public class SimpleBettingOffice implements BettingOffice {

	private final String name;
	private final int portNumber;
	private final int maximumBet;
	private final int p;
	private List<SportEvent> events;
	public SimpleBettingOffice(String name, int portNumber, int maximumBet,
			int p) {
		this.name = name;
		this.portNumber = portNumber;
		this.maximumBet = maximumBet;
		this.p = p;
		this.events = new ArrayList<SportEvent>();
	}
	
	public String getName() {
		return name;
	}
	public int getPortNumber() {
		return portNumber;
	}
	public int getMaximumBet() {
		return maximumBet;
	}
	public int getP() {
		return p;
	}
	public List<SportEvent> getEvents() {
		return events;
	}
	public void setEvents(List<SportEvent> events) {
		this.events = events;
	}
	
}
