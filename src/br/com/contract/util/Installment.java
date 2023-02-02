package br.com.contract.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Installment {

	private LocalDate dueDate;
	private Double amount;
	
	private DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	public Installment(LocalDate dueDate, Double amount) {
		this.dueDate = dueDate;
		this.amount = amount;
	}

	public LocalDate getDueDate() {
		return dueDate;
	}

	public void setDueDate(LocalDate dueDate) {
		this.dueDate = dueDate;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return  dtf.format(dueDate) + " - R$" + String.format("%.2f", amount);
	}
	
	
}
