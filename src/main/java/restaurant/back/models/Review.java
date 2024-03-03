package restaurant.back.models;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Review {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	long id;
	String title;
	
	@ManyToOne
	@JoinColumn(name ="menu_item")
	MenuItem menuItem;
	
	public MenuItem getMenuItem() {
		return menuItem;
	}


	public void setMenuItem(MenuItem menuItem) {
		this.menuItem = menuItem;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	String description;
	byte rate;
	
	
	@Override
	public String toString() {
		return "Reviews [id=" + id + ", title=" + title + ", description=" + description + ", rate=" + rate + "menuitem id" + menuItem.id + "]";
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
		Review other = (Review) obj;
		return Objects.equals(description, other.description) && id == other.id && rate == other.rate
				&& Objects.equals(title, other.title);
	}
	
	
}
