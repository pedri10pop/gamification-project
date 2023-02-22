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
		storage.addBadgeObserver(new LetMeAdd());
		storage.addBadgeObserver(new Inventor());
		storage.addBadgeObserver(new PartOfTheCommunity());
	}

	public void addObserver(AchievementObserver observer) {
		storage.addBadgeObserver(observer);
	}
	
	@Override
	public void addTopic(String user, String topic) {
		
		forumServiceImplementation.addTopic(user, topic);
		
		storage.addAchivement(user, new Points("CREATION", 5));
	}


	@Override
	public void addComment(String user, String topic, String comment) {
		
		forumServiceImplementation.addComment(user, topic, comment);
		
		storage.addAchivement(user,new Points("PARTICIPATION", 3));

	}

	@Override
	public void likeTopic(String user, String topic, String topicUser) {

		forumServiceImplementation.likeTopic(user, topic,topicUser);
		
		storage.addAchivement(user, new Points("CREATION", 1));

	}

	@Override
	public void likeComment(String user, String topic, String comment, String commentUser) {

		forumServiceImplementation.likeComment(user, topic, comment, commentUser);
		
		storage.addAchivement(user, new Points("PARTICIPATION", 1));

	}

	class ICanTalk implements AchievementObserver{
		@Override
		public void achievementUpdate(String user, Achievement achievement) {
			
			
			if(achievement.getName().equals("CREATION") &&
					achievement.getClass().equals(Points.class) &&
					achievement.getPoints().equals(5))
				storage.addAchivement(user, new Badge("CREATION", "I CAN TALK"));
		}
	}
	
	class LetMeAdd implements AchievementObserver{
		@Override
		public void achievementUpdate(String user, Achievement achievement) {
			
			if(achievement.getName().equals("PARTICIPATION") &&
					achievement.getClass().equals(Points.class) &&
					achievement.getPoints().equals(3)) {
				storage.addAchivement(user, new Badge("PARTICIPATION", "LET ME ADD"));
			}
		}
	}
	
	class Inventor implements AchievementObserver{
		@Override
		public void achievementUpdate(String user, Achievement achievement) {
			
			if(achievement.getName().equals("CREATION") &&
					achievement.getClass().equals(Points.class) &&
					achievement.getPoints().equals(100)) {
				storage.addAchivement(user, new Badge("CREATION", "INVENTOR"));
			}
		}
	}
	
	class PartOfTheCommunity implements AchievementObserver{
		@Override
		public void achievementUpdate(String user, Achievement achievement) {
			
			if(achievement.getName().equals("PARTICIPATION") &&
					achievement.getClass().equals(Points.class) &&
					achievement.getPoints() >= (100)) {
				storage.addAchivement(user, new Badge("PARTICIPATION", "PART OF THE COMMUNITY"));
			}
		}
	}
	
}
