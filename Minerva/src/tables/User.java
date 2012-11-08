package tables;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;



import org.hibernate.annotations.GenericGenerator;

@Entity
public class User {
	private String thirdPartId;
	@Id
	@GenericGenerator(name = "generator", strategy = "increment") 
    @GeneratedValue(generator = "generator")
	private long id;
	private String email;
	
	@OneToOne
	@JoinColumn
	private Profile profile;

	public User() {
	}

	public String getThirdPartId() {
		return thirdPartId;
	}

	public void setThirdPartId(String thirdPartId) {
		this.thirdPartId = thirdPartId;
	}

	public long getId() {
		return id;
	}

	private void setId(long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public Profile getProfile() {
		return profile;
	}

	public void setProfile(Profile profile) {
		this.profile = profile;
	}
}
