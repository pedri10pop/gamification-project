package forumService;

import achivements.Achievement;
import achivements.Badge;
import achivements.Points;
import storage.AchievementObserver;
import storage.AchievementStorage;
import storage.AchievementStorageFactory;
import storage.InMemoryAchievementStorage;

public class ForumServiceGamificationProxy implements ForumService {

	private ForumService forumServiceImplementation = null;
	private AchievementStorage storage;
	
	
	public ForumServiceGamificationProxy(ForumService forumServiceImplementation) {
		this.forumServiceImplementation = forumServiceImplementation;
		AchievementStorageFactory.setAchievementStorageFactory(new InMemoryAchievementStorage());
		this.storage = AchievementStorageFactory.getAchievementStorage();
		storage.addBadgeObserver(new ICanTalk());
	}

	public void addObserver(AchievementObserver observer) {
		storage.addBadgeObserver(observer);
	}
	
	@Override
	public void addTopic(String user, String topic) {
		
		forumServiceImplementation.addTopic(user, topic);
		
		storage.addAchivement(user, new Points("CREATION",5));
	}


	@Override
	public void addComment(String user, String topic, String comment) {
		// TODO Auto-generated method stub

	}

	@Override
	public void likeTopic(String user, String topic, String topicUser) {
		// TODO Auto-generated method stub

	}

	@Override
	public void likeComment(String user, String topic, String comment, String commentUser) {
		// TODO Auto-generated method stub

	}

	class ICanTalk implements AchievementObserver{
		@Override
		public void achievementUpdate(String user, Achievement achievement) {
			Achievement a = storage.getAchivement(user, achievement.getName());
			
			
			if(achievement.getName().equals("CREATION") &&
					achievement.getClass().equals(Points.class) &&
					achievement.getPoints().equals(5))
				storage.addAchivement(user, new Badge("CREATION", "I CAN TALK"));
		}
	}
	
}
