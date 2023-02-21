package achivements;

public class AchivementObjectHasNoPoints extends Exception {

	public AchivementObjectHasNoPoints(String e) {
		super("An "+ e+" has no getPoints Implementation "+ e);
	}

	
}
