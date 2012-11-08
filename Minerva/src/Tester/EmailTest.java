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
		ProfileCon.createUser("test45", 567, "Ola", "Normann", "NO");
        ProfileCon.createUser("hjem@gogle.com", 37, "Hans", "Hansen", "NO");
        ProfileCon.createUser("test@gogle.com", 57, "Oskar", "Berg", "NO");
        ProfileCon.createUser("ekstra@gogle.com", 67, "Tom", "Trulsen", "NO");
		
		
		boolean test = ProfileCon.emailExcists("hjem@gogle.com");
		boolean test2 = ProfileCon.emailExcists("test@google.com");
		
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
	}

}
