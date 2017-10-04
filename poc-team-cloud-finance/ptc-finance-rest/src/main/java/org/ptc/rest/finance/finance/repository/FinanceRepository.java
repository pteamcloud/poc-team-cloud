package org.ptc.rest.finance.finance.repository;

import org.ptc.rest.finance.finance.entity.PtcTransaction;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FinanceRepository extends CrudRepository<PtcTransaction, Long> {

	PtcTransaction findById(Long name);

}
