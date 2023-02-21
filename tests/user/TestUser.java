package user;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import achivements.AchievmentsHasNoPointsToAdd;
import achivements.Achivement;
import achivements.AchivementObjectHasNoPoints;
import achivements.Badge;
import achivements.PointsAchivement;

class TestUser {

	@Test
	void testCreateAnUser() {
		String userName = "Pedro";
		User u = new User(userName);
		
		assertEquals("Pedro", u.getName());
		assertEquals(0, u.getPoints());
	}
	
	@Test
	void testCreateAnUserAndGiveAchivements() throws AchievmentsHasNoPointsToAdd, AchivementObjectHasNoPoints {
		String userName = "Pedro";
		User u = new User(userName);
		
		Achivement a = new PointsAchivement("COMMENT", 5);
		u.newAchivement(a);
		
		assertEquals("Pedro", u.getName());
		assertEquals(5, u.getPoints());
	}
	
	@Test
	void testCreateAnUserAndGiveTowAchivements() throws AchievmentsHasNoPointsToAdd, AchivementObjectHasNoPoints {
		String userName = "Pedro";
		User u = new User(userName);
		
		Achivement a = new PointsAchivement("COMMENT", 5);
		Achivement b = new PointsAchivement("LIKE IT", 1);
		u.newAchivement(a);
		u.newAchivement(b);
		
		assertEquals("Pedro", u.getName());
		assertEquals(6, u.getPoints());
	}
	
	@Test
	void testCreateAnUserAndGiveBadge() {
		String userName = "Pedro";
		User u = new User(userName);
		
		Achivement a = new Badge("COMMENT", "YOU OWN IT");
		
		assertEquals("Pedro", u.getName());
		assertEquals(0, u.getPoints());
	}
	
	@Test
	void testCreateAnUserAndThreePointAchivmentsEqual() throws UserHasNotThisAchivement, AchivementObjectHasNoPoints, AchievmentsHasNoPointsToAdd {
		String userName = "Pedro";
		User u = new User(userName);
		
		Achivement a = new PointsAchivement("COMMENT", 5);
		Achivement b = new PointsAchivement("COMMENT", 5);
		Achivement c = new PointsAchivement("COMMENT", 5);
		u.newAchivement(a);
		u.newAchivement(b);
		u.newAchivement(c);
		
		assertEquals("Pedro", u.getName());
		assertEquals(15, u.getPoints());
		assertEquals(15, u.getAchivementPoints("COMMENT"));
	}
	
	@Test
	void testCreateAnUserAndMultiplePoints() throws UserHasNotThisAchivement, AchivementObjectHasNoPoints, AchievmentsHasNoPointsToAdd {
		String userName = "Pedro";
		User u = new User(userName);
		
		Achivement a = new PointsAchivement("COMMENT", 5);
		Achivement b = new PointsAchivement("COMMENT", 5);
		Achivement c = new PointsAchivement("COMMENT", 5);
		u.newAchivement(a);
		u.newAchivement(b);
		u.newAchivement(c);
		
		assertEquals("Pedro", u.getName());
		assertEquals(15, u.getPoints());
		assertEquals(15, u.getAchivementPoints("COMMENT"));
	}
	
}
