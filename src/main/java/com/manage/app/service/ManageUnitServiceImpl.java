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

import com.manage.app.bean.ManageBuilding;
import com.manage.app.bean.ManageUnit;
import com.manage.app.dao.ManageUnitDao;
import com.utis.Page;
import com.utis.TreeNode;

@Service("ManageUnitService")
@Transactional
public class ManageUnitServiceImpl implements ManageUnitService {
	
	private static Logger logger = LoggerFactory.getLogger(ManageUnitServiceImpl.class);
	@Autowired
	private ManageUnitDao manageUnitDao;

	
	@Transactional("transactionManager")
	public boolean delete(ManageUnit entity) throws GSSException {
		try {
			return manageUnitDao.delete(entity);
		} catch (GSSException e) {
			logger.debug("ManageUnitServiceImpl：删除ManageUnit发生错误！", e);
			e.printStackTrace();
		}
		return false;
	}
	
	@Transactional(readOnly = true)
	public ManageUnit findById(ManageUnit entity) throws GSSException {
		try {
			entity = manageUnitDao.get(entity);
		} catch (GSSException e) {
			logger.debug("ManageUnitServiceImpl：查询单个ManageUnit发生错误！", e);
			e.printStackTrace();
		}
		return entity;
	}
	public Page findAllPage(Page page) throws GSSException {
		int count=manageUnitDao.selectCount(page);
		List<ManageUnit> list=manageUnitDao.findAllPage(page);
		page.setTotalRow(count);
		page.setList(list);
		return page;
	}
	
	public void save(ManageUnit entity) throws GSSException {
		try {
			manageUnitDao.save(entity);
		} catch (GSSException e) {
			logger.debug("BusinessMenuServiceImpl：保存BusinessMenu发生错误！", e);
			e.printStackTrace();
		}
		
	}

	public void Update(ManageUnit entity) throws GSSException {
		try {
			manageUnitDao.Update(entity);
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
	public String treeData(ManageUnit entity) {
		List<ManageUnit> list=manageUnitDao.treeData(entity);
		TreeNode root=null;
		root = new TreeNode("0", "0", "职位", "",0);
		for (int i = 0; i < list.size(); i++) {
			TreeNode node = null;
			node = new TreeNode(list.get(i).getUnitId().toString(), "0", list.get(i).getUnitName(),"",0);   
			root.add(node);
		}
		JSONArray obj = JSONArray.fromObject(root.getChildren());// 不要根   
		return obj.toString();
		
	}
	
	
}
