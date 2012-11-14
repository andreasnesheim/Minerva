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
		createMainCategories();
		createSubCategories();
		createTopics();
//		linkingPersonToTopic();
		
		createProfilesEkstra();

	}

	private static void createUsers() {
		ProfileCon.createUser("test45", "WIkfnsjv", "Ola", "Normann", "NO","tomt","dyr","man",30);
        ProfileCon.createUser("hjem@gogle.com", "AksmvIRJo", "Hans", "Hansen", "NO","tomt","ikke noe","dame",0);
        ProfileCon.createUser("test@gogle.com", "FoTijasdmN", "Oskar", "Berg", "NO","","sove","usikker",22);
        ProfileCon.createUser("ekstra@gogle.com", "PkcNuqsS", "Tom", "Trulsen", "NO","tomt","musikk","begge",23);


	}
	
	private static void createMainCategories(){
		CategoryCon.createMainCategory("Objektorientert programmering");
		CategoryCon.createMainCategory("Webprogrammering");
		CategoryCon.createMainCategory("Nettverksteknologi");
	}
	
	private static void createSubCategories(){
		CategoryCon.createSubCategory("Java", 1);
		CategoryCon.createSubCategory("C/C++", 1);
		CategoryCon.createSubCategory("C#", 1);
		CategoryCon.createSubCategory("Python", 1);
		
		CategoryCon.createSubCategory("HTML", 2);
		CategoryCon.createSubCategory("CSS", 2);
		CategoryCon.createSubCategory("JavaScript", 2);
		
		CategoryCon.createSubCategory("TCP/IP", 3);
		CategoryCon.createSubCategory("DNS", 3);
		CategoryCon.createSubCategory("Microsoft Server", 3);
		CategoryCon.createSubCategory("Novell NetWare", 3);
		CategoryCon.createSubCategory("Linux", 3);
	}
	
	private static void createTopics(){
		TopicCon.createTopic("Sockets", "Socket-programmering i Java", 1);
		TopicCon.createTopic("GUI", "Graphical User Interface i Java", 1);
		TopicCon.createTopic("Nybegynner", "Java for nybegynnere", 1);
		TopicCon.createTopic("Tr&aring;dh&aring;dtering", "Tråder i Java", 1);
		
		TopicCon.createTopic("Form-elementer", "Form-elementer", 5);
		
		TopicCon.createTopic("Font-stilering", "Endre stil på fonter ved hjelp av CSS", 6);
//		TopicCon.createTopic("Tull 2.0", "Implementasjon av tull 2.0", 3);
	}
	
	private static void linkingPersonToTopic(){
		//Ola Normann er mentor i Tull 2.0
//		TopicCon.addMentorToTopic(1, 3);
		TopicCon.addMentorToTopic(1, 8);
		TopicCon.addMentorToTopic(1, 7);
		
		
		//Ola Normann er trainee innen java3d og tcp
		TopicCon.addTraineeToTopic(1, 2);
		TopicCon.addTraineeToTopic(1, 1);
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
