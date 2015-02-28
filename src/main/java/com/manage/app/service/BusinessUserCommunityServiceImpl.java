package com.manage.app.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.manage.app.bean.BusinessUserCommunity;
import com.manage.app.dao.BusinessUserCommunityDao;
import com.manage.app.vo.BaseBean;
import com.manage.app.vo.BusinessUserCommunityQuery;
import com.manage.framework.exception.DaoException;
import com.manage.framework.exception.ServiceException;

@Service("BusinessUserCommunityService")
@Transactional
public class BusinessUserCommunityServiceImpl implements BusinessUserCommunityService {
	
	private static Logger logger = LoggerFactory.getLogger(BusinessUserCommunityServiceImpl.class);
	@Autowired
	private BusinessUserCommunityDao businessUserCommunityDao;

	/**
	 * 查询单个BusinessUserCommunity
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public BusinessUserCommunity findById(final Integer id) throws ServiceException {
		BusinessUserCommunity businessUserCommunity = new BusinessUserCommunity();
		try {
			businessUserCommunity = businessUserCommunityDao.findById(id);
		} catch (DaoException e) {
			logger.debug("BusinessUserCommunityServiceImpl findById()：查询单个BusinessUserCommunity发生错误！", e);
			e.printStackTrace();
		}
		return businessUserCommunity;
	}
	
	/**
	 * 无条件查询所有BusinessUserCommunity
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public List<BusinessUserCommunity> findAll() throws ServiceException {
		List<BusinessUserCommunity> list = new ArrayList<BusinessUserCommunity>() ;
		try {
			list=businessUserCommunityDao.findAll();
		} catch (DaoException e) {
			logger.debug("BusinessUserCommunityServiceImpl findAll()：无条件查询所有BusinessUserCommunity发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessUserCommunity
	 * @param paramMap
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<BusinessUserCommunity> findByMap(final Map paramMap) throws ServiceException {
		List<BusinessUserCommunity> list = new ArrayList<BusinessUserCommunity>() ;
		try {
			list=businessUserCommunityDao.findByMap(paramMap);
		} catch (DaoException e) {
			logger.debug("BusinessUserCommunityServiceImpl findByMap()：按Map对象条件查询所有BusinessUserCommunity发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessUserCommunity-限制返回条数
	 * @param paramMap
	 * @return
	 * @throws ServiceException
	 */	
	/*@Transactional(readOnly = true)
	public List<BusinessUserCommunity> findByMap(final Map paramMap, final Integer limit) throws ServiceException {
		List<BusinessUserCommunity> list = new ArrayList<BusinessUserCommunity>() ;
		try {
			list=businessUserCommunityDao.findByMap(paramMap, limit);
		} catch (DaoException e) {
			logger.debug("BusinessUserCommunityServiceImpl findByMap()：按Map对象条件查询所有BusinessUserCommunity-限制返回条数发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}*/
	
