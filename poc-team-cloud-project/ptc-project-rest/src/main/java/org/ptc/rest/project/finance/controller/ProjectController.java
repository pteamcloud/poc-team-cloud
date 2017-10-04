package org.ptc.rest.project.finance.controller;

import org.ptc.rest.project.finance.entity.PtcProject;
import org.ptc.rest.project.finance.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("project")
public class ProjectController {

	@Autowired
	ProjectRepository projectRepositoy;

	@RequestMapping( method = RequestMethod.GET,  produces = "application/json; charset=UTF-8"  )
	public Iterable<PtcProject> getPtcProject() {

		return projectRepositoy.findAll();

	}

	@RequestMapping( method = RequestMethod.GET,  produces = "application/json; charset=UTF-8", value="{idProject}")
	public PtcProject getPtcProjectById(@PathVariable("idProject") Long  idProject) {

		return projectRepositoy.findById(idProject);

	}

}
