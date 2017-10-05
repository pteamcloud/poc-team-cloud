package org.ptc.rest.finance.controller;

import org.ptc.rest.finance.entity.PtcTransaction;
import org.ptc.rest.finance.repository.FinanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("finance")
public class FinanceController {

	@Autowired
	FinanceRepository financeRepositoy;

	@RequestMapping(method = RequestMethod.GET, produces = "application/json; charset=UTF-8")
	public Iterable<PtcTransaction> getAllPtcTransaction() {

		return financeRepositoy.findAll();

	}

	@RequestMapping(method = RequestMethod.GET, produces = "application/json; charset=UTF-8", value = "{transactionId}")
	public PtcTransaction getPtcTransactionById(@PathVariable("transactionId") Long transactionId) {

		return financeRepositoy.findById(transactionId);

	}

}
