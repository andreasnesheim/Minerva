package Connection;

import java.io.File;
import java.io.FileInputStream;
import java.nio.channels.SeekableByteChannel;
import java.sql.*;
import java.util.List;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import tables.*;

public class ProfileCon {

	
	// lager en user og en profli til brukeren
	// går forløpig utifra at hver profil bare har en bruker
	public static void createUser(String email, String thirdPartId, String firstName, String lastName, String location, String information, String interests, String sex, int age) {

		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();

		User user = new User();
		user.setEmail(email);
		user.setThirdPartId(thirdPartId);
		
		session.save(user);
		session.getTransaction().commit();
		
		Profile profile = createProfile(firstName, lastName, location, information, interests, sex, age, user);

		
		
		
		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		
		user.setProfile(profile);
		
		session.update(user);
		session.getTransaction().commit();

	}
	public static long getUserId(String email, String thirdPartId) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		
		Criteria crit = session.createCriteria(User.class)
				.add(Restrictions.like("email", email))
				.add(Restrictions.like("thirdPartId", thirdPartId));
		crit.setMaxResults(1);
		List<User> results = crit.list();
		return results.get(0).getId();
	}

    public static Profile getProfile(long id) {


        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();


        Profile profile = (Profile) session.get(Profile.class, id);
        session.getTransaction().commit();  

        return profile;

    }

    public static void changeProfile(long id, String newFirstName, String newLastName, String newLocation, String newInformation, String newInterests, String newSex, String newAge, String newImage) {

        Profile profile = null;

        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();

        profile = (Profile) session.get(Profile.class, id);

        if (newFirstName  != "" && newFirstName != null ) {
            profile.setFirstName(newFirstName);
        }
        if (newLastName  != "" && newLastName != null ) {
            profile.setLastName(newLastName);
        }
        if (newLocation  != "" && newLocation != null ) {
            profile.setLocation(newLocation);
        }
        if (newInformation  != "" && newInformation != null ) {
            profile.setInformation(newInformation);
        }
        if (newInterests  != "" && newInterests != null ) {
            profile.setInterests(newInterests);
        }
        if (newSex  != "" && newSex != null ) {
            profile.setSex(newSex);
        }
        if (newAge  != "" && newAge != null) {
        	int newAgeInInt = Integer.parseInt(newAge);
            profile.setAge(newAgeInInt);
        }
        if (newImage  != "" && newImage != null ) {
            profile.setImage(newImage);
        }

        session.update(profile);

        session.getTransaction().commit();
        //session.close();

    
//        return true;
    }
    
    public static Profile createProfile(String FirstName, String LastName, String Location, String information, String interests, String sex, int age, User user) {


        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();

        Profile profile = new Profile();

        
            profile.setFirstName(FirstName);
            profile.setLastName(LastName);
            profile.setLocation(Location);
            profile.setInformation(information);
            profile.setInterests(interests);
            profile.setSex(sex);
            profile.setAge(age);
            profile.setUser(user);
    		profile.setUserId();

        session.save(profile);

        session.getTransaction().commit();  

        return profile;
    }
    public static Set<Profile> getListOfMentorsInTopic(long topicId) {
    	Session session = HibernateUtil.getSessionFactory().getCurrentSession();
    	session.beginTransaction();
    	Topic topic = TopicCon.getTopic(topicId);
    	session.getTransaction().commit();
    	return topic.getMentors();
    }
    public static Set<Profile> getListOfTraineesInTopic(long topicId) {
    	Session session = HibernateUtil.getSessionFactory().getCurrentSession();
    	session.beginTransaction();
    	Topic topic = TopicCon.getTopic(topicId);
    	session.getTransaction().commit();
    	return topic.getTrainees();
    }
    
    public static List<User> getListOfUsersInDatabase() {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();

        List<User> users = session.createQuery("from User").list();
        session.getTransaction().commit();  
        

        return users;
    }
    
    public static boolean emailExcists(String email) {
        
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();


        Criteria crit = session.createCriteria(User.class)
                .add(Restrictions.like("email", email
                ));
        crit.setMaxResults(1);
        List users = crit.list();    
        
        session.getTransaction().commit();  
        try {
			if (users.get(0) != null) {
				
			    return true;
			}


			
		} catch (IndexOutOfBoundsException e) {
			// TODO Auto-generated catch block
			
		}
        return false;
    }
    
//    public static void uploadImage(long id, String fileString) {
//    	 Profile profile = null;
//
//         Session session = HibernateUtil.getSessionFactory().getCurrentSession();
//         session.beginTransaction();
//
//         profile = (Profile) session.get(Profile.class, id);
// 
//        //save image into database
//    	File file = new File(fileString);
//        byte[] bFile = new byte[(int) file.length()];
// 
//        try {
//	     FileInputStream fileInputStream = new FileInputStream(file);
//	     //convert file into array of bytes
//	     fileInputStream.read(bFile);
//	     fileInputStream.close();
//        } catch (Exception e) {
//	     e.printStackTrace();
//        }
// 
//        profile.setImage(bFile);
// 
//        session.update(profile);
//
//        session.getTransaction().commit();
//    }
    
    public static String getEmail(long id) {


        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();


        Profile profile = (Profile) session.get(Profile.class, id);


        Criteria crit = session.createCriteria(User.class)
                .add(Restrictions.like("profile", profile
                ));
        crit.setMaxResults(1);
        List<User> users = crit.list();    
        
        session.getTransaction().commit();  
        try {
			if (users.get(0) != null) {
				
			    return users.get(0).getEmail();
			}


			
		} catch (IndexOutOfBoundsException e) {
			// TODO Auto-generated catch block
			
		} 
       // session.close();

        return "fail";

    }
    
} 
