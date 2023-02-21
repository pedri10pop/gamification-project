package storage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import achivements.AchievmentsHasNoPointsToAdd;
import achivements.Achivement;
import achivements.AchivementObjectHasNoPoints;
import user.User;

public class InMemoryAchivementStorage implements AchivementStorage {

	private Map<String, List<Achivement>> storage = new HashMap<>();
	
	@Override
	public List<Achivement> getAchivements(String user) {
		return storage.get(user);
	}

	@Override
	public Achivement getAchivement(String user, String achivemet) {
		return null;
	}

	@Override
	public void addAchivement(User user, Achivement a) throws AchievmentsHasNoPointsToAdd, AchivementObjectHasNoPoints{	
		List<Achivement> achives = storage.get(user.getName());
		Achivement acvmt;
		if(achives == null)
			achives = new ArrayList<>();
		else
			for(Achivement ac : achives)
				if(ac.equals(a))
					ac.addPoints(a);
		
		achives.add(a);
		storage.put(user.getName(), achives);	
	}

}
