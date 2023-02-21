package achivements;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class TestAchivements {

	@Test
	void testCreateAchivementOfPointsType() {
		String achivimentName = "COMMENT";
		Integer achivementPoints = 5;
		Achievement a = new Points(achivimentName, achivementPoints);
		
		assertEquals("COMMENT", a.getName());
		assertEquals(5, a.getPoints());
	}

	@Test
	void testCreateAchivementOfBadgeType() {
		String achivimentName = "COMMENT";
		String achivimentBadge = "YOU ARE A WRITTER";
		
		Achievement a = new Badge(achivimentName, achivimentBadge);
		
		assertEquals("COMMENT", a.getName());
		assertEquals("YOU ARE A WRITTER", a.getBadge());
	}
	
	@Test
	void testValidatingPointsEquality() {
		
		Achievement a = new Points("LIKE",5);
		Achievement b = new Points("LIKE",3);
		
		assertTrue(a.equals(b));		
	}
	
	@Test
	void testValidatingBadgeEquality() {
		
		Achievement a = new Badge("LIKE","LIKER");
		Achievement b = new Badge("LIKE","LIKER");
		
		assertTrue(a.equals(b));		
	}
	
	
	
}
