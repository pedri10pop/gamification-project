package storage;

public class AchievementStorageFactory {
	
	private static AchievementStorage storageMethod = null;

	public static void setAchievementStorageFactory(AchievementStorage storageMethod) {
		if(AchievementStorageFactory.storageMethod == null)
			AchievementStorageFactory.storageMethod = storageMethod;
	}

	public static AchievementStorage getAchievementStorage() {
		return storageMethod;
	}

}
