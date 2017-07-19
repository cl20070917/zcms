package com.zhijia.zcms.dao.impl;


import java.util.List;

import org.springframework.stereotype.Repository;

import com.zhijia.zcms.dao.RoleDao;
import com.zhijia.zcms.model.yh.Role;

@Repository("roleDao")
public class RoleDaoImpl extends BaseDaoImpl<Role> implements RoleDao {

	@Override
	public List<Role> listRole() {
		return this.list("from Role");
	}

	@Override
	public void deleteRoleUsers(int rid) {
		this.updateByHql("delete UserRole ur where ur.role.id=?",rid);
	}


}
