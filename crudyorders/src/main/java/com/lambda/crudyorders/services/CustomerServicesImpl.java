package com.lambda.crudyorders.services;

import com.lambda.crudyorders.models.Customer;
import com.lambda.crudyorders.repositories.CustomerRepository;
import com.lambda.crudyorders.views.OrderCounts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

/**
 * The type Customer services.
 */
@Service(value = "customerServices")
public class CustomerServicesImpl implements CustomerServices
{
	/**
	 * The Custrepos.
	 */
	@Autowired
	CustomerRepository custrepos;
	
	@Override
	public Customer save(Customer customer)
	{
		return custrepos.save(customer);
	}
	
	@Override public List<Customer> findAllCustomers()
	{
		List<Customer> retlst = new ArrayList<>();
		custrepos.findAll().iterator().forEachRemaining(retlst::add);
		return retlst;
	}
	
	@Override public Customer findCustomerById(long id)
	{
		return custrepos.findById(id).orElseThrow(() -> new EntityNotFoundException("Customer " + id + " not found"));
	}
	
	@Override public List<Customer> findCustomersByNameLike(String subname) throws EntityNotFoundException
	{
		List<Customer> retlst = custrepos.findByCustnameContainingIgnoreCase(subname);
		
		if (retlst == null)
		{
			throw new EntityNotFoundException("Customer containing '" + subname + "' not found");
		}
		
		return retlst;
	}
	
	@Override public List<OrderCounts> findAllCustomersOrderCounts()
	{
		return custrepos.findOrderCounts();
	}
}
