package com.lambda.crudyorders.services;

import com.lambda.crudyorders.models.Order;
import com.lambda.crudyorders.views.AdvanceAmounts;

import java.util.List;

/**
 * The interface Order services.
 */
public interface OrderServices
{
	/**
	 * Find order by id order.
	 *
	 * @param ordnum the ordnum
	 * @return the order
	 */
	Order findOrderById(long ordnum);
	
	/**
	 * Find orders by advance amt list.
	 *
	 * @return the list
	 */
	List<AdvanceAmounts> findOrdersByAdvanceAmt();
	
	/**
	 * Save order.
	 *
	 * @param order the order
	 * @return the order
	 */
	Order save(Order order);
}
