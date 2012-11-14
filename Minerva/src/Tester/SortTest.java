package Tester;

import java.util.List;

import tables.*;
import Connection.*;

public class SortTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List<Topic> uSortert = TopicCon.getTopics(1);
		System.out.println("usortert");
		for (int i = 0; i<uSortert.size(); i++) {
			System.out.println(uSortert.get(i).getName());
		}
		System.out.println("sortert");
		List<Topic> sortert = Sort.sortTopicsByName(uSortert);
		
		for (int i = 0; i<sortert.size(); i++) {
			System.out.println(sortert.get(i).getName());
		}
	}

}
