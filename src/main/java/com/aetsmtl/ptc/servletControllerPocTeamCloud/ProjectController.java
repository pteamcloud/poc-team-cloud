package com.aetsmtl.ptc.servletControllerPocTeamCloud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.aetsmtl.ptc.beanPocTeamCloud.Project;
import com.aetsmtl.ptc.modelPocTeamCloud.MemberDAO;
import com.aetsmtl.ptc.modelPocTeamCloud.ProjectDAO;

@Controller
@RequestMapping("pj")
public class ProjectController {

	@Autowired
	private ProjectDAO pDAO;
	@Autowired
	private MemberDAO mDAO;
	
	@RequestMapping
	public String getProject(Model model){
		System.out.println("Making sure that we pass by this ways projects /projects");
		
		
		model.addAttribute("ourTeam", mDAO.findAllMember());
		model.addAttribute("ourProject", pDAO.findAllMember());
		
		
		return "projects";
	}
	
	@RequestMapping("{id}")
	public String getAProject (@PathVariable("id") Project proj, Model model){
		
		model.addAttribute("ourTeam", mDAO.findAllMember());
		model.addAttribute("proj", proj);
		return "projectX";
	}
}
