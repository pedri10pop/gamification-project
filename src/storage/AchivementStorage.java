package storage;

import java.util.List;

import achivements.Achivement;

public interface AchivementStorage {
	
	public List<Achivement> getAchivements(String user);

	public Achivement getAchivement(String user, String a);

	public void addAchivement(String user, Achivement a);

}
