package achivements;

public class Points extends Achievement {

	private Integer points;
	
	public Points(String achivementName, Integer points) {
		this.Name = achivementName;
		this.points = points;
	}
	
	public Integer getPoints() {
		return points;
	}

	@Override
	public void addPoints(Achievement other){
		if(other.getClass().equals(this.getClass()))
			this.points += other.getPoints();
		
	}

	@Override
	public String getBadge() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean equals(Achievement other) {
		return this.Name.equals(other.Name) &&
				this.getClass().equals(other.getClass());
	}
}
