package org.ptc.platform.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import org.ptc.api.finance.dto.PtcTransaction;
import org.ptc.api.project.dto.PtcProject;
import org.ptc.api.user.dto.PtcUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

@Controller
public class PlatformController {

	private static final Logger LOGGER = LoggerFactory.getLogger(PlatformController.class);

	// Using default configuration
	private static final RestTemplate REST_TEMPLATE = new RestTemplate();

	@RequestMapping("/")
	public String welcome(Model model) {

		LOGGER.info(" === > Requesting PlatformController controller at root endpoint <===");

		// User Infos
		final ParameterizedTypeReference<List<PtcUser>> userResponseType = new ParameterizedTypeReference<List<PtcUser>>() {
		};
		ResponseEntity<List<PtcUser>> userEntity = null;
		try {
			userEntity = REST_TEMPLATE.exchange("http://localhost:8069/user", HttpMethod.GET, null, userResponseType);
			List<PtcUser> users = userEntity.getBody();
			final int lastIndex = users.size();
			if (checkIfListSizeIsMoreThanThree(users)) {
				users = (users).subList(lastIndex - 2, lastIndex);
			}
			model.addAttribute(users);
		} catch (Exception e) {
			LOGGER.info("Error during feetching users information from user.api", e);
		}

		// Project Infos
		final ParameterizedTypeReference<List<PtcProject>> projectResponseType = new ParameterizedTypeReference<List<PtcProject>>() {
		};
		ResponseEntity<List<PtcProject>> projectEntity = null;
		try {
			projectEntity = REST_TEMPLATE.exchange("http://localhost:8059/project", HttpMethod.GET, null,
					projectResponseType);
			List<PtcProject> projects = projectEntity.getBody();
			final int lastIndex = projects.size();
			if (checkIfListSizeIsMoreThanThree(projects)) {
				projects = projects.subList(lastIndex - 2, lastIndex);
			}
			model.addAttribute("ourProject", projects);
		} catch (Exception e) {
			LOGGER.info("Error during feetching project information from project.api", e);
		}

		// Finance Infos
		final ParameterizedTypeReference<List<PtcTransaction>> financeResponseType = new ParameterizedTypeReference<List<PtcTransaction>>() {
		};
		ResponseEntity<List<PtcTransaction>> financetEntity = null;
		try {
			financetEntity = REST_TEMPLATE.exchange("http://localhost:8079/finance", HttpMethod.GET, null,
					financeResponseType);
			List<PtcTransaction> finances = financetEntity.getBody();
			final int lastIndex = finances.size();
			if (checkIfListSizeIsMoreThanThree(finances)) {
				finances = finances.subList(lastIndex - 2, lastIndex);
			}
			model.addAttribute("ourfinance", finances);
		} catch (Exception e) {
			LOGGER.info("Error during feetching finance transaction from finance.api", e);
		}
		
		model.addAttribute("jumTitle", "Welcome to Poc-Team-Cloud [ P.T.C. ]");
		return "index";
	}

	@RequestMapping("/login-error")
	public String loginError(Model model) {
		model.addAttribute("loginError", true);
		return "login";
	}

	@RequestMapping(value = "/portfolio")
	public String getAPortfolio() {
		return "portfolio";
	}

	@RequestMapping(value = "/login")
	public String login() {
		return "login";
	}

	@RequestMapping("/aboutUs")
	public String aboutsUs(Model model) {
		
		model.addAttribute("jumTitle", "Everything about US!");
		return "aboutUs";
		
	}

	private <T> boolean checkIfListSizeIsMoreThanThree(List<T> proj2) {
		if (proj2 == null || ((List<T>) proj2).isEmpty() || ((List<T>) proj2).size() <= 1) {
			return false;
		}
		return true;
	}
}
