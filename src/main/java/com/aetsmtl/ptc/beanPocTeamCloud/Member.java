package com.aetsmtl.ptc.beanPocTeamCloud;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Member {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String lastName;
	private String role;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	public Member() {
		
		//For Spring :-)
	}
	
	public Member(String lastName, String role) {
		super();
		//this.id = id;
		this.lastName = lastName;
		this.role = role;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return String.format("my ID : %d\n, my last Name is : %s\n, I am currently : %s\n", id, lastName, role);
	}

}
