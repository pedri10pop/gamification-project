package forumService;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import storage.AchievementStorage;
import user.User;

class TestForumServiceGamificationProxy {
	
	User user;
	AchievementStorage storage;
	
	@BeforeEach
	void setup() {
		user = new User("Pedro");
	}

	@Test
	void testCreatingForumServiceGamificationProxyAndAddTopic() {
		MockForumServiceImplementation mockService = new MockForumServiceImplementation();
		ForumServiceGamificationProxy fsgp = new ForumServiceGamificationProxy(mockService);
		MockProxyObserver mock = new MockProxyObserver();
		fsgp.addObserver(mock);
		fsgp.addTopic(user.getName(), "CREATION");
		assertTrue(mock.wasCalled());
		assertTrue(mockService.wasCalled());
	}

}
