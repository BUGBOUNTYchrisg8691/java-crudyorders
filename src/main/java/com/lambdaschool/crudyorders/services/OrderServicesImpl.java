package com.lambdaschool.crudyorders.services;

import com.lambdaschool.crudyorders.models.Order;
import com.lambdaschool.crudyorders.models.Payment;
import com.lambdaschool.crudyorders.repositories.OrderRepository;
import com.lambdaschool.crudyorders.repositories.PaymentRepository;
import com.lambdaschool.crudyorders.views.AdvanceAmounts;
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
	
	@Transactional
	@Override
	public Order save(Order order)
	{
		Order newOrder = new Order();
		
		if (order.getOrdnum() != 0)
		{
			ordrepos.findById(order.getOrdnum())
					.orElseThrow(() -> new EntityNotFoundException("Order " + order.getOrdnum() + " not found"));
			newOrder.setOrdnum(order.getOrdnum());
		}
		
		newOrder.setOrdamount(order.getOrdamount());
		newOrder.setAdvanceamount(order.getAdvanceamount());
		newOrder.setOrderdescription(order.getOrderdescription());
		newOrder.setCustomer(order.getCustomer());
		
		newOrder.getPayments().clear();
		for (Payment payment : order.getPayments())
		{
			Payment newPayment = payrepos.findById(payment.getPaymentid())
					.orElseThrow(() -> new EntityNotFoundException("Payment " + payment.getPaymentid() + " not found"));
			newOrder.getPayments().add(newPayment);
		}
		
		return ordrepos.save(newOrder);
	}
	
	@Transactional
	@Override public void delete(long ordnum)
	{
		ordrepos.deleteById(ordnum);
	}
	
	@Override
	public Order findOrderById(long ordnum)
	{
		
		return ordrepos.findById(ordnum).orElseThrow(() -> new EntityNotFoundException("Order " + ordnum + " not found"));
	}
	
	@Override
	public List<AdvanceAmounts> findOrdersByAdvanceAmt()
	{
		return ordrepos.findByAdvanceAmt();
	}
}
