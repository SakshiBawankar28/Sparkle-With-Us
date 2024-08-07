package com.app.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.entities.Review;
import com.app.exception.ResourceNotFoundException;
import com.app.repository.ReviewRepository;

@Service
@Transactional
public class ReviewServiceImpl implements ReviewService
{
	@Autowired
	private ReviewRepository reviewRepository;
	
	@Override
	public List<Review> getAllReview() 
	{
		return reviewRepository.findAll();
	}

	@Override
	public Review getById(Long id) 
	{
		Optional<Review>review = reviewRepository.findById(id);
		return review.orElseThrow(() -> new ResourceNotFoundException("Invalide Review Id"));
	}

	@Override
	public Review addReview(Review review) 
	{
		return reviewRepository.save(review);
	}

	@Override
	public Review updateReview(Review review) 
	{
		return reviewRepository.save(review);
	}

	@Override
	public String removeReview(Long id) 
	{
		if(reviewRepository.existsById(id))
		{
			reviewRepository.deleteById(id);
			return "Deleteing Review";
		}
		return "Deleting Review Failed : Invalid Review Id";
	}

}
