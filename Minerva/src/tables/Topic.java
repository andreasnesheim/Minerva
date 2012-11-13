package tables;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Topic {

	@Id
	@GenericGenerator(name = "generator", strategy = "increment") 
	@GeneratedValue(generator = "generator")
	private long id;
	private String name;
	private String description;

	@ManyToOne
	@JoinColumn(name="subCategoryID")
	private SubCategory subCategory;

	@ManyToMany(cascade = CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinTable(name = "hasMentor", 
	joinColumns= {@JoinColumn(name = "id")},
	inverseJoinColumns = { @JoinColumn(name = "userId") })
	private Set<Profile> mentors = new HashSet<Profile>();
	
	@ManyToMany(cascade = CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinTable(name = "hasTrainee", 
	joinColumns= {@JoinColumn(name = "id")},
	inverseJoinColumns = { @JoinColumn(name = "userId") })
	private Set<Profile> trainees = new HashSet<Profile>();
	


	public Topic() {
	}

	public long getId() {
		return id;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public SubCategory getSubCategory() {
		return subCategory;
	}

	public void setSubCategory(SubCategory subCategory) {
		this.subCategory = subCategory;
	}

	public Set<Profile> getMentors() {
		return mentors;
	}

	public void setMentors(Set<Profile> mentors) {
		this.mentors = mentors;
	}

	public Set<Profile> getTrainees() {
		return trainees;
	}

	public void setTrainees(Set<Profile> trainees) {
		this.trainees = trainees;
	}
}
