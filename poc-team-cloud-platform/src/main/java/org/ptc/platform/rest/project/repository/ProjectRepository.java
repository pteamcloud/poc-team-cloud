package org.ptc.platform.rest.project.repository;

import org.ptc.platform.rest.project.entity.PtcProject;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends CrudRepository<PtcProject, Long> {
}
