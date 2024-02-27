package restaurant.back.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import restaurant.back.models.Reviews;

public interface ReviewsRepo extends JpaRepository<Reviews,Long>{
	List<Reviews> findByTitle(String name);
	List<Reviews> findByTitleLike(String name);
	List<Reviews> findTop1ByTitle(String name);
}
