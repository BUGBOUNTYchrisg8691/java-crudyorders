package com.lambdaschool.crudyorders.controllers;

import com.lambdaschool.crudyorders.models.Order;
import com.lambdaschool.crudyorders.services.OrderServices;
import com.lambdaschool.crudyorders.services.PaymentServices;
import com.lambdaschool.crudyorders.views.AdvanceAmounts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
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
	
	@DeleteMapping(value = "/order/{ordnum}")
	public ResponseEntity<?> deleteOrder(@PathVariable long ordnum)
	{
		orderServices.delete(ordnum);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@PutMapping(value = "/order/{ordnum}", consumes = {"application/json"})
	public ResponseEntity<?> replaceOrder(@PathVariable long ordnum, @RequestBody Order order)
	{
		order.setOrdnum(ordnum);
		order = orderServices.save(order);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@PostMapping(value = "/order", consumes = {"application/json"})
	public ResponseEntity<?> addNewOrder(@Valid @RequestBody Order order)
	{
		order.setOrdnum(0);
		order = orderServices.save(order);
		
		HttpHeaders respHeaders = new HttpHeaders();
		URI orderURI =
				ServletUriComponentsBuilder.fromCurrentRequest().path("/{ordnum}").buildAndExpand(order.getOrdnum()).toUri();
		respHeaders.setLocation(orderURI);
		
		return new ResponseEntity<>(null, respHeaders, HttpStatus.CREATED);
	}
}
