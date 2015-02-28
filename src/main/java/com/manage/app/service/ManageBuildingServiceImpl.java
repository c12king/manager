package com.manage.app.service;

import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;

import org.ietf.jgss.GSSException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.manage.app.bean.ManageBuilding;
import com.manage.app.dao.ManageBuildingDao;
import com.manage.framework.exception.ServiceException;
import com.utis.Page;
import com.utis.TreeNode;

@Service("ManageBuildingService")
@Transactional
public class ManageBuildingServiceImpl implements ManageBuildingService {
	
	private static Logger logger = LoggerFactory.getLogger(ManageBuildingServiceImpl.class);
	@Autowired
	private ManageBuildingDao manageBuildingDao;

	
	@Transactional("transactionManager")
	public boolean delete(ManageBuilding entity) throws GSSException {
		try {
			return manageBuildingDao.delete(entity);
		} catch (GSSException e) {
			logger.debug("ManageBuildingServiceImpl：删除ManageBuilding发生错误！", e);
			e.printStackTrace();
		}
		return false;
	}
	
	@Transactional(readOnly = true)
	public ManageBuilding findById(ManageBuilding entity) throws GSSException {
		try {
			entity = manageBuildingDao.get(entity);
		} catch (GSSException e) {
			logger.debug("ManageBuildingServiceImpl：查询单个ManageBuilding发生错误！", e);
			e.printStackTrace();
		}
		return entity;
	}
	public Page findAllPage(Page page) throws GSSException {
		int count=manageBuildingDao.selectCount(page);
		List<ManageBuilding> list=manageBuildingDao.findAllPage(page);
		page.setTotalRow(count);
		page.setList(list);
		return page;
	}
	
	public void save(ManageBuilding entity) throws GSSException {
		try {
			manageBuildingDao.save(entity);
		} catch (GSSException e) {
			logger.debug("BusinessMenuServiceImpl：保存BusinessMenu发生错误！", e);
			e.printStackTrace();
		}
		
	}

	public void Update(ManageBuilding entity) throws GSSException {
		try {
			manageBuildingDao.Update(entity);
		} catch (GSSException e) {
			logger.debug("BusinessMenuServiceImpl：修改BusinessMenu发生错误！", e);
			e.printStackTrace();
		}
	}
	
	public String treeData(ManageBuilding entity) {
		List<ManageBuilding> list=manageBuildingDao.treeData(entity);
		TreeNode root=null;
		root = new TreeNode("0", "0", "职位", "",0);
		for (int i = 0; i < list.size(); i++) {
			TreeNode node = null;
			node = new TreeNode(list.get(i).getBuildingId().toString(), "0", list.get(i).getBuildingName(),"",0);   
			root.add(node);
		}
		JSONArray obj = JSONArray.fromObject(root.getChildren());// 不要根   
		return obj.toString();
		
	}
	
	/**
	 * 按Map对象条件查询所有ManageBuilding
	 * @return
	 * @throws ServiceException
	 */	
	public List<ManageBuilding> findByMap(final Map<String, Object> paramMap) throws GSSException {
		return manageBuildingDao.findByMap(paramMap);
	}
	
}
