package com.aetsmtl.ptc.servletControllerPocTeamCloud;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Controller
public class ProjectAcc{
	
	private static final String PATH = "/error";
	
	@Value("${qui.n: Aetsmtl}")
	private String qui;
	
//	public String getErrorPath() {
//		// TODO Auto-generated method stub
//		return PATH;
//	}
//	
//    @RequestMapping(value = PATH)
//    public String error() {
//        return "errorHandling";
//    }
	
	@RequestMapping("/")
	public String indexConnexion(){
		System.out.println("Making sure that we pass by this way index at /");

		return "index";
	}
	
	@RequestMapping(value="accueil")
	public String accueil(Model model){
		System.out.println("Making sure that we pass by this way accueil" + qui);
		
		return "accueil";
	}
	
	@RequestMapping("projects")
	public String getProject(Model model){
		System.out.println("Making sure that we pass by this ways projects /projects");
		
		return "projects";
	}
	
	@RequestMapping(value="members")
	public String getMembers(Model model){
		System.out.println("Making sure that we pass by this ways members /members");
	
		return "members";
	}
	
	@RequestMapping("members/aymard")
	public String getAymardInf(){
		System.out.println("Making sure that we pass by this way index at AymardInf");
		//model.addAttribute("time", new Date());
		return "aymard";
	}
}
