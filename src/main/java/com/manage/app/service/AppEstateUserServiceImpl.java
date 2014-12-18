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

import com.manage.app.bean.AppEstateUser;
import com.manage.app.dao.AppEstateUserDao;
import com.utis.Page;

@Service("AppEstateUserService")
@Transactional
public class AppEstateUserServiceImpl implements AppEstateUserService {
	
	private static Logger logger = LoggerFactory.getLogger(AppEstateUserServiceImpl.class);
	@Autowired
	private AppEstateUserDao appEstateUserDao;

	/**
	 * 删除AppEstateUser
	 * @param entity
	 * @return
	 * @throws GSSException
	 */
	@Transactional("transactionManager")
	public boolean delete(AppEstateUser entity) throws GSSException {
		try {
			return appEstateUserDao.delete(entity);
		} catch (GSSException e) {
			logger.debug("AppEstateUserServiceImpl：删除AppEstateUser发生错误！", e);
			e.printStackTrace();
		}
		return false;
	}
	/**
	 * 查询单个AppEstateUser
	 * @param entity
	 * @return
	 * @throws GSSException
	 */
	@Transactional(readOnly = true)
	public AppEstateUser findById(AppEstateUser entity) throws GSSException {
		try {
			entity = appEstateUserDao.get(entity);
		} catch (GSSException e) {
			logger.debug("AppEstateUserServiceImpl：查询单个AppEstateUser发生错误！", e);
			e.printStackTrace();
		}
		return entity;
	}
	/**
	 * 查询AppEstateUser列表展示数据
	 * @param page
	 * @return
	 * @throws GSSException
	 */
	@Transactional(readOnly = true)
	public Page findAllPage(Page page) throws GSSException {
		int count=appEstateUserDao.selectCount(page);
		List<AppEstateUser> list=appEstateUserDao.findAllPage(page);
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
	public void save(AppEstateUser entity) throws GSSException {
		try {
			appEstateUserDao.save(entity);
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
	public void Update(AppEstateUser entity) throws GSSException {
		try {
			appEstateUserDao.Update(entity);
		} catch (GSSException e) {
			logger.debug("BusinessMenuServiceImpl：修改BusinessMenu发生错误！", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 查看用户所属小区
	 * @param entity
	 * @return
	 * @throws GSSException
	 */
	@Transactional(readOnly = true)
	public List<AppEstateUser> estateUserList(AppEstateUser entity){
		List list=null;
		try {
			list = appEstateUserDao.estateUserList(entity);
		} catch (GSSException e) {
			logger.debug("AppEstateUserServiceImpl：查询单个AppEstateUser发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
}
