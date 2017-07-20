package com.zhijia.zcms.service.impl;

import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.zhijia.zcms.dao.AttachmentDao;
import com.zhijia.zcms.dao.ChannelDao;
import com.zhijia.zcms.dao.TopicDao;
import com.zhijia.zcms.dao.UserDao;
import com.zhijia.zcms.model.CmsException;
import com.zhijia.zcms.model.Pager;
import com.zhijia.zcms.model.cnt.Attachment;
import com.zhijia.zcms.model.cnt.Channel;
import com.zhijia.zcms.model.cnt.Topic;
import com.zhijia.zcms.model.yh.User;
import com.zhijia.zcms.service.TopicService;

@Service("topicService")
public class TopicServiceImpl implements TopicService {
	private TopicDao topicDao;
	private AttachmentDao attachmentDao;
	private ChannelDao channelDao;
	private UserDao userDao;
	
	
	public ChannelDao getChannelDao() {
		return channelDao;
	}
	@Inject
	public void setChannelDao(ChannelDao channelDao) {
		this.channelDao = channelDao;
	}
	public UserDao getUserDao() {
		return userDao;
	}
	@Inject
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	public TopicDao getTopicDao() {
		return topicDao;
	}
	@Inject
	public void setTopicDao(TopicDao topicDao) {
		this.topicDao = topicDao;
	}

	public AttachmentDao getAttachmentDao() {
		return attachmentDao;
	}
	@Inject
	public void setAttachmentDao(AttachmentDao attachmentDao) {
		this.attachmentDao = attachmentDao;
	}
	
	private void addTopicAtts(Topic topic,Integer[] aids) {
		if(aids!=null) {
			for(Integer aid:aids) {
				Attachment a = attachmentDao.load(aid);
				if(a==null) continue;
				a.setTopic(topic);
			}
		}
	}

	@Override
	public void add(Topic topic, int cid, int uid, Integer[] aids) {
		Channel c = channelDao.load(cid);
		User u = userDao.load(uid);
		if(c==null||u==null)throw new CmsException("要添加的文章必须有用户和栏目");
		topic.setAuthor(u.getNickname());
		topic.setCname(c.getName());
		topic.setCreateDate(new Date());
		topic.setChannel(c);
		topic.setUser(u);
		topicDao.add(topic);
		addTopicAtts(topic, aids);
	}

	@Override
	public void add(Topic topic, int cid, int uid) {
		add(topic,cid,uid,null);
	}

	@Override
	public void delete(int id) {
		List<Attachment> atts = attachmentDao.listByTopic(id);
		attachmentDao.deleteByTopic(id);
		topicDao.delete(id);
		//删除硬盘上面的文件
		for(Attachment a:atts) {
			AttachmentServiceImpl.deleteAttachFiles(a);
		}
	}

	@Override
	public void update(Topic topic, int cid, Integer[] aids) {
		Channel c = channelDao.load(cid);
		if(c==null)throw new CmsException("要更新的文章必须有用户和栏目");
		topic.setCname(c.getName());
		topic.setChannel(c);
		topicDao.update(topic);
		addTopicAtts(topic, aids);
	}

	@Override
	public void update(Topic topic, int cid) {
		update(topic,cid,null);
	}

	@Override
	public Topic load(int id) {
		return topicDao.load(id);
	}

	@Override
	public Pager<Topic> find(Integer cid, String title, Integer status) {
		return topicDao.find(cid, title, status);
	}

	@Override
	public Pager<Topic> find(Integer uid, Integer cid, String title,
			Integer status) {
		return topicDao.find(uid, cid, title, status);
	}

	@Override
	public Pager<Topic> searchTopicByKeyword(String keyword) {
		return topicDao.searchTopicByKeyword(keyword);
	}

	@Override
	public Pager<Topic> searchTopic(String con) {
		return topicDao.searchTopic(con);
	}

	@Override
	public Pager<Topic> findRecommendTopic(Integer ci) {
		return topicDao.findRecommendTopic(ci);
	}
	@Override
	public void updateStatus(int tid) {
		Topic t = topicDao.load(tid);
		if(t.getStatus()==0) t.setStatus(1);
		else t.setStatus(0);
		topicDao.update(t);
	}

}
