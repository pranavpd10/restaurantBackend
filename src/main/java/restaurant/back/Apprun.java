package restaurant.back;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import restaurant.back.Services.MenuItemService;

@Controller
public class Apprun {
	@Autowired
	MenuItemService menuItemService;
	
	public void test() {
		try {
			menuItemService.createMenuItem();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
//		AnnotationConfigApplicationContext context
//        = new AnnotationConfigApplicationContext();
////		 context.scan("restaurant.back");
////		 context.refresh();
//		 
//		 MenuItemService myServiceClass
//         = context.getBean(MenuItemService.class);
//		 
//		 myServiceClass.createMenuItem();

	}

}
