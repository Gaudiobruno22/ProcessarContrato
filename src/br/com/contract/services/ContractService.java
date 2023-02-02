package br.com.contract.services;

import java.text.SimpleDateFormat;
import java.time.LocalDate;

import br.com.contract.interfaces.OnlinePaymentService;
import br.com.contract.util.Contract;
import br.com.contract.util.Installment;

public class ContractService {
	
	public static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	private OnlinePaymentService paymentService;
	
	public ContractService(OnlinePaymentService paymentService) {
		this.paymentService = paymentService;
	}
	
	public void processContract(Contract contracts, int months) {
		
		double cota = contracts.getTotalValue() / months;
		
		for (int i=0; i <= months; i++) {
			
			LocalDate dataInicial = contracts.getDate().plusMonths(i);
			
			PaypalService service = new PaypalService();
			double interest = service.interest(cota, i);		
			double juros = service.paymentFee(interest) + cota;
			double valorLiquido = cota + interest + juros;
			
			contracts.addInstallment(new Installment(dataInicial, valorLiquido));
		}
		
		
		
		 
	}
	
}
