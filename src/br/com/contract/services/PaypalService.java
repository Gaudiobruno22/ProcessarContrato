package br.com.contract.services;

import br.com.contract.interfaces.OnlinePaymentService;

public class PaypalService implements OnlinePaymentService{

	public double paymentFee(double amount) {		
		return amount * 0.02 ;
	}
	
	public double interest(double amount, int months) {
		return amount * (months * 0.01);
	}
}