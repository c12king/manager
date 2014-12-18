package com.manage.app.service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.ietf.jgss.GSSException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.manage.app.vo.BaseBean;
import com.manage.framework.exception.ServiceException;
import com.manage.framework.exception.DaoException;

import com.manage.app.vo.BusinessUserResourceQuery;
import com.manage.app.bean.BusinessUserResource;
import com.manage.app.bean.ManageEstate;
import com.manage.app.dao.BusinessUserResourceDao;
import com.manage.app.dao.ManageEstateDao;

@Service("BusinessUserResourceService")
@Transactional
public class BusinessUserResourceServiceImpl implements BusinessUserResourceService {
	
	private static Logger logger = LoggerFactory.getLogger(BusinessUserResourceServiceImpl.class);
	@Autowired
	private BusinessUserResourceDao businessUserResourceDao;
	@Autowired
	private ManageEstateDao manageEstateDao;
	/**
	 * 查询单个BusinessUserResource
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public BusinessUserResource findById(final Integer id) throws ServiceException {
		BusinessUserResource businessUserResource = new BusinessUserResource();
		try {
			businessUserResource = businessUserResourceDao.findById(id);
		} catch (DaoException e) {
			logger.debug("BusinessUserResourceServiceImpl findById()：查询单个BusinessUserResource发生错误！", e);
			e.printStackTrace();
		}
		return businessUserResource;
	}
	
	/**
	 * 无条件查询所有BusinessUserResource
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public List<BusinessUserResource> findAll() throws ServiceException {
		List<BusinessUserResource> list = new ArrayList<BusinessUserResource>() ;
		try {
			list=businessUserResourceDao.findAll();
		} catch (DaoException e) {
			logger.debug("BusinessUserResourceServiceImpl findAll()：无条件查询所有BusinessUserResource发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessUserResource
	 * @param paramMap
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<BusinessUserResource> findByMap(final Map paramMap) throws ServiceException {
		List<BusinessUserResource> list = new ArrayList<BusinessUserResource>() ;
		try {
			list=businessUserResourceDao.findByMap(paramMap);
		} catch (DaoException e) {
			logger.debug("BusinessUserResourceServiceImpl findByMap()：按Map对象条件查询所有BusinessUserResource发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessUserResource-限制返回条数
	 * @param paramMap
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<BusinessUserResource> findByMap(final Map paramMap, final Integer limit) throws ServiceException {
		List<BusinessUserResource> list = new ArrayList<BusinessUserResource>() ;
		try {
			list=businessUserResourceDao.findByMap(paramMap, limit);
		} catch (DaoException e) {
			logger.debug("BusinessUserResourceServiceImpl findByMap()：按Map对象条件查询所有BusinessUserResource-限制返回条数发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有BusinessUserResource
	 * @param query
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<BusinessUserResource> findByExample(final BusinessUserResourceQuery query) throws ServiceException {
		List<BusinessUserResource> list = new ArrayList<BusinessUserResource>() ;
		try {
			list=businessUserResourceDao.findByExample(query);
		} catch (DaoException e) {
			logger.debug("BusinessUserResourceServiceImpl findByExample()：按VO对象条件查询所有BusinessUserResource发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有BusinessUserResource-限制返回条数
	 * @param query
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<BusinessUserResource> findByExample(final BusinessUserResourceQuery query, final Integer limit) throws ServiceException {
		List<BusinessUserResource> list = new ArrayList<BusinessUserResource>() ;
		try {
			list=businessUserResourceDao.findByExample(query, limit);
		} catch (DaoException e) {
			logger.debug("BusinessUserResourceServiceImpl findByExample()：按VO对象条件查询所有BusinessUserResource-限制返回条数发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public BaseBean findAllPage(final BusinessUserResourceQuery query) throws ServiceException {
		List<BusinessUserResource> list = new ArrayList<BusinessUserResource>() ;
		int count=0;
		BaseBean baseBean = new BaseBean();
		try {
			list=businessUserResourceDao.findAllPage(query);
			count=businessUserResourceDao.selectCount(query);
		} catch (DaoException e) {
			logger.debug("BusinessUserResourceServiceImpl findAllPage()：根据搜索条件，搜索分页数据发生错误！", e);
			e.printStackTrace();
		}
		//baseBean.setLsit(list);
		baseBean.setCount(count);
		return baseBean;
	}
	
	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public int selectCount(final BusinessUserResourceQuery query) throws ServiceException {
		int count = 0;
		try{
			count = businessUserResourceDao.selectCount(query);
		} catch (DaoException e) {
			logger.debug("BusinessUserResourceServiceImpl selectCount()：根据搜索条件，搜索分页总数发生错误！", e);
			e.printStackTrace();
		}
		return count;
	}
	
	/**
	 * 保存BusinessUserResource数据
	 * @param entity
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public void save(BusinessUserResource entity) throws ServiceException {
		try {
			businessUserResourceDao.save(entity);
		} catch (DaoException e) {
			logger.debug("BusinessUserResourceServiceImpl save()：保存BusinessUserResource发生错误！", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 保存BusinessUserResource数据
	 * @param entity
	 * @throws ServiceException
	 */
	public void save_resources(int userId,String [] comId,String [] estateId) throws ServiceException {
		BusinessUserResource businessUserResource = new BusinessUserResource();
		try {
			businessUserResourceDao.delete(userId);
			businessUserResource.setUserId(userId);
	        Timestamp  ts=new Timestamp(new Date().getTime());
	        businessUserResource.setCreateTime(ts);
	        businessUserResource.setEditTime(ts);
	        businessUserResource.setEstateId(0);
	        businessUserResource.setComId(0);
	        if(estateId!=null){
	        	for (String string : estateId) {
	 	        	businessUserResource.setEstateId(new Integer(string));
	 	        	ManageEstate manageEstate;
					try {
						manageEstate = manageEstateDao.selectSingleManageById(new Integer(string));
						businessUserResource.setEstateName(manageEstate.getEstateName());
		 	        	businessUserResourceDao.save(businessUserResource);
					} catch (GSSException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	 	        	
	 			}
	        }
	        if(comId!=null){
	        	for (String string : comId) {
		        	businessUserResource.setComId(new Integer(string));
		        	businessUserResourceDao.save(businessUserResource);
				}	
	        }
		} catch (DaoException e) {
			logger.debug("BusinessUserResourceServiceImpl save()：保存BusinessUserResource发生错误！", e);
			e.printStackTrace();
		}
	}

	/**
	 * 修改BusinessUserResource数据
	 * @param entity
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public void update(BusinessUserResource entity) throws ServiceException {
		try {
			businessUserResourceDao.update(entity);
		} catch (DaoException e) {
			logger.debug("BusinessUserResourceServiceImpl update()：修改BusinessUserResource发生错误！", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 删除BusinessUserResource
	 * @param entityId
	 * @return
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public boolean delete(Integer id) throws ServiceException {
		try {
			return businessUserResourceDao.delete(id);
		} catch (DaoException e) {
			logger.debug("BusinessUserResourceServiceImpl delete()：删除BusinessUserResource发生错误！", e);
			e.printStackTrace();
		}
		return false;
	}
	
}
