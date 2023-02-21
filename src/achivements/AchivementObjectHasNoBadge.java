package achivements;

public class AchivementObjectHasNoBadge extends Exception {
	
	public AchivementObjectHasNoBadge(String e) {
		super("An "+ e +" has no getBadge Implementation "+ e);
	}

}
