package storage;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.Test;

import achivements.Achivement;
import achivements.Points;
import user.User;

class TestAchivementStorage {

	@Test
	void testCreatingAMemoryAchivimentStorage() {
		AchivementStorage as = new InMemoryAchivementStorage();		
		
		assertEquals(null, as.getAchivements("Invalid User"));
		assertEquals(null, as.getAchivement("Inexistent User", "Invalid Achiviment"));
	}
	
	@Test
	void testAddAchivementToStorage() {
		AchivementStorage as = new InMemoryAchivementStorage();
		User u = new User("Pedro");
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
		AchivementStorage as = new InMemoryAchivementStorage();
		User u = new User("Pedro");
		Achivement a = new Points("COMMENT", 5);
		Achivement b = new Points("LIKE", 2);

		as.addAchivement(u.getName(), a);
		as.addAchivement(u.getName(), b);
		
		assertEquals(2, as.getAchivements("Pedro").size());
		
		assertEquals("COMMENT", as.getAchivement("Pedro","COMMENT").getName());
		assertEquals(5, as.getAchivement("Pedro","COMMENT").getPoints());
		assertEquals("COMMENT", as.getAchivement("Pedro","LIKE").getName());
		assertEquals(2, as.getAchivement("Pedro","LIKE").getPoints());
	}
	
	@Test
	void testAddTwoEqualAchivementToAStorage() {
		AchivementStorage as = new InMemoryAchivementStorage();
		User u = new User("Pedro");
		Achivement a = new Points("COMMENT", 5);
		Achivement b = new Points("COMMENT", 5);
		
		as.addAchivement(u.getName(), a);
		as.addAchivement(u.getName(), b);
		
		assertEquals(2, as.getAchivements("Pedro").size());
		assertEquals(10, as.getAchivement("Pedro","COMMENT").getPoints());
	}
	
	
}
