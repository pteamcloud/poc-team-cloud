package org.ptc.platform.rest.member.repository;

import org.ptc.platform.rest.member.entity.PtcMember;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends CrudRepository<PtcMember, Long> {
}
