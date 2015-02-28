package com.manage.app.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.manage.app.bean.BusinessRoleFunction;
import com.manage.app.dao.BusinessRoleFunctionDao;
import com.manage.app.vo.BaseBean;
import com.manage.app.vo.BusinessRoleFunctionQuery;
import com.manage.framework.exception.DaoException;
import com.manage.framework.exception.ServiceException;

@Service("BusinessRoleFunctionService")
@Transactional
public class BusinessRoleFunctionServiceImpl implements BusinessRoleFunctionService {
	
	private static Logger logger = LoggerFactory.getLogger(BusinessRoleFunctionServiceImpl.class);
	@Autowired
	private BusinessRoleFunctionDao businessRoleFunctionDao;

	/**
	 * 查询单个BusinessRoleFunction
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public BusinessRoleFunction findById(final Integer id) throws ServiceException {
		BusinessRoleFunction businessRoleFunction = new BusinessRoleFunction();
		try {
			businessRoleFunction = businessRoleFunctionDao.findById(id);
		} catch (DaoException e) {
			logger.debug("BusinessRoleFunctionServiceImpl findById()：查询单个BusinessRoleFunction发生错误！", e);
			e.printStackTrace();
		}
		return businessRoleFunction;
	}
	
	/**
	 * 无条件查询所有BusinessRoleFunction
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public List<BusinessRoleFunction> findAll() throws ServiceException {
		List<BusinessRoleFunction> list = new ArrayList<BusinessRoleFunction>() ;
		try {
			list=businessRoleFunctionDao.findAll();
		} catch (DaoException e) {
			logger.debug("BusinessRoleFunctionServiceImpl findAll()：无条件查询所有BusinessRoleFunction发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessRoleFunction
	 * @param paramMap
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<BusinessRoleFunction> findByMap(final Map paramMap) throws ServiceException {
		List<BusinessRoleFunction> list = new ArrayList<BusinessRoleFunction>() ;
		try {
			list=businessRoleFunctionDao.findByMap(paramMap);
		} catch (DaoException e) {
			logger.debug("BusinessRoleFunctionServiceImpl findByMap()：按Map对象条件查询所有BusinessRoleFunction发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessRoleFunction-限制返回条数
	 * @param paramMap
	 * @return
	 * @throws ServiceException
	 */	
	/*@Transactional(readOnly = true)
	public List<BusinessRoleFunction> findByMap(final Map paramMap, final Integer limit) throws ServiceException {
		List<BusinessRoleFunction> list = new ArrayList<BusinessRoleFunction>() ;
		try {
			list=businessRoleFunctionDao.findByMap(paramMap, limit);
		} catch (DaoException e) {
			logger.debug("BusinessRoleFunctionServiceImpl findByMap()：按Map对象条件查询所有BusinessRoleFunction-限制返回条数发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}*/
	
