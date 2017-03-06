package com.aetsmtl.ptc.modelPocTeamCloud;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.aetsmtl.ptc.beanPocTeamCloud.Member;
import com.aetsmtl.ptc.beanPocTeamCloud.Project;

@Component
public class ProjectDAO {

	private static final Logger logProjectDAO = LoggerFactory.getLogger(ProjectDAO.class);

	ProjectRepository projectRepo;
	
	public ProjectDAO() {
		// TODO Auto-generated constructor stub
		// For Spring
	}
	
	@Autowired
	public void setProjectRepo(ProjectRepository projectRepo) {
		this.projectRepo = projectRepo;
	}
	
	public ProjectDAO (ProjectRepository projectRepository){
		logProjectDAO.info("Instantiation of PROJECTREPOSITORY $$$$$");
		setProjectRepo(projectRepository);
	}
	
	public boolean saveProject (Project p){
		logProjectDAO.info("Saving an Project $$$$$");
		if (p.equals(projectRepo.save(p))){
			
			return true;
		}
		return false;
	}
	
	public void deleteProject (Long pId){
		logProjectDAO.info("Deleting an Project $$$$$");
		//projectRepo.delete(p);
		projectRepo.delete(pId);
	}
	
	public Project findProjectX (long Xid){
		logProjectDAO.info("Finding an Object By ID $$$$$");
		return projectRepo.findById(Xid);
	}
	
	public Iterable<Project> findAllMember (){
		logProjectDAO.info("Finding an Object By ID $$$$$");
		return projectRepo.findAll();
	}
}
