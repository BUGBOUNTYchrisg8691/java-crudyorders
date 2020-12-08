package com.lambda.crudyorders.repositories;

import com.lambda.crudyorders.models.Customer;
import com.lambda.crudyorders.views.OrderCounts;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * The interface Customer repository.
 */
public interface CustomerRepository extends CrudRepository<Customer, Long>
{
	/**
	 * Find by custname containing ignore case list.
	 *
	 * @param subname the subname
	 * @return the list
	 */
	List<Customer> findByCustnameContainingIgnoreCase(String subname);
	
	/**
	 * Find order counts list.
	 *
	 * @return the list
	 */
	@Query(value = "", nativeQuery = true)
	List<OrderCounts> findOrderCounts();
}
