package restaurant.back.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import restaurant.back.Services.MenuItemService;
import restaurant.back.models.MenuItem;
import restaurant.back.models.Review;


@RestController
public class MenuItemController {
	
	@Autowired
	MenuItemService menuItemService;
	
	/**
	 * get all the menu items from the database 
	 * @param startNo page number , the items/page value is 2  
	 * @return List of &lt;MenuItem>
	 */
	@GetMapping("/menuitems")
	public List<MenuItem> getMenuItems(@RequestParam(defaultValue = "0") int startNo) {
		List<MenuItem> menuItems = menuItemService.getMenuItems(startNo);
		return  menuItems;
	}
	
	/**
	 * save the menu item but not the reviews and id is not required 
	 * to be created by front end 
	 * @param menuItem
	 */
	@PostMapping("/menuitems")
	public void createMenuItems(@RequestBody @Valid MenuItem menuItem) {
		System.out.println("menuItem "+menuItem);
		menuItemService.createMenuItem(menuItem);
	}
	
	/**
	 * deletes the menuItem passed
	 * @param menuItem
	 */
	@DeleteMapping("/menuitems")
	public void deleteMenuItem(@RequestBody MenuItem menuItem,
			@RequestBody Review review) {
		System.out.println("menuItem "+menuItem + " review "+review);
//		menuItemService.deleteMenuItem(menuItem);
	}
}
