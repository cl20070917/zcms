package com.zhijia.zcms.dao;

import java.util.List;

import com.zhijia.zcms.model.yh.Role;


public interface RoleDao extends BaseDao<Role> {
	public List<Role> listRole();
	public void deleteRoleUsers(int rid);
	
	
}
