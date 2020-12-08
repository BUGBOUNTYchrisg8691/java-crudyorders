package com.lambda.crudyorders.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * The type Agent.
 */
@Entity
@Table(name = "agents")
public class Agent
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long agentcode;
	
	private String agentname;
	private String workingarea;
	private double commission;
	private String phone;
	private String country;
	
	@OneToMany(mappedBy = "agent", cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonIgnoreProperties(value = "agent", allowSetters = true)
	private List<Customer> customers = new ArrayList<>();
	
	/**
	 * Instantiates a new Agent.
	 */
	public Agent()
	{
	}
	
	/**
	 * Instantiates a new Agent.
	 *
	 * @param agentname   the agentname
	 * @param workingarea the workingarea
	 * @param commission  the commission
	 * @param phone       the phone
	 * @param country     the country
	 */
	public Agent(String agentname, String workingarea, double commission, String phone, String country)
	{
		this.agentname = agentname;
		this.workingarea = workingarea;
		this.commission = commission;
		this.phone = phone;
		this.country = country;
	}
	
	/**
	 * Gets agentcode.
	 *
	 * @return the agentcode
	 */
	public long getAgentcode()
	{
		return agentcode;
	}
	
	/**
	 * Sets agentcode.
	 *
	 * @param agentcode the agentcode
	 */
	public void setAgentcode(long agentcode)
	{
		this.agentcode = agentcode;
	}
	
	/**
	 * Gets agentname.
	 *
	 * @return the agentname
	 */
	public String getAgentname()
	{
		return agentname;
	}
	
	/**
	 * Sets agentname.
	 *
	 * @param agentname the agentname
	 */
	public void setAgentname(String agentname)
	{
		this.agentname = agentname;
	}
	
	/**
	 * Gets workingarea.
	 *
	 * @return the workingarea
	 */
	public String getWorkingarea()
	{
		return workingarea;
	}
	
	/**
	 * Sets workingarea.
	 *
	 * @param workingarea the workingarea
	 */
	public void setWorkingarea(String workingarea)
	{
		this.workingarea = workingarea;
	}
	
	/**
	 * Gets commission.
	 *
	 * @return the commission
	 */
	public double getCommission()
	{
		return commission;
	}
	
	/**
	 * Sets commission.
	 *
	 * @param commission the commission
	 */
	public void setCommission(double commission)
	{
		this.commission = commission;
	}
	
	/**
	 * Gets phone.
	 *
	 * @return the phone
	 */
	public String getPhone()
	{
		return phone;
	}
	
	/**
	 * Sets phone.
	 *
	 * @param phone the phone
	 */
	public void setPhone(String phone)
	{
		this.phone = phone;
	}
	
	/**
	 * Gets country.
	 *
	 * @return the country
	 */
	public String getCountry()
	{
		return country;
	}
	
	/**
	 * Sets country.
	 *
	 * @param country the country
	 */
	public void setCountry(String country)
	{
		this.country = country;
	}
	
	/**
	 * Gets customer.
	 *
	 * @return the customer
	 */
	public List<Customer> getCustomers()
	{
		return customers;
	}
	
	/**
	 * Sets customers.
	 *
	 * @param customers the customers
	 */
	public void setCustomers(List<Customer> customers)
	{
		this.customers = customers;
	}
}
