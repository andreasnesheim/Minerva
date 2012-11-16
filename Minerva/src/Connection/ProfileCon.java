package Connection;

import java.io.File;
import java.io.FileInputStream;
import java.nio.channels.SeekableByteChannel;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
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
	
	// Henter ut User id til User med email og thirdPartId lik parameterne
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
	
	// Henter ut Profil med riktig id
	public static Profile getProfile(long id) {


		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();


		Profile profile = (Profile) session.get(Profile.class, id);
		session.getTransaction().commit();  

		return profile;

	}

	// Endrer variablene lagret i Profile'en med riktig id
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
		if ((newImage  != "" && newImage != null ) || newImage == "reset") {
			if (newImage == "reset")
				profile.setImage(null);
			else
				profile.setImage(newImage);
		}

		session.update(profile);

		session.getTransaction().commit();
		
	}

	// Lagrer en Profile i databasen som er koblet til User'en den får som innparameter
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

	// Lister opp alle User objektene i databasen
	public static List<User> getListOfUsersInDatabase() {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();

		List<User> users = session.createQuery("from User").list();
		session.getTransaction().commit();  


		return users;
	}

	// Lister opp alle Profile objektene i databasen
	public static List<Profile> getListOfProfilesInDatabase() {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();

		List<Profile> profiles = session.createQuery("from Profile").list();
		session.getTransaction().commit();  


		return profiles;
	}

	// Sjekker om email adressen allerede finnes i databasen
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

	// Søker i databasen etter Profile objekter med fornavn, etternavn eller lokasjon lik søkeordene
	public static List<Profile> searchProfiles(String search) {
		List<Profile> results, results2, results3;

		String[] splitNames = search.split("\\s");
		String lname = splitNames[splitNames.length - 1];
		String fname = "";
		for (int i=0; i<splitNames.length - 1; i++) {
			fname += splitNames[i];
			if (i<splitNames.length - 2)
				fname += " ";
		}

		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Criteria crit;

		if (splitNames.length == 1) {
			crit = session.createCriteria(Profile.class)
					.add(Restrictions.like("lastName", lname + "%"));
			results = crit.list();

			session = HibernateUtil.getSessionFactory().getCurrentSession();
			session.beginTransaction();
			crit = session.createCriteria(Profile.class)
					.add(Restrictions.like("firstName", lname + "%"));
			results2 = crit.list();
			results3 = null;
		} else {
			// Finner de med likt fornavn OG etternavn OG lokasjon
			crit = session.createCriteria(Profile.class)
					.add(Restrictions.like("lastName", lname + "%"))
					.add(Restrictions.like("firstName", fname + "%"));
			results = crit.list();

			session = HibernateUtil.getSessionFactory().getCurrentSession();
			session.beginTransaction();
			crit = session.createCriteria(Profile.class)
					.add(Restrictions.or(
							Restrictions.and(
									Restrictions.like("location", splitNames[0] + "%"), Restrictions.like("lastName", lname + "%")),
									Restrictions.and(
											Restrictions.like("lastName", fname +"%"), Restrictions.like("location", lname +"%"))
							));
			results.addAll(crit.list());
			
			session = HibernateUtil.getSessionFactory().getCurrentSession();
			session.beginTransaction();
			crit = session.createCriteria(Profile.class)
					.add(Restrictions.or(
							Restrictions.and(
									Restrictions.like("location", splitNames[0] + "%"), Restrictions.like("firstName", lname + "%")),
									Restrictions.and(
											Restrictions.like("firstName", fname +"%"), Restrictions.like("location", lname +"%"))
							));
			results.addAll(crit.list());
			System.out.println(crit.list().toString());

			session = HibernateUtil.getSessionFactory().getCurrentSession();
			session.beginTransaction();
			// Finner de med likt etternavn OG ULIKT fornavn
			crit = session.createCriteria(Profile.class)
					.add(Restrictions.like("lastName", lname + "%"))
					.add(Restrictions.not(Restrictions.like("firstName","%" + fname + "%")));
			results2 = crit.list();

			session = HibernateUtil.getSessionFactory().getCurrentSession();
			session.beginTransaction();
			// Finner de med likt fornavn OG ULIKT etternavn
			crit = session.createCriteria(Profile.class)
					.add(Restrictions.like("firstName", fname + "%"))
					.add(Restrictions.not(Restrictions.like("lastName","%" +  lname + "%")));
			results3 = crit.list();
			
			session = HibernateUtil.getSessionFactory().getCurrentSession();
			session.beginTransaction();
			crit = session.createCriteria(Profile.class)
					.add(Restrictions.like("firstName", lname + "%"));
			results.addAll(crit.list());
			
			session = HibernateUtil.getSessionFactory().getCurrentSession();
			session.beginTransaction();
			crit = session.createCriteria(Profile.class)
					.add(Restrictions.like("lastName","%"+ lname + "%"));
			results.addAll(crit.list());
			
			session = HibernateUtil.getSessionFactory().getCurrentSession();
			session.beginTransaction();
			crit = session.createCriteria(Profile.class)
					.add(Restrictions.like("lastName", "%" + fname + "%"));
			results.addAll(crit.list()); 
			
		}
		results.addAll(results2);
		try {
			results.addAll(results3); } catch (Exception e) {}
		

		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();

		List<Profile> results4 = new ArrayList<Profile>();
		List<Profile> resultsAll = new ArrayList<Profile>();

		crit = session.createCriteria(Profile.class);
		Criterion criterion = Restrictions.like("location","%" + splitNames[0]+"%");
		Criterion newCriterion;

		for(int i = 1; i<splitNames.length; i++) {
			newCriterion = Restrictions.like("location", "%"+ splitNames[i]+"%");
			criterion = Restrictions.or(criterion, newCriterion);
		}

		crit.add(criterion);
		results4 = crit.list();
		resultsAll.addAll(results4);

		boolean found = false;
		for (int k = 0; k<results.size(); k++) {
			found = false;
			for (int l = 0; l<resultsAll.size(); l++){

				if (results.get(k).getUserId() == resultsAll.get(l).getUserId()) {
					found = true;
				}

			}
			if (!found) {
				resultsAll.add(results.get(k));
			}

		}


		return resultsAll;
	}
	
	// Henter ut email til Profile'en med riktig id
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
