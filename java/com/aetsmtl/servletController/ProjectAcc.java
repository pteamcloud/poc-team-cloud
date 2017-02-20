package com.aetsmtl.servletController;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProjectAcc {
	
	@RequestMapping(value="/accueil")
	public String accueil(Model model){
		System.out.println("Making sure that we pass by this way accueil");
		
		return "accueil";
	}
	
	@RequestMapping(value="/")
	public String indexConnexion(Model model){
		System.out.println("Making sure that we pass by this way index");
		
		return "index";
	}
	
	@RequestMapping(value="/projects")
	public String getProject(Model model){
		System.out.println("Making sure that we pass by this ways projects");
		
		return "project";
	}
}
