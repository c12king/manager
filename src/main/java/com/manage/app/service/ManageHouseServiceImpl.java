package com.manage.app.service;

import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.ietf.jgss.GSSException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.manage.app.bean.ManageHouse;
import com.manage.app.dao.ManageHouseDao;
import com.utis.Page;

@Service("ManageHouseService")
@Transactional
public class ManageHouseServiceImpl implements ManageHouseService {
	
	private static Logger logger = LoggerFactory.getLogger(ManageHouseServiceImpl.class);
	@Autowired
	private ManageHouseDao manageHouseDao;

	
	@Transactional("transactionManager")
	public boolean delete(ManageHouse entity) throws GSSException {
		try {
			return manageHouseDao.delete(entity);
		} catch (GSSException e) {
			logger.debug("ManageHouseServiceImpl：删除ManageHouse发生错误！", e);
			e.printStackTrace();
		}
		return false;
	}
	
	@Transactional(readOnly = true)
	public ManageHouse findById(ManageHouse entity) throws GSSException {
		try {
			entity = manageHouseDao.get(entity);
		} catch (GSSException e) {
			logger.debug("ManageHouseServiceImpl：查询单个ManageHouse发生错误！", e);
			e.printStackTrace();
		}
		return entity;
	}
	public Page findAllPage(Page page) throws GSSException {
		int count=manageHouseDao.selectCount(page);
		List<ManageHouse> list=manageHouseDao.findAllPage(page);
		page.setTotalRow(count);
		page.setList(list);
		return page;
	}
	
	public void save(ManageHouse entity) throws GSSException {
		try {
			manageHouseDao.save(entity);
		} catch (GSSException e) {
			logger.debug("BusinessMenuServiceImpl：保存BusinessMenu发生错误！", e);
			e.printStackTrace();
		}
		
	}

	public void Update(ManageHouse entity) throws GSSException {
		try {
			manageHouseDao.Update(entity);
		} catch (GSSException e) {
			logger.debug("BusinessMenuServiceImpl：修改BusinessMenu发生错误！", e);
			e.printStackTrace();
		}
	}
	
	
	
}
