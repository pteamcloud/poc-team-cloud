package org.ptc.platform.controller;

import java.util.Date;
import java.util.Set;

import org.ptc.api.finance.dto.Account;
import org.ptc.api.finance.dto.PtcTransaction;
import org.ptc.platform.repository.FinanceOperations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("finances")
public class FinanceController {

	@Autowired
	private FinanceOperations financeOps;

	@RequestMapping
	public String getFinances(Model model) {

		Set<PtcTransaction> lOperation = financeOps.findAll();
		
		Account aState = new Account();
		
		double solde = lOperation.stream().filter(o -> Double.valueOf(o.getAmount()) != null)
				.mapToDouble(o -> o.getAmount()).sum();
		Date rdate = lOperation.stream().map(o -> o.getDate()).max(Date::compareTo).get();
		PtcTransaction lastOperation = lOperation.stream()
				// .peek(num -> System.out.println("will filter " + num))
				.filter(o -> o.getDate().equals(rdate)).findFirst().get();
	
		model.addAttribute("ptcFinSolde", aState);
		model.addAttribute("ptcFinOps", lOperation);
		model.addAttribute("jumTitle", "FINANCES");

		return "finance-view";
	}

}
