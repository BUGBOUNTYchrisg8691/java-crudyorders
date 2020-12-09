package com.lambda.crudyorders.services;

import com.lambda.crudyorders.models.Customer;
import com.lambda.crudyorders.models.Order;
import com.lambda.crudyorders.repositories.CustomerRepository;
import com.lambda.crudyorders.repositories.OrderRepository;
import com.lambda.crudyorders.views.OrderCounts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
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
	
	@Autowired
	private OrderRepository ordrepos;
	
	@Transactional
	@Override
	public Customer save(Customer customer)
	{
		Customer newCustomer = new Customer();
		
		if (customer.getCustcode() != 0)
		{
			custrepos.findById(customer.getCustcode()).orElseThrow(() -> new EntityNotFoundException("Customer " + customer.getCustcode() + " not found"));
			newCustomer.setCustcode(customer.getCustcode());
		}
		
		newCustomer.setCustname(customer.getCustname());
		newCustomer.setCustcity(customer.getCustcity());
		newCustomer.setCustcountry(customer.getCustcountry());
		newCustomer.setGrade(customer.getGrade());
		newCustomer.setOpeningamt(customer.getOpeningamt());
		newCustomer.setOutstandingamt(customer.getOutstandingamt());
		newCustomer.setPaymentamt(customer.getPaymentamt());
		newCustomer.setReceiveamt(customer.getReceiveamt());
		newCustomer.setPhone(customer.getPhone());
		newCustomer.setAgent(customer.getAgent());
		
		newCustomer.getOrders().clear();
		for (Order order : customer.getOrders())
		{
			Order newOrder = ordrepos.findById(order.getOrdnum()).orElseThrow(() -> new EntityNotFoundException((
					"Order " + order.getOrdnum() + " not found")));
			
			newCustomer.getOrders().add(newOrder);
		}
		
		return custrepos.save(customer);
	}
	
	@Transactional
	@Override public void delete(long id)
	{
		if (custrepos.findById(id).isPresent())
		{
			custrepos.deleteById(id);
		}
		else
		{
			throw new EntityNotFoundException("Customer " + id + " not found");
		}
	}
	
	@Transactional
	@Override public Customer update(Customer customer, long id)
	{
		return new Customer();
	}
	
	@Transactional
	@Override
	public void deleteAllCustomers()
	{
		custrepos.deleteAll();
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
