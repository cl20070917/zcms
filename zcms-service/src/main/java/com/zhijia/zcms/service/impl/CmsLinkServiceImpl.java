package com.zhijia.zcms.service.impl;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.zhijia.zcms.dao.CmsLinkDao;
import com.zhijia.zcms.model.Pager;
import com.zhijia.zcms.model.sys.CmsLink;
import com.zhijia.zcms.service.CmsLinkService;

@Service("cmsLinkService")
public class CmsLinkServiceImpl implements CmsLinkService {
	private CmsLinkDao cmsLinkDao;
	
	

	public CmsLinkDao getCmsLinkDao() {
		return cmsLinkDao;
	}

	@Inject
	public void setCmsLinkDao(CmsLinkDao cmsLinkDao) {
		this.cmsLinkDao = cmsLinkDao;
	}

	@Override
	public void add(CmsLink cl) {
		cmsLinkDao.add(cl);
	}

	@Override
	public void delete(int id) {
		cmsLinkDao.delete(id);
	}

	@Override
	public void update(CmsLink cl) {
		cmsLinkDao.update(cl);
	}

	@Override
	public CmsLink load(int id) {
		return cmsLinkDao.load(id);
	}

	@Override
	public Pager<CmsLink> findByType(String type) {
		return cmsLinkDao.findByType(type);
	}

	@Override
	public List<CmsLink> listByType(String type) {
		return cmsLinkDao.listByType(type);
	}

	@Override
	public List<String> listAllType() {
		return cmsLinkDao.listAllType();
	}

	@Override
	public Map<String, Integer> getMinAndMaxPos() {
		return cmsLinkDao.getMinAndMaxPos();
	}

	@Override
	public void updatePos(int id, int oldPos, int newPos) {
		cmsLinkDao.updatePos(id, oldPos, newPos);
	}

}
