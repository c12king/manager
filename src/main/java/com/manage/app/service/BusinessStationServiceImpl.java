package com.manage.app.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.manage.app.vo.BaseBean;
import com.manage.framework.exception.ServiceException;
import com.manage.framework.exception.DaoException;
import com.manage.app.vo.BusinessStationQuery;
import com.manage.app.bean.BusinessProperty;
import com.manage.app.bean.BusinessStation;
import com.manage.app.dao.BusinessStationDao;

@Service("BusinessStationService")
@Transactional
public class BusinessStationServiceImpl implements BusinessStationService {
	
	private static Logger logger = LoggerFactory.getLogger(BusinessStationServiceImpl.class);
	@Autowired
	private BusinessStationDao businessStationDao;

	/**
	 * 查询单个BusinessStation
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public BusinessStation findById(final Integer id) throws ServiceException {
		BusinessStation businessStation = new BusinessStation();
		try {
			businessStation = businessStationDao.findById(id);
		} catch (DaoException e) {
			logger.debug("BusinessStationServiceImpl findById()：查询单个BusinessStation发生错误！", e);
			e.printStackTrace();
		}
		return businessStation;
	}
	
	/**
	 * 无条件查询所有BusinessStation
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public List<BusinessStation> findAll() throws ServiceException {
		List<BusinessStation> list = new ArrayList<BusinessStation>() ;
		try {
			list=businessStationDao.findAll();
		} catch (DaoException e) {
			logger.debug("BusinessStationServiceImpl findAll()：无条件查询所有BusinessStation发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessStation
	 * @param paramMap
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<BusinessStation> findByMap(final Map paramMap) throws ServiceException {
		List<BusinessStation> list = new ArrayList<BusinessStation>() ;
		try {
			list=businessStationDao.findByMap(paramMap);
		} catch (DaoException e) {
			logger.debug("BusinessStationServiceImpl findByMap()：按Map对象条件查询所有BusinessStation发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessStation-限制返回条数
	 * @param paramMap
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<BusinessStation> findByMap(final Map paramMap, final Integer limit) throws ServiceException {
		List<BusinessStation> list = new ArrayList<BusinessStation>() ;
		try {
			list=businessStationDao.findByMap(paramMap, limit);
		} catch (DaoException e) {
			logger.debug("BusinessStationServiceImpl findByMap()：按Map对象条件查询所有BusinessStation-限制返回条数发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有BusinessStation
	 * @param query
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<BusinessStation> findByExample(final BusinessStationQuery query) throws ServiceException {
		List<BusinessStation> list = new ArrayList<BusinessStation>() ;
		try {
			list=businessStationDao.findByExample(query);
		} catch (DaoException e) {
			logger.debug("BusinessStationServiceImpl findByExample()：按VO对象条件查询所有BusinessStation发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有BusinessStation-限制返回条数
	 * @param query
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<BusinessStation> findByExample(final BusinessStationQuery query, final Integer limit) throws ServiceException {
		List<BusinessStation> list = new ArrayList<BusinessStation>() ;
		try {
			list=businessStationDao.findByExample(query, limit);
		} catch (DaoException e) {
			logger.debug("BusinessStationServiceImpl findByExample()：按VO对象条件查询所有BusinessStation-限制返回条数发生错误！", e);
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
	public BaseBean findAllPage(final BusinessStationQuery query) throws ServiceException {
		List<BusinessStation> list = new ArrayList<BusinessStation>() ;
		int count=0;
		BaseBean baseBean = new BaseBean();
		try {
			list=businessStationDao.findAllPage(query);
			count=businessStationDao.selectCount(query);
		} catch (DaoException e) {
			logger.debug("BusinessStationServiceImpl findAllPage()：根据搜索条件，搜索分页数据发生错误！", e);
			e.printStackTrace();
		}
		baseBean.setList(list);
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
	public int selectCount(final BusinessStationQuery query) throws ServiceException {
		int count = 0;
		try {
			count = businessStationDao.selectCount(query);
		} catch (DaoException e) {
			logger.debug("BusinessStationServiceImpl selectCount()：根据搜索条件，搜索分页总数发生错误！", e);
			e.printStackTrace();
		}
		return count;
	}
	
	/**
	 * 保存BusinessStation数据
	 * @param entity
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public void save(BusinessStation entity) throws ServiceException {
		try {
			businessStationDao.save(entity);
		} catch (DaoException e) {
			logger.debug("BusinessStationServiceImpl save()：保存BusinessStation发生错误！", e);
			e.printStackTrace();
		}
	}

	/**
	 * 修改BusinessStation数据
	 * @param entity
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public void update(BusinessStation entity) throws ServiceException {
		try {
			businessStationDao.update(entity);
		} catch (DaoException e) {
			logger.debug("BusinessStationServiceImpl update()：修改BusinessStation发生错误！", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 删除BusinessStation
	 * @param entityId
	 * @return
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public boolean delete(Integer id) throws ServiceException {
		try {
			return businessStationDao.delete(id);
		} catch (DaoException e) {
			logger.debug("BusinessStationServiceImpl delete()：删除BusinessStation发生错误！", e);
			e.printStackTrace();
		}
		return false;
	}
	
	/**
	 * 获取该区域下驿站下拉菜单json
	 * @param request
	 * @param response
	 * @param Menu
	 * @return
	 */
	public String getComboboxData(final Integer countyId) throws ServiceException{
		// TODO Auto-generated method stub
		String json="";
		List<BusinessStation> list=null;
		try {
			list=businessStationDao.getComboboxData(countyId);
		} catch (DaoException e) {
			logger.debug("BusinessStationServiceImpl getComboboxData()：获取该区域下驿站下拉菜单json发生错误！", e);
			e.printStackTrace();
		}
		StringBuilder result = new StringBuilder();
		result.append("[");
		for (BusinessStation businessStation : list) {
			result.append("{");
			result.append("\"label\":").append(businessStation.getStationId()).append(",");
			result.append("\"value\":").append("\""+businessStation.getStaName()+"\"");
			result.append("},");
		}
		json = result.toString();
		if(list.size() > 0) {
			json = json.substring(0, json.length()-1);
		}
		json += "]";
		return json;
	}
	
}
