package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.dto.ApiResponse;
import com.app.entities.Review;

@Repository
public interface ReviewRepository extends JpaRepository<Review,Long> 
{

}
