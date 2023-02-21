package achivements;

public class Points extends Achivement {

	private Integer points;
	
	public Points(String achivementName, Integer points) {
		this.Name = achivementName;
		this.points = points;
	}
	
	public Integer getPoints() {
		return points;
	}

	@Override
	public void addPoints(Achivement other){
		if(other.getClass().equals(this.getClass()))
			this.points += other.getPoints();
		
	}

	@Override
	public String getBadge() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean equals(Achivement other) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean equals(String AchivementType) {
		// TODO Auto-generated method stub
		return false;
	}

}
