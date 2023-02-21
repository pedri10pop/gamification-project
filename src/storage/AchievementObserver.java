package storage;

import achivements.Achievement;

public interface AchievementObserver {
	
	public void achievementUpdate(String user, Achievement a);

}
