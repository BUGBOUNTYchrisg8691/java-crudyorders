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

@RestController
@RequestMapping("/orders")
public class OrderController
{
	@Autowired
	OrderServices orderServices;
	
	// GET /orders/order/{id}
	@GetMapping(value = "order/{id}", produces = {"application/json"})
	public ResponseEntity<?> getOrderById(@PathVariable long id)
	{
		Order retord = orderServices.findOrderById(id);
		
		return new ResponseEntity<>(retord, HttpStatus.OK);
	}
	
	// stretch - GET /orders/advanceamount
}
