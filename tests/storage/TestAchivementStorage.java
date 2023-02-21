package storage;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import achivements.Achivement;
import achivements.Badge;
import achivements.Points;
import user.User;

class TestAchivementStorage {
	
	AchivementStorage as;
	User u;
	
	@BeforeEach
	public void setup(){
		as = new InMemoryAchievementStorage();		
		u = new User("Pedro");
	}

	@Test
	void testCreatingAMemoryAchivimentStorage() {
		assertEquals(null, as.getAchivements("Invalid User"));
		assertEquals(null, as.getAchivement("Inexistent User", "Invalid Achiviment"));
	}
	
	@Test
	void testAddAchivementToStorage() {
		Achivement a = new Points("COMMENT", 5);
		as.addAchivement(u.getName(), a);
		
		assertEquals("COMMENT", as.getAchivements("Pedro").get(0).getName());
		assertEquals(5, as.getAchivements("Pedro").get(0).getPoints());
		assertEquals(1, as.getAchivements("Pedro").size());
		assertEquals("COMMENT", as.getAchivement("Pedro","COMMENT").getName());
		assertEquals(5, as.getAchivement("Pedro","COMMENT").getPoints());
	}
	
	@Test
	void testAddTwoDifferentAchivementToAStorage() {
		Achivement a = new Points("COMMENT", 5);
		Achivement b = new Points("LIKE", 2);

		as.addAchivement(u.getName(), a);
		as.addAchivement(u.getName(), b);
		
		assertEquals(2, as.getAchivements("Pedro").size());
		
		assertEquals("COMMENT", as.getAchivement("Pedro","COMMENT").getName());
		assertEquals(5, as.getAchivement("Pedro","COMMENT").getPoints());
		assertEquals("LIKE", as.getAchivement("Pedro","LIKE").getName());
		assertEquals(2, as.getAchivement("Pedro","LIKE").getPoints());
	}
	
	@Test
	void testAddTwoEqualAchivementToAStorage() {
		Achivement a = new Points("COMMENT", 5);
		Achivement b = new Points("COMMENT", 5);
		
		as.addAchivement(u.getName(), a);
		as.addAchivement(u.getName(), b);
		
		assertEquals(1, as.getAchivements("Pedro").size());
		assertEquals(10, as.getAchivement("Pedro","COMMENT").getPoints());
	}

	@Test
	void testAddPointAndBadgeOfSameAchivement() {
		Achivement a = new Points("COMMENT", 5);
		Achivement b = new Badge("COMMENT", "YOU GOT IT");
		
		as.addAchivement(u.getName(), a);
		as.addAchivement(u.getName(), b);
		
		assertEquals(2, as.getAchivements("Pedro").size());
		assertEquals(5, as.getAchivement("Pedro","COMMENT").getPoints());
	}
	
	
}
