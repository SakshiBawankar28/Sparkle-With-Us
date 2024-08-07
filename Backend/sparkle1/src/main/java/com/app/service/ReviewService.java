package com.app.service;

import java.util.List;

import com.app.entities.Review;

public interface ReviewService {

	List<Review> getAllReview();

	Review getById(Long id) ;
	
	Review addReview(Review review) ;

	Review updateReview(Review review) ;

	String removeReview(Long id) ;
}
