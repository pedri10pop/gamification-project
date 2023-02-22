package storage;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import achivements.Achievement;
import achivements.Badge;
import achivements.Points;
import user.User;

class TestAchivementStorage {
	
	AchievementStorage as;
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
		Achievement a = new Points("COMMENT", 5);
		as.addAchivement(u.getName(), a);
		
		assertEquals("COMMENT", as.getAchivements("Pedro").get(0).getName());
		assertEquals(5, as.getAchivements("Pedro").get(0).getPoints());
		assertEquals(1, as.getAchivements("Pedro").size());
		assertEquals("COMMENT", as.getAchivement("Pedro","COMMENT").getName());
		assertEquals(5, as.getAchivement("Pedro","COMMENT").getPoints());
	}
	
	@Test
	void testAddTwoDifferentAchivementToAStorage() {
		Achievement a = new Points("COMMENT", 5);
		Achievement b = new Points("LIKE", 2);

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
		Achievement a = new Points("COMMENT", 5);
		Achievement b = new Points("COMMENT", 5);
		
		as.addAchivement(u.getName(), a);
		as.addAchivement(u.getName(), b);
		
		assertEquals(1, as.getAchivements("Pedro").size());
		assertEquals(10, as.getAchivement("Pedro","COMMENT").getPoints());
	}

	@Test
	void testAddPointAndBadgeOfSameAchivement() {
		Achievement a = new Points("COMMENT", 5);
		Achievement b = new Badge("COMMENT", "YOU GOT IT");
		
		as.addAchivement(u.getName(), a);
		as.addAchivement(u.getName(), b);
		
		assertEquals(2, as.getAchivements("Pedro").size());
		assertEquals(5, as.getAchivement("Pedro","COMMENT").getPoints());
	}
	
	@Test
	void testObserverUtilization() {
		MockBadgeObserver mock = new MockBadgeObserver();
		as.addBadgeObserver(mock);
		Achievement a = new Points("COMMENT", 5);
		Achievement b = new Points("LIKE", 2);

		as.addAchivement(u.getName(), a);
		as.addAchivement(u.getName(), b);
		
		assertTrue(mock.wasCalled());
	}	
	
	@Test
	void testMultipleObserverUtilization() {
		MockBadgeObserver mock = new MockBadgeObserver();
		MockBadgeObserver mock2 = new MockBadgeObserver();
		MockBadgeObserver mock3 = new MockBadgeObserver();
		as.addBadgeObserver(mock);
		as.addBadgeObserver(mock2);
		as.addBadgeObserver(mock3);
		Achievement a = new Points("COMMENT", 5);
		Achievement b = new Points("LIKE", 2);
		
		as.addAchivement(u.getName(), a);
		as.addAchivement(u.getName(), b);
		
		assertTrue(mock.wasCalled());
		assertTrue(mock2.wasCalled());
		assertTrue(mock3.wasCalled());
	}
	
	
}
