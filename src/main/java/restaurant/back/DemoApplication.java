package restaurant.back;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import restaurant.back.Services.MenuItemServiceProto;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner{

	@Autowired
	MenuItemServiceProto menuItemService;
	
	@Override
	public void run(String... args) throws Exception {
//		menuItemService.deleteItems();
//		menuItemService.createMenuItem();
//		menuItemService.mi();
//		menuItemService.openMenuItem();
		
//		menuItemService.getMenuItemReview();
//		menuItemService.deleteMenuItemReview();
	}
	
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
//		AnnotationConfigApplicationContext context =
//				new AnnotationConfigApplicationContext();
//		context.scan("restaurant.back");
//		context.refresh();
//		Apprun bean = context.getBean(Apprun.class);
//		bean.test();
	}
}
