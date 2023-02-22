package forumService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import achivements.Achievement;
import storage.AchievementStorage;
import storage.AchievementStorageFactory;
import storage.InMemoryAchievementStorage;
import user.User;

class TestForumServiceGamificationProxy {
	
	User user;
	AchievementStorage storage;
	
	@BeforeEach
	void setup() {
		user = new User("Pedro");
		storage = new InMemoryAchievementStorage();
		AchievementStorageFactory.forceNewStorageMethod(storage);
	}

	@Test
	void testAddTopic() {
		MockForumServiceImplementation mockService = new MockForumServiceImplementation();
		ForumServiceGamificationProxy fsgp = new ForumServiceGamificationProxy(mockService);
		MockProxyObserver mock = new MockProxyObserver();
		fsgp.addObserver(mock);
		fsgp.addTopic(user.getName(), "Agile Principles");
		assertTrue(mock.wasCalled("CREATION"));
		assertTrue(mock.wasBadgeCalled("I CAN TALK"));
		assertTrue(mockService.wasAddTopicCalled());
	}
	
	@Test
	void testAddComment() {
		MockForumServiceImplementation mockService = new MockForumServiceImplementation();
		ForumServiceGamificationProxy fsgp = new ForumServiceGamificationProxy(mockService);
		MockProxyObserver mock = new MockProxyObserver();
		fsgp.addObserver(mock);
		fsgp.addComment(user.getName(), "Agile Principles", "Good implementation of SOLID Principles");
		assertTrue(mock.wasCalled("PARTICIPATION"));
		assertTrue(mock.wasBadgeCalled("LET ME ADD"));
		assertTrue(mockService.wasAddCommentCalled());
	}
	
	@Test
	void testLikeTopic() {
		MockForumServiceImplementation mockService = new MockForumServiceImplementation();
		ForumServiceGamificationProxy fsgp = new ForumServiceGamificationProxy(mockService);
		MockProxyObserver mock = new MockProxyObserver();
		fsgp.addObserver(mock);
		fsgp.likeTopic(user.getName(), "Agile Principles", "Joseph");
		assertTrue(mock.wasCalled("CREATION"));
		assertFalse(mock.wasBadgeCalled("I CAN TALK"));
		assertTrue(mockService.wasLikeTopicCalled());
	}
	
	@Test
	void testLikeComment() {
		MockForumServiceImplementation mockService = new MockForumServiceImplementation();
		ForumServiceGamificationProxy fsgp = new ForumServiceGamificationProxy(mockService);
		MockProxyObserver mock = new MockProxyObserver();
		fsgp.addObserver(mock);
		fsgp.likeComment(user.getName(), "Agile Principles", "Good implementation of SOLID Principles","Joseph");
		assertTrue(mock.wasCalled("PARTICIPATION"));
		assertFalse(mock.wasBadgeCalled("LET ME ADD"));
		assertTrue(mockService.wasLikeCommentCalled());
	}
	
	@Test
	void testAddTopicTwoTimes() {
		MockForumServiceImplementation mockService = new MockForumServiceImplementation();
		ForumServiceGamificationProxy fsgp = new ForumServiceGamificationProxy(mockService);
		MockProxyObserver mock = new MockProxyObserver();
		fsgp.addObserver(mock);
		fsgp.addTopic(user.getName(), "Agile Principles");
		fsgp.addTopic(user.getName(), "Design Patterns");
		
		assertEquals(2, storage.getAchivements(user.getName()).size());
		assertEquals(10, storage.getAchivements(user.getName()).get(0).getPoints());
		assertEquals("I CAN TALK", storage.getAchivements(user.getName()).get(1).getBadge());
		
		assertTrue(mock.wasCalled("CREATION"));
		assertTrue(mock.wasBadgeCalled("I CAN TALK"));
		assertTrue(mockService.wasAddTopicCalled());
	}

	@Test
	void testVariouMethodsCalled() {
		MockForumServiceImplementation mockService = new MockForumServiceImplementation();
		ForumServiceGamificationProxy fsgp = new ForumServiceGamificationProxy(mockService);
		MockProxyObserver mock = new MockProxyObserver();
		fsgp.addObserver(mock);

		
		fsgp.addTopic(user.getName(), "Agile Principles");
		fsgp.likeTopic(user.getName(), "Agile Principles", "Joseph");
		fsgp.addComment(user.getName(), "Agile Principles", "Good implementation of SOLID Principles");
		fsgp.likeComment(user.getName(), "Agile Principles", "Good implementation of SOLID Principles", "Mike");
		
		Integer totalPoints = 0;
		for(Achievement a : storage.getAchivements(user.getName()))
			if(a.getPoints() != null)
				totalPoints += a.getPoints();
		
		assertEquals(4, storage.getAchivements(user.getName()).size());
		assertEquals(10, totalPoints);
		
		assertTrue(mock.wasCalled("PARTICIPATION"));
		assertTrue(mock.wasBadgeCalled("LET ME ADD"));
		assertTrue(mock.wasCalled("CREATION"));
		assertTrue(mock.wasBadgeCalled("I CAN TALK"));
		assertTrue(mockService.wasAddTopicCalled());
	}
	
