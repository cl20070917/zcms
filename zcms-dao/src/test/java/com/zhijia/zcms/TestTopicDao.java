package com.zhijia.zcms;

import java.util.Date;

import javax.inject.Inject;

import org.junit.Test;

import com.zhijia.zcms.dao.ChannelDao;
import com.zhijia.zcms.dao.TopicDao;
import com.zhijia.zcms.dao.UserDao;
import com.zhijia.zcms.model.cnt.Topic;

public class TestTopicDao extends BaseTest {
	@Inject
	private TopicDao topicDao;
	@Inject
	private ChannelDao channelDao;
	@Inject
	private UserDao userDao;
	@Test
	public void add() {
		Topic t = new Topic();
		t.setAuthor("aa");
		t.setChannel(this.channelDao.load(1));
		t.setContent("hhhhh");
		t.setPublishDate(new Date());
		t.setCreateDate(new Date());
		t.setUser(this.userDao.load(3));
		this.topicDao.add(t);
		System.out.println("hello....");
	}
	/*
	 * @Test public void list(){ List<Role> roleList =
	 * this.userDao.listUserRoles(3); System.out.println(roleList.size()); }
	 */
}
