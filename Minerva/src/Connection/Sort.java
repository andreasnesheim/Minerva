package Connection;

import java.util.ArrayList;
import java.util.List;

import tables.*;

public class Sort {


	// Sorterer listen etter fornavn p� Profile objektene
	public static List<Profile> sortProfilesByName (List<Profile> innList) {

		List<Profile> newList= new ArrayList<Profile>();
		
		int size = innList.size();
		for (int j = 0; j<size; j++) {
			
			Profile innProfile = innList.get(0);
			for(int i = 0; i<innList.size(); i++) {

				Profile testProfile = innList.get(i);
				if(innProfile.getFirstName().compareToIgnoreCase(testProfile.getFirstName()) > 0) {
					innProfile = testProfile;
				}
				
			}
			newList.add(innProfile);
			innList.remove(innProfile);
		}
		return newList;
	}
	
		// Sorterer listen etter lokasjon p� Profile objektene
		public static List<Profile> sortProfilesByLocation (List<Profile> innList) {

			List<Profile> newList= new ArrayList<Profile>();
			
			int size = innList.size();
			for (int j = 0; j<size; j++) {
				
				Profile innProfile = innList.get(0);
				for(int i = 0; i<innList.size(); i++) {

					Profile testProfile = innList.get(i);
					if(innProfile.getLocation().compareToIgnoreCase(testProfile.getLocation()) > 0) {
						innProfile = testProfile;
					}
					
				}
				newList.add(innProfile);
				innList.remove(innProfile);
			}



		return newList;
	}
		
		// Sorterer listen etter navn p� Topic objektene
		public static List<Topic> sortTopicsByName (List<Topic> innList) {

			List<Topic> newList= new ArrayList<Topic>();
			
			int size = innList.size();
			for (int j = 0; j<size; j++) {
				
				Topic innProfile = innList.get(0);
				for(int i = 0; i<innList.size(); i++) {

					Topic testProfile = innList.get(i);
					if(innProfile.getName().compareToIgnoreCase(testProfile.getName()) > 0) {
						innProfile = testProfile;
					}
					
				}
				newList.add(innProfile);
				innList.remove(innProfile);
			}



		return newList;
	}
}
