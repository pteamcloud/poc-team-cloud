package org.ptc.finance.rest;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "contributions", path = "contributions")
public interface ContributionRepository extends PagingAndSortingRepository<Contribution, Long>{
	Contribution findByAmountAllIgnoringCase(double amount);
}
