package com.lambda.crudyorders.services;

import com.lambda.crudyorders.models.Order;
import com.lambda.crudyorders.models.Payment;
import com.lambda.crudyorders.repositories.OrderRepository;
import com.lambda.crudyorders.repositories.PaymentRepository;
import com.lambda.crudyorders.views.AdvanceAmount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;

/**
 * The type Order services.
 */
@Transactional
@Service(value = "orderServices")
public class OrderServicesImpl implements OrderServices
{
	/**
	 * The Ordrepos.
	 */
	@Autowired
	OrderRepository ordrepos;
	
	@Autowired
	PaymentRepository payrepos;
	
	@Override public Order findOrderById(long id)
	{
		return ordrepos.findById(id).orElseThrow(() -> new EntityNotFoundException("Order " + id + " not found"));
	}
	
	@Override public List<AdvanceAmount> findOrdersByAdvanceAmount()
	{
		return ordrepos.findAdvanceAmounts();
	}
	
	@Transactional
	@Override public Order save(Order order)
	{
		Order newOrder = new Order();
		
		if (order.getOrdnum() != 0)
		{
			ordrepos.findById(order.getOrdnum()).orElseThrow(() ->
					new EntityNotFoundException("Order " + order.getOrdnum() + " not found"));
			
			newOrder.setOrdnum(order.getOrdnum());
		}
		
		newOrder.setAdvanceamt(order.getAdvanceamt());
		newOrder.setOrdamount(order.getOrdamount());
		newOrder.setOrderdescription(order.getOrderdescription());
		newOrder.setCustomer(order.getCustomer());
		
		for (Payment payment : order.getPayments())
		{
			Payment newPay = payrepos.findById(payment.getPaymentid()).orElseThrow(() -> new EntityNotFoundException(
					"Payment " + payment.getPaymentid() + " not found"));
			
			newOrder.getPayments().add(newPay);
		}
		
		return ordrepos.save(newOrder);
	}
	
	@Transactional
	@Override public void delete(long id)
	{
		if (ordrepos.findById(id).isPresent())
		{
			ordrepos.deleteById(id);
		}
		else
		{
			throw new EntityNotFoundException("Order " + id + " not found");
		}
	}
	
	@Transactional
	@Override public void deleteAllOrders()
	{
		ordrepos.deleteAll();
	}
	
	@Transactional
	@Override public Order update(Order order, long id)
	{
		return new Order();
	}
}
