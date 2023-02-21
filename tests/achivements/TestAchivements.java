package achivements;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class TestAchivements {

	@Test
	void testCreateAchivementCOMMENT() {
		String AchivimentName = "COMMENT";
		Achivement a = new Achivement(AchivimentName);
		
		assertEquals("COMMENT", a.getName());
	}
	
	@Test
	void testCreateScoreAchivement() throws AchivementObjectHasNoPoints {
		String AchivimentName = "COMMENT";
		Integer points = 5;
		Achivement a = new PointsAchivement(AchivimentName, points);
		
		assertEquals("COMMENT", a.getName());
		assertEquals(5, a.getPoints());
	}
	
	@Test
	void testCreateBadge() throws AchivementObjectHasNoBadge {
		String achivementName = "COMMENT";
		String badgeName = "I CAN TALK";
		Achivement a = new Badge(achivementName, badgeName);
		
		assertEquals("COMMENT", a.getName());
		assertEquals("I CAN TALK", a.getBadge());
	}

	@Test
	void testCallGetBadgeOnAchivimentObject() {
		String achivementName = "COMMENT";
		Achivement a = new Achivement(achivementName);
		
		assertThrows(AchivementObjectHasNoBadge.class, ()->{
			a.getBadge();
		});
	}
	
	@Test
	void testCallGetBadgeOnPointsObject() {
		String AchivementName = "COMMENT";
		Integer points = 5;
		Achivement a = new PointsAchivement(AchivementName, points);
		
		assertThrows(AchivementObjectHasNoBadge.class, ()->{
			a.getBadge();
		});
	}
	
	@Test
	void testCallGetPointsOnBadgeObject() {
		String achivementName = "COMMENT";
		String badgeName = "I CAN TALK";
		Achivement a = new Badge(achivementName, badgeName);
		
		assertThrows(AchivementObjectHasNoPoints.class, ()->{
			a.getPoints();
		});
	}
	
	@Test
	void testCallGetPointsOnAchivimentObject() {
		String achivementName = "COMMENT";
		Achivement a = new Achivement(achivementName);
		
		assertThrows(AchivementObjectHasNoPoints.class, ()->{
			a.getPoints();
		});
	}

}
