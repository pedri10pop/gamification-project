package storage;

public class AchievementStorageFactory {
	
	private static AchivementStorage storageMethod = null;

	public static void setAchievementStorageFactory(AchivementStorage storageMethod) {
		if(AchievementStorageFactory.storageMethod == null)
			AchievementStorageFactory.storageMethod = storageMethod;
	}

	public static AchivementStorage getAchievementStorage() {
		return storageMethod;
	}

}
