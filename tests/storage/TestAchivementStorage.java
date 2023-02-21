package storage;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
		as.addAchivement(u, a);
		
		assertEquals(a, as.getAchivements("Pedro").get(0));
		assertEquals(1, as.getAchivements("Pedro").size());
		assertEquals(a, as.getAchivement("Pedro","COMMENT"));
	}
	
	@Test
	void testAddTwoDifferentAchivementToAStorage() {
		AchivementStorage as = new InMemoryAchivementStorage();
		User u = new User("Pedro");
		Achivement a = new Points("COMMENT", 5);
		Achivement b = new Points("LIKE", 2);

		as.addAchivement(u, a);
		as.addAchivement(u, b);
		
		assertEquals(2, as.getAchivements("Pedro").size());
		assertEquals(a, as.getAchivement("Pedro","COMMENT"));
		assertEquals(b, as.getAchivement("Pedro","LIKE"));
	}
	
	@Test
	void testAddTwoEqualAchivementToAStorage() {
		AchivementStorage as = new InMemoryAchivementStorage();
		User u = new User("Pedro");
		Achivement a = new Points("COMMENT", 5);
		Achivement b = new Points("COMMENT", 5);
		
		as.addAchivement(u, a);
		as.addAchivement(u, b);
		
		assertEquals(2, as.getAchivements("Pedro").size());
		assertEquals(10, as.getAchivement("Pedro","COMMENT").getPoints());
	}
	
	
}
