package org.ptc.api.finance.dto;

import java.util.Set;

public class Account {

	private Set<PtcTransaction> ptcTransaction ;

	public Set<PtcTransaction> getPtcTransaction() {
		return ptcTransaction;
	}

	public void setPtcTransaction(Set<PtcTransaction> ptcTransaction) {
		this.ptcTransaction = ptcTransaction;
	}
}
