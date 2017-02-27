/**
 * 
 */
package org.cinexin.javabrains.springbootstarter.topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

/**
 * @author migue
 *
 * Spring Business Service for "Topic" Resource
 */
@Service
public class TopicService {

	
	private List<Topic> topics = new ArrayList<Topic>( Arrays.asList(
					new Topic("spring", "Java Spring", "Java Spring Framework Basis"),
					new Topic("java", "Java Core", "Java Core Fundamentals"),
					new Topic("javascript", "JavaScript", "JavaScript Language Basis")
				)
			);
	
	public List<Topic> getAllTopics() {
		return topics;
	}
	
	public Topic getTopic(String id) {
		// lambda solution....CLASSY!!!
		return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
	}

	public void addTopic(Topic topic) {
		topics.add(topic);
		
	}

	public void updateTopic(Topic topic, String id) {
		for (int i = 0; i < topics.size(); i++) {
			Topic currentTopic = topics.get(i);
			if (currentTopic.getId().equals(id)) {
				topics.set(i, topic);
			}
		}
		
	}

	public void deleteTopic(String id) {
		topics.removeIf(t -> t.getId().equals(id));
		
	}
}