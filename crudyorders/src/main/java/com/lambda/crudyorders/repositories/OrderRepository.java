package com.lambda.crudyorders.repositories;

import com.lambda.crudyorders.models.Order;
import com.lambda.crudyorders.views.AdvanceAmount;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * The interface Order repository.
 */
public interface OrderRepository extends CrudRepository<Order, Long>
{
	@Query(value = "SELECT o.ordnum orderid, o.advanceamt advanceamount, c.custname name " +
			"FROM customers c LEFT JOIN orders o ON c.custcode = o.custcode " +
			"WHERE ADVANCEAMT > 0 " +
			"ORDER BY ADVANCEAMT DESC", nativeQuery = true)
	List<AdvanceAmount> findAdvanceAmounts();
}
