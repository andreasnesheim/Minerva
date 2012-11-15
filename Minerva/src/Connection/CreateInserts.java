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
		linkingPersonToTopic();
		
//		createProfilesEkstra();

	}

	private static void createUsers() {
		ProfileCon.createUser("bash@github.com", "WIkfnsjv", "Ola", "Nordmann", "NO","tomt","dyr","mann",30);
        ProfileCon.createUser("him@gmail.com", "AksmvIRJo", "Hans", "Hansen", "NO","tomt","ikke noe","dame",13);
        ProfileCon.createUser("test@yahoo.no", "FoTijasdmN", "Oskar", "Berg", "NO","","sove","usikker",22);
        ProfileCon.createUser("xtra@gigolo.com", "PkcNuqsS", "Tom", "Trulsen", "NO","tomt","musikk","begge",23);
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
	
	private static void createTopics() {
		TopicCon.createTopic("Sockets", "Socket-programmering i Java", 1);
		TopicCon.createTopic("GUI", "Graphical User Interface i Java", 1);
		TopicCon.createTopic("Nybegynner", "Java for nybegynnere", 1);
		TopicCon.createTopic("Tr&aring;dh&aring;ndtering", "Tråder i Java", 1);
		
		TopicCon.createTopic("Form-elementer", "Form-elementer", 5);
		
		TopicCon.createTopic("Font-stilering", "Endre stil på fonter ved hjelp av CSS", 6);
	}
	
	private static void linkingPersonToTopic(){
		// Ola Nordmann er mentor i Java Sockets
		TopicCon.addMentorToTopic(1, 1);
		// Hans Hansen er mentor i Java GUI 
		TopicCon.addMentorToTopic(2, 2);
		// Oskar Berg er mentor i Java Nybegynner
		TopicCon.addMentorToTopic(3, 3);
		// Tom Trulsen er mentor i Java Trådhåndtering
		TopicCon.addMentorToTopic(4, 4);
		
		
		// Ola Nordmann er elev i HTML Form-elementer
		TopicCon.addTraineeToTopic(1, 5);
		// Hans Hansen er elev i CSS Font-stilering
		TopicCon.addTraineeToTopic(2, 6);
		// Oskar Berg er elev i Java Sockets
		TopicCon.addTraineeToTopic(3, 1);
		// Tom Trulsen er elev i Java GUI
		TopicCon.addTraineeToTopic(4, 2);
	}

	public static void createProfilesEkstra(){
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();

		Profile daniel = new Profile();
		daniel.setFirstName("Daniel");
		daniel.setLastName("Jajevski");
		daniel.setInformation("blabla-informasjon!!!!!");
		daniel.setLocation("Fister, Hjelmeland");
		
		Profile rolf = new Profile();
		rolf.setFirstName("Rolf Andreas");
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
