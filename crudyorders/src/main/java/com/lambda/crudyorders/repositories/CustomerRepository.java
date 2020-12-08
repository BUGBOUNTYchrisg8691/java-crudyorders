package com.lambda.crudyorders.repositories;

import com.lambda.crudyorders.models.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Long>
{
}
