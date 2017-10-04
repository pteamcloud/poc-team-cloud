package org.ptc.api.project.dto;

import java.util.Set;

public class PtcProject {

	private Long id;
	private String name;
	private String description;
	private String versionningLink;

	private Set<PtcUser> contributors;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public Set<PtcUser> getContributors() {
		return contributors;
	}
	public void setContributors(Set<PtcUser> contributor) {
		this.contributors = contributor;
	}
	
	public String getVersionningLink() {
		return versionningLink;
	}
	public void setVersionningLink(String versionningLink) {
		this.versionningLink = versionningLink;
	}
	public PtcProject() {
		
		//For Spring :-)
	}
	
	public PtcProject(String name, String description) {
		super();
		//this.id = id;
		this.name = name;
		this.description = description;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return String.format("my ID : %d\n, my Name : %s\n, little Description : %s\n", id, name, description);
	}

}
