package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.entities.Booking;
import com.app.service.BookingService;

@RestController
@RequestMapping("/booking")
public class BookingController 
{
	@Autowired
	private BookingService bookingService;
	
	public BookingController() 
	{
		System.out.println("In Booking Controller "+ getClass());
	}
	
	@GetMapping
	public List<Booking> getAllBookingDetails()
	{
		return bookingService.getAllBookingDetails();
	}
	
	@GetMapping("/{id}")
	public Booking getBookingDetailsById(@PathVariable Long id)
	{
		return bookingService.getBookingDetailsById(id);
	}
	
	@DeleteMapping("/{id}")
	public String deleteBookingById(Long id)
	{
		return bookingService.deleteBookingById(id);
	}
	
	@PostMapping
	public Booking addNewBooking(@RequestBody Booking newBooking)
	{
		return bookingService.addNewBookingDetails(newBooking);
	}
	
	@PutMapping
	public Booking updateBookingDetalis(@RequestBody Booking booking)
	{
		return bookingService.updateBookingDetails(booking);
	}
	
	@GetMapping("/sorted")
	public List<Booking> getBookingSortedBydate()
	{
		return bookingService.findAllByOrderByBookingDateAsc();
	}
}




