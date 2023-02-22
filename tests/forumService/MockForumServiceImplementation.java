package forumService;

import java.util.function.BooleanSupplier;

public class MockForumServiceImplementation implements ForumService {

	private BooleanSupplier wasCalled = () -> false;
	
	public BooleanSupplier wasCalled() {
		return wasCalled;
	}
	
	@Override
	public void addTopic(String user, String topic) {
		wasCalled = () -> true;
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

}
