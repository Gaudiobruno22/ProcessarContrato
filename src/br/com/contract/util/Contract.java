package br.com.contract.util;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.com.contract.services.ServiceException;

public class Contract {
	
	private Integer number;
	private LocalDate date;
	private Double totalValue;

	private List<Installment> installments = new ArrayList<>();

	public Contract(Integer number, LocalDate date, Double totalValue) {
		this.number = number;
		this.date = date;
		this.totalValue = totalValue;
		if(number == null || date == null || totalValue == null) {
			throw new ServiceException("Os valores de Defini??o de COntrato n?o pode ser Nulo.");
		}
	}

	public Integer getnumber() {
		return number;
	}

	public void setnumber(Integer number) {
		this.number = number;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public Double getTotalValue() {
		return totalValue;
	}

	public void setTotalValue(Double totalValue) {
		this.totalValue = totalValue;
	}

	public List<Installment> getInstallment() {
		return installments;
	}
	
	public void addInstallment(Installment installment) {
		installments.add(installment);
	}
	
	public void removeInstallment(Installment installment) {
		installments.remove(installment);
	}
	
}