	@Test
	void testGettingINVENTORBadge() {
		MockForumServiceImplementation mockService = new MockForumServiceImplementation();
		ForumServiceGamificationProxy fsgp = new ForumServiceGamificationProxy(mockService);
		MockProxyObserver mock = new MockProxyObserver();
		fsgp.addObserver(mock);
		for(int i = 0; i < 20; i++)
			fsgp.addTopic(user.getName(), "Agile Principles Part "+ i);
		
		assertEquals(3, storage.getAchivements(user.getName()).size());
		assertEquals(100, storage.getAchivements(user.getName()).get(0).getPoints());
		
		assertTrue(mock.wasCalled("CREATION"));
		assertTrue(mock.wasBadgeCalled("I CAN TALK"));
		assertTrue(mock.wasBadgeCalled("INVENTOR"));
	}
	
	@Test
	void testGettingINVENTORBadgeWith101Points() {
		MockForumServiceImplementation mockService = new MockForumServiceImplementation();
		ForumServiceGamificationProxy fsgp = new ForumServiceGamificationProxy(mockService);
		MockProxyObserver mock = new MockProxyObserver();
		fsgp.addObserver(mock);
		for(int i = 0; i < 20; i++)
			fsgp.addTopic(user.getName(), "Agile Principles Part "+ i);
		fsgp.likeTopic(user.getName(), "Agile Principles Part 1","Joseph");
		
		
		assertEquals(3, storage.getAchivements(user.getName()).size());
		assertEquals(101, storage.getAchivements(user.getName()).get(0).getPoints());
		
		assertTrue(mock.wasCalled("CREATION"));
		assertTrue(mock.wasBadgeCalled("I CAN TALK"));
		assertTrue(mock.wasBadgeCalled("INVENTOR"));
	}
	
	@Test
	void testGettingPART_OF_THE_COMMUNITYBadge() {
		MockForumServiceImplementation mockService = new MockForumServiceImplementation();
		ForumServiceGamificationProxy fsgp = new ForumServiceGamificationProxy(mockService);
		MockProxyObserver mock = new MockProxyObserver();
		fsgp.addObserver(mock);
		for(int i = 0; i < 33; i++)
			fsgp.addComment(user.getName(), "Agile Principles", "Good implementation of SOLID Principles Part " + i);
		fsgp.likeComment(user.getName(), "Agile Principles", "Good implementation of SOLID Principles Part 1", "Joseph");
		
		assertEquals(3, storage.getAchivements(user.getName()).size());
		assertEquals(100, storage.getAchivements(user.getName()).get(0).getPoints());
		
		assertTrue(mock.wasCalled("PARTICIPATION"));
		assertTrue(mock.wasBadgeCalled("LET ME ADD"));
		assertTrue(mock.wasBadgeCalled("PART OF THE COMMUNITY"));
	}
	
	@Test
	void testGettingPART_OF_THE_COMMUNITYBadgeWith101Points() {
		MockForumServiceImplementation mockService = new MockForumServiceImplementation();
		ForumServiceGamificationProxy fsgp = new ForumServiceGamificationProxy(mockService);
		MockProxyObserver mock = new MockProxyObserver();
		fsgp.addObserver(mock);
		for(int i = 0; i < 33; i++)
			fsgp.addComment(user.getName(), "Agile Principles", "Good implementation of SOLID Principles Part " + i);
		fsgp.likeComment(user.getName(), "Agile Principles", "Good implementation of SOLID Principles Part 1", "Joseph");
		fsgp.likeComment(user.getName(), "Agile Principles", "Good implementation of SOLID Principles Part 2", "Joseph");
		
		assertEquals(3, storage.getAchivements(user.getName()).size());
		assertEquals(101, storage.getAchivements(user.getName()).get(0).getPoints());
		
		assertTrue(mock.wasCalled("PARTICIPATION"));
		assertTrue(mock.wasBadgeCalled("LET ME ADD"));
		assertTrue(mock.wasBadgeCalled("PART OF THE COMMUNITY"));
	}

}
