package org.ptc.platform.rest.finance.controller;

import java.util.Arrays;
import java.util.List;

import javax.websocket.server.PathParam;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
public class FinanceController {

	private static final Logger LOGGER = LoggerFactory.getLogger(FinanceController.class);

	@GetMapping(path="/ptc/api/v0/finance-operations", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<String> getFinancesOperations() {
		
		LOGGER.info("get bucket of List of FinanceOpe");
		return Arrays.asList("cotis-boris-002-AAZ, cotis-Amed-000-xnbd, ...".split(","));
	}

	@GetMapping(path="ptc/api/v0/finance-operations/{finance-operationsId}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public String getFinanceOperationsById(@PathParam("finance-operationsId") Long financeOpeId) {
		
		LOGGER.info("get specific FinanceOpe by id");
		return "cotis-Amed-000-xnbd";
	}
	
}
