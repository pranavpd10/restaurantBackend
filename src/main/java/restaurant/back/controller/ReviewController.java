package restaurant.back.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import restaurant.back.Exceptions.InvalidRequestParamExcpetion;
import restaurant.back.Services.ReviewService;
import restaurant.back.models.MenuItem;
import restaurant.back.models.Review;
import restaurant.back.repos.ReviewRepo;

@RestController
public class ReviewController {
	private static final List<String> REVIEW_COLUMNS = new ArrayList<>();
	static {
		REVIEW_COLUMNS.add("rate");
		REVIEW_COLUMNS.add("id");
		REVIEW_COLUMNS.add("title");
		REVIEW_COLUMNS.add("createdDate");
	}
	
	@Autowired
	ReviewService reviewService;
	
	@GetMapping("/getReviews/{menuItemId}")
	public List<Review> getMenuItems(@PathVariable long menuItemId, @RequestParam(required = false) String column) {
		System.out.println(" menuItemId "+menuItemId + " column "+column);
		List<Review> reviews = null;
		if (column != null) {
			if (!REVIEW_COLUMNS.contains(column)) {
				Map<String, String> errorMap = new HashMap<>();
				errorMap.put("sorting column", "invalid value " + column);
				throw new InvalidRequestParamExcpetion(errorMap);
			}else {
				reviews = reviewService.getReviewsBySortedColumn(column);
			}
		} else {
			reviews = reviewService.getAllReview(menuItemId);
		}
		return reviews;
	}
	
	@GetMapping("/getReviewsByRating/{title}/")
	public List<Review> getReviewsByRating(@PathVariable(required = true) String title) {
		System.out.println("title is "+title );
		List<Review> reviews = reviewService.getReviewsByTitle(title);
		return reviews;
	}
	
	
	@PostMapping("/createReview")
	public Review createReview(@RequestBody @Valid Review review) {
		System.out.println("review "+review);
		Review reviews = reviewService.createReview(review);
		return reviews;
	}
}
