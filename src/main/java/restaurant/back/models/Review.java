package restaurant.back.models;

import java.util.Date;
import java.util.Objects;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;


@Entity
@EntityListeners(AuditingEntityListener.class)
public class Review {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(unique = true)
	long id;

	@Min(value=1, message = "rate can not be less than 1 ")
	@Max(value=5, message = "rate can not be greater than 5 ")
	int rate;
	
	@NotBlank
	String title;

	String description;
	
	@CreatedDate
	Date createdDate;

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	//	@JsonBackReference // backward serialization
//	@JsonIgnoreProperties({"hibernateLazyInitializer", "reviews"})
	@ManyToOne
	@JoinColumn(name = "menu_item")
	@NotNull
	MenuItem menuItem;

	public MenuItem getMenuItem() {
		return menuItem;
	}

	public void setMenuItem(MenuItem menuItem) {
		this.menuItem = menuItem;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getRate() {
		return rate;
	}

	public void setRate(int rate) {
		this.rate = rate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public String toString() {
//		return "Reviews [id=" + id + ", title=" + title + ", description=" + description + ", rate=" + rate + "menuitem id" + menuItem.id + "]";
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
		Review other = (Review) obj;
		return Objects.equals(description, other.description) && id == other.id && rate == other.rate
				&& Objects.equals(title, other.title);
	}

}
