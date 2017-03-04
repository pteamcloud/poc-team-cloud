package com.aetsmtl.ptc.servletControllerPocTeamCloud;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.aetsmtl.ptc.beanPocTeamCloud.Member;
import com.aetsmtl.ptc.beanPocTeamCloud.Project;
import com.aetsmtl.ptc.modelPocTeamCloud.MemberDAO;
import com.aetsmtl.ptc.modelPocTeamCloud.ProjectDAO;


@Controller
public class ProjectAcc{
	
	@Autowired
	private ProjectDAO pDAO;
	@Autowired
	private MemberDAO mDAO;
	
	private Iterable<Member> team;
	private Iterable<Project> proj;
	
	private List<Member> ht;
	
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
	public String indexConnexion(Model model){
		logController.info("Making sure that we pass by this way index at / LOgger");		
		logController.info("Démarrage de la creation de 4 projects et membres / LOgger");
		
//		createSomeUserForTesting ();
//		createSomeProjectForTesting();
		
		team = mDAO.findAllMember();
	
//		team.forEach(member -> logController.info(member.toString()));
		proj = pDAO.findAllMember();
		
		int lastIndex = ((List<Project>)proj).size();
		List<Project> lp = ((List<Project>)proj).subList(lastIndex-2, lastIndex);

//		team.forEach(projet -> logController.info(projet.toString()));
		
		
		model.addAttribute("ourTeam", team);
		model.addAttribute("ourProject", lp);
		
		return "index";
	}
	
	
//	private void createSomeProjectForTesting() {
//	 //TODO Auto-generated method stub
//		pDAO.saveProject(new Project("project UNO", "Je decris le premier project"));
//		pDAO.saveProject(new Project("project DOCE", "Je decris le premier project"));
//		pDAO.saveProject(new Project("project TRECE", "Je decris le premier project"));
//		pDAO.saveProject(new Project("project QUATRO", "Je decris le premier project"));
//		pDAO.saveProject(new Project("project CINQO", "Je decris le premier project"));
//	
//	}
//
//	private void createSomeUserForTesting() {
//	// TODO Auto-generated method stub
//		mDAO.saveMember(new Member("FEWOU", "Ing. Virtualisation Cloud chez Axians"));
//		mDAO.saveMember(new Member("KOUAM", "Developpeuse Python Chez ..."));
//		mDAO.saveMember(new Member("MBOUMEHANG", "Ing. Production Chez NextXP "));
//		mDAO.saveMember(new Member("MIAFFOSSA", "Ing. DevOps Chez Capgemini"));
//		mDAO.saveMember(new Member("FOTSING", "Cadre Ing. Chez Adneom"));
//	}

	
	@RequestMapping(value="accueil")
	public String accueil(Model model){
		System.out.println("Making sure that we pass by this way accueil" + qui);
		
		return "accueil";
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
