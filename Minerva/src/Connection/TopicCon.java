package Connection;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import tables.*;


public class TopicCon {
	
	public static void createTopic(String name, String description, SubCategory subCategory) {

		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();

		Topic topic= new Topic();
		topic.setName(name);
		topic.setDescription(description);
		topic.setSubCategory(subCategory);


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
        session.close();

        return topic;

    }

}
