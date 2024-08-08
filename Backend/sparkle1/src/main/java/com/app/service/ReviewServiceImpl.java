package com.app.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.entities.Customer;
import com.app.entities.Review;
import com.app.exception.ResourceNotFoundException;
import com.app.repository.CustomerRepository;
import com.app.repository.ReviewRepository;

@Service
@Transactional
public class ReviewServiceImpl implements ReviewService {
	@Autowired
	private ReviewRepository reviewRepository;
	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public List<Review> getAllReview() {
		return reviewRepository.findAll();
	}

	@Override
	public Review getById(Long id) {
		Optional<Review> review = reviewRepository.findById(id);
		return review.orElseThrow(() -> new ResourceNotFoundException("Invalide Review Id"));
	}

//	@Override
//	public Review addReview(Review review) 
//	{
//		Optional<Customer> customer = customerRepository.findById(review.getId());
//		if(customer.isPresent())
//		{
//			return reviewRepository.save(review);
//		}
//		else
//		{
//			throw new ResourceNotFoundException("Customer Id not match");
//		}
//	}

	@Override
	public Review addReview(Review review) {
        // Find the customer by ID
        Optional<Customer> optionalCustomer = customerRepository.findById(review.getCustomer().getId());

        // Check if customer exists
        if (optionalCustomer.isPresent()) {
            Customer customer = optionalCustomer.get();

            // Validate first name and last name
            if (customer.getFirstName().equals(review.getFirstName()) && 
                customer.getLastName().equals(review.getLastName())) {
                
                // Save the review
                return reviewRepository.save(review);
               // return ResponseEntity.ok("Review added successfully");
            } else {
                //return ResponseEntity.badRequest().body("First name or last name do not match");
            	throw new ResourceNotFoundException("First name or last name do not match");
            }
        } else {
            //return ResponseEntity.badRequest().body("Customer not found");
        	throw new ResourceNotFoundException("Customer not found");
        	}
        }

	@Override
	public Review updateReview(Review review) {
		return reviewRepository.save(review);
	}

	@Override
	public String removeReview(Long id) {
		if (reviewRepository.existsById(id)) {
			reviewRepository.deleteById(id);
			return "Deleteing Review";
		}
		return "Deleting Review Failed : Invalid Review Id";
	}

}
