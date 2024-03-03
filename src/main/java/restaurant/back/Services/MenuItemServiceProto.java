package restaurant.back.Services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityManagerFactory;

import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import restaurant.back.models.MenuItem;
import restaurant.back.models.Review;
import restaurant.back.repos.MenuItemRepo;
import restaurant.back.repos.ReviewRepo;

@Repository
public class MenuItemServiceProto {
	
	@Autowired
	EntityManagerFactory entityManagerFactory;
	
	@Autowired
	MenuItemRepo menuItemRepo;
	
	@Autowired
	ReviewRepo reviewsRepo;
	
	@Transactional
	public void createMenuItem() {
		
		List<Review> reviews = new ArrayList<>();
		
		MenuItem menuItem = new MenuItem("dish1");
		MenuItem menuItem2 = new MenuItem("dish2");
		
		Review reviews1 = new Review();
		reviews1.setTitle("reviews1");
		
		Review reviews2 = new Review();
		reviews2.setTitle("reviews2");
		
		System.out.println(menuItemRepo);
		System.out.println(reviewsRepo);
		
//		reviews.add(reviews1);
//		reviews.add(reviews2);
//		
//		menuItem.setReviews(reviews);
		
		menuItemRepo.save(menuItem);
		menuItemRepo.save(menuItem2);
		
		reviews1.setMenuItem(menuItem);
		reviews2.setMenuItem(menuItem);
		
		reviewsRepo.save(reviews1);
		reviewsRepo.save(reviews2);
		
//		reviews2.setMenuItem(menuItem2);
//		reviewsRepo.save(reviews2);
				
//		Optional<MenuItem> byId = menuItemRepo.findById(1l);
//		MenuItem menuItem3 = byId.get();
//		System.out.println("byId.get " +byId.get());
//		System.out.println(menuItem3.getReviews());
		
		long id = menuItem.getId();
		mi(id);
//		for(Reviews r: byId.get().getReviews()){
//			System.out.println(r);
//		}

		
		Review reviewst = new Review();
		reviews1.setTitle("reviews1");
		
		List<Review> findByTitle = reviewsRepo.findByTitleLike("reviews%");
		Review reviewsRepo2 = findByTitle.get(0);
		System.out.println(reviewsRepo2+ "size is "+findByTitle.size());
		
//		System.out.println(menuItem);
//		System.out.println(reviews1);
	}
	
	@Transactional(isolation = Isolation.READ_UNCOMMITTED)
	public void mi(long ID) {
		Optional<MenuItem> byId = menuItemRepo.findById(ID);
		MenuItem menuItem3 = byId.get();
		System.out.println("byId.get " +byId.get());
		System.out.println(menuItem3.getReviews());
	}
	
	// tests cascade delete working 
	@Transactional
	public void deleteItems() {
		menuItemRepo.deleteById(1l);
	}
	
	// tests cascade delete working 
	@Transactional
	public void getMenuItemReview() {
		Collection<Object[]> menuItemReview = reviewsRepo.getMenuItemReview();
		menuItemReview.forEach(i->{System.out.println((Review)i[0]);
		System.out.println((MenuItem) i[1]);});
	}
	
	@Transactional
	public void deleteMenuItemReview() {
		System.out.println("deleted the items " + reviewsRepo.deleteMenuItemReview()); 
	}
	
	public void openMenuItem() {
		SessionFactory sessionFactory = entityManagerFactory.unwrap(SessionFactory.class);
		Session openSession = sessionFactory.openSession();
		Transaction beginTransaction = openSession.getTransaction();
		beginTransaction.begin();
		
		List<Review> reviews = new ArrayList<>();
		
		MenuItem menuItem = new MenuItem("dish1");
		MenuItem menuItem2 = new MenuItem("dish2");
		
		Review reviews1 = new Review();
		reviews1.setTitle("reviews1");
		
		Review reviews2 = new Review();
		reviews2.setTitle("reviews2");
		
		System.out.println(menuItemRepo);
		System.out.println(reviewsRepo);
		
//		reviews.add(reviews1);
//		reviews.add(reviews2);
//		
//		menuItem.setReviews(reviews);
		
		menuItemRepo.save(menuItem);
		menuItemRepo.save(menuItem2);
		
		reviews1.setMenuItem(menuItem);
		reviews2.setMenuItem(menuItem);
		
		reviewsRepo.save(reviews1);
		reviewsRepo.save(reviews2);
		
		Optional<MenuItem> byId = menuItemRepo.findById(1l);
		MenuItem menuItem3 = byId.get();
		System.out.println("byId.get " +byId.get());
		System.out.println(menuItem3.getReviews());
		
		beginTransaction.commit();
		openSession.close();
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
