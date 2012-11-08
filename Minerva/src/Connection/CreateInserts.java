package Connection;

import org.hibernate.Session;

import tables.Profile;
import tables.User;

public class CreateInserts {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		createUsers();
	}

	private static void createUsers() {
		ProfileCon.createUser("test45", 567, "Ola", "Normann", "NO","tomt","dyr","man",30);
        ProfileCon.createUser("hjem@gogle.com", 37, "Hans", "Hansen", "NO","tomt","ikke noe","dame",0);
        ProfileCon.createUser("test@gogle.com", 57, "Oskar", "Berg", "NO","","sove","usikker",22);
        ProfileCon.createUser("ekstra@gogle.com", 67, "Tom", "Trulsen", "NO","tomt","musikk","begge",23);

	}
	
	private static void createMainCategories(){
		CategoryCon.createMainCategory("Programmering");
		CategoryCon.createMainCategory("Netverk");
		CategoryCon.createMainCategory("Annet");
	}
	
	private static void createSubCategories(){
		CategoryCon.createSubCategory("Java", 2);
		CategoryCon.createSubCategory("TCP", 3);
		CategoryCon.createSubCategory("tull", 4);
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
