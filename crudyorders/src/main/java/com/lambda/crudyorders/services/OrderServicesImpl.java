package com.lambda.crudyorders.services;

import com.lambda.crudyorders.models.Order;
import com.lambda.crudyorders.repositories.OrderRepository;
import com.lambda.crudyorders.views.AdvanceAmounts;
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
	
	@Transactional
	@Override
	public Order save(Order order)
	{
		return ordrepos.save(order);
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
