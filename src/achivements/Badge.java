package achivements;

public class Badge extends Achivement {
	
	private String badgeName;
	
	public Badge(String achivementName, String badgeName) {
		super(achivementName);
		this.badgeName = badgeName;
	}
	
	public String getBadge() {
		return badgeName;
	}

}
