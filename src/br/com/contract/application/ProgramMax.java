package br.com.contract.application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import br.com.contract.services.CalculationService;
import br.com.contract.util.Product;

public class ProgramMax {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*******************************************************************************************
		*                               Programa para Estudos:						               *
		*  Lendo um Arquivo E verificando qual será o Maior valor Deste Produto lido pelo Arquivo. *
		*  Utilizando Conceito de Classes Generics - Comparable e Seu método CompareTo().          *
		********************************************************************************************/

		List<Product> list = new ArrayList<>();
		String caminho = "C:\\Users\\Bruno.Mattos\\Teste_Bruno\\Produtos.txt";
		
		//Lendo o Arquivo a Instânciando seu conteúdo para a Classe de produtos.
		try(BufferedReader br = new BufferedReader(new FileReader(caminho))){
			String linha = br.readLine();
			while(linha != null) {
				String[] registrosLinha = linha.split(",");
				list.add(new Product(registrosLinha[0], Double.parseDouble(registrosLinha[1])));
				linha = br.readLine();
			}
			Product a = CalculationService.max(list);
			System.out.println("Most Expensive: ");
			System.out.println(a);
			
			
		}catch(IOException e){
			System.out.println("Error Reading File : " + e.getMessage());
		}
	}

}
