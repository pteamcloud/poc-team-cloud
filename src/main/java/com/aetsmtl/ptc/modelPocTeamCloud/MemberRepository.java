package com.aetsmtl.ptc.modelPocTeamCloud;

import java.util.Set;

import org.springframework.data.repository.CrudRepository;

import com.aetsmtl.ptc.beanPocTeamCloud.Member;
import com.aetsmtl.ptc.beanPocTeamCloud.Project;

public interface MemberRepository extends CrudRepository<Member, Long> {
	
	Member findByLastName(String name);
	Member findById(Long id);
}
