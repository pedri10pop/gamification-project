package achivements;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class TestAchivements {

	@Test
	void testCreateAchivementOfPointsType() {
		String achivimentName = "COMMENT";
		Integer achivementPoints = 5;
		Achivement a = new Points(achivimentName, achivementPoints);
		
		assertEquals("COMMENT", a.getName());
		assertEquals(5, a.getPoints());
	}

	@Test
	void testCreateAchivementOfBadgeType() {
		String achivimentName = "COMMENT";
		String achivimentBadge = "YOU ARE A WRITTER";
		
		Achivement a = new Badge(achivimentName, achivimentBadge);
		
		assertEquals("COMMENT", a.getName());
		assertEquals("YOU ARE A WRITTER", a.getBadge());
	}
	
	@Test
	void testValidatingPointsEquality() {
		
		Achivement a = new Points("LIKE",5);
		Achivement b = new Points("LIKE",3);
		
		assertTrue(a.equals(b));		
	}
	
	@Test
	void testValidatingBadgeEquality() {
		
		Achivement a = new Badge("LIKE","LIKER");
		Achivement b = new Badge("LIKE","LIKER");
		
		assertTrue(a.equals(b));		
	}
	
	
	
}
