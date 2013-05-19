package org.joesoft.sportBet;

import org.junit.Before;
import org.junit.Test;

import junit.framework.TestCase;

public class SimpleSportEventTest extends TestCase {
	
	private static final int PERCENTAGE_X = 10;
	private static final int PERCENTAGE_2 = 50;
	private static final int PERCENTAGE_1 = 40;
	private static final String TEST_EVENT_NAME = "event";
	private static final long END_TIME = 3000L;
	private static final long START_TIME = 2000L;
	private SportEvent underTest;
	
	@Before
	public void setUp() {
		underTest = new SimpleSportEvent(TEST_EVENT_NAME, PERCENTAGE_1, 
				PERCENTAGE_2, PERCENTAGE_X, START_TIME, END_TIME);
	}

	@Test
	public void testCanBetOnItShoudReturnFalseWhenTheActualTimeIsLowerAsTheStartTime() {
		boolean canBetOnIt = underTest.canBetOnIt(500L);
		
		assertFalse(canBetOnIt);
	}
	
	@Test
	public void testCanBetOnItShoudTrueFalseWhenTheActualTimeIsHigherAsTheStartTimeButLowerThanEndTime() {
		boolean canBetOnIt = underTest.canBetOnIt(2500L);
		
		assertTrue(canBetOnIt);
	}

}
