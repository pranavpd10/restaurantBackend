package restaurant.back;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import restaurant.back.Services.MenuItemServiceProto;

@SpringBootApplication
@EnableJpaAuditing
public class DemoApplication implements CommandLineRunner{
	
//	  @Bean
//	  public AuditorAware<AuditableUser> auditorProvider() {
//	    return new AuditorAwareImpl();
//	  }

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
