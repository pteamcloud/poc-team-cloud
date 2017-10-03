package org.ptc.platform.repository;

import java.util.Set;

import org.ptc.api.finance.dto.PtcTransaction;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FinanceOperations extends CrudRepository<PtcTransaction, Long> {
	
	Set<PtcTransaction> findAll();
	
}
