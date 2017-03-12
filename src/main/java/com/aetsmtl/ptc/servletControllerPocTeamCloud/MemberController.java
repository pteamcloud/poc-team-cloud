package com.aetsmtl.ptc.servletControllerPocTeamCloud;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
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

import com.aetsmtl.ptc.beanPocTeamCloud.Member;
import com.aetsmtl.ptc.beanPocTeamCloud.Project;
import com.aetsmtl.ptc.modelPocTeamCloud.MemberDAO;
import com.aetsmtl.ptc.modelPocTeamCloud.ProjectDAO;

@Controller
@RequestMapping("mb")
public class MemberController {

	private static final Logger memberControllerLogger = 
			LoggerFactory.getLogger(MemberController.class);
	
	@Autowired
	private ProjectDAO pDAO;
	@Autowired
	private MemberDAO mDAO;
	
	@RequestMapping
	public String getMembers(Model model){
	
		memberControllerLogger.info(" $$$ Response from MemberControllerRoot");
		
		model.addAttribute("ourTeam", mDAO.findAllMember());
		model.addAttribute("ourProject", pDAO.findAllMember());
		
		return "members";
	}
	
	@RequestMapping("{id}")
	public String getAMember (@PathVariable("id") Member memb, Model model){
		
		
		//model.addAttribute("ourTeam", mDAO.findAllMember());
		//Find all (projects, activity, using, etccc, ...) informations about this member
		model.addAttribute("proj", mDAO.getProjectLinkedToMember(memb.getId()));
		model.addAttribute("memb", memb);
		return "MemberX";
	}
	
	@RequestMapping(params = "form", method = RequestMethod.GET)
	public String createMForm(Model model) {

		model.addAttribute("memb", new Member());
		
		return "createMemberForm";
	}

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView createM(@Valid Member memb, BindingResult result,
			RedirectAttributes redirect) {
		if (result.hasErrors()) {
			return new ModelAndView("createMemberForm", "formErrors", result.getAllErrors());
		}
		if (mDAO.saveMember(memb)){
			//System.out.println(memb.toString());
		};
		redirect.addFlashAttribute("globalMessage", "Successfully created a new member");
		return new ModelAndView("redirect:/mb/{memb.id}", "memb.id", memb.getId());
	}
	
	@RequestMapping(value="{id}", params = "pId", method = RequestMethod.POST)
	public ModelAndView deleteM(@PathVariable("id") String pId, RedirectAttributes redirect) {
		
		
		memberControllerLogger.info(" $$$ Deleting a Member");
		
		mDAO.deleteMember(Long.parseLong(pId));
		
		return new ModelAndView ("redirect:/mb");
	}
	
	
}
