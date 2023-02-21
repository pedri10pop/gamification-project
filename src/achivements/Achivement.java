package achivements;

public abstract class Achivement{

	protected String Name;

	public String getName() {
		return Name;
	}

	public abstract Integer getPoints();

	public abstract String getBadge();
	
	public abstract boolean equals(Achivement other);

	public abstract void addPoints(Achivement other);
	

}
