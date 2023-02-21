package user;

public class UserHasNotThisAchivement extends Exception {

	public UserHasNotThisAchivement(String e) {
		super("User do not have the "+ e +" achivement");
	}
	
}
