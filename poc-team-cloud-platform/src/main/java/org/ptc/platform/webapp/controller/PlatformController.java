package org.ptc.platform.webapp.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PlatformController {

	private static final Logger LOGGER = LoggerFactory.getLogger(PlatformController.class);

	@RequestMapping("/accueil")
	public String welcome(Model model) {

		LOGGER.info(" === > Requesting PlatformController controller at root endpoint <===");
		
		model.addAttribute("jumTitle", "Welcome to Poc-Team-Cloud [ P.T.C. ]");
		
		return "index";
	}

	@RequestMapping("/login-error")
	public String loginError(Model model) {
		
		model.addAttribute("loginError", true);
		
		return "login";
	}


	@RequestMapping("/aboutUs")
	public String aboutsUs(Model model) {
		
		model.addAttribute("jumTitle", "Everything about US!");
		
		return "aboutUs";
	}
	
}
