package storage;

public class AchievementStorageFactory {
	
	private static AchivementStorage storageMethod;

	public static void setAchievementStorageFactory(AchivementStorage storageMethod) {
		if(storageMethod == null)
			AchievementStorageFactory.storageMethod = storageMethod;
	}

	public static AchivementStorage getAchievementStorage() {
		return storageMethod;
	}

}
