package org.ptc.platform.repository;

import org.ptc.api.user.dto.Project;
import org.springframework.data.repository.CrudRepository;

public interface ProjectRepository extends CrudRepository<Project, Long> {
	
	Project findByName(String name);
	Project findById(Long id);
	
}
