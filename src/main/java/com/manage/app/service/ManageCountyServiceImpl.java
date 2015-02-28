package com.manage.app.service;

import java.util.List;

import net.sf.json.JSONArray;

import org.ietf.jgss.GSSException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.manage.app.bean.ManageCounty;
import com.manage.app.dao.ManageCountyDao;
import com.utis.Page;
import com.utis.TreeNode;

@Service("ManageCountyService")
@Transactional
public class ManageCountyServiceImpl implements ManageCountyService {
	
	private static Logger logger = LoggerFactory.getLogger(ManageCountyServiceImpl.class);
	@Autowired
	private ManageCountyDao manageCountyDao;

	/**
	 * 删除ManageCounty
	 * @param entity
	 * @return
	 * @throws GSSException
	 */
	@Transactional("transactionManager")
	public boolean delete(ManageCounty entity) throws GSSException {
		try {
			return manageCountyDao.delete(entity);
		} catch (GSSException e) {
			logger.debug("ManageCountyServiceImpl：删除ManageCounty发生错误！", e);
			e.printStackTrace();
		}
		return false;
	}
	/**
	 * 查询单个ManageCounty
	 * @param entity
	 * @return
	 * @throws GSSException
	 */
	@Transactional(readOnly = true)
	public ManageCounty findById(ManageCounty entity) throws GSSException {
		try {
			entity = manageCountyDao.get(entity);
		} catch (GSSException e) {
			logger.debug("ManageCountyServiceImpl：查询单个ManageCounty发生错误！", e);
			e.printStackTrace();
		}
		return entity;
	}
	/**
	 * 查询ManageCounty列表展示数据
	 * @param page
	 * @return
	 * @throws GSSException
	 */
	@Transactional(readOnly = true)
	public Page findAllPage(Page page) throws GSSException {
		int count=manageCountyDao.selectCount(page);
		List<ManageCounty> list=manageCountyDao.findAllPage(page);
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
	public void save(ManageCounty entity) throws GSSException {
		try {
			manageCountyDao.save(entity);
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
	public void Update(ManageCounty entity) throws GSSException {
		try {
			manageCountyDao.Update(entity);
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
	public String treeData(ManageCounty entity) {
		List<ManageCounty> list=manageCountyDao.treeData(entity);
		TreeNode root=null;
		root = new TreeNode("0", "0", "职位", "",0);
		for (int i = 0; i < list.size(); i++) {
			TreeNode node = null;
			node = new TreeNode(list.get(i).getCountyId().toString(), "0", list.get(i).getCountyName(),"",0);   
			root.add(node);
		}
		JSONArray obj = JSONArray.fromObject(root.getChildren());// 不要根   
		return obj.toString();
		
	}
	
	/**
	 * 获取区域下拉菜单json
	 * @param entity
	 * @return
	 * @throws GSSException
	 */
	public String getComboboxData(ManageCounty entity) {
		// TODO Auto-generated method stub
		String json="";
		List<ManageCounty> list=manageCountyDao.treeData(entity);
		StringBuilder result = new StringBuilder();
		result.append("[");
		for (ManageCounty manageCounty : list) {
			result.append("{");
			result.append("\"label\":").append(manageCounty.getCountyId()).append(",");
			result.append("\"value\":").append("\""+manageCounty.getCountyName()+"\"");
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
