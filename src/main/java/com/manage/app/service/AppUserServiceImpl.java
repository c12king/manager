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

import com.manage.app.bean.AppUser;
import com.manage.app.dao.AppUserDao;
import com.utis.Page;

@Service("AppUserService")
@Transactional
public class AppUserServiceImpl implements AppUserService {
	
	private static Logger logger = LoggerFactory.getLogger(AppUserServiceImpl.class);
	@Autowired
	private AppUserDao appUserDao;

	/**
	 * 删除AppUser
	 * @param entity
	 * @return
	 * @throws GSSException
	 */
	@Transactional("transactionManager")
	public boolean delete(AppUser entity) throws GSSException {
		try {
			return appUserDao.delete(entity);
		} catch (GSSException e) {
			logger.debug("AppUserServiceImpl：删除AppUser发生错误！", e);
			e.printStackTrace();
		}
		return false;
	}
	/**
	 * 查询单个AppUser
	 * @param entity
	 * @return
	 * @throws GSSException
	 */
	@Transactional(readOnly = true)
	public AppUser findById(AppUser entity) throws GSSException {
		try {
			entity = appUserDao.get(entity);
		} catch (GSSException e) {
			logger.debug("AppUserServiceImpl：查询单个AppUser发生错误！", e);
			e.printStackTrace();
		}
		return entity;
	}
	/**
	 * 查询AppUser列表展示数据
	 * @param page
	 * @return
	 * @throws GSSException
	 */
	@Transactional(readOnly = true)
	public Page findAllPage(Page page) throws GSSException {
		int count=appUserDao.selectCount(page);
		List<AppUser> list=appUserDao.findAllPage(page);
		page.setTotalRow(count);
		page.setList(list);
		return page;
	}
	/**
	 * 保存BusinessMenu数据
	 * @param entity
	 * @throws GSSException
	 */
	@Transactional("transactionManager")
	public void save(AppUser entity) throws GSSException {
		try {
			appUserDao.save(entity);
		} catch (GSSException e) {
			logger.debug("BusinessMenuServiceImpl：保存BusinessMenu发生错误！", e);
			e.printStackTrace();
		}
		
	}
	/**
	 * 修改BusinessMenu数据
	 * @param entity
	 * @throws GSSException
	 */
	@Transactional("transactionManager")
	public void Update(AppUser entity) throws GSSException {
		try {
			appUserDao.Update(entity);
		} catch (GSSException e) {
			logger.debug("BusinessMenuServiceImpl：修改BusinessMenu发生错误！", e);
			e.printStackTrace();
		}
	}
	
	
	
}
