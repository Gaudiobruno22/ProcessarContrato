package br.com.contract.application;

import java.util.HashSet;
import java.util.Set;

import br.com.contract.util.Product;

public class ProgramTest {

	public static void main(String[] args) {
		
		Set<Product> set = new HashSet<>();
		set.add(new Product("TV", 900.0));
		set.add(new Product("Notebook", 1200.0));
		set.add(new Product("Tablet", 400.0));
		
		Product prod = new Product("Notebook", 1200.0);
		System.out.println(set.contains(prod));
	}
}
