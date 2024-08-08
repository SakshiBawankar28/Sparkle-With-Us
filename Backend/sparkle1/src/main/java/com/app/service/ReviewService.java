package com.app.service;

import java.util.List;

import com.app.dto.ApiResponse;
import com.app.entities.Review;

public interface ReviewService {

	List<Review> getAllReview();

	Review getById(Long id) ;
	
	ApiResponse addReview(Review review) ;

	Review updateReview(Review review) ;

	String removeReview(Long id) ;
}