	/**
	 * 按VO对象条件查询所有BusinessRoleFunction
	 * @param query
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<BusinessRoleFunction> findByExample(final BusinessRoleFunctionQuery query) throws ServiceException {
		List<BusinessRoleFunction> list = new ArrayList<BusinessRoleFunction>() ;
		try {
			list=businessRoleFunctionDao.findByExample(query);
		} catch (DaoException e) {
			logger.debug("BusinessRoleFunctionServiceImpl findByExample()：按VO对象条件查询所有BusinessRoleFunction发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有BusinessRoleFunction-限制返回条数
	 * @param query
	 * @return
	 * @throws ServiceException
	 */	
	/*@Transactional(readOnly = true)
	public List<BusinessRoleFunction> findByExample(final BusinessRoleFunctionQuery query, final Integer limit) throws ServiceException {
		List<BusinessRoleFunction> list = new ArrayList<BusinessRoleFunction>() ;
		try {
			list=businessRoleFunctionDao.findByExample(query, limit);
		} catch (DaoException e) {
			logger.debug("BusinessRoleFunctionServiceImpl findByExample()：按VO对象条件查询所有BusinessRoleFunction-限制返回条数发生错误！", e);
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
	public BaseBean findAllPage(final BusinessRoleFunctionQuery query) throws ServiceException {
		List<BusinessRoleFunction> list = new ArrayList<BusinessRoleFunction>() ;
		int count=0;
		BaseBean baseBean = new BaseBean();
		try {
			count=businessRoleFunctionDao.selectCount(query);
			query.setCount(count);
			list=businessRoleFunctionDao.findAllPage(query);
		} catch (DaoException e) {
			logger.debug("BusinessRoleFunctionServiceImpl findAllPage()：根据搜索条件，搜索分页数据发生错误！", e);
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
	public int selectCount(final BusinessRoleFunctionQuery query) throws ServiceException {
		int count = 0;
		try {
			count = businessRoleFunctionDao.selectCount(query);
		} catch (DaoException e) {
			logger.debug("BusinessRoleFunctionServiceImpl selectCount()：根据搜索条件，搜索分页总数发生错误！", e);
			e.printStackTrace();
		}
		return count;
	}
	
	/**
	 * 保存BusinessRoleFunction数据
	 * @param entity
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public void save(BusinessRoleFunction entity) throws ServiceException {
		try {
			businessRoleFunctionDao.save(entity);
		} catch (DaoException e) {
			logger.debug("BusinessRoleFunctionServiceImpl save()：保存BusinessRoleFunction发生错误！", e);
			e.printStackTrace();
		}
	}

	/**
	 * 修改BusinessRoleFunction数据
	 * @param entity
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public void update(BusinessRoleFunction entity) throws ServiceException {
		try {
			businessRoleFunctionDao.update(entity);
		} catch (DaoException e) {
			logger.debug("BusinessRoleFunctionServiceImpl update()：修改BusinessRoleFunction发生错误！", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 删除BusinessRoleFunction
	 * @param entityId
	 * @return
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public boolean delete(Integer id) throws ServiceException {
		try {
			return businessRoleFunctionDao.delete(id);
		} catch (DaoException e) {
			logger.debug("BusinessRoleFunctionServiceImpl delete()：删除BusinessRoleFunction发生错误！", e);
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
	public BaseBean findAllPageByField(final Map fieldMap, final BusinessRoleFunctionQuery query) throws ServiceException {
		List<BusinessRoleFunction> list = new ArrayList<BusinessRoleFunction>() ;
		int count=0;
		BaseBean baseBean = new BaseBean();
		try {
			count=businessRoleFunctionDao.selectCount(query);
			query.setCount(count);
			list=businessRoleFunctionDao.findAllPageByField(fieldMap, query);
		} catch (DaoException e) {
			logger.debug("BusinessRoleFunctionServiceImpl findAllPageByField()：根据搜索条件，根据搜索条件，搜索分页所需的数据发生错误！", e);
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
	public List findListByField(final Map fieldMap, final BusinessRoleFunctionQuery query) throws ServiceException {
		List<BusinessRoleFunction> list = new ArrayList<BusinessRoleFunction>() ;
		try {
			list=businessRoleFunctionDao.findListByField(fieldMap, query);
		} catch (DaoException e) {
			logger.debug("BusinessRoleFunctionServiceImpl findListByField()：根据条件查询所需字段，返回列表发生错误！", e);
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
	public BusinessRoleFunction findByField(final Map fieldMap, final Integer id) throws ServiceException {
		BusinessRoleFunction businessRoleFunction = new BusinessRoleFunction();
		try {
			businessRoleFunction = businessRoleFunctionDao.findByField(fieldMap, id);
		} catch (DaoException e) {
			logger.debug("BusinessRoleFunctionServiceImpl findByField()：根据条件查询所需字段，返回对象发生错误！", e);
			e.printStackTrace();
		}
		return businessRoleFunction;
	}
	
}
