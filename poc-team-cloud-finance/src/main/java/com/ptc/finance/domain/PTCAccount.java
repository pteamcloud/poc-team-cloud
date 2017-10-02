package com.ptc.finance.domain;

import java.util.List;

public class PTCAccount {

	private List <Contribution> aLContribution ;
	private double solde ;
	
	public List<Contribution> getALContribution() {
		return aLContribution;
	}
	
	public double getSolde() {
		
		solde = 0.0;
		aLContribution.stream().forEach( s -> {solde = s.getAmount() + solde;});
		return solde ;
	}
	
	public boolean getStatus() {
		
		return solde >  0 ? true :  false ;
	}
}
