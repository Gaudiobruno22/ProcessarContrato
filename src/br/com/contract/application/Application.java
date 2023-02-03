package br.com.contract.application;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import br.com.contract.services.ContractService;
import br.com.contract.services.ServiceException;
import br.com.contract.util.Contract;
import br.com.contract.util.Installment;

public class Application {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		Contract contrato;
		LocalDate retirada;
		
		try {
			System.out.println("***PLANOS DE PARCELAS***");
			System.out.println();
			System.out.print("Entre os dados do contrato:");
			int numeroContrato = sc.nextInt();
			while(numeroContrato == 0) {
				System.out.println("O Número do Contrato não pode ser 0. Tente Novamente.");
				System.out.print("Entre os dados do contrato:");
				numeroContrato = sc.nextInt();
			}
			sc.nextLine();
			System.out.print("Data (DD/MM/YYYY):");
			retirada = LocalDate.parse(sc.nextLine(), dtf);
			
			System.out.print("Valor do contrato:");
			double valorTotal = sc.nextDouble();
			
			contrato = new Contract(numeroContrato, retirada, valorTotal);
			System.out.print("Entre com o numero de parcelas:");
			int parcela = sc.nextInt();
			
			ContractService service = new ContractService(contrato, parcela);
			service.processContract(contrato, parcela);
			
			System.out.println("Parcelas:");
			
			for(Installment installment : contrato.getInstallment()) {
				System.out.println(installment);
			}
		}
		catch(ServiceException e) {
			System.out.println("Erro Ao Gerar Contrato: " + e.getMessage());
		}
		catch(DateTimeException e) {
			System.out.println("Erro: A data não pode Ser nula.");
		}

		
		sc.close();

	}

}
