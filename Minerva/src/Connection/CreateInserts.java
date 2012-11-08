package Connection;

import org.hibernate.Session;

import tables.Profile;
import tables.User;

public class CreateInserts {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		createSubCategories();
	}
	
	private static void createUsers() {
		ProfileCon.createUser("test45", "567", "Ola", "Normann", "NO");

	}
	
	private static void createMainCategories(){
		CategoryCon.createMainCategory("Programmering");
		CategoryCon.createMainCategory("Nettverk");
		CategoryCon.createMainCategory("Operativsystem");
	}
	
	private static void createSubCategories(){
		CategoryCon.createSubCategory("C#", 1);
		CategoryCon.createSubCategory("UDP", 2);
		CategoryCon.createSubCategory("mer tull", 3);
	}

	public static void createProfilesEkstra(){
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();

		Profile daniel = new Profile();
		daniel.setFirstName("Daniel");
		daniel.setLastName("Jajevski");
		daniel.setInformation("blabla-informasjon!!!!!");
		daniel.setLocation("Stavanger");
		
		Profile rolf = new Profile();
		rolf.setFirstName("Rolf");
		rolf.setLastName("Boiten");
		rolf.setInformation("test");
		rolf.setLocation("Gjerstad");
		
		Profile bard = new Profile();
		bard.setFirstName("Bård");
		bard.setLastName("Helland");
		bard.setInformation("enda en test");
		bard.setLocation("Stavanger");
		
		Profile andy = new Profile();
		andy.setFirstName("Andreas");
		andy.setLastName("Nesheim");
		andy.setInformation("test igjen");
		andy.setLocation("Tasta");
		
		session.save(daniel); // doesn't save here
		session.save(rolf); // doesn't save here
		session.save(bard); // doesn't save here
		session.save(andy); // doesn't save here
		session.getTransaction().commit();
	}
}
