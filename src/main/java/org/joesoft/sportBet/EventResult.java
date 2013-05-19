package org.joesoft.sportBet;

public enum EventResult {
	NOT_FINISHED("-"), FIRST_WON("1"), SECOND_WON("2"), DRAWN("x");
	
	private String code;
	
	private EventResult(String code) {
		this.code = code;
	}
	
	public String getCode() {
		return code;
	}
}
