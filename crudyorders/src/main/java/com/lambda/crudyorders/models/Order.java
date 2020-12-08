package com.lambda.crudyorders.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * The type Order.
 */
@Entity
@Table(name = "orders")
public class Order
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long ordnum;
	
	@ManyToOne
	@JoinColumn(name = "custcode", nullable = false)
	@JsonIgnoreProperties(value = {"orders", "agent"}, allowSetters = true)
	private Customer customer;
	
	@ManyToMany
	@JoinTable(name = "orderspayments", joinColumns = @JoinColumn(name = "ordnum"), inverseJoinColumns =
	@JoinColumn(name = "paymentid"))
	@JsonIgnoreProperties(value = "orders", allowSetters = true)
	private Set<Payment> payments = new HashSet<>();
	
	private double ordamount;
	private double advanceamt;
	private String orderdescription;
	
	/**
	 * Instantiates a new Order.
	 */
	public Order()
	{
	}
	
	/**
	 * Instantiates a new Order.
	 *
	 * @param ordamount        the ordamount
	 * @param advanceamt       the advanceamt
	 * @param orderdescription the orderdescription
	 * @param customer         the customer
	 */
	public Order(double ordamount, double advanceamt, String orderdescription, Customer customer)
	{
		this.customer = customer;
		this.ordamount = ordamount;
		this.advanceamt = advanceamt;
		this.orderdescription = orderdescription;
	}
	
	/**
	 * Gets ordnum.
	 *
	 * @return the ordnum
	 */
	public long getOrdnum()
	{
		return ordnum;
	}
	
	/**
	 * Sets ordnum.
	 *
	 * @param ordnum the ordnum
	 */
	public void setOrdnum(long ordnum)
	{
		this.ordnum = ordnum;
	}
	
	/**
	 * Gets customer.
	 *
	 * @return the customer
	 */
	public Customer getCustomer()
	{
		return customer;
	}
	
	/**
	 * Sets customer.
	 *
	 * @param customer the customer
	 */
	public void setCustomer(Customer customer)
	{
		this.customer = customer;
	}
	
	/**
	 * Gets payments.
	 *
	 * @return the payments
	 */
	public Set<Payment> getPayments()
	{
		return payments;
	}
	
	/**
	 * Sets payments.
	 *
	 * @param payments the payments
	 */
	public void setPayments(Set<Payment> payments)
	{
		this.payments = payments;
	}
	
	/**
	 * Gets ordamount.
	 *
	 * @return the ordamount
	 */
	public double getOrdamount()
	{
		return ordamount;
	}
	
	/**
	 * Sets ordamount.
	 *
	 * @param ordamount the ordamount
	 */
	public void setOrdamount(double ordamount)
	{
		this.ordamount = ordamount;
	}
	
	/**
	 * Gets advanceamt.
	 *
	 * @return the advanceamt
	 */
	public double getAdvanceamt()
	{
		return advanceamt;
	}
	
	/**
	 * Sets advanceamt.
	 *
	 * @param advanceamt the advanceamt
	 */
	public void setAdvanceamt(double advanceamt)
	{
		this.advanceamt = advanceamt;
	}
	
	/**
	 * Gets orderdescription.
	 *
	 * @return the orderdescription
	 */
	public String getOrderdescription()
	{
		return orderdescription;
	}
	
	/**
	 * Sets orderdescription.
	 *
	 * @param orderdescription the orderdescription
	 */
	public void setOrderdescription(String orderdescription)
	{
		this.orderdescription = orderdescription;
	}
}
