package achivements;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

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
	
}
