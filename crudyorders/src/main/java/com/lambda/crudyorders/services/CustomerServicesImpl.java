package com.lambda.crudyorders.services;

import com.lambda.crudyorders.models.Customer;
import com.lambda.crudyorders.repositories.CustomerRepository;
import com.lambda.crudyorders.views.OrderCounts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

/**
 * The type Customer services.
 */
@Transactional
@Service(value = "customerServices")
public class CustomerServicesImpl implements CustomerServices
{
	/**
	 * The Custrepos.
	 */
	@Autowired
	CustomerRepository custrepos;
	
	@Transactional
	@Override
	public Customer save(Customer customer)
	{
		return custrepos.save(customer);
	}
	
	@Override
	public List<Customer> findAllCustomers()
	{
		
		List<Customer> retLst = new ArrayList<>();
		custrepos.findAll().iterator().forEachRemaining(retLst::add);
		return retLst;
	}
	
	@Override
	public Customer findCustomerById(long id)
	{
		return custrepos.findById(id).orElseThrow(() -> new EntityNotFoundException("Customer " + id + " not found"));
	}
	
	@Override
	public List<Customer> findCustomersByLikeName(String subname)
	{
		return custrepos.findByCustnameContainingIgnoringCase(subname);
	}
	
	@Override
	public List<OrderCounts> findCustomerOrderCounts()
	{
		return custrepos.findOrderCount();
	}
}
