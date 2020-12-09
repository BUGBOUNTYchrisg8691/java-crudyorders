package com.lambda.crudyorders.services;

import com.lambda.crudyorders.models.Order;
import com.lambda.crudyorders.views.AdvanceAmount;

import java.util.List;

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
	 * Delete.
	 *
	 * @param id the id
	 */
	void delete(long id);
	
	/**
	 * Delete all orders.
	 */
	void deleteAllOrders();
	
	/**
	 * Update order.
	 *
	 * @param order the order
	 * @param id    the id
	 * @return the order
	 */
	Order update(Order order, long id);
	
	/**
	 * Find order by id order.
	 *
	 * @param id the id
	 * @return the order
	 */
	Order findOrderById(long id);
	
	/**
	 * Find orders by advance amount list.
	 *
	 * @return the list
	 */
	List<AdvanceAmount> findOrdersByAdvanceAmount();
}
