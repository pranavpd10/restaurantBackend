package restaurant.back.repos;

import java.util.Collection;
import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import jakarta.persistence.OrderBy;
import restaurant.back.models.Review;

@Transactional
public interface ReviewRepo extends JpaRepository<Review,Long>{
	List<Review> findByTitle(String name);
	List<Review> findByTitleLike(String name);
	List<Review> findTop1ByTitle(String name);
	
	List<Review> findByMenuItemId(long name);
//	List<Review> findByid(long name);
	
	@Query("SELECT r,m from Review as r left join MenuItem as m on r.menuItem.id=m.id  where r.menuItem.id=192")
//	@Query("SELECT r.id from Review as r")
	Collection<Object[]> getMenuItemReview();
	
	@Modifying
	@Query("delete from Review where id in ( SELECT r.id from Review as r left join MenuItem as m on r.menuItem.id=m.id  where r.menuItem.id=192)")
	int deleteMenuItemReview();
	
	@Query("SELECT r from Review as r")
	List<Review> getReviewsBySortedColumn(Sort sort);
}
