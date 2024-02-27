package restaurant.back.models;

import java.util.List;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;


@Entity
public class MenuItem {
	@Id
	@GeneratedValue(generator = "MENUITEM_SEQ")
	@GenericGenerator(name = "MENUITEM_SEQ",
		type = org.hibernate.id.enhanced.SequenceStyleGenerator.class,
		parameters = {
			@Parameter(name = "sequence_name", value = "MENUITEM_SEQ"),
			@Parameter(name = "initial_value", value = "1"),
			@Parameter(name = "increment_size", value = "2")
	})
	long id;
	String name;
	
	@OneToMany
	List<Reviews> reviews;
	
	public void setReviews(List<Reviews> reviews) {
		this.reviews = reviews;
	}

	public MenuItem(String name) {
		this.name=name;
	}
	
	
	
	@Override
	public String toString() {
		return "MenuItem [id=" + id + ", name=" + name + "]";
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}
	
	
}
