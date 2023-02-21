package storage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import achivements.Achievement;

public class InMemoryAchievementStorage implements AchivementStorage {

	private Map<String, List<Achievement>> storage = new HashMap<>();
	private List<AchievementObserver> observers = new ArrayList<>();
	
	@Override
	public List<Achievement> getAchivements(String user) {
		return storage.get(user);
	}

	@Override
	public Achievement getAchivement(String user, String achivementName) {
		List<Achievement> userAchivements = storage.get(user);
		
		if(userAchivements == null)
			return null;
		
		for (Achievement a : userAchivements) {
			if(a.getName().equals(achivementName))
				return a;
		}
		
		return null;
	}

	@Override
	public void addAchivement(String user, Achievement a){	
		List<Achievement> userAchivements = storage.containsKey(user) 
				? storage.get(user)
				: new ArrayList<>();
		
		for(Achievement ac : userAchivements ) {
			if(ac.equals(a)) {
				ac.addPoints(a);
				storage.put(user, userAchivements);
				achievementListUpdate(user, ac);
				return ;
			}
		}

		userAchivements.add(a);
		achievementListUpdate(user,a);
		storage.put(user, userAchivements);
	}

	@Override
	public void addBadgeObserver(AchievementObserver badgeObserver) {

		observers.add(badgeObserver);
		
	}
	
	private void achievementListUpdate(String user, Achievement a) {
		observers.forEach((x) -> x.achievementUpdate(user, a));
	}

}
