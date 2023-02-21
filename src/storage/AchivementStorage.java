package storage;

import java.util.List;

import achivements.Achivement;
import user.User;

public interface AchivementStorage {
	
	public List<Achivement> getAchivements(String user);

	public Achivement getAchivement(String user, String a);

	public void addAchivement(String user, Achivement a);

}
