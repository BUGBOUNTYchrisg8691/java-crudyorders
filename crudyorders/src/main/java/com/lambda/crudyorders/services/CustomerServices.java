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
	 * Save customer.
	 *
	 * @param customer the customer
	 * @return the customer
	 */
	Customer save(Customer customer);
	
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
	 * Find customers by name like list.
	 *
	 * @param subname the subname
	 * @return the list
	 */
	List<Customer> findCustomersByNameLike(String subname);
	
	/**
	 * Find all customers order counts list.
	 *
	 * @return the list
	 */
	List<OrderCounts> findAllCustomersOrderCounts();
}
