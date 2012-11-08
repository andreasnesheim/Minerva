package tables;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Rating {
	
	@Id
	@GenericGenerator(name = "generator", strategy = "increment") 
    @GeneratedValue(generator = "generator")
	private long id;
	private long userId;
	private int rating;
	private long raterId;

	public long getRaterId() {
		return raterId;
	}

	public void setRaterId(long raterId) {
		this.raterId = raterId;
	}

	public Rating() {
	}
	
	public long getId() {
		return id;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	};
}
