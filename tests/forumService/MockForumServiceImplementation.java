package forumService;

import java.util.function.BooleanSupplier;

public class MockForumServiceImplementation implements ForumService {

	private BooleanSupplier wasAddTopicCalled = () -> false;
	private BooleanSupplier wasAddCommentCalled = () -> false;
	private BooleanSupplier wasLikeTopicCalled = () -> false;
	private BooleanSupplier wasLikeCommentCalled = () -> false;
	
	public BooleanSupplier wasAddTopicCalled() {
		return wasAddTopicCalled;
	}
	
	public BooleanSupplier wasAddCommentCalled() {
		return wasAddCommentCalled;
	}
	
	public BooleanSupplier wasLikeTopicCalled() {
		return wasLikeTopicCalled;
	}
	
	public BooleanSupplier wasLikeCommentCalled() {
		return wasLikeCommentCalled;
	}
	
	@Override
	public void addTopic(String user, String topic) {
		wasAddTopicCalled = () -> true;
	}

	@Override
	public void addComment(String user, String topic, String comment) {
		wasAddCommentCalled = () -> true;
	}

	@Override
	public void likeTopic(String user, String topic, String topicUser) {
		wasLikeTopicCalled = () -> true;
	}

	@Override
	public void likeComment(String user, String topic, String comment, String commentUser) {
		wasLikeCommentCalled = () -> true;
	}

	

}
