package com.lambda.crudyorders.controllers;

import com.lambda.crudyorders.models.Customer;
import com.lambda.crudyorders.services.CustomerServices;
import com.lambda.crudyorders.views.OrderCounts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * The type Customer controller.
 */
@RestController
@RequestMapping("/customers")
public class CustomerController
{
	@Autowired
	private CustomerServices customerServices;
	
	/**
	 * Gets all customers.
	 *
	 * @return the all customers
	 */
	//	GET /customers/orders - Returns all customers with their orders
	@GetMapping(value = "/orders", produces = {"application/json"})
	public ResponseEntity<?> getAllCustomers()
	{
		List<Customer> retLst = customerServices.findAllCustomers();
		return new ResponseEntity<>(retLst, HttpStatus.OK);
	}
	
	/**
	 * Gets customer orders count.
	 *
	 * @param id the id
	 * @return the customer orders count
	 */
	//	GET /customers/customer/{id} - Returns the customer and their orders with the given customer id
	@GetMapping(value = "/customer/{id}", produces = {"application/json"})
	public ResponseEntity<?> getCustomerOrdersCount(@PathVariable long id)
	{
		Customer retCust = customerServices.findCustomerById(id);
		return new ResponseEntity<>(retCust, HttpStatus.OK);
	}
	
	/**
	 * Gets customer by like name.
	 *
	 * @param likename the likename
	 * @return the customer by like name
	 */
	//  GET /customers/namelike/{likename} - Returns all customers and their orders with a customer name containing
	//  the given substring
	@GetMapping(value = "/namelike/{likename}", produces = {"application/json"})
	public ResponseEntity<?> getCustomerByLikeName(@PathVariable String likename)
	{
		List<Customer> retLst =
				customerServices.findCustomersByLikeName(likename);
		return new ResponseEntity<>(retLst, HttpStatus.OK);
	}
	
	/**
	 * Gets customer order counts.
	 *
	 * @return the customer order counts
	 */
	//	GET /customers/orders/count - Using a custom query, return a list of all customers with the number of orders
	@GetMapping(value = "/orders/count", produces = {"application/json"})
	public ResponseEntity<?> getCustomerOrderCounts()
	{
		List<OrderCounts> retLst = customerServices.findCustomerOrderCounts();
		return new ResponseEntity<>(retLst, HttpStatus.OK);
	}
}
