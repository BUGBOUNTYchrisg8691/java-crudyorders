package com.lambda.crudyorders.services;

import com.lambda.crudyorders.models.Order;
import com.lambda.crudyorders.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "orderServices")
public class OrderServicesImpl implements OrderService
{
	@Autowired
	OrderRepository ordrepos;
	
	
	@Override public Order save(Order order)
	{
		return ordrepos.save(order);
	}
}
