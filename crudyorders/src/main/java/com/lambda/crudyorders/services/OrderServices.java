package com.lambda.crudyorders.services;

import com.lambda.crudyorders.models.Order;

/**
 * The interface Order services.
 */
public interface OrderServices
{
	/**
	 * Save order.
	 *
	 * @param order the order
	 * @return the order
	 */
	Order save(Order order);
	
	/**
	 * Find order by id order.
	 *
	 * @param id the id
	 * @return the order
	 */
	Order findOrderById(long id);
}
