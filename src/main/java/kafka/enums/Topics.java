package kafka.enums;

public enum Topics {

	Books("books");
	String topicName;

	Topics(String topicName) {
		this.topicName = topicName;
	}

	public String getTopicName() {
		return this.topicName;
	}

}
