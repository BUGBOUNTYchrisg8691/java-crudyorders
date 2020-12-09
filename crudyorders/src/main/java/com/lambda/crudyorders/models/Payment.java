package com.lambda.crudyorders.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * The type Payment.
 */
@Entity
@Table(name = "payments")
public class Payment
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long paymentid;
	
	@Column(nullable = false)
	private String type;
	
	@ManyToMany(mappedBy = "payments")
	@JsonIgnoreProperties(value = "payments", allowSetters = true)
	private Set<Order> orders = new HashSet<>();
	
	/**
	 * Instantiates a new Payment.
	 */
	public Payment()
	{
	}
	
	/**
	 * Instantiates a new Payment.
	 *
	 * @param type the type
	 */
	public Payment(String type)
	{
		this.type = type;
	}
	
	/**
	 * Gets paymentid.
	 *
	 * @return the paymentid
	 */
	public long getPaymentid()
	{
		return paymentid;
	}
	
	/**
	 * Sets paymentid.
	 *
	 * @param paymentid the paymentid
	 */
	public void setPaymentid(long paymentid)
	{
		this.paymentid = paymentid;
	}
	
	/**
	 * Gets type.
	 *
	 * @return the type
	 */
	public String getType()
	{
		return type;
	}
	
	/**
	 * Sets type.
	 *
	 * @param type the type
	 */
	public void setType(String type)
	{
		this.type = type;
	}
	
	/**
	 * Gets orders.
	 *
	 * @return the orders
	 */
	public Set<Order> getOrders()
	{
		return orders;
	}
	
	/**
	 * Sets orders.
	 *
	 * @param orders the orders
	 */
	public void setOrders(Set<Order> orders)
	{
		this.orders = orders;
	}
}
