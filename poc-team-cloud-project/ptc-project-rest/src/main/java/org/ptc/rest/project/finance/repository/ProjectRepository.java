package org.ptc.rest.project.finance.repository;

import org.ptc.rest.project.finance.entity.PtcProject;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends CrudRepository<PtcProject, Long> {

	PtcProject findByName(String name);

	PtcProject findById(Long id);

}
