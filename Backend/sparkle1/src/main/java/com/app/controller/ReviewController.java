package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.entities.Review;
import com.app.exception.ResourceNotFoundException;
import com.app.service.ReviewService;

@RestController
@RequestMapping("/review")
public class ReviewController {
	@Autowired
	private ReviewService reviewService;
	
	public ReviewController() 
	{
		System.out.println("In Review Controller class " + getClass());
	}

	@GetMapping
	public List<Review> getAllReview() {
		return reviewService.getAllReview();
	}

	@PostMapping
	public ResponseEntity<Review> addReview(@RequestBody Review revi) {
		try {
			Review review = reviewService.addReview(revi);
			return new ResponseEntity<>(review, HttpStatus.CREATED);
		} catch (ResourceNotFoundException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("/{id}")
	public Review getById(Long id) throws ResourceNotFoundException {
		return reviewService.getById(id);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Review> updateReview(Review review) 
	{
		Review review1 = reviewService.updateReview(review);
		return ResponseEntity.ok(review1);
	}

	@DeleteMapping("/{id}")
	public String removeReview(@PathVariable Long id){
		return reviewService.removeReview(id);

	}
}
