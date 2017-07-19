package com.zhijia.zcms.test;

import javax.inject.Inject;

import org.junit.Test;

import com.zhijia.zcms.base.BaseTest;
import com.zhijia.zcms.model.yh.User;
import com.zhijia.zcms.service.UserService;

public class TestUserService extends BaseTest {
	@Inject
	private UserService userService;
	@Test
	public void testUser(){
		User u = userService.load(2);
		System.out.println(u.getId());
	}
	/*@Test
	public void hello(){
		System.out.println("aaa");
	}*/
}
