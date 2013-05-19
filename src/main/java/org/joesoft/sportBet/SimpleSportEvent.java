package org.joesoft.sportBet;

import java.util.Random;

public class SimpleSportEvent implements SportEvent {
	
	private final String evetName;
	private final int percent1;
	private final int percent2;
	private final int percentX;
	private final long startsAt;
	private final long endsAt;
	private final Random random;
	private EventResult result = EventResult.NOT_FINISHED;
	
	public SimpleSportEvent(String evetName, int percent1, int percent2,
			int percentX, long startsAt, long endsAt) {
		this.evetName = evetName;
		this.percent1 = percent1;
		this.percent2 = percent2;
		this.percentX = percentX;
		this.startsAt = startsAt;
		this.endsAt = endsAt;
		
		this.random = new Random();
	}
	
	public EventResult getResult() {
		return result;
	}

	public boolean canBetOnIt(long actualTime) {
		return isAfterStartTime(actualTime) && isBeforeEndTime(actualTime);
	}

	private boolean isBeforeEndTime(long actualTime) {
		return actualTime <= endsAt;
	}

	private boolean isAfterStartTime(long actualTime) {
		return startsAt <= actualTime;
	}
	
	public String getEvetName() {
		return evetName;
	}

	public int getPercent1() {
		return percent1 + getRandomTwentyFivePercent();
	}

	public int getPercent2() {
		return percent2 + getRandomTwentyFivePercent();
	}

	public int getPercentX() {
		return percentX + getRandomTwentyFivePercent();
	}

	public long getStartsAt() {
		return startsAt;
	}

	public long getEndsAt() {
		return endsAt;
	}
	
	public void setResult(EventResult result) {
		this.result = result;
	}
	
	private int getRandomTwentyFivePercent() {
		return random.nextInt(50) - 25;
	}
}
