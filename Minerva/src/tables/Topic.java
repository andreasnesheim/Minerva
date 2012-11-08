package tables;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
}
