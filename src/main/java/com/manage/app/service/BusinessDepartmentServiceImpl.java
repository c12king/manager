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

import com.manage.app.bean.BusinessDepartment;
import com.manage.app.bean.ManageCity;
import com.manage.app.dao.BusinessDepartmentDao;
import com.utis.Page;
import com.utis.TreeNode;

@Service("BusinessDepartmentService")
@Transactional
public class BusinessDepartmentServiceImpl implements BusinessDepartmentService {
	
	private static Logger logger = LoggerFactory.getLogger(BusinessDepartmentServiceImpl.class);
	@Autowired
	private BusinessDepartmentDao businessDepartmentDao;

	/**
	 * 删除BusinessDepartment
	 * @param entity
	 * @return
	 * @throws GSSException
	 */
	@Transactional("transactionManager")
	public boolean delete(BusinessDepartment entity) throws GSSException {
		try {
			return businessDepartmentDao.delete(entity);
		} catch (GSSException e) {
			logger.debug("BusinessDepartmentServiceImpl：删除BusinessDepartment发生错误！", e);
			e.printStackTrace();
		}
		return false;
	}
	/**
	 * 查询单个BusinessDepartment
	 * @param entity
	 * @return
	 * @throws GSSException
	 */
	@Transactional(readOnly = true)
	public BusinessDepartment findById(BusinessDepartment entity) throws GSSException {
		try {
			entity = businessDepartmentDao.get(entity);
		} catch (GSSException e) {
			logger.debug("BusinessDepartmentServiceImpl：查询单个BusinessDepartment发生错误！", e);
			e.printStackTrace();
		}
		return entity;
	}
	/**
	 * 查询BusinessDepartment列表展示数据
	 * @param page
	 * @return
	 * @throws GSSException
	 */
	@Transactional(readOnly = true)
	public Page findAllPage(Page page) throws GSSException {
		int count=businessDepartmentDao.selectCount(page);
		List<BusinessDepartment> list=businessDepartmentDao.findAllPage(page);
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
	public void save(BusinessDepartment entity) throws GSSException {
		try {
			businessDepartmentDao.save(entity);
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
	public void Update(BusinessDepartment entity) throws GSSException {
		try {
			businessDepartmentDao.Update(entity);
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
	public String treeData(BusinessDepartment entity) {
		List<BusinessDepartment> list=businessDepartmentDao.treeData(entity);
		TreeNode root=null;
		root = new TreeNode("0", "0", "职位", "",0);
		for (int i = 0; i < list.size(); i++) {
			TreeNode node = null;
			node = new TreeNode(list.get(i).getDepId().toString(), "0", list.get(i).getDepName(),"",0);   
			root.add(node);
		}
		JSONArray obj = JSONArray.fromObject(root.getChildren());// 不要根   
		return obj.toString();
		
	}
	
}
