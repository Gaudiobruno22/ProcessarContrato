package br.com.contract.util;

import java.util.Objects;

public class Product implements Comparable <Product>{

	private String name;
	private Double price;
	
	public Product(String name, Double price) {
		this.name = name;
		this.price = price;
	}
	
	public Product(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		System.out.println("Product Info:");
		return "Name: " 
				+ name 
				+ ", Price: " 
				+ String.format("%.2f", price);
	}

	@Override
	public int compareTo(Product other) {
		return price.compareTo(other.getPrice());
	}

	//HashCode e Equals - Utilizando Conceito de Set.
	@Override
	public int hashCode() {
		return Objects.hash(name, price);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		return Objects.equals(name, other.name) && Objects.equals(price, other.price);
	}
	
	
	
}