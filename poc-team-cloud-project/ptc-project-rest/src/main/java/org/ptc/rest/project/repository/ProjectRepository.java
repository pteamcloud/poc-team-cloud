package org.ptc.rest.project.repository;

import org.ptc.rest.project.entity.PtcProject;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends CrudRepository<PtcProject, Long> {

	PtcProject findByName(String name);

	PtcProject findById(Long id);

}
