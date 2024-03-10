package restaurant.back;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.web.servlet.config.annotation.CorsRegistration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import restaurant.back.Services.MenuItemServiceProto;

@SpringBootApplication
@EnableJpaAuditing
public class DemoApplication implements CommandLineRunner, WebMvcConfigurer {
	
	/**
	 * override default method from WebMvcConfigurer for CORS config
	 */
	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**");
	}
	
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
