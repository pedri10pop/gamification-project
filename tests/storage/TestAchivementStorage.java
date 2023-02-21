package storage;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import achivements.Achivement;
import achivements.AchivementObjectHasNoPoints;
import achivements.PointsAchivement;
import user.User;

class TestAchivementStorage {

	@Test
	void testCreatingAMemoryAchivimentStorage() {
		AchivementStorage as = new MemoryAchivementStorage();
		
		assertEquals(null, as.getAchivements(""));
	}
	
	@Test
	void testAddAAchivementToAStorage() {
		AchivementStorage as = new MemoryAchivementStorage();
		User u = new User("Pedro");
		Achivement a = new PointsAchivement("COMMENT", 5);
		as.addAchivement(u, a);
		
		assertEquals(a, as.getAchivements("Pedro").get(0));
		assertEquals(1, as.getAchivements("Pedro").size());
		assertEquals(a, as.getAchivement("Pedro","COMMENT"));
	}
	
	@Test
	void testAddTwoDifferentAchivementToAStorage() {
		AchivementStorage as = new MemoryAchivementStorage();
		User u = new User("Pedro");
		Achivement a = new PointsAchivement("COMMENT", 5);
		Achivement b = new PointsAchivement("LIKE", 2);

		as.addAchivement(u, a);
		as.addAchivement(u, b);
		
		assertEquals(2, as.getAchivements("Pedro").size());
		assertEquals(a, as.getAchivement("Pedro","COMMENT"));
		assertEquals(b, as.getAchivement("Pedro","LIKE"));
	}
	
	@Test
	void testAddTwoEqualAchivementToAStorage() throws AchivementObjectHasNoPoints {
		AchivementStorage as = new MemoryAchivementStorage();
		User u = new User("Pedro");
		Achivement a = new PointsAchivement("COMMENT", 5);
		Achivement b = new PointsAchivement("COMMENT", 5);
		
		as.addAchivement(u, a);
		as.addAchivement(u, b);
		
		assertEquals(2, as.getAchivements("Pedro").size());
		assertEquals(10, as.getAchivement("Pedro","COMMENT").getPoints());
	}
	
	
}
