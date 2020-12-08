package com.lambda.crudyorders.repositories;

import com.lambda.crudyorders.models.Payment;
import org.springframework.data.repository.CrudRepository;

/**
 * The interface Payment repository.
 */
public interface PaymentRepository extends CrudRepository<Payment, Long>
{
}
