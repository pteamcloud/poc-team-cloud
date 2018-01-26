package org.ptc.platform.rest.finance.repository;

import org.ptc.platform.rest.finance.entity.PtcTransaction;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FinanceOperationRepository extends CrudRepository<PtcTransaction, Long> {
}

