package org.ptc.platform.rest.project.controller;

import java.util.Arrays;
import java.util.List;

import javax.websocket.server.PathParam;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProjectController {

	private static final Logger LOGGER = LoggerFactory.getLogger(ProjectController.class);

	@GetMapping(path="/ptc/api/v0/projects", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<String> getProject() {
		
		LOGGER.info("get bucket of List of project");
		return Arrays.asList("ldapAuth, dockerHub, ...".split(","));
	}

	@GetMapping(path="ptc/api/v0/projects/{projectId}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public String getProjectById(@PathParam("projectId") Long projectId) {
		
		LOGGER.info("get specific projects by id");
		return "dockerHub";
	}
	
}
