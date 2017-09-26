package com.ptc.finance.service;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.ptc.finance.domain.Contribution;

@RepositoryRestResource(collectionResourceRel = "contributions", path = "contributions")
public interface ContributionRepository extends PagingAndSortingRepository<Contribution, Long>{

//	Page<Contribution> findAllContibution(Pageable pageable);
	
	Contribution findByAmountAllIgnoringCase(double amount);

	
}
