package org.ptc.platform.rest.member.controller;

import java.util.Arrays;
import java.util.List;

import javax.websocket.server.PathParam;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
public class MemberController {

	private static final Logger LOGGER = LoggerFactory.getLogger(MemberController.class);

	@GetMapping(path="/ptc/api/v0/members", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<String> getMembers() {
		
		LOGGER.info("get bucket of List of Members");
		return Arrays.asList("Arnold, Boris, ...".split(","));
	}

	@GetMapping(path="ptc/api/v0/members/{memberId}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public String getMemberById(@PathParam("memberId") Long memberId) {
		
		LOGGER.info("get specific Member by id");
		return "Arnold";
	}
	
}
