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

import com.manage.app.bean.ManageCity;
import com.manage.app.bean.ManageUnit;
import com.manage.app.dao.ManageCityDao;
import com.utis.Page;
import com.utis.TreeNode;

@Service("ManageCityService")
@Transactional
public class ManageCityServiceImpl implements ManageCityService {
	
	private static Logger logger = LoggerFactory.getLogger(ManageCityServiceImpl.class);
	@Autowired
	private ManageCityDao manageCityDao;

	/**
	 * 删除ManageCity
	 * @param entity
	 * @return
	 * @throws GSSException
	 */
	@Transactional("transactionManager")
	public boolean delete(ManageCity entity) throws GSSException {
		try {
			return manageCityDao.delete(entity);
		} catch (GSSException e) {
			logger.debug("ManageCityServiceImpl：删除ManageCity发生错误！", e);
			e.printStackTrace();
		}
		return false;
	}
	/**
	 * 查询单个ManageCity
	 * @param entity
	 * @return
	 * @throws GSSException
	 */
	@Transactional(readOnly = true)
	public ManageCity findById(ManageCity entity) throws GSSException {
		try {
			entity = manageCityDao.get(entity);
		} catch (GSSException e) {
			logger.debug("ManageCityServiceImpl：查询单个ManageCity发生错误！", e);
			e.printStackTrace();
		}
		return entity;
	}
	/**
	 * 查询ManageCity列表展示数据
	 * @param page
	 * @return
	 * @throws GSSException
	 */
	@Transactional(readOnly = true)
	public Page findAllPage(Page page) throws GSSException {
		int count=manageCityDao.selectCount(page);
		List<ManageCity> list=manageCityDao.findAllPage(page);
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
	public void save(ManageCity entity) throws GSSException {
		try {
			manageCityDao.save(entity);
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
	public void Update(ManageCity entity) throws GSSException {
		try {
			manageCityDao.Update(entity);
		} catch (GSSException e) {
			logger.debug("BusinessMenuServiceImpl：修改BusinessMenu发生错误！", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 获取菜单树形展示json数据
	 * @param entity
	 * @return
	 * @throws GSSException
	 */
	public String treeData(ManageCity entity) {
		List<ManageCity> list=manageCityDao.treeData(entity);
		TreeNode root=null;
		root = new TreeNode("0", "0", "职位", "",0);
		for (int i = 0; i < list.size(); i++) {
			TreeNode node = null;
			node = new TreeNode(list.get(i).getCityId().toString(), "0", list.get(i).getCityName(),"",0);   
			root.add(node);
		}
		JSONArray obj = JSONArray.fromObject(root.getChildren());// 不要根   
		return obj.toString();
		
	}
	
}
