package achivements;

public class AchievmentsHasNoPointsToAdd extends Exception {

	AchievmentsHasNoPointsToAdd(String e){
		super("The class "+ e +" has no points to be added");
	}
}
