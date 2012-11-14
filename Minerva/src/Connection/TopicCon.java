package Connection;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.httpclient.methods.GetMethod;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import tables.*;


public class TopicCon {

	
	public static void createTopic(String name, String description, long subCategoryId) {

		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		SubCategory sub = (SubCategory) session.get(SubCategory.class, subCategoryId);
		
		Topic topic= new Topic();
		topic.setName(name);
		topic.setDescription(description);
		topic.setSubCategory(sub);
		
		session.save(topic);
		session.getTransaction().commit();

	}

	public static void changeTopic(long id ,String newName, String newDescription) {

		Topic topic = null;

		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();

		topic = (Topic) session.get(Topic.class, id);

		if (newName  != "" && newName != null ) {
			topic.setName(newName);
		}
		if (newDescription  != "" && newDescription != null ) {
			topic.setDescription(newDescription);
		}

		session.update(topic);
		session.getTransaction().commit();

	}

	public static List<Topic> getTopics(int subCategory) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();

		List<Topic> result;
		try {
			result = session.createQuery("from Topic where subCategoryID =" + subCategory + "").list();
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			return null;
		}

		session.getTransaction().commit();

		return result;
	}

	public static Topic getTopic(long id) {


		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();


		Topic topic = (Topic) session.get(Topic.class, id);
		session.getTransaction().commit();  
//		session.close();

		return topic;

	}
	
	
	public static List<Profile> getListOfMentorsInTopic(long topicId) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		
		Topic topic = (Topic) session.get(Topic.class, topicId);
		Set<Profile> mentors = topic.getMentors();
		
		List<Profile> mentorsToArray = new ArrayList<Profile>();
		mentorsToArray.addAll(mentors);
		
		session.getTransaction().commit();
		return mentorsToArray;
	}
	
	public static List<Profile> getListOfTraineesInTopic(long topicId) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		
		Topic topic = (Topic) session.get(Topic.class, topicId);
		Set<Profile> trainees = topic.getTrainees();
		
		List<Profile> traineesToArray = new ArrayList<Profile>();
		traineesToArray.addAll(trainees);
		
		session.getTransaction().commit();
		return traineesToArray;
	}

	public static int getNumberOfMentorInTopic (long topicId) {
		return getListOfMentorsInTopic(topicId).size();
	}

	public static int getNumberOfTraineesInTopic (long topicId) {
		return getListOfTraineesInTopic(topicId).size();
	}
	
	public static void addMentorToTopic(long profileId, long topicId) {
		
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();

		Topic topic = (Topic) session.get(Topic.class, topicId);
		Profile profile = (Profile) session.get(Profile.class, profileId);
		Set<Profile> mentors = topic.getMentors();
		mentors.add(profile);
		topic.setMentors(mentors);
		
		session.update(topic);
		session.getTransaction().commit();
	}

	public static void addTraineeToTopic(long profileId, long topicId) {
		
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();

		Topic topic = (Topic) session.get(Topic.class, topicId);
		Profile profile = (Profile) session.get(Profile.class, profileId);
		Set<Profile> trainee = topic.getTrainees();
		trainee.add(profile);
		topic.setMentors(trainee);
		
		session.update(topic);
		session.getTransaction().commit();
	}

	public static List<Topic> getTopicsTraineeIn(long profileId) {


		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();

		Profile profile = (Profile) session.get(Profile.class, profileId);
		Set<Topic> topics = profile.getTopicsTraineed();
		
		List<Topic> topicsToArray = new ArrayList<Topic>();
		topicsToArray.addAll(topics);

		session.getTransaction().commit();
//		session.close();

		
		return topicsToArray;

	}
	
	public static List<Topic> getTopicsMentorIn(long profileId) {


		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();

		Profile profile = (Profile) session.get(Profile.class, profileId);
		Set<Topic> topics = profile.getTopicsMentored();
		
		List<Topic> topicsToArray = new ArrayList<Topic>();
		topicsToArray.addAll(topics);

		session.getTransaction().commit();
//		session.close();
		

		return topicsToArray;

	}

}
