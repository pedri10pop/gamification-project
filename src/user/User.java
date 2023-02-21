package user;

import java.util.ArrayList;
import java.util.List;

import achivements.AchievmentsHasNoPointsToAdd;
import achivements.Achivement;
import achivements.AchivementObjectHasNoPoints;
import achivements.PointsAchivement;

public class User {

	private String name;
	private List<Achivement> achivements = new ArrayList<Achivement>();
	
	public User(String Name) {
		this.name = Name;
	}

	public String getName() {
		return name;
	}

	public Integer getPoints() {
		Integer total = 0;
		total = totalPoint(total);
		return total;
	}

	public void newAchivement(Achivement a) throws AchievmentsHasNoPointsToAdd, AchivementObjectHasNoPoints {
		if(alreadyHaveThisAchivement(a)) 
			addPointsToAchivement(a);
		else
			achivements.add(a);
	}


	public Integer getAchivementPoints(String achivementName) throws UserHasNotThisAchivement, AchivementObjectHasNoPoints {
		for(Achivement a : achivements) {
			if(isDesiredPointAchiviment(achivementName, a))
				return a.getPoints();
		}
		throw new UserHasNotThisAchivement(achivementName);
	}
	
	private void addPointsToAchivement(Achivement a) throws AchievmentsHasNoPointsToAdd, AchivementObjectHasNoPoints {
		for(Achivement ac : achivements) {
			if(isPointAchivementsEquals(a, ac)) {
					ac.addPoints(a);
			}
		}
	}
	
	private boolean alreadyHaveThisAchivement(Achivement a) {
		for(Achivement ac : achivements) 
			if(isPointAchivementsEquals(a, ac))
				return true;
		return false;
	}
	
	private Integer totalPoint(Integer total) {
		for(Achivement a : achivements) {
			try {
				total += a.getPoints();
			} catch (AchivementObjectHasNoPoints e) {
				
			}
		}
		return total;
	}
	
	private boolean isDesiredPointAchiviment(String achivementName, Achivement a) {
		return a.getClass().equals(PointsAchivement.class) && achivementName.equals(a.getName());
	}
	
	private boolean isPointAchivementsEquals(Achivement a, Achivement b) {
		return b.equals(a) && a.getClass().equals(PointsAchivement.class);
	}

	
}
