package com.app.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dto.ApiResponse;
import com.app.entities.Customer;
import com.app.entities.Review;
import com.app.exception.ResourceNotFoundException;
import com.app.repository.CustomerRepository;
import com.app.repository.ReviewRepository;

@Service
@Transactional
public class ReviewServiceImpl implements ReviewService
{
	@Autowired
	private ReviewRepository reviewRepository;
	@Autowired
	private CustomerRepository customerRepository;
	
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
	public ApiResponse addReview(Review review) 
	{
		
		Customer customer = customerRepository.findById(review.getCustomer())
				//.orElseThrow(() -> new ResourceNotFoundException("Invalid commenter id!!!"));
		//return reviewRepository.save(review);
		return null;
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
