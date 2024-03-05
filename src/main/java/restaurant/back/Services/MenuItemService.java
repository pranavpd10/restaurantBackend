package restaurant.back.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import restaurant.back.models.MenuItem;
import restaurant.back.repos.MenuItemRepo;

@Service
public class MenuItemService {
	
	static int pageSize = 2;
	
	@Autowired
	MenuItemRepo menuItemRepo;
	
	@Transactional
	public List<MenuItem> getMenuItems(int startNo) {
		Pageable pageRequest = PageRequest.of(startNo, pageSize); 
		return menuItemRepo.findAll(pageRequest).toList();
//		 List<MenuItem> all = menuItemRepo.findAll();
//		 return all;
	}
	
	@Transactional
	public void createMenuItems(MenuItem menuItem) {
		try {
			 MenuItem save = menuItemRepo.save(menuItem);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
}
