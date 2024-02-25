package restaurant.back.Services;

import org.springframework.beans.factory.annotation.Autowired;

import restaurant.back.models.MenuItem;
import restaurant.back.models.Reviews;
import restaurant.back.repos.MenuItemRepo;
import restaurant.back.repos.ReviewsRepo;

public class MenuItemService {
	
	@Autowired
	MenuItemRepo menuItemRepo;
	
	@Autowired
	ReviewsRepo reviewsRepo;
	
	public void createMenuItem() {
		MenuItem menuItem = new MenuItem();
		Reviews reviews = new Reviews();
		
		menuItemRepo.save(menuItem);
		reviewsRepo.save(reviews);
		
		System.out.println(menuItem);
		System.out.println(reviews);
		
		
	}

}
