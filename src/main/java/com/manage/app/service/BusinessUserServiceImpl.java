package com.manage.app.service;

import java.util.HashMap;
import java.util.Iterator;
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

import com.manage.app.bean.BusinessUser;
import com.manage.app.bean.ManageFunction;
import com.manage.app.bean.ManageModule;
import com.manage.app.bean.ManageModulemenu;
import com.manage.app.bean.ManagePositionUser;
import com.manage.app.bean.ManageUserFunction;
import com.manage.app.dao.BusinessUserDao;
import com.manage.app.dao.ManageFunctionDao;
import com.manage.app.dao.ManageModuleDao;
import com.manage.app.dao.ManageModulemenuDao;
import com.manage.app.dao.ManageUserFunctionDao;
import com.manage.framework.exception.DaoException;
import com.utis.Page;

@Service("BusinessUserService")
@Transactional
public class BusinessUserServiceImpl implements BusinessUserService {
	
	private static Logger logger = LoggerFactory.getLogger(BusinessUserServiceImpl.class);
	//用户dao
	@Autowired
	private BusinessUserDao businessUserDao; 
	
	//用户权限dao
	@Autowired
	private ManageUserFunctionDao manageUserFunctionDao;
	
	//模版dao
	@Autowired
	private ManageModuleDao manageModuleDao;
	
	//模版菜单dao
	@Autowired
	private ManageModulemenuDao manageModulemenuDao;
	
	//权限dao
	@Autowired
	private ManageFunctionDao manageFunctionDao;
	

	
	@Transactional("transactionManager")
	public boolean delete(BusinessUser entity) throws GSSException {
		try {
			return businessUserDao.delete(entity);
		} catch (GSSException e) {
			logger.debug("BusinessUserServiceImpl：删除BusinessUser发生错误！", e);
			e.printStackTrace();
		}
		return false;
	}
	
	@Transactional(readOnly = true)
	public BusinessUser findById(BusinessUser entity) throws GSSException {
		try {
			entity = businessUserDao.get(entity);
		} catch (GSSException e) {
			logger.debug("BusinessUserServiceImpl：查询单个BusinessUser发生错误！", e);
			e.printStackTrace();
		}
		return entity;
	}
	public Page findAllPage(Page page) throws GSSException {
		int count=businessUserDao.selectCount(page);
		List<BusinessUser> list=businessUserDao.findAllPage(page);
		page.setTotalRow(count);
		page.setList(list);
		return page;
	}
	
	public void save(BusinessUser entity) throws GSSException {
		try {
			businessUserDao.save(entity);
		} catch (GSSException e) {
			logger.debug("BusinessMenuServiceImpl：保存BusinessMenu发生错误！", e);
			e.printStackTrace();
		}
		
	}
	
	public void saveJOB(BusinessUser entity) throws GSSException {
		try {
			businessUserDao.updatePosition(entity);
		} catch (GSSException e) {
			logger.debug("BusinessMenuServiceImpl：删除deleteManagePositionUserAll发生错误！", e);
			e.printStackTrace();
		}		
		
	}

	public void Update(BusinessUser entity) throws GSSException {
		try {
			businessUserDao.Update(entity);
		} catch (GSSException e) {
			logger.debug("BusinessMenuServiceImpl：修改BusinessMenu发生错误！", e);
			e.printStackTrace();
		}
	}

	public List<ManagePositionUser> selectManagePositionUser(BusinessUser entity)
			throws GSSException {
		List list=null;
		try {
			list = businessUserDao.selectManagePositionUser(entity);
		} catch (GSSException e) {
			logger.debug("BusinessUserServiceImpl：查询ManagePositionUser发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}


	public void isCharge(BusinessUser entity) throws GSSException {
		try {
			businessUserDao.noIsCharge(entity);
			businessUserDao.isCharge(entity);
		} catch (GSSException e) {
			logger.debug("BusinessMenuServiceImpl：保存ManagePositionUser发生错误！", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 获取用户已拥有权限和用户所属机构全部权限
	 * @param entity
	 * @throws GSSException
	 */
	public Map getFunction(BusinessUser entity) throws GSSException {
		Map map = new HashMap();
		try {
			List<ManageModule> moduleList=manageModuleDao.findOrgTypeAll(entity.getOrgType());
			for (ManageModule manageModule : moduleList) {
				Map moduleMap = new HashMap();
				moduleMap.put("moduleId", manageModule.getModuleId());
				moduleMap.put("moduleCode", manageModule.getModuleCode());
				moduleMap.put("moduleName", manageModule.getModuleName());
				Map menuMap = new HashMap();
				ManageUserFunction manageUserFunction = new ManageUserFunction();
				manageUserFunction.setUserId(entity.getUserId());
				manageUserFunction.setModuleCode(manageModule.getModuleCode());
				List<ManageUserFunction> UserFunctionList = manageUserFunctionDao.findByUserIdModule(manageUserFunction);
				moduleMap.put("checkedList", UserFunctionList);
				List<ManageModulemenu> moduleMenuList=manageModulemenuDao.findByIdModuleId(manageModule.getModuleId());
				for (ManageModulemenu manageModulemenu : moduleMenuList) {
					Map moduleMenuMap = new HashMap();
					moduleMenuMap.put("menuId",manageModulemenu.getMenuId());
					moduleMenuMap.put("menuMame",manageModulemenu.getName());
					List<ManageFunction> manageFunctionList=manageFunctionDao.findById(manageModulemenu.getMenuId());
					moduleMenuMap.put("List", manageFunctionList);
					menuMap.put(moduleMenuMap, moduleMenuMap);
				}
				moduleMap.put("menuMap", menuMap);
				map.put(moduleMap, moduleMap);
			}
		} catch (DaoException e) {
			logger.debug("BusinessMenuServiceImpl：保存ManagePositionUser发生错误！", e);
			e.printStackTrace();
		}
		return map;
	}
	
	
	
}
