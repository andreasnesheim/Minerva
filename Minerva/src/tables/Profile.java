package tables;

import java.awt.Image;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Profile {
//	@GeneratedValue (strategy=GenerationType.TABLE, generator="userid")
	@Id
	private long userId;
//	private Image image;
	private String information;
	private String location;
	private String lastName;
	private String firstName;
	
	@OneToOne
	@JoinColumn
	private User user;

	public Profile() {
	}
	
	public void setUserId() {
		this.userId = user.getId();
	}
	public long getUserId() {
		return userId;
	}

	

//	public Image getImage() {
//		return image;
//	}

//	public void setImage(Image image) {
//		this.image = image;
//	}

	public String getInformation() {
		return information;
	}

	public void setInformation(String information) {
		this.information = information;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
}
