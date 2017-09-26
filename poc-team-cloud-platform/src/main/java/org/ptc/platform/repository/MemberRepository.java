package org.ptc.platform.repository;

import java.util.Set;

import org.ptc.platform.bean.Member;
import org.ptc.platform.bean.Project;
import org.springframework.data.repository.CrudRepository;

public interface MemberRepository extends CrudRepository<Member, Long> {
	
	Member findByLastName(String name);
	Member findById(Long id);
}
