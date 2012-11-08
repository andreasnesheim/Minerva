package Tester;

import org.hibernate.Session;

import Connection.*;

import tables.Profile;
import tables.User;

public class EmailTest {

	/**
	 * @param args
	 */
	
	
	public static void main(String[] args) {
		
		//lager brukere
//		ProfileCon.createUser("test45", 567, "Ola", "Normann", "NO","tomt","dyr","man",30);
//        ProfileCon.createUser("hjem@gogle.com", 37, "Hans", "Hansen", "NO","tomt","ikke noe","dame",0);
//        ProfileCon.createUser("test@gogle.com", 57, "Oskar", "Berg", "NO","","sove","usikker",22);
//        ProfileCon.createUser("ekstra@gogle.com", 67, "Tom", "Trulsen", "NO","tomt","musikk","begge",23);
		
		
		boolean test = ProfileCon.emailExcists("hjem@gogle.com");
		boolean test2 = ProfileCon.emailExcists("test@google.com");
		String test3 = ProfileCon.getEmail(2);
		
		if (test && !test2) {
			System.out.println("Test 1 og 2 var vellykket");
		}
		else {
			if(test) 
				System.out.println("Test 1 var vellykket");
			else if(!test2)
				System.out.println("Test 2 var vellykket");
			
			else 
				System.out.println("Testen 1 og 2 feilet");

		}
		
	System.out.println("mailen er: "+ test3);
	}

}
