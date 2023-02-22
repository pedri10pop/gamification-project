package forumService;

import java.util.function.BooleanSupplier;

import achivements.Achievement;
import storage.AchievementObserver;

public class MockProxyObserver implements AchievementObserver {

	private BooleanSupplier wasCalled = () -> false;
	
	@Override
	public void achievementUpdate(String user, Achievement a) {
		this.wasCalled = () -> true;
	}

	public BooleanSupplier wasCalled() {
		return wasCalled;
	}

}
