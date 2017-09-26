package org.ptc.platform.repository;

import java.util.List;

import org.ptc.platform.bean.Operation;

public interface FinanceOperations {

	List<Operation> findAllOfOperations();
}
