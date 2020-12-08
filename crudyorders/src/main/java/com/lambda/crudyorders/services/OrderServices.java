package com.lambda.crudyorders.services;

import com.lambda.crudyorders.models.Order;

public interface OrderServices
{
	Order save(Order order);
	
	Order findOrderById(long id);
}
