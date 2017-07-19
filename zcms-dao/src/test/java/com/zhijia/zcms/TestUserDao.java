package com.zhijia.zcms;


import java.util.List;

import javax.inject.Inject;

import org.junit.Test;

import com.zhijia.zcms.dao.UserDao;
import com.zhijia.zcms.model.yh.Role;
import com.zhijia.zcms.model.yh.User;

public class TestUserDao extends BaseTest {
	@Inject
	private UserDao userDao;
	@Test
	public void add(){
		User u = this.userDao.load(3);
		System.out.println(u.getEmail());
	}
	@Test
	public void list(){
		List<Role> roleList = this.userDao.listUserRoles(3);
		System.out.println(roleList.size());
	}
}
