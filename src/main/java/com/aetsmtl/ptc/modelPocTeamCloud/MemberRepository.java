package com.aetsmtl.ptc.modelPocTeamCloud;

import org.springframework.data.repository.CrudRepository;

import com.aetsmtl.ptc.beanPocTeamCloud.Member;

public interface MemberRepository extends CrudRepository<Member, Long> {
	
	Member findByLastName(String name);
	Member findById(Long id);
	
}
