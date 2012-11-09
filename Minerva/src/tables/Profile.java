package tables;

import java.awt.Image;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Profile {
//	@GeneratedValue (strategy=GenerationType.TABLE, generator="userid")
	@Id
	@GenericGenerator(name = "generator", strategy = "increment") 
    @GeneratedValue(generator = "generator")
	private long userId;
	private byte[] image;
	private String information;
	private String location;
	private String lastName;
	private String firstName;
	private String interests;
	private String sex;
	private int age;
	
	@OneToMany(targetEntity=User.class, mappedBy="profile", cascade=CascadeType.REMOVE, fetch=FetchType.LAZY)
	private List<User> users;
	
	@ManyToMany(mappedBy="mentors")
	private Set<Topic> topicsMentored = new HashSet<Topic>();
	
	@ManyToMany(mappedBy="trainees")
	private Set<Topic> topicsTraineed = new HashSet<Topic>();
	
	public Profile() {
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
	
	public List<User> getUsers() {
		return users;
	}

	public String getInterests() {
		return interests;
	}

	public void setInterests(String interests) {
		this.interests = interests;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	public Set<Topic> getTopicsMentored() {
		return topicsMentored;
	}

	public void setTopicsMentored(Set<Topic> topicsMentored) {
		this.topicsMentored = topicsMentored;
	}

	public Set<Topic> getTopicsTraineed() {
		return topicsTraineed;
	}

	public void setTopicsTraineed(Set<Topic> topicsTraineed) {
		this.topicsTraineed = topicsTraineed;
	}
}
