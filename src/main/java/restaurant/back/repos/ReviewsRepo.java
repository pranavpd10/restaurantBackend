package restaurant.back.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import restaurant.back.models.Reviews;

public interface ReviewsRepo extends JpaRepository<Reviews,Long>{
	
}
