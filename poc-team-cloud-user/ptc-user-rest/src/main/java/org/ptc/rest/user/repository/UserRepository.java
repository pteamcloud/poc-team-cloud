package org.ptc.rest.user.repository;

import org.ptc.rest.user.entity.PtcUser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<PtcUser, Long> {

	PtcUser findByLastName(String name);

	PtcUser findById(Long id);

}
