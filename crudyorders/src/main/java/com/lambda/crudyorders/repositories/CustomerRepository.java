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
	 * Find by custname containing ignoring case list.
	 *
	 * @param subname the subname
	 * @return the list
	 */
	List<Customer> findByCustnameContainingIgnoringCase(String subname);
	
	/**
	 * Find order count list.
	 *
	 * @return the list
	 */
	@Query(value = "SELECT c.custname name, count(ordnum) ordercount " +
			"FROM orders o " +
			"LEFT JOIN customers c on c.custcode = o.custcode " +
			"GROUP BY name " +
			"ORDER BY ordercount DESC", nativeQuery = true)
	List<OrderCounts> findOrderCount();
}
