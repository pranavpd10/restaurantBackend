package restaurant.back.repos;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import restaurant.back.models.Review;

@Transactional
public interface ReviewRepo extends JpaRepository<Review,Long>{
	List<Review> findByTitle(String name);
	List<Review> findByTitleLike(String name);
	List<Review> findTop1ByTitle(String name);
	
	@Query("SELECT r,m from Review as r left join MenuItem as m on r.menuItem.id=m.id  where r.menuItem.id=192")
//	@Query("SELECT r.id from Review as r")
	Collection<Object[]> getMenuItemReview();
	
	@Modifying
	@Query("delete from Review where id in ( SELECT r.id from Review as r left join MenuItem as m on r.menuItem.id=m.id  where r.menuItem.id=192)")
	int deleteMenuItemReview();
}
