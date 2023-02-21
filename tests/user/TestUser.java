package user;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class TestUser {

	@Test
	void testCreateAnUser() {
		String userName = "Pedro";
		User u = new User(userName);
		
		assertEquals("Pedro", u.getName());
		assertEquals(0, u.getPoints());
	}
	
}
