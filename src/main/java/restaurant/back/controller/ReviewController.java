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
import restaurant.back.Exceptions.InvalidPathVariable;
import restaurant.back.Exceptions.InvalidRequestParamExcpetion;
import restaurant.back.Services.ReviewService;
import restaurant.back.models.MenuItem;
import restaurant.back.models.Review;
import restaurant.back.repos.ReviewRepo;

import restaurant.back.Util.MenuItemReviewFunctions;
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
	
	@Autowired
	MenuItemReviewFunctions menuItemReviewFunctions;
	
	@GetMapping("/getReviews/{menuItemId}")
	public ResponseEntity<List<Review>> getMenuItems(@PathVariable long menuItemId, @RequestParam(required = false) String column) {
		System.out.println(" menuItemId "+menuItemId + " column "+column);
		ResponseEntity<List<Review>> reviewEntity = null;
		List<Review> reviews = null;
		if(!menuItemReviewFunctions.isMenuItemPresent(menuItemId)) {
			Map<String, String> errorMap = new HashMap<>();
			errorMap.put("pathVariable", "no menu item present on id " + menuItemId);
			throw new InvalidPathVariable(errorMap);
		}
		if (column != null) {
			if (!REVIEW_COLUMNS.contains(column)) {
				Map<String, String> errorMap = new HashMap<>();
				errorMap.put("sorting column", "invalid value " + column);
				throw new InvalidRequestParamExcpetion(errorMap);
			} else {
				reviews = reviewService.getReviewsBySortedColumn(column);
				reviewEntity = reviewEntity.ok().body(reviews);
			}
		} else {
			reviews = reviewService.getAllReview(menuItemId);
			reviewEntity = reviewEntity.ok().body(reviews);

		}
		return reviewEntity;
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
