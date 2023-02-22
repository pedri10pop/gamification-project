package storage;

import java.util.List;

import achivements.Achievement;

public interface AchievementStorage {
	
	public List<Achievement> getAchivements(String user);

	public Achievement getAchivement(String user, String a);

	public void addAchivement(String user, Achievement a);

	public void addBadgeObserver(AchievementObserver badgeObserver);

}
