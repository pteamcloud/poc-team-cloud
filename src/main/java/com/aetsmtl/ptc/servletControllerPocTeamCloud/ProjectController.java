package com.aetsmtl.ptc.servletControllerPocTeamCloud;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.aetsmtl.ptc.beanPocTeamCloud.Project;
import com.aetsmtl.ptc.modelPocTeamCloud.MemberDAO;
import com.aetsmtl.ptc.modelPocTeamCloud.ProjectDAO;

@Controller
@RequestMapping("pj")
public class ProjectController {

	private static final Logger projectControllerLogger = 
			LoggerFactory.getLogger(ProjectController.class);
	
	@Autowired
	private ProjectDAO pDAO;
	@Autowired
	private MemberDAO mDAO;
	
	@RequestMapping
	public String getProjects(Model model){
	
		projectControllerLogger.info(" $$$ Response from ProjectControllerRoot");
		
		model.addAttribute("ourTeam", mDAO.findAllMember());
		model.addAttribute("ourProject", pDAO.findAllMember());
		
		return "projects";
	}
	
	@RequestMapping("{id}")
	public String getAProject (@PathVariable("id") Project proj, Model model){
		
		model.addAttribute("ourTeam", pDAO.getMemberLinkedToProject(proj.getId()));
		model.addAttribute("proj", proj);
		return "projectX";
	}
	
	@RequestMapping(params = "form", method = RequestMethod.GET)
	public String createPForm(Model model) {

		model.addAttribute("proj", new Project() );
		
		return "createProjectForm";
	}

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView create(@Valid Project proj, BindingResult result,
			RedirectAttributes redirect) {
		if (result.hasErrors()) {
			return new ModelAndView("createProjectForm", "formErrors", result.getAllErrors());
		}
		if (pDAO.saveProject(proj)){
			System.out.println(proj.toString());
		};
		redirect.addFlashAttribute("globalMessage", "Successfully created a new project");
		return new ModelAndView("redirect:/pj/{proj.id}", "proj.id", proj.getId());
	}
	
	@RequestMapping(value="{id}/proj", params = "pId", method = RequestMethod.POST)
	public ModelAndView deleteP(@PathVariable("id") String pId, RedirectAttributes redirect) {
		
		
		projectControllerLogger.info(" $$$ Deleting a project");
		
		pDAO.deleteProject(Long.parseLong(pId));
		
		return new ModelAndView ("redirect:/pj");
	}
	
	
}
