package com.lambdaschool.crudyorders.controllers;

import com.lambdaschool.crudyorders.models.Order;
import com.lambdaschool.crudyorders.services.OrderServices;
import com.lambdaschool.crudyorders.views.AdvanceAmounts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * The type Order controller.
 */
@RestController
@RequestMapping("/orders")
public class OrderController
{
	@Autowired
	private OrderServices orderServices;
	
	/**
	 * Gets order by id.
	 *
	 * @param ordnum the ordnum
	 * @return the order by id
	 */
	//	GET /orders/order/{id} - Returns the order and its customer with the given order number
	@GetMapping(value = "/order/{ordnum}", produces = {"application/json"})
	public ResponseEntity<?> getOrderById(@PathVariable long ordnum)
	{
		Order retOrd = orderServices.findOrderById(ordnum);
		return new ResponseEntity<>(retOrd, HttpStatus.OK);
	}
	
	/**
	 * Gets orders by advance amt.
	 *
	 * @return the orders by advance amt
	 */
/*  Stretch
		GET /orders/advanceamount - returns all orders with their customers
		that have an advanceamount greater than 0. */
	@GetMapping(value = "/advanceamount", produces = {"application" +
			"/json"})
	public ResponseEntity<?> getOrdersByAdvanceAmt()
	{
		List<AdvanceAmounts> retLst = orderServices.findOrdersByAdvanceAmt();
		return new ResponseEntity<>(retLst, HttpStatus.OK);
	}
}
