package com.lambdaschool.crudyorders.services;

import com.lambdaschool.crudyorders.models.Customer;
import com.lambdaschool.crudyorders.models.Order;
import com.lambdaschool.crudyorders.models.Payment;
import com.lambdaschool.crudyorders.repositories.CustomerRepository;
import com.lambdaschool.crudyorders.repositories.OrderRepository;
import com.lambdaschool.crudyorders.repositories.PaymentRepository;
import com.lambdaschool.crudyorders.views.OrderCounts;
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
	
	@Autowired
	OrderRepository ordrepos;
	
	@Autowired
	PaymentRepository payrepos;
	
	@Transactional
	@Override
	public Customer save(Customer customer)
	{
		Customer newCustomer = new Customer();
		
		if (customer.getCustcode() != 0)
		{
			newCustomer = custrepos.findById(customer.getCustcode())
					.orElseThrow(() ->
							new EntityNotFoundException("Customer " + customer.getCustcode() + " not found"));
			newCustomer.setCustcode(customer.getCustcode());
		}
		
		newCustomer.setCustname(customer.getCustname());
		newCustomer.setCustcity(customer.getCustcity());
		newCustomer.setCustcountry(customer.getCustcountry());
		newCustomer.setWorkingarea(customer.getWorkingarea());
		newCustomer.setGrade(customer.getGrade());
		newCustomer.setPhone(customer.getPhone());
		newCustomer.setOpeningamt(customer.getOpeningamt());
		newCustomer.setReceiveamt(customer.getReceiveamt());
		newCustomer.setPaymentamt(customer.getPaymentamt());
		newCustomer.setOutstandingamt(customer.getOutstandingamt());
		newCustomer.setAgent(customer.getAgent());
		
		newCustomer.getOrders().clear();
		for (Order order : customer.getOrders())
		{
			Order newOrder = new Order(order.getOrdamount(), order.getAdvanceamount(), order.getOrderdescription(),
					newCustomer);
			for (Payment payment : order.getPayments())
			{
				Payment newPayment = payrepos.findById(payment.getPaymentid())
						.orElseThrow(() ->
								new EntityNotFoundException("Payment " + payment.getPaymentid() + " not found"));
				newOrder.getPayments().add(newPayment);
			}
			newCustomer.getOrders().add(newOrder);
		}
		
		return custrepos.save(newCustomer);
	}
	
	@Transactional
	@Override public void delete(long custcode)
	{
		custrepos.deleteById(custcode);
	}
	
	@Transactional
	@Override public Customer update(Customer customerPatch, long custcode)
	{
		Customer currCustomer = custrepos.findById(custcode)
				.orElseThrow(() -> new EntityNotFoundException("Customer " + custcode + " not found"));
		
		if (customerPatch.getCustname() != null)
			currCustomer.setCustname(customerPatch.getCustname());
		if (customerPatch.getCustcity() != null)
			currCustomer.setCustcity(customerPatch.getCustcity());
		if (customerPatch.getCustcountry() != null)
		{
			currCustomer.setCustcountry(customerPatch.getCustcountry());
		}
		if (customerPatch.getWorkingarea() != null)
		{
			currCustomer.setWorkingarea(customerPatch.getWorkingarea());
		}
		if (customerPatch.getPhone() != null)
		{
			currCustomer.setPhone(customerPatch.getPhone());
		}
		if (customerPatch.getGrade() != null)
		{
			currCustomer.setGrade(customerPatch.getGrade());
		}
		if (customerPatch.hasopeningamt)
		{
			currCustomer.setOpeningamt(customerPatch.getOpeningamt());
		}
		if (customerPatch.hasreceiveamt)
		{
			currCustomer.setReceiveamt(customerPatch.getReceiveamt());
		}
		if (customerPatch.haspaymentamt)
		{
			currCustomer.setPaymentamt(customerPatch.getPaymentamt());
		}
		if (customerPatch.hasoutstandingamt)
		{
			currCustomer.setOutstandingamt(customerPatch.getOutstandingamt());
		}
		if (customerPatch.getAgent() != null)
		{
			currCustomer.setAgent(customerPatch.getAgent());
		}
		
		if (customerPatch.getOrders().size() > 0)
		{
			currCustomer.getOrders().clear();
			for (Order order : customerPatch.getOrders())
			{
				Order newOrder = new Order(order.getOrdamount(), order.getAdvanceamount(),
						order.getOrderdescription(), currCustomer);
				for (Payment payment : order.getPayments())
				{
					Payment newPayment = payrepos.findById(payment.getPaymentid())
							.orElseThrow(() ->
									new EntityNotFoundException("Payment " + payment.getPaymentid() + " not found"));
					newOrder.getPayments().add(newPayment);
				}
				
				currCustomer.getOrders().add(newOrder);
			}
		}
		
		return custrepos.save(currCustomer);
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
