package com.zhijia.zcms.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zhijia.zcms.auth.AuthMethod;
import com.zhijia.zcms.model.yh.User;
import com.zhijia.zcms.service.UserService;

@Controller
public class AdminController {
	@Inject
	private UserService userService;
	@RequestMapping("/admin")
	@AuthMethod
	public String index() {
		return "admin/index";
	}
	
	@AuthMethod
	@RequestMapping("/admin/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/login";
	}}
