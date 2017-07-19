package com.zhijia.zcms.service.impl;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.zhijia.zcms.dao.RoleDao;
import com.zhijia.zcms.dao.UserDao;
import com.zhijia.zcms.model.CmsException;
import com.zhijia.zcms.model.yh.Role;
import com.zhijia.zcms.model.yh.User;
import com.zhijia.zcms.service.RoleService;

@Service("roleService")
public class RoleServiceImpl implements RoleService {
	private RoleDao roleDao;
	private UserDao userDao;
	
	public RoleDao getRoleDao() {
		return roleDao;
	}
	@Inject
	public void setRoleDao(RoleDao roleDao) {
		this.roleDao = roleDao;
	}

	public UserDao getUserDao() {
		return userDao;
	}
	@Inject
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public void add(Role role) {
		roleDao.add(role);
	}

	@Override
	public void delete(int id) {
		List<User> us = userDao.listRoleUsers(id);
		if(us!=null&&us.size()>0) throw new CmsException("删除的角色对象中还有用户，不能删除");
		roleDao.delete(id);
	}

	@Override
	public void update(Role role) {
		roleDao.update(role);
	}

	@Override
	public Role load(int id) {
		return roleDao.load(id);
	}

	@Override
	public List<Role> listRole() {
		return roleDao.listRole();
	}

	@Override
	public void deleteRoleUsers(int rid) {
		roleDao.deleteRoleUsers(rid);
	}

}
