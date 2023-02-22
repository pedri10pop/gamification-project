package forumService;

import java.util.ArrayList;
import java.util.List;

import achivements.Achievement;
import storage.AchievementObserver;
import storage.AchievementStorage;
import storage.AchievementStorageFactory;
import storage.InMemoryAchievementStorage;

public class ForumServiceGamificationProxy implements ForumService {

	private ForumService forumServiceImplementation = null;
	private List<AchievementObserver> observers = new ArrayList<>();
	private AchievementStorage storage;
	
	
	public ForumServiceGamificationProxy(ForumService forumServiceImplementation) {
		this.forumServiceImplementation = forumServiceImplementation;
		AchievementStorageFactory.setAchievementStorageFactory(new InMemoryAchievementStorage());
		this.storage = AchievementStorageFactory.getAchievementStorage();
		storage.addBadgeObserver(null);
	}

	public void addObserver(AchievementObserver observer) {
		observers.add(observer);
	}
	
	@Override
	public void addTopic(String user, String topic) {
		
		forumServiceImplementation.addTopic(user, topic);
		
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
			
		}
		
	}
	
}
