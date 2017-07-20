package com.zhijia.zcms.test;

import java.util.Date;

import javax.inject.Inject;

import org.junit.Test;

import com.zhijia.zcms.base.BaseTest;
import com.zhijia.zcms.model.cnt.Topic;
import com.zhijia.zcms.service.ChannelService;
import com.zhijia.zcms.service.TopicService;
import com.zhijia.zcms.service.UserService;

public class TestTopicService extends BaseTest {
	@Inject
	private TopicService topicService;
	@Inject
	private UserService userService;
	@Inject
	private ChannelService channelService;
	@Test
	public void testUser(){
		Topic t = new Topic();
		t.setAuthor("aa");
		t.setChannel(this.channelService.load(1));
		t.setContent("hhhhh");
		t.setPublishDate(new Date());
		t.setCreateDate(new Date());
		t.setUser(this.userService.load(3));
		this.topicService.add(t, 1, 4);
	}
}
