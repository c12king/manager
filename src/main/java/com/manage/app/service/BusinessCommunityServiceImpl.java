package com.manage.app.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;

import org.ietf.jgss.GSSException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.manage.app.bean.BusinessCommunity;
import com.manage.app.dao.BusinessCommunityDao;
import com.manage.app.vo.BaseBean;
import com.manage.app.vo.BusinessCommunityQuery;
import com.manage.framework.exception.DaoException;
import com.manage.framework.exception.ServiceException;
import com.utis.TreeNode;

@Service("BusinessCommunityService")
@Transactional
public class BusinessCommunityServiceImpl implements BusinessCommunityService {
	
	private static Logger logger = LoggerFactory.getLogger(BusinessCommunityServiceImpl.class);
	@Autowired
	private BusinessCommunityDao businessCommunityDao;

	/**
	 * 查询单个BusinessCommunity
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public BusinessCommunity findById(final Integer id) throws ServiceException {
		BusinessCommunity businessCommunity = new BusinessCommunity();
		try {
			businessCommunity = businessCommunityDao.findById(id);
		} catch (DaoException e) {
			logger.debug("BusinessCommunityServiceImpl findById()：查询单个BusinessCommunity发生错误！", e);
			e.printStackTrace();
		}
		return businessCommunity;
	}
	
	/**
	 * 无条件查询所有BusinessCommunity
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public List<BusinessCommunity> findAll() throws ServiceException {
		List<BusinessCommunity> list = new ArrayList<BusinessCommunity>() ;
		try {
			list=businessCommunityDao.findAll();
		} catch (DaoException e) {
			logger.debug("BusinessCommunityServiceImpl findAll()：无条件查询所有BusinessCommunity发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessCommunity
	 * @param paramMap
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<BusinessCommunity> findByMap(final Map paramMap) throws ServiceException {
		List<BusinessCommunity> list = new ArrayList<BusinessCommunity>() ;
		try {
			list=businessCommunityDao.findByMap(paramMap);
		} catch (DaoException e) {
			logger.debug("BusinessCommunityServiceImpl findByMap()：按Map对象条件查询所有BusinessCommunity发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessCommunity-限制返回条数
	 * @param paramMap
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<BusinessCommunity> findByMap(final Map paramMap, final Integer limit) throws ServiceException {
		List<BusinessCommunity> list = new ArrayList<BusinessCommunity>() ;
		try {
			list=businessCommunityDao.findByMap(paramMap, limit);
		} catch (DaoException e) {
			logger.debug("BusinessCommunityServiceImpl findByMap()：按Map对象条件查询所有BusinessCommunity-限制返回条数发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有BusinessCommunity
	 * @param query
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<BusinessCommunity> findByExample(final BusinessCommunityQuery query) throws ServiceException {
		List<BusinessCommunity> list = new ArrayList<BusinessCommunity>() ;
		try {
			list=businessCommunityDao.findByExample(query);
		} catch (DaoException e) {
			logger.debug("BusinessCommunityServiceImpl findByExample()：按VO对象条件查询所有BusinessCommunity发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有BusinessCommunity-限制返回条数
	 * @param query
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<BusinessCommunity> findByExample(final BusinessCommunityQuery query, final Integer limit) throws ServiceException {
		List<BusinessCommunity> list = new ArrayList<BusinessCommunity>() ;
		try {
			list=businessCommunityDao.findByExample(query, limit);
		} catch (DaoException e) {
			logger.debug("BusinessCommunityServiceImpl findByExample()：按VO对象条件查询所有BusinessCommunity-限制返回条数发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 根据搜索条件,查询社区列表
	 * @param query
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public BaseBean findAllPage(final BusinessCommunityQuery query) throws ServiceException {
		List<BusinessCommunity> list = new ArrayList<BusinessCommunity>() ;
		int count=0;
		BaseBean baseBean = new BaseBean();
		try {
			list=businessCommunityDao.findAllPage(query);
			count=businessCommunityDao.selectCount(query);
		} catch (DaoException e) {
			logger.debug("BusinessCommunityServiceImpl findAllPage()：根据搜索条件，搜索分页数据发生错误！", e);
			e.printStackTrace();
		}
		baseBean.setList(list);
		baseBean.setCount(count);
		return baseBean;
	}
	/**
	 * 根据搜索条件,查询社区列表
	 * @param query
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public BaseBean findComListPage(final Map<String, Object> con) throws ServiceException
	{
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>() ;
		int count=0;
		BaseBean baseBean = new BaseBean();
		try {
			list=businessCommunityDao.findComListPage(con);
			count=businessCommunityDao.selectCount(null); // 全查询
		} catch (DaoException e) {
			logger.debug("BusinessCommunityServiceImpl findComListPage()：根据搜索条件，搜索分页数据发生错误！", e);
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
	public int selectCount(final BusinessCommunityQuery query) throws ServiceException {
		int count = 0;
		try {
			count = businessCommunityDao.selectCount(query);
		} catch (DaoException e) {
			logger.debug("BusinessCommunityServiceImpl selectCount()：根据搜索条件，搜索分页总数发生错误！", e);
			e.printStackTrace();
		}
		return count;
	}
	
	/**
	 * 保存BusinessCommunity数据
	 * @param entity
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public void save(BusinessCommunity entity) throws ServiceException {
		try {
			businessCommunityDao.save(entity);
		} catch (DaoException e) {
			logger.debug("BusinessCommunityServiceImpl save()：保存BusinessCommunity发生错误！", e);
			e.printStackTrace();
		}
	}

	/**
	 * 修改BusinessCommunity数据
	 * @param entity
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public void update(BusinessCommunity entity) throws ServiceException {
		try {
			businessCommunityDao.update(entity);
		} catch (DaoException e) {
			logger.debug("BusinessCommunityServiceImpl update()：修改BusinessCommunity发生错误！", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 删除BusinessCommunity
	 * @param entityId
	 * @return
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public boolean delete(Integer id) throws ServiceException {
		try {
			return businessCommunityDao.delete(id);
		} catch (DaoException e) {
			logger.debug("BusinessCommunityServiceImpl delete()：删除BusinessCommunity发生错误！", e);
			e.printStackTrace();
		}
		return false;
	}
	
	/**
	 * 获取该区域下社区下拉菜单json
	 * @param request
	 * @param response
	 * @param Menu
	 * @return
	 */
	public String getComboboxData(final Integer countyId) throws ServiceException{
		// TODO Auto-generated method stub
		String json="";
		List<BusinessCommunity> list=null;
		try {
			list=businessCommunityDao.getComboboxData(countyId);
		} catch (DaoException e) {
			logger.debug("BusinessCommunityServiceImpl getComboboxData()：删除获取区域下拉菜单json发生错误！", e);
			e.printStackTrace();
		}
		StringBuilder result = new StringBuilder();
		result.append("[");
		for (BusinessCommunity businessCommunity : list) {
			result.append("{");
			result.append("\"label\":").append(businessCommunity.getComId()).append(",");
			result.append("\"value\":").append("\""+businessCommunity.getComName()+"\"");
			result.append("},");
		}
		json = result.toString();
		if(list.size() > 0) {
			json = json.substring(0, json.length()-1);
		}
		json += "]";
		return json;
	}
	
	public String treeData() throws GSSException {
		// TODO Auto-generated method stub
		//List<ManageBuilding> list= //manageBuildingDao.treeData(entity);
		List<BusinessCommunity> list = null;
		try {
			list = businessCommunityDao.findAll();
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		TreeNode root=null;
		root = new TreeNode("0", "0", "社区", "",0);
		for (int i = 0; i < list.size(); i++) {      
			TreeNode node = null;
			node = new TreeNode(list.get(i).getComId().toString(), "0", list.get(i).getComName().toString(),"",0);   
			root.add(node);
		}
		JSONArray obj = JSONArray.fromObject(root);//(root.getChildren());// 不要根   
		return obj.toString();
	}
	
}
