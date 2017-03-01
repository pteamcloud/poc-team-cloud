package com.aetsmtl.ptc.servletControllerPocTeamCloud;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aetsmtl.ptc.PtcApplication;
import com.aetsmtl.ptc.beanPocTeamCloud.Project;
import com.aetsmtl.ptc.modelPocTeamCloud.ProjectDAO;


@Controller
public class ProjectAcc{
	
	@Autowired
	private ProjectDAO pDAO;
	
	private static final Logger logController = LoggerFactory.getLogger(ProjectAcc.class);
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
		logController.info("Making sure that we pass by this way index at / LOgger");
		System.out.println("Making sure that we pass by this way index at /");
		
		logController.info("Démarrage de la creation de projet / LOgger");
		
//		pDAO.saveProject(new Project("project UNO", "Je decris le premier project"));
//		pDAO.saveProject(new Project("project DOCE", "Je decris le premier project"));
//		pDAO.saveProject(new Project("project TRECE", "Je decris le premier project"));
//		pDAO.saveProject(new Project("project QUATRO", "Je decris le premier project"));
//		pDAO.saveProject(new Project("project CINQO", "Je decris le premier project"));

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
		
        logController.info("Récupération d'un des projets / LOgger");
//        logController.info(pDAO.findProjectX(3).toString());
		
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
