package com.lambda.crudyorders.controllers;

import com.lambda.crudyorders.models.Order;
import com.lambda.crudyorders.services.OrderServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * The type Order controller.
 */
@RestController
@RequestMapping("/orders")
public class OrderController
{
	/**
	 * The Order services.
	 */
	@Autowired
	OrderServices orderServices;
	
	// GET /orders/order/{id}
	/**
	 * Gets order by id.
	 *
	 * @param id the id
	 * @return the order by id
	 */
	@GetMapping(value = "order/{id}", produces = {"application/json"})
	public ResponseEntity<?> getOrderById(@PathVariable long id)
	{
		Order retord = orderServices.findOrderById(id);
		
		return new ResponseEntity<>(retord, HttpStatus.OK);
	}
	
	// stretch - GET /orders/advanceamount
}
