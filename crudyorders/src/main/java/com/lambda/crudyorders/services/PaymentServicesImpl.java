package com.lambda.crudyorders.services;

import com.lambda.crudyorders.models.Payment;
import com.lambda.crudyorders.repositories.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * The type Payment services.
 */
@Service(value = "paymentServices")
public class PaymentServicesImpl implements PaymentServices
{
	/**
	 * The Payrepos.
	 */
	@Autowired
	PaymentRepository payrepos;
	
	@Override public Payment save(Payment payment)
	{
		return payrepos.save(payment);
	}
}
