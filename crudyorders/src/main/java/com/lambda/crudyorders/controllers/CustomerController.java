package com.lambda.crudyorders.controllers;

import com.lambda.crudyorders.models.Customer;
import com.lambda.crudyorders.models.Order;
import com.lambda.crudyorders.services.CustomerServices;
import com.lambda.crudyorders.views.OrderCounts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Customer controller.
 */
@RestController
@RequestMapping("/customers")
public class CustomerController
{
	/**
	 * The Customer services.
	 */
	@Autowired
	CustomerServices customerServices;
	
	// GET /customers/orders
	
	/**
	 * Gets all customers.
	 *
	 * @return the all customers
	 */
	@GetMapping(value = "/orders", produces = {"application/json"})
	public ResponseEntity<?> getAllCustomers()
	{
		List<Customer> retlst = customerServices.findAllCustomers();
		
		return new ResponseEntity<>(retlst, HttpStatus.OK);
	}
	
	// GET /customers/customer/{id}
	
	/**
	 * Gets customer by id.
	 *
	 * @param id the id
	 * @return the customer by id
	 */
	@GetMapping(value = "/customer/{id}", produces = {"application/json"})
	public ResponseEntity<?> getCustomerById(@PathVariable long id)
	{
		Customer retcust = customerServices.findCustomerById(id);
		
		return new ResponseEntity<>(retcust, HttpStatus.OK);
	}
	
	/**
	 * Gets customers by name like.
	 *
	 * @param subname the subname
	 * @return the customers by name like
	 */
	// GET /customers/orders/count
	@GetMapping(value = "/namelike/{subname}", produces = {"application/json"})
	public ResponseEntity<?> getCustomersByNameLike(@PathVariable String subname)
	{
		List<Customer> retlst = customerServices.findCustomersByNameLike(subname);
		return new ResponseEntity<>(retlst, HttpStatus.OK);
	}
	
	// GET /customers/orders/count
	
	/**
	 * Gets customers order count.
	 *
	 * @return the customers order count
	 */
	@GetMapping(value = "/orders/count", produces = {"application/json"})
	public ResponseEntity<?> getCustomersOrderCount()
	{
		List<OrderCounts> retlst = customerServices.findAllCustomersOrderCounts();
		return new ResponseEntity<>(retlst, HttpStatus.OK);
	}
}
