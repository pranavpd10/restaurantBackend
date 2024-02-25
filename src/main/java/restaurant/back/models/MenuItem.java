package restaurant.back.models;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;


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
	
	
	@Override
	public String toString() {
		return "MenuItem [id=" + id + ", name=" + name + "]";
	}
	
	
}
