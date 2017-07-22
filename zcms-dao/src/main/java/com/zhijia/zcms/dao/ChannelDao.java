package com.zhijia.zcms.dao;

import java.util.List;

import com.zhijia.zcms.model.cnt.Channel;
import com.zhijia.zcms.model.cnt.ChannelTree;

public interface ChannelDao extends BaseDao<Channel> {
	/**
	 * 根据父id获取所有的子栏目
	 * @param pid
	 * @return
	 */
	public List<Channel> listByParent(Integer pid);
	/**
	 * 获取子栏目的最大的排序号
	 * @param pid
	 * @return
	 */
	public int getMaxOrderByParent(Integer pid);
	/**
	 * 把所有的栏目获取并生成一颗完整的树
	 * @return
	 */
	public List<ChannelTree> generateTree();
	/**
	 * 根据父类对象获取子类栏目，并且生成树列表
	 * @param pid
	 * @return
	 */
	public List<ChannelTree> generateTreeByParent(Integer pid);
	/**
	 * 通过一个数组来完成排序
	 * @param ids
	 */
	public void updateSort(Integer[] ids);
	/**
	 * 获取所有的可以发布文章的栏目，栏目的状态必须为启用状态
	 * @return
	 */
	public List<Channel> listPublishChannel();
}
