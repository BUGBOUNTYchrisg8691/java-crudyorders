package com.lambdaschool.crudyorders.models;

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
	
	private double ordamount;
	private double advanceamount;
	private String orderdescription;
	
	@ManyToOne
	@JoinColumn(name = "custcode", nullable = false)
	@JsonIgnoreProperties(value = {"agent", "orders"}, allowSetters = true)
	private Customer customer;
	
	@ManyToMany
	@JoinTable(name = "orderspayments", joinColumns = @JoinColumn(name = "ordnum"), inverseJoinColumns =
	@JoinColumn(name = "paymentid"))
	@JsonIgnoreProperties(value = "orders", allowSetters = true)
	private Set<Payment> payments = new HashSet<>();
	
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
	 * @param advanceamount    the advanceamount
	 * @param orderdescription the orderdescription
	 * @param customer         the customer
	 */
	public Order(double ordamount, double advanceamount, String orderdescription, Customer customer)
	{
		this.ordamount = ordamount;
		this.advanceamount = advanceamount;
		this.orderdescription = orderdescription;
		this.customer = customer;
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
	 * Gets advanceamount.
	 *
	 * @return the advanceamount
	 */
	public double getAdvanceamount()
	{
		return advanceamount;
	}
	
	/**
	 * Sets advanceamount.
	 *
	 * @param advanceamount the advanceamount
	 */
	public void setAdvanceamount(double advanceamount)
	{
		this.advanceamount = advanceamount;
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
}
