package org.ptc.platform.webapp.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class PlatformController {

	private static final Logger LOGGER = LoggerFactory.getLogger(PlatformController.class);


	@GetMapping("/")
    public String redirectWithUsingRedirectView(RedirectAttributes attributes) {
        return "redirect:/welcome-friend";
    }
	
	@RequestMapping("/welcome-friend")
	public String getWelcome(Model model) {

		LOGGER.info(" === > Requesting PlatformController controller at root endpoint <===");
		
		model.addAttribute("jumTitle", "Welcome to Poc-Team-Cloud [ P.T.C. ]");
		
		return "index";
	}

//	@RequestMapping("/login-error")
//	public String loginError(Model model) {
//		
//		model.addAttribute("loginError", true);
//		
//		return "login";
//	}


	@RequestMapping("/aboutUs")
	public String aboutsUs(Model model) {
		
		model.addAttribute("jumTitle", "Everything about US!");
		
		return "aboutUs";
	}
	
}
