package storage;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class TestAchivementStorageFactory {

	@Test
	void testCreateAStorageFactory() {
		AchievementStorageFactory.setAchievementStorageFactory(new InMemoryAchievementStorage());
		AchivementStorage as = AchievementStorageFactory.getAchievementStorage();
		
		assertEquals(null, as.getAchivements("Invalid User"));
		assertEquals(null, as.getAchivement("Inexistent User", "Invalid Achiviment"));
	}
	
	@Test
	void testStorageFactoryUniqueness() {
		AchievementStorageFactory.setAchievementStorageFactory(new InMemoryAchievementStorage());
		AchivementStorage as = AchievementStorageFactory.getAchievementStorage();
		AchivementStorage bs = AchievementStorageFactory.getAchievementStorage();
		
		assertEquals(as, bs);
	}
	
	@Test
	void testStorageFactoryUniquenessToCreationOverrideAttempt() {
		AchievementStorageFactory.setAchievementStorageFactory(new InMemoryAchievementStorage());
		AchivementStorage as = AchievementStorageFactory.getAchievementStorage();
		AchievementStorageFactory.setAchievementStorageFactory(new InMemoryAchievementStorage());
		AchivementStorage bs = AchievementStorageFactory.getAchievementStorage();
		
		assertEquals(as, bs);
	}

}
