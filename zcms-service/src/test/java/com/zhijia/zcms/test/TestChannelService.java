package com.zhijia.zcms.test;

import javax.inject.Inject;

import org.junit.Test;

import com.zhijia.zcms.base.BaseTest;
import com.zhijia.zcms.model.cnt.Channel;
import com.zhijia.zcms.model.cnt.ChannelType;
import com.zhijia.zcms.service.ChannelService;

public class TestChannelService extends BaseTest {
	@Inject
	private ChannelService channelService;
	
	@Test
	public void add(){
		Channel c = new Channel();
		c.setCustomLink(1);
		c.setCustomLinkUrl("11");
		c.setIsIndex(0);
		c.setIsTopNav(0);
		c.setName("aa");
		c.setOrders(1);
		c.setParent(null);
		c.setRecommend(1);
		c.setType(ChannelType.NAV_CHANNEL);
		c.setStatus(0);
		
		this.channelService.add(c, 0);
		
		
		
		
		
		
	}
}
