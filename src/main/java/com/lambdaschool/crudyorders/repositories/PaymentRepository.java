package com.lambdaschool.crudyorders.repositories;

import com.lambdaschool.crudyorders.models.Payment;
import org.springframework.data.repository.CrudRepository;

/**
 * The interface Payment repository.
 */
public interface PaymentRepository extends CrudRepository<Payment, Long>
{
}
