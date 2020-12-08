package com.lambda.crudyorders.services;

import com.lambda.crudyorders.models.Customer;
import com.lambda.crudyorders.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "customerServices")
public class CustomerServicesImpl implements CustomerServices
{
	@Autowired
	CustomerRepository custrepos;
	
	@Override
	public Customer save(Customer customer)
	{
		return custrepos.save(customer);
	}
}
