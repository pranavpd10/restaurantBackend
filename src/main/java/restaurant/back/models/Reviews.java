package restaurant.back.models;

import java.util.Objects;

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
	
	public void setTitle(String title) {
		this.title = title;
	}

	String description;
	byte rate;
	
	
	@Override
	public String toString() {
		return "Reviews [id=" + id + ", title=" + title + ", description=" + description + ", rate=" + rate + "]";
	}


	@Override
	public int hashCode() {
		return Objects.hash(description, id, rate, title);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Reviews other = (Reviews) obj;
		return Objects.equals(description, other.description) && id == other.id && rate == other.rate
				&& Objects.equals(title, other.title);
	}
	
	
}
