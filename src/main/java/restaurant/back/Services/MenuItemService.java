package restaurant.back.Services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import restaurant.back.models.MenuItem;
import restaurant.back.models.Reviews;
import restaurant.back.repos.MenuItemRepo;
import restaurant.back.repos.ReviewsRepo;

@Repository
public class MenuItemService {
	
	@Autowired
	MenuItemRepo menuItemRepo;
	
	@Autowired
	ReviewsRepo reviewsRepo;
	
	public void createMenuItem() {
		List<Reviews> reviews=new ArrayList<>();
		
		MenuItem menuItem = new MenuItem("dish1");
		
		Reviews reviews1 = new Reviews();
		reviews1.setTitle("reviews1");
		
		Reviews reviews2 = new Reviews();
		reviews2.setTitle("reviews2");
		
		System.out.println(menuItemRepo);
		System.out.println(reviewsRepo);
		
		reviews.add(reviews1);
		reviews.add(reviews2);
		
		menuItem.setReviews(reviews);
		
		reviewsRepo.save(reviews1);
		reviewsRepo.save(reviews2);
		
		menuItemRepo.save(menuItem);		

		
		Reviews reviewst = new Reviews();
		reviews1.setTitle("reviews1");
		
		List<Reviews> findByTitle = reviewsRepo.findByTitleLike("reviews%");
		Reviews reviewsRepo2 = findByTitle.get(0);
		System.out.println(reviewsRepo2+ "size is "+findByTitle.size());
		
//		System.out.println(menuItem);
//		System.out.println(reviews1);
	}

	// find by object by using hashcode and equals method 
//	Optional<Reviews> one = reviewsRepo.findOne(Example.of(reviewst));
//	System.out.println(one.get());
	
	// using 'findBy' derived query method
//	List<Reviews> findByTitle = reviewsRepo.findByTitle("reviews1");
//	Reviews reviewsRepo2 = findByTitle.get(0);
	
	// using 'findBy' derived query method for getting top 1 result
//	List<Reviews> findByTitle = reviewsRepo.findTop1ByTitle("reviews1");
//	Reviews reviewsRepo2 = findByTitle.get(0);
	
	// to search the title with wild cards 
//	List<Reviews> findByTitle = reviewsRepo.findByTitleLike("reviews%");
//	Reviews reviewsRepo2 = findByTitle.get(0);
//	System.out.println(reviewsRepo2+ "size is "+findByTitle.size());
}
