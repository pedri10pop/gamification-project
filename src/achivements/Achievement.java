package achivements;

public abstract class Achievement{

	protected String Name;

	public String getName() {
		return Name;
	}

	public abstract Integer getPoints();

	public abstract String getBadge();
	
	public abstract boolean equals(Achievement other);

	public abstract void addPoints(Achievement other);
	

}
