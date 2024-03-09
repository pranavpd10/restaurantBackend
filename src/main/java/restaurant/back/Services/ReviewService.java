package restaurant.back.Services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import restaurant.back.models.Review;
import restaurant.back.repos.ReviewRepo;

@Service
public class ReviewService {

	@Autowired
	ReviewRepo reviewRepo;
	
	@Transactional
	public  List<Review> getAllReview(long menuItemId) {
		return reviewRepo.findByMenuItemId(menuItemId);
//		 Review review = reviewRepo.getReferenceById(menuItemId);
//		 ArrayList<Review> arrayList = new ArrayList<>();
//		 arrayList.add(review);
//		 return arrayList;
	}
	
	public  List<Review> getReviewsByTitle(String title) {
		return reviewRepo.findByTitle(title);
	}
	
	@Transactional
	public Review createReview(Review review) {
		return reviewRepo.save(review);
	}
	
	@Transactional
	public Review getAllReviewsBySortedRate(Review review) {
		return reviewRepo.save(review);
	}
	
	/**
	 * to get the reviews based upon the column sorting 
	 * @param column
	 * @return
	 */
	public List<Review> getReviewsBySortedColumn(String column) {
		return reviewRepo.getReviewsBySortedColumn(Sort.by(Sort.Direction.ASC, column));
	}
}
