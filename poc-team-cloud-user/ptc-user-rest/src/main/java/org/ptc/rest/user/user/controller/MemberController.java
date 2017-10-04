package org.ptc.rest.user.user.controller;

import org.ptc.rest.user.user.entity.PtcUser;
import org.ptc.rest.user.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
public class MemberController {

	@Autowired
	UserRepository userRepositoy;

	@RequestMapping(method = RequestMethod.GET,  produces = "application/json; charset=UTF-8")
	public Iterable<PtcUser> getPtcUser() {
		
		return userRepositoy.findAll();
	
	}
	
	@RequestMapping( method = RequestMethod.GET,  produces = "application/json; charset=UTF-8", value="{idUser}")
	public PtcUser getPtcUserById(@PathVariable("idUser") Long  idUser) {

		return userRepositoy.findById(idUser);

	}

}
