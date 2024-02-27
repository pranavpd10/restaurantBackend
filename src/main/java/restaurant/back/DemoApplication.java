package restaurant.back;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import restaurant.back.Services.MenuItemService;

//@EnableJpaRepositories("restaurant.back")
//@EntityScan("restaurant.back")
@SpringBootApplication
public class DemoApplication implements CommandLineRunner{

	@Autowired
	MenuItemService menuItemService;
	
	@Override
	public void run(String... args) throws Exception {
		menuItemService.createMenuItem();
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
