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

import com.app.entities.Customer;
import com.app.service.CustomerService;

@RestController
@RequestMapping("/customers")
public class CustomerController 
{
	@Autowired
	private CustomerService customerService;
	
	public CustomerController() 
	{
		System.out.println("In Customer Controller "+ getClass());
	}
	
	@GetMapping
    public ResponseEntity<List<Customer>> getAllCustomerDetails() {
        List<Customer> customers = customerService.getAllCustomerDetails();
        return ResponseEntity.ok(customers);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable Long id) {
        Customer customer = customerService.getCustomerById(id);
        if (customer != null) {
            return ResponseEntity.ok(customer);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @PostMapping
    public ResponseEntity<Customer> addNewCustomer(@RequestBody Customer customer) {
        Customer newCustomer = customerService.addCustomerDetails(customer);
        return ResponseEntity.status(HttpStatus.CREATED).body(newCustomer);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCustomerById(@PathVariable Long id) {
        String response = customerService.deleteCustomerById(id);
        return ResponseEntity.ok(response);
    }

    @PutMapping
    public ResponseEntity<Customer> updateCustomerDetails(@RequestBody Customer customer) {
        Customer updatedCustomer = customerService.updateCustomerDetails(customer);
        return ResponseEntity.ok(updatedCustomer);
    }

    @GetMapping("/sorted")
    public ResponseEntity<List<Customer>> getAllCustomersSortedByName() {
        List<Customer> sortedCustomers = customerService.getAllCustomersSortedByName();
        return ResponseEntity.ok(sortedCustomers);
    }
}
