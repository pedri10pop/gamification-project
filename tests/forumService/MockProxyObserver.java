package forumService;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BooleanSupplier;

import achivements.Achievement;
import storage.AchievementObserver;

public class MockProxyObserver implements AchievementObserver {
	
	private List<Achievement> calledAchievements = new ArrayList<>(); 
	
	@Override
	public void achievementUpdate(String user, Achievement a) {
		calledAchievements.add(a);
	}

	public BooleanSupplier wasCalled(String achievementName) {
		return () -> {
			for(Achievement a : calledAchievements)
				if(a.getName().equals(achievementName))
					return true;
			return false;
		};
	}
	
	public BooleanSupplier wasBadgeCalled(String badgeName) {
		return () -> {
			for(Achievement a : calledAchievements)
				if(a.getBadge() != null && a.getBadge().equals(badgeName))
					return true;
			return false;
		};
	}
	
	

}
