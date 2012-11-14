package Tester;

import java.util.List;

import tables.*;
import Connection.*;

public class TopicTester {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String searchString = "a";
		List<Topic> topics = TopicCon.searchTopics(searchString);
		for (int i = 0; i<topics.size(); i++) {
			System.out.println(topics.get(i).getName()+ "         description:     " +topics.get(i).getDescription());
		}

	}

}
