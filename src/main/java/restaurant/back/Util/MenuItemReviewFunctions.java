package restaurant.back.Util;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import restaurant.back.models.MenuItem;
import restaurant.back.repos.MenuItemRepo;
import restaurant.back.repos.ReviewRepo;

@Component
public class MenuItemReviewFunctions {

	@Autowired
	MenuItemRepo menuItemRepo;
	
	@Autowired
	ReviewRepo reviewRepo;
	
	
	public boolean isMenuItemPresent(long itemId) {
		 Optional<MenuItem> byId = menuItemRepo.findById(itemId);
		 System.out.println(byId.isPresent());
		return byId.isPresent();
		
	}
	
}