	/**
	 * 按VO对象条件查询所有BusinessUserCommunity
	 * @param query
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<BusinessUserCommunity> findByExample(final BusinessUserCommunityQuery query) throws ServiceException {
		List<BusinessUserCommunity> list = new ArrayList<BusinessUserCommunity>() ;
		try {
			list=businessUserCommunityDao.findByExample(query);
		} catch (DaoException e) {
			logger.debug("BusinessUserCommunityServiceImpl findByExample()：按VO对象条件查询所有BusinessUserCommunity发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有BusinessUserCommunity-限制返回条数
	 * @param query
	 * @return
	 * @throws ServiceException
	 */	
	/*@Transactional(readOnly = true)
	public List<BusinessUserCommunity> findByExample(final BusinessUserCommunityQuery query, final Integer limit) throws ServiceException {
		List<BusinessUserCommunity> list = new ArrayList<BusinessUserCommunity>() ;
		try {
			list=businessUserCommunityDao.findByExample(query, limit);
		} catch (DaoException e) {
			logger.debug("BusinessUserCommunityServiceImpl findByExample()：按VO对象条件查询所有BusinessUserCommunity-限制返回条数发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}*/
	
	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public BaseBean findAllPage(final BusinessUserCommunityQuery query) throws ServiceException {
		List<BusinessUserCommunity> list = new ArrayList<BusinessUserCommunity>() ;
		int count=0;
		BaseBean baseBean = new BaseBean();
		try {
			count=businessUserCommunityDao.selectCount(query);
			query.setCount(count);
			list=businessUserCommunityDao.findAllPage(query);
		} catch (DaoException e) {
			logger.debug("BusinessUserCommunityServiceImpl findAllPage()：根据搜索条件，搜索分页数据发生错误！", e);
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
	public int selectCount(final BusinessUserCommunityQuery query) throws ServiceException {
		int count = 0;
		try {
			count = businessUserCommunityDao.selectCount(query);
		} catch (DaoException e) {
			logger.debug("BusinessUserCommunityServiceImpl selectCount()：根据搜索条件，搜索分页总数发生错误！", e);
			e.printStackTrace();
		}
		return count;
	}
	
	/**
	 * 保存BusinessUserCommunity数据
	 * @param entity
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public void save(BusinessUserCommunity entity) throws ServiceException {
		try {
			businessUserCommunityDao.save(entity);
		} catch (DaoException e) {
			logger.debug("BusinessUserCommunityServiceImpl save()：保存BusinessUserCommunity发生错误！", e);
			e.printStackTrace();
		}
	}

	/**
	 * 修改BusinessUserCommunity数据
	 * @param entity
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public void update(BusinessUserCommunity entity) throws ServiceException {
		try {
			businessUserCommunityDao.update(entity);
		} catch (DaoException e) {
			logger.debug("BusinessUserCommunityServiceImpl update()：修改BusinessUserCommunity发生错误！", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 删除BusinessUserCommunity
	 * @param entityId
	 * @return
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public boolean delete(Integer id) throws ServiceException {
		try {
			return businessUserCommunityDao.delete(id);
		} catch (DaoException e) {
			logger.debug("BusinessUserCommunityServiceImpl delete()：删除BusinessUserCommunity发生错误！", e);
			e.printStackTrace();
		}
		return false;
	}
	
	/**
	 * 根据搜索条件，搜索分页所需的数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public BaseBean findAllPageByField(final Map fieldMap, final BusinessUserCommunityQuery query) throws ServiceException {
		List<BusinessUserCommunity> list = new ArrayList<BusinessUserCommunity>() ;
		int count=0;
		BaseBean baseBean = new BaseBean();
		try {
			count=businessUserCommunityDao.selectCount(query);
			query.setCount(count);
			list=businessUserCommunityDao.findAllPageByField(fieldMap, query);
		} catch (DaoException e) {
			logger.debug("BusinessUserCommunityServiceImpl findAllPageByField()：根据搜索条件，根据搜索条件，搜索分页所需的数据发生错误！", e);
			e.printStackTrace();
		}
		baseBean.setList(list);
		baseBean.setCount(count);
		return baseBean;
	}
	
	/**
	 * 根据条件查询所需字段，返回列表
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public List findListByField(final Map fieldMap, final BusinessUserCommunityQuery query) throws ServiceException {
		List<BusinessUserCommunity> list = new ArrayList<BusinessUserCommunity>() ;
		try {
			list=businessUserCommunityDao.findListByField(fieldMap, query);
		} catch (DaoException e) {
			logger.debug("BusinessUserCommunityServiceImpl findListByField()：根据条件查询所需字段，返回列表发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 根据条件查询所需字段，返回对象
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public BusinessUserCommunity findByField(final Map fieldMap, final Integer id) throws ServiceException {
		BusinessUserCommunity businessUserCommunity = new BusinessUserCommunity();
		try {
			businessUserCommunity = businessUserCommunityDao.findByField(fieldMap, id);
		} catch (DaoException e) {
			logger.debug("BusinessUserCommunityServiceImpl findByField()：根据条件查询所需字段，返回对象发生错误！", e);
			e.printStackTrace();
		}
		return businessUserCommunity;
	}
	
	/**
	 * 删除用户下的社区关系
	 * @param entityId
	 * @return
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public boolean deleteCommunity(Integer userId) throws ServiceException {
		try {
			return businessUserCommunityDao.deleteCommunity(userId);
		} catch (DaoException e) {
			logger.debug("BusinessUserCommunityServiceImpl delete()：删除用户下的社区关系发生错误！", e);
			e.printStackTrace();
		}
		return false;
	}
	
}
