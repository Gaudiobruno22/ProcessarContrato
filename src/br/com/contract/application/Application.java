package br.com.contract.application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import br.com.contract.services.ContractService;
import br.com.contract.util.Contract;
import br.com.contract.util.Installment;

public class Application {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		System.out.println("***PLANOS DE PARCELAS***");
		System.out.println();
		System.out.print("Entre os dados do contrato:");
		int numeroContrato = sc.nextInt();
		sc.nextLine();
		System.out.print("Data (DD/MM/YYYY):");
		LocalDate retirada = LocalDate.parse(sc.nextLine(), dtf);
		System.out.print("Valor do contrato:");
		double valorTotal = sc.nextDouble();
		
		Contract contrato = new Contract(numeroContrato, retirada, valorTotal);
		
		System.out.print("Entre com o numero de parcelas:");
		int parcela = sc.nextInt();
		
		ContractService service = new ContractService(contrato, parcela);
		service.processContract(contrato, parcela);
		
		System.out.println("Parcelas:");
		
		for(Installment installment : contrato.getInstallment()) {
			System.out.println(installment);
		}
		
		sc.close();

	}

}
