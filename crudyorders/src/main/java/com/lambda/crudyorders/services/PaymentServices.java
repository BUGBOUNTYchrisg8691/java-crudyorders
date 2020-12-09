package com.lambda.crudyorders.services;

import com.lambda.crudyorders.models.Payment;

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
