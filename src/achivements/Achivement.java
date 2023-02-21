package achivements;

public class Achivement{

	protected String Name;
	
	public Achivement(String achivementName) {
		this.Name = achivementName;
	}

	public String getName() {
		return Name;
	}

	public Integer getPoints() throws AchivementObjectHasNoPoints{
		throw new AchivementObjectHasNoPoints(this.getClass().toString());
	}

	public String getBadge() throws AchivementObjectHasNoBadge {
		throw new AchivementObjectHasNoBadge(this.getClass().toString());
	}
	
	public boolean equals(Achivement other) {
		return this.Name.equals(other.Name);
	}
	
	public boolean equals(String AchivementType) {
		return this.Name.equals(AchivementType);
	}

	public void addPoints(Achivement other) throws AchievmentsHasNoPointsToAdd, AchivementObjectHasNoPoints {
		throw new AchievmentsHasNoPointsToAdd(this.getClass().toString());
	}
	

}
