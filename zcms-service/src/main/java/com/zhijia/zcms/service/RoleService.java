package com.zhijia.zcms.service;

import java.util.List;

import com.zhijia.zcms.model.yh.Role;


public interface RoleService {
	public void add(Role role);
	public void delete(int id);
	public void update(Role role);
	public Role load(int id);
	public List<Role> listRole();
	public void deleteRoleUsers(int rid);
}
