package org.ptc.platform.controller.finance;

import java.util.Comparator;
import java.util.Date;
import java.util.List;

import org.ptc.platform.bean.Account;
import org.ptc.platform.bean.Operation;
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

		List<Operation> lOperation = financeOps.findAllOfOperations();
		
		Account aState = new Account();
		
		double solde = lOperation.stream().filter(o -> Double.valueOf(o.getAmount()) != null)
				.mapToDouble(o -> o.getAmount()).sum();
		Date rdate = lOperation.stream().map(o -> o.getDate()).max(Date::compareTo).get();
		Operation lastOperation = lOperation.stream()
				// .peek(num -> System.out.println("will filter " + num))
				.filter(o -> o.getDate().equals(rdate)).findFirst().get();
		
		aState.setNumTransaction(lOperation.size());
		aState.setSolde(solde);
		aState.setOp(lastOperation);

		model.addAttribute("ptcFinSolde",aState);
		model.addAttribute("ptcFinOps", lOperation);
		model.addAttribute("jumTitle", "FINANCES");

		return "finance-view";
	}

}
