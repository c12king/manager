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

import com.manage.app.bean.ManageFunction;
import com.manage.app.dao.ManageFunctionDao;
import com.utis.Page;

@Service("ManageFunctionService")
@Transactional
public class ManageFunctionServiceImpl implements ManageFunctionService {
	
	private static Logger logger = LoggerFactory.getLogger(ManageFunctionServiceImpl.class);
	@Autowired
	private ManageFunctionDao manageFunctionDao;

	
	@Transactional("transactionManager")
	public boolean delete(ManageFunction entity) throws GSSException {
		try {
			return manageFunctionDao.delete(entity);
		} catch (GSSException e) {
			logger.debug("ManageFunctionServiceImpl：删除ManageFunction发生错误！", e);
			e.printStackTrace();
		}
		return false;
	}
	
	@Transactional(readOnly = true)
	public ManageFunction findById(ManageFunction entity) throws GSSException {
		try {
			entity = manageFunctionDao.get(entity);
		} catch (GSSException e) {
			logger.debug("ManageFunctionServiceImpl：查询单个ManageFunction发生错误！", e);
			e.printStackTrace();
		}
		return entity;
	}
	public Page findAllPage(Page page) throws GSSException {
		int count=manageFunctionDao.selectCount(page);
		List<ManageFunction> list=manageFunctionDao.findAllPage(page);
		page.setTotalRow(count);
		page.setList(list);
		return page;
	}
	
	public void save(ManageFunction entity) throws GSSException {
		try {
			manageFunctionDao.save(entity);
		} catch (GSSException e) {
			logger.debug("BusinessMenuServiceImpl：保存BusinessMenu发生错误！", e);
			e.printStackTrace();
		}
		
	}

	public void Update(ManageFunction entity) throws GSSException {
		try {
			manageFunctionDao.Update(entity);
		} catch (GSSException e) {
			logger.debug("BusinessMenuServiceImpl：修改BusinessMenu发生错误！", e);
			e.printStackTrace();
		}
	}
	
	
	
}
