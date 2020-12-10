package com.lambdaschool.crudyorders.repositories;

import com.lambdaschool.crudyorders.models.Order;
import com.lambdaschool.crudyorders.views.AdvanceAmounts;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * The interface Order repository.
 */
public interface OrderRepository extends CrudRepository<Order, Long>
{
	/**
	 * Find by advance amt list.
	 *
	 * @return the list
	 */
	@Query(value = "SELECT o.ordnum orderid, o.advanceamount advamt, " +
			"c.custname name " +
			"FROM customers c " +
			"LEFT JOIN orders o " +
			"ON o.custcode = c.custcode " +
			"WHERE o.advanceamount > 0 " +
			"ORDER BY advamt DESC", nativeQuery = true)
	List<AdvanceAmounts> findByAdvanceAmt();
}
