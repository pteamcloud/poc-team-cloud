package com.aetsmtl.ptc.servletControllerPocTeamCloud;

import javax.validation.Valid;

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
		//return "projects";
	}
	
	@RequestMapping(value="{id}/proj", params = "pId", method = RequestMethod.POST)
	public ModelAndView deleteP(@PathVariable("id") String pId, RedirectAttributes redirect) {
		
		
		System.out.println("Deleting a project");
		
		pDAO.deleteProject(Long.parseLong(pId));
		
		return new ModelAndView ("redirect:/pj");
	}
	
}
