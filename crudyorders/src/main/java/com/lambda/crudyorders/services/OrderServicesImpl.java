package com.lambda.crudyorders.services;

import com.lambda.crudyorders.models.Order;
import com.lambda.crudyorders.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

/**
 * The type Order services.
 */
@Service(value = "orderServices")
public class OrderServicesImpl implements OrderServices
{
	/**
	 * The Ordrepos.
	 */
	@Autowired
	OrderRepository ordrepos;
	
	@Override public Order findOrderById(long id)
	{
		return ordrepos.findById(id).orElseThrow(() -> new EntityNotFoundException("Order " + id + " not found"));
	}
	
	@Override public Order save(Order order)
	{
		return ordrepos.save(order);
	}
}
