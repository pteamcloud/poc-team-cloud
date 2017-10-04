package org.ptc.platform.controller;

import org.springframework.stereotype.Controller;


@Controller
public class ProjectAcc{
//	
//	RestTemplate rt =  new RestTemplate();
//	
//	
//	@Autowired
//	private ProjectDAO pDAO;
//	@Autowired
//	private MemberDAO mDAO;
//	
//	private Iterable<Member> team;
//	private Iterable<Project> proj;
//	
//// 	private static final Logger logController = LoggerFactory.getLogger(ProjectAcc.class);
////	private static final String PATH = "/error";
//	
//	@Value("${qui.n: Aetsmtl}")
//	private String qui;
//	
//	@RequestMapping("/")
//	public String indexConnexion(Model model){
//		
//		team = mDAO.findAllMember();
//		proj = pDAO.findAllMember();
//		
//		List<Project> lp = (List<Project>)proj ;
//		List<Member> lm = (List<Member>)team;
//		
//		int lastIndex = ((List<Project>)proj).size();
//		
//		if (checkIfListSizeOfProjectIsMoreThanThree (proj)){
//			lp = ((List<Project>)proj).subList(lastIndex-2, lastIndex);
//		}
//		
//		lastIndex = ((List<Member>)team).size();
//		
//		if (checkIfListSizeOfMemberIsMoreThanThree(team)){
//			lm = ((List<Member>)team).subList(lastIndex-2, lastIndex);
//		}
//
//		model.addAttribute("ourTeam", lm);
//		model.addAttribute("ourProject", lp);
//		model.addAttribute("jumTitle", "Welcome to Poc-Team-Cloud [ P.T.C. ]");
//		
//		return "index";
//	}
//	
//	@RequestMapping(value="/portfolio")
//	public String getAPortfolio(){
//	
//		return "portfolio";
//	}
//	
//	@RequestMapping(value="/login")
//	public String login(){
//	
//		return "login";
//	}
//	
//	@RequestMapping("/login-error")
//	public String loginError(Model model) {
//		model.addAttribute("loginError", true);
//		return "login";
//	}
//	
//	@RequestMapping("/aboutUs")
//	public String aboutsUs(Model model){
//				
//		team = mDAO.findAllMember();
//		proj = pDAO.findAllMember();
//
//		model.addAttribute("ourTeam", team);
//		model.addAttribute("ourProject", proj);
//		model.addAttribute("jumTitle", "Everything about US!");
//
//		
//		return "aboutUs";
//	}
//	
//	private boolean checkIfListSizeOfProjectIsMoreThanThree(Iterable<Project> proj2) {
//		// TODO Auto-generated method stub
//		if (proj2 == null || 
//				((List<Project>)proj2).isEmpty() || 
//				((List<Project>)proj2).size() <= 1){
//					return false;
//				}
//		return true;
//	}
//	
//	private boolean checkIfListSizeOfMemberIsMoreThanThree(Iterable<Member> memb) {
//		// TODO Auto-generated method stub
//		if (memb == null || 
//				((List<Member>)memb).isEmpty() || 
//				((List<Member>)memb).size() <= 1){
//					return false;
//				}
//		return true;
//	}
//	
//	
//	
//
//	
//	@RequestMapping
//	public String getMembers(Model model){
//			
//		model.addAttribute("ourTeam", mDAO.findAllMember());
//		model.addAttribute("ourProject", pDAO.findAllMember());
//		model.addAttribute("jumTitle", "Members");
//
//		return "members";
//	}
//	
//	@RequestMapping("{id}")
//	public String getAMember (@PathVariable("id") PtcUser memb, Model model){
//		
//		model.addAttribute("proj", mDAO.getProjectLinkedToMember(memb.getId()));
//		model.addAttribute("memb", memb);
//		model.addAttribute("jumTitle", memb.getSurName());
//
//		return "memberX";
//	}
//	
//	@RequestMapping(params = "form", method = RequestMethod.GET)
//	public String createMForm(Model model) {
//
//		model.addAttribute("memb", new PtcUser());
//		model.addAttribute("jumTitle", "Create a new member");
//		
//		return "createMemberForm";
//	}
//
//	@RequestMapping(method = RequestMethod.POST)
//	public ModelAndView create(@Valid PtcUser memb, BindingResult result,
//			RedirectAttributes redirect) {
//		if (result.hasErrors()) {
//			return new ModelAndView("createMemberForm", "formErrors", result.getAllErrors());
//		}
//		if (mDAO.saveMember(memb)){
//			//System.out.println(memb.toString());
//		};
//		redirect.addFlashAttribute("globalMessage", "Successfully created a new member");
//		return new ModelAndView("redirect:/mb/{memb.id}", "memb.id", memb.getId());
//	}
//	
//	@RequestMapping(value="{id}/d", method = RequestMethod.POST)
//	public ModelAndView delete(@PathVariable("id") String pId, RedirectAttributes redirect) {
//		
//		mDAO.deleteMember(Long.parseLong(pId));
//		return new ModelAndView ("redirect:/mb");
//	}
//	
//	@RequestMapping(value="{id}/u", method = RequestMethod.GET)
//	public String updateMForm(@PathVariable("id") String pId, Model model) {
//		
//		model.addAttribute("memb", mDAO.findMemberX(Long.parseLong(pId)));
//		//Add to header.views th:text=" 'Hello world from ' + ${jumTitle}"
//		model.addAttribute("jumTitle", "updating This Member Infos");
//		
//		return "updateMemberForm";
//	}
//	
//	@RequestMapping(value="{id}/up", method = RequestMethod.POST)
//	public ModelAndView update(@PathVariable("id") String pId, @Valid PtcUser memb, BindingResult result,
//			RedirectAttributes redirect) {
//		if (result.hasErrors()) {
//			return new ModelAndView("updateProjectForm", "formErrors", result.getAllErrors());
//		}
//		memb.setId(Long.parseLong(pId));
//		if (mDAO.saveMember(memb)){
//			System.out.println(memb.toString());
//		};
//		redirect.addFlashAttribute("globalMessage", "Successfully update this member");
//		return new ModelAndView("redirect:/mb/{memb.id}", "memb.id", memb.getId());
//	}
//	
//	
//
////	private static final Logger projectControllerLogger = 
////			LoggerFactory.getLogger(ProjectController.class);
//
//	@Autowired
//	private ProjectDAO pDAO;
//	@Autowired
//	private MemberDAO mDAO;
//	
//	@RequestMapping
//	public String getProjects(Model model){
//			
//		model.addAttribute("ourTeam", mDAO.findAllMember());
//		model.addAttribute("ourProject", pDAO.findAllMember());
//		model.addAttribute("jumTitle", "Projects");
//		
//		return "projects";
//	}
//	
//	@RequestMapping("{id}")
//	public String getAProject (@PathVariable("id") PtcProject proj, Model model){
//		
//		model.addAttribute("ourTeam", pDAO.getMemberLinkedToProject(proj.getId()));
//		model.addAttribute("proj", proj);
//		model.addAttribute("jumTitle", proj.getName());
//
//		return "projectX";
//	}
//	
//	@RequestMapping(params = "form", method = RequestMethod.GET)
//	public String createPForm(@RequestParam("form") String form, Model model) {
//			
//			model.addAttribute("proj", new PtcProject() );
//			//Add to header.views th:text=" 'Hello world from ' + ${jumTitle}"
//			model.addAttribute("jumTitle", "Create a new project");
//			
//		return "createProjectForm";
//	}
//
//	@RequestMapping(value="cr", method = RequestMethod.POST)
//	public ModelAndView create(@PathVariable("id") String pId, @Valid PtcProject proj, BindingResult result,
//			RedirectAttributes redirect) {
//		if (result.hasErrors()) {
//			return new ModelAndView("createProjectForm", "formErrors", result.getAllErrors());
//		}
//		if (pDAO.saveProject(proj)){
//			System.out.println(proj.toString());
//		};
//		redirect.addFlashAttribute("globalMessage", "Successfully created a new project");
//		return new ModelAndView("redirect:/pj/{proj.id}", "proj.id", proj.getId());
//	}
//	
//	@RequestMapping(value="{id}/d", method = RequestMethod.POST)
//	public ModelAndView delete(@PathVariable("id") String pId, RedirectAttributes redirect) {
//			
//		pDAO.deleteProject(Long.parseLong(pId));	
//		return new ModelAndView ("redirect:/pj");
//	}
//	
//	@RequestMapping(value="{id}/u", method = RequestMethod.GET)
//	public String updatePForm(@PathVariable("id") String pId, Model model) {
//		
//		model.addAttribute("proj", pDAO.findProjectX(Long.parseLong(pId)));
//		//Add to header.views th:text=" 'Hello world from ' + ${jumTitle}"
//		model.addAttribute("jumTitle", "updating This project");
//		
//		return "updateProjectForm";
//	}
//	
//	@RequestMapping(value="{id}/up", method = RequestMethod.POST)
//	public ModelAndView update(@PathVariable("id") String pId, @Valid PtcProject proj, BindingResult result,
//			RedirectAttributes redirect) {
//		if (result.hasErrors()) {
//			return new ModelAndView("updateProjectForm", "formErrors", result.getAllErrors());
//		}
//		proj.setId(Long.parseLong(pId));
//		if (pDAO.saveProject(proj)){
//			System.out.println(proj.toString());
//		};
//		redirect.addFlashAttribute("globalMessage", "Successfully update this project");
//		return new ModelAndView("redirect:/pj/{proj.id}", "proj.id", proj.getId());
//	}
//	
//
//	@Autowired
//	private FinanceOperations financeOps;
//
//	@RequestMapping
//	public String getFinances(Model model) {
//
//		Set<PtcTransaction> lOperation = financeOps.findAll();
//
//		Account aState = new Account();
//
//		double solde = lOperation.stream().filter(o -> Double.valueOf(o.getAmount()) != null)
//				.mapToDouble(o -> o.getAmount()).sum();
//		Date rdate = lOperation.stream().map(o -> o.getDate()).max(Date::compareTo).get();
//		PtcTransaction lastOperation = lOperation.stream()
//				// .peek(num -> System.out.println("will filter " + num))
//				.filter(o -> o.getDate().equals(rdate)).findFirst().get();
//
//		model.addAttribute("ptcFinSolde", aState);
//		model.addAttribute("ptcFinOps", lOperation);
//		model.addAttribute("jumTitle", "FINANCES");
//
//		return "finance-view";
//	}
//	
}
