package storage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import achivements.Achivement;

public class InMemoryAchievementStorage implements AchivementStorage {

	private Map<String, List<Achivement>> storage = new HashMap<>();
	
	@Override
	public List<Achivement> getAchivements(String user) {
		return storage.get(user);
	}

	@Override
	public Achivement getAchivement(String user, String achivementName) {
		List<Achivement> userAchivements = storage.get(user);
		
		if(userAchivements == null)
			return null;
		
		for (Achivement a : userAchivements) {
			if(a.getName().equals(achivementName))
				return a;
		}
		
		return null;
	}

	@Override
	public void addAchivement(String user, Achivement a){	
		List<Achivement> userAchivements = storage.containsKey(user) 
				? storage.get(user)
				: new ArrayList<>();
		
		for(Achivement ac : userAchivements ) {
			if(ac.equals(a)) {
				ac.addPoints(a);
				storage.put(user, userAchivements);
				return ;
			}
		}

		userAchivements.add(a);
		
		storage.put(user, userAchivements);
	}

}
