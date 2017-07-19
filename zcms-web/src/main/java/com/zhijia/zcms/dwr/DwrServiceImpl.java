package com.zhijia.zcms.dwr;

import javax.inject.Inject;

import org.directwebremoting.annotations.RemoteMethod;
import org.directwebremoting.annotations.RemoteProxy;

import com.zhijia.zcms.service.GroupService;

@RemoteProxy(name="dwrService")
public class DwrServiceImpl implements DwrService{
	private GroupService groupService;
	
	
	
	public GroupService getGroupService() {
		return groupService;
	}
	@Inject
	public void setGroupService(GroupService groupService) {
		this.groupService = groupService;
	}

	@Override
	@RemoteMethod
	public void addGroupChannel(int gid, int cid) {
		groupService.addGroupChannel(gid, cid);
	}

	@Override
	@RemoteMethod
	public void deleteGroupChannel(int gid, int cid) {
		groupService.deleteGroupChannel(gid, cid);
	}

}
