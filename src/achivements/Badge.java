package achivements;

public class Badge extends Achievement {
	
	private String badgeName;
	
	public Badge(String achivementName, String badgeName) {
		this.Name = achivementName;
		this.badgeName = badgeName;
	}
	
	public String getBadge() {
		return badgeName;
	}

	@Override
	public Integer getPoints() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean equals(Achievement other) {
		return this.Name.equals(other.Name) &&
				this.badgeName.equals(other.getBadge());
	}

	@Override
	public void addPoints(Achievement other) {
		// TODO Auto-generated method stub
		
	}

}
