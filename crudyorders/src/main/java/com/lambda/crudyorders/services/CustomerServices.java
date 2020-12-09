package com.lambda.crudyorders.services;


import com.lambda.crudyorders.models.Customer;
import com.lambda.crudyorders.views.OrderCounts;

import java.util.List;

/**
 * The interface Customer services.
 */
public interface CustomerServices
{
	/**
	 * Find all customers list.
	 *
	 * @return the list
	 */
	List<Customer> findAllCustomers();
	
	/**
	 * Find customer by id customer.
	 *
	 * @param id the id
	 * @return the customer
	 */
	Customer findCustomerById(long id);
	
	/**
	 * Find customers by like name list.
	 *
	 * @param likename the likename
	 * @return the list
	 */
	List<Customer> findCustomersByLikeName(String likename);
	
	/**
	 * Find customer order counts list.
	 *
	 * @return the list
	 */
	List<OrderCounts> findCustomerOrderCounts();
	
	/**
	 * Save customer.
	 *
	 * @param customer the customer
	 * @return the customer
	 */
	Customer save(Customer customer);
}
