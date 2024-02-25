package restaurant.back.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Reviews {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	long id;
	String title;
	String description;
	byte rate;
	
	
	@Override
	public String toString() {
		return "Reviews [id=" + id + ", title=" + title + ", description=" + description + ", rate=" + rate + "]";
	}
	
	
}
