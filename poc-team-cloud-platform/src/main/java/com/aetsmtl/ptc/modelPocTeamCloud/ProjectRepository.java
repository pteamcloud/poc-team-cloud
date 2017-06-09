package com.aetsmtl.ptc.modelPocTeamCloud;

import org.springframework.data.repository.CrudRepository;

import com.aetsmtl.ptc.beanPocTeamCloud.Project;

public interface ProjectRepository extends CrudRepository<Project, Long> {
	
	Project findByName(String name);
	Project findById(Long id);
	
}
