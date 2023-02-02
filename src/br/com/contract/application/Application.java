package br.com.contract.application;

import br.com.contract.services.PaypalService;

public class Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		PaypalService service = new PaypalService();
		
		System.out.println(service.paymentFee(202));

	}

}
