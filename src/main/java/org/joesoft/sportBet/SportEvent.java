package org.joesoft.sportBet;

public interface SportEvent {
	boolean canBetOnIt(long actualTime);
	EventResult getResult();
}
