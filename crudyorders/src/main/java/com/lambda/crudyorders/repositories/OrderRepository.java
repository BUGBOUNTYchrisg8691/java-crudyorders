package com.lambda.crudyorders.repositories;

import com.lambda.crudyorders.models.Order;
import org.springframework.data.repository.CrudRepository;

/**
 * The interface Order repository.
 */
public interface OrderRepository extends CrudRepository<Order, Long>
{
}
