package com.lambdaschool.crudyorders.services;

import com.lambdaschool.crudyorders.models.Payment;

/**
 * The interface Payment services.
 */
public interface PaymentServices
{
	/**
	 * Save payment.
	 *
	 * @param payment the payment
	 * @return the payment
	 */
	Payment save(Payment payment);
}
