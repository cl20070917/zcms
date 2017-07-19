package com.zhijia.zcms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zhijia.zcms.auth.AuthClass;
import com.zhijia.zcms.auth.AuthMethod;

@Controller
@AuthClass("login")
@RequestMapping("/admin/topic")
public class TopicController {
	
	@RequestMapping("/add")
	@AuthMethod(role="ROLE_PUBLISH")
	public void add() {
		
	}
	
	@RequestMapping("/delete")
	@AuthMethod(role="ROLE_PUBLISH")
	public void delete() {
		
	}
	
	@RequestMapping("/audit")
	@AuthMethod(role="ROLE_AUDIT")
	public void audit() {
		
	}
}
