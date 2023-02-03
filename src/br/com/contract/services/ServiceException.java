package br.com.contract.services;

public class ServiceException extends NullPointerException{
	
	private static final long serialVersionUID = 1L;
	
	public ServiceException(String msg) {
		super(msg);
		
	}

}
