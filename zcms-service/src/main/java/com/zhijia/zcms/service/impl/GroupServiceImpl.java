package com.zhijia.zcms.service.impl;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.zhijia.zcms.dao.ChannelDao;
import com.zhijia.zcms.dao.GroupDao;
import com.zhijia.zcms.dao.UserDao;
import com.zhijia.zcms.model.CmsException;
import com.zhijia.zcms.model.Pager;
import com.zhijia.zcms.model.cnt.Channel;
import com.zhijia.zcms.model.cnt.ChannelTree;
import com.zhijia.zcms.model.cnt.GroupChannel;
import com.zhijia.zcms.model.yh.Group;
import com.zhijia.zcms.model.yh.User;
import com.zhijia.zcms.service.GroupService;

@Service("groupService")
public class GroupServiceImpl implements GroupService {
	private GroupDao groupDao;
	private UserDao userDao;
	private ChannelDao channelDao;
	public GroupDao getGroupDao() {
		return groupDao;
	}

	@Inject
	public void setGroupDao(GroupDao groupDao) {
		this.groupDao = groupDao;
	}

	public UserDao getUserDao() {
		return userDao;
	}

	@Inject
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
	public ChannelDao getChannelDao() {
		return channelDao;
	}
	@Inject
	public void setChannelDao(ChannelDao channelDao) {
		this.channelDao = channelDao;
	}

	@Override
	public void add(Group group) {
		groupDao.add(group);
	}

	@Override
	public void delete(int id) {
		List<User> users = userDao.listGroupUsers(id);
		if (users != null && users.size() > 0)
			throw new CmsException("删除的组中还有用户，不能删除");
		groupDao.delete(id);
	}

	@Override
	public Group load(int id) {
		return groupDao.load(id);
	}

	@Override
	public void update(Group group) {
		groupDao.update(group);
	}

	@Override
	public List<Group> listGroup() {
		return groupDao.listGroup();
	}

	@Override
	public Pager<Group> findGroup() {
		return groupDao.findGroup();
	}

	@Override
	public void deleteGroupUsers(int gid) {
		groupDao.deleteGroupUsers(gid);
	}

	@Override
	public void addGroupChannel(int gid, int cid) {
		Group g = groupDao.load(gid);
		Channel c = channelDao.load(cid);
		if (c == null || g == null)
			throw new CmsException("要添加的组频道关联对象不存在");
		groupDao.addGroupChannel(g, c);
	}

	@Override
	public GroupChannel loadGroupChannel(int gid, int cid) {
		return groupDao.loadGroupChannel(gid, cid);
	}

	@Override
	public void clearGroupChannel(int gid) {
		groupDao.clearGroupChannel(gid);
	}

	@Override
	public void deleteGroupChannel(int gid, int cid) {
		groupDao.deleteGroupChannel(gid, cid);
	}

	@Override
	public List<Integer> listGroupChannelIds(int gid) {
		return groupDao.listGroupChannelIds(gid);
	}

	@Override
	public List<ChannelTree> generateGroupChannelTree(int gid) {
		return groupDao.generateGroupChannelTree(gid);
	}

	@Override
	public List<ChannelTree> generateUserChannelTree(int uid) {
		return groupDao.generateUserChannelTree(uid);
	}

}
