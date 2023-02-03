package br.com.contract.services;

import java.text.SimpleDateFormat;
import java.time.LocalDate;

import br.com.contract.interfaces.OnlinePaymentService;
import br.com.contract.util.Contract;
import br.com.contract.util.Installment;

public class ContractService implements OnlinePaymentService{
	
	public static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	private OnlinePaymentService paymentService;
	private Contract contracts;
	private int months;
	
	public ContractService(Contract contract, int months) {
		this.contracts = contract;
		this.paymentService = paymentService;
		this.months = months;
	}
	
	@Override
	public double paymentFee(double amount) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double interest(double amount, int months) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public void processContract(Contract contracts, int months) {
		
		double cota = contracts.getTotalValue() / months;
		
		for (int i=1; i <= months; i++) {
			
			LocalDate dataInicial = contracts.getDate().plusMonths(i);
			
			PaypalService service = new PaypalService();
			double interest = service.interest(cota, i);		
			double juros =  service.paymentFee(cota + interest);
			double valorLiquido = cota  + interest + juros;
			
			contracts.addInstallment(new Installment(dataInicial, valorLiquido));
			
			/*if (contracts.getnumber() == 0){
				throw new ServiceException("O Número do Contrato não pode ser Zero.");
			}
			
			if(contracts.getTotalValue() <= 0) {
				throw new ServiceException("O valor do Contrato não pode Ser Zero.");
			}*/
		}			 
	}	
}
