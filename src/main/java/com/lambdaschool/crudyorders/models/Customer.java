package com.lambdaschool.crudyorders.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * The type Customer.
 */
@Entity
@Table(name = "customers")
@JsonIgnoreProperties(value = {"hasopeningamt", "hasreceiveamt", "haspaymentamt", "hasoutstandingamt"})
public class Customer
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long custcode;
	
	@Column(nullable = false)
	private String custname;
	
	private String custcountry;
	private String custcity;
	private String workingarea;
	private String grade;
	private String phone;
	
	@Transient
	public boolean hasopeningamt = false;
	private double openingamt;
	
	@Transient
	public boolean hasreceiveamt = false;
	private double receiveamt;
	
	@Transient
	public boolean haspaymentamt = false;
	private double paymentamt;
	
	@Transient
	public boolean hasoutstandingamt = false;
	private double outstandingamt;
	
	@ManyToOne
	@JoinColumn(name = "agentcode", nullable = false)
	@JsonIgnoreProperties(value = "customers", allowSetters = true)
	private Agent agent;
	
	@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonIgnoreProperties(value = "customer", allowSetters = true)
	private List<Order> orders = new ArrayList<>();
	
	/**
	 * Instantiates a new Customer.
	 */
	public Customer()
	{
	}
	
	/**
	 * Instantiates a new Customer.
	 *
	 * @param custname       the custname
	 * @param custcountry    the custcountry
	 * @param custcity       the custcity
	 * @param workingarea    the workingarea
	 * @param grade          the grade
	 * @param openingamt     the openingamt
	 * @param receiveamt     the receiveamt
	 * @param paymentamt     the paymentamt
	 * @param outstandingamt the outstandingamt
	 * @param phone          the phone
	 * @param agent          the agent
	 */
	public Customer(String custname, String custcountry, String custcity, String workingarea, String grade,
	                double openingamt, double receiveamt, double paymentamt, double outstandingamt, String phone,
	                Agent agent)
	{
		this.custname = custname;
		this.custcountry = custcountry;
		this.custcity = custcity;
		this.workingarea = workingarea;
		this.grade = grade;
		this.openingamt = openingamt;
		this.receiveamt = receiveamt;
		this.paymentamt = paymentamt;
		this.outstandingamt = outstandingamt;
		this.phone = phone;
		this.agent = agent;
	}
	
	/**
	 * Gets custcode.
	 *
	 * @return the custcode
	 */
	public long getCustcode()
	{
		return custcode;
	}
	
	/**
	 * Sets custcode.
	 *
	 * @param custcode the custcode
	 */
	public void setCustcode(long custcode)
	{
		this.custcode = custcode;
	}
	
	/**
	 * Gets custname.
	 *
	 * @return the custname
	 */
	public String getCustname()
	{
		return custname;
	}
	
	/**
	 * Sets custname.
	 *
	 * @param custname the custname
	 */
	public void setCustname(String custname)
	{
		this.custname = custname;
	}
	
	/**
	 * Gets custcountry.
	 *
	 * @return the custcountry
	 */
	public String getCustcountry()
	{
		return custcountry;
	}
	
	/**
	 * Sets custcountry.
	 *
	 * @param custcountry the custcountry
	 */
	public void setCustcountry(String custcountry)
	{
		this.custcountry = custcountry;
	}
	
	/**
	 * Gets custcity.
	 *
	 * @return the custcity
	 */
	public String getCustcity()
	{
		return custcity;
	}
	
	/**
	 * Sets custcity.
	 *
	 * @param custcity the custcity
	 */
	public void setCustcity(String custcity)
	{
		this.custcity = custcity;
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
	 * Gets grade.
	 *
	 * @return the grade
	 */
	public String getGrade()
	{
		return grade;
	}
	
	/**
	 * Sets grade.
	 *
	 * @param grade the grade
	 */
	public void setGrade(String grade)
	{
		this.grade = grade;
	}
	
	/**
	 * Gets openingamt.
	 *
	 * @return the openingamt
	 */
	public double getOpeningamt()
	{
		return openingamt;
	}
	
	/**
	 * Sets openingamt.
	 *
	 * @param openingamt the openingamt
	 */
	public void setOpeningamt(double openingamt)
	{
		hasopeningamt = true;
		this.openingamt = openingamt;
	}
	
	/**
	 * Gets receiveamt.
	 *
	 * @return the receiveamt
	 */
	public double getReceiveamt()
	{
		return receiveamt;
	}
	
	/**
	 * Sets receiveamt.
	 *
	 * @param receiveamt the receiveamt
	 */
	public void setReceiveamt(double receiveamt)
	{
		hasreceiveamt = true;
		this.receiveamt = receiveamt;
	}
	
	/**
	 * Gets paymentamt.
	 *
	 * @return the paymentamt
	 */
	public double getPaymentamt()
	{
		return paymentamt;
	}
	
	/**
	 * Sets paymentamt.
	 *
	 * @param paymentamt the paymentamt
	 */
	public void setPaymentamt(double paymentamt)
	{
		haspaymentamt = true;
		this.paymentamt = paymentamt;
	}
	
	/**
	 * Gets outstandingamt.
	 *
	 * @return the outstandingamt
	 */
	public double getOutstandingamt()
	{
		return outstandingamt;
	}
	
	/**
	 * Sets outstandingamt.
	 *
	 * @param outstandingamt the outstandingamt
	 */
	public void setOutstandingamt(double outstandingamt)
	{
		hasoutstandingamt = true;
		this.outstandingamt = outstandingamt;
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
	 * Gets agent.
	 *
	 * @return the agent
	 */
	public Agent getAgent()
	{
		return agent;
	}
	
	/**
	 * Sets agent.
	 *
	 * @param agent the agent
	 */
	public void setAgent(Agent agent)
	{
		this.agent = agent;
	}
	
	/**
	 * Gets orders.
	 *
	 * @return the orders
	 */
	public List<Order> getOrders()
	{
		return orders;
	}
	
	/**
	 * Sets orders.
	 *
	 * @param orders the orders
	 */
	public void setOrders(List<Order> orders)
	{
		this.orders = orders;
	}
}
