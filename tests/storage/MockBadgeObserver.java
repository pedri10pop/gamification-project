package storage;

import java.util.function.BooleanSupplier;

import achivements.Achievement;

public class MockBadgeObserver implements AchievementObserver {

	private BooleanSupplier wasCalled;
	
	@Override
	public void achievementUpdate(String user, Achievement achievement) {
		wasCalled = () -> true;
	}

	public BooleanSupplier wasCalled() {
		return wasCalled;
	}

}
