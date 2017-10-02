package org.ptc.platform.repository;

import org.ptc.platform.bean.Member;
import org.springframework.data.repository.CrudRepository;

public interface MemberRepository extends CrudRepository<Member, Long> {
	
	Member findByLastName(String name);
	Member findById(Long id);
}
