package achivements;

public class PointsAchivement extends Achivement {

	private Integer points;
	
	public PointsAchivement(String achivementName, Integer points) {
		super(achivementName);
		this.points = points;
	}
	
	public Integer getPoints() {
		return points;
	}

	@Override
	public void addPoints(Achivement other) throws AchivementObjectHasNoPoints, AchievmentsHasNoPointsToAdd{
		if(other.getClass().equals(this.getClass()))
			this.points += other.getPoints();
		else
			throw new AchievmentsHasNoPointsToAdd("");
		
	}

}
