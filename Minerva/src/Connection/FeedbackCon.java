package Connection;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import tables.Feedback;
import tables.User;

public class FeedbackCon {
	
	// Lager et Feedback objekt og lagrer det i databasen
	public static void createFeedback(String header, String info, long recieverId, long senderId) {

		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();

		Feedback feedback = new Feedback();
		feedback.setHeader(header);
		feedback.setFeedback(info);
		feedback.setRecieverId(recieverId);
		feedback.setSenderId(senderId);


		session.save(feedback);
		session.getTransaction().commit();

	}
	
	// Henter ut et Feedback objekt med id
	public static Feedback getFeedback(long id) {


        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();


        Feedback feedback = (Feedback) session.get(Feedback.class, id);
        session.getTransaction().commit();  

        return feedback;

    }
	
	// Ender Feedback objektet med riktig id
	public static void changeFeedback(long id ,String newHeader, String newInfo) {

		Feedback feedback = null;

		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();

		feedback = (Feedback) session.get(Feedback.class, id);

		if (newHeader  != "" && newHeader != null ) {
			feedback.setHeader(newHeader);
		}
		if (newInfo  != "" && newInfo != null ) {
			feedback.setFeedback(newInfo);
		}

		session.update(feedback);
		session.getTransaction().commit();

	}
	
	// Lister opp alle Feedback objekter ifra databasen
	public static List<Feedback> getFeedbacks() {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();

		List<Feedback> result;
		try {
			result = session.createQuery("from Feedback").list();
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			return null;
		}

		session.getTransaction().commit();

		return result;
	}
	
	// Lister opp alle Feedback objekter ifra databasen med riktig reciverId
	public static List<Feedback> getUsersFeedback(long id) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		
		Criteria crit = session.createCriteria(Feedback.class)
				.add(Restrictions.like("recieverId", id));
		
		List<Feedback> results = crit.list();
		return results;
	}

}
