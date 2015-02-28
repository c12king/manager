package com.manage.app.service;

import java.util.List;

import net.sf.json.JSONArray;

import org.ietf.jgss.GSSException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.manage.app.bean.ManageEstate;
import com.manage.app.dao.ManageEstateDao;
import com.utis.Page;
import com.utis.TreeNode;

@Service("ManageEstateService")
@Transactional
public class ManageEstateServiceImpl implements ManageEstateService {
	
	private static Logger logger = LoggerFactory.getLogger(ManageEstateServiceImpl.class);
	@Autowired
	private ManageEstateDao manageEstateDao;

	
	@Transactional("transactionManager")
	public boolean delete(ManageEstate entity) throws GSSException {
		try {
			return manageEstateDao.delete(entity);
		} catch (GSSException e) {
			logger.debug("ManageEstateServiceImpl：删除ManageEstate发生错误！", e);
			e.printStackTrace();
		}
		return false;
	}
	
	@Transactional(readOnly = true)
	public ManageEstate findById(ManageEstate entity) throws GSSException {
		try {
			entity = manageEstateDao.get(entity);
		} catch (GSSException e) {
			logger.debug("ManageEstateServiceImpl：查询单个ManageEstate发生错误！", e);
			e.printStackTrace();
		}
		return entity;
	}
	public Page findAllPage(Page page) throws GSSException {
		int count=manageEstateDao.selectCount(page);
		List<ManageEstate> list=manageEstateDao.findAllPage(page);
		page.setTotalRow(count);
		page.setList(list);
		return page;
	}
	
	public void save(ManageEstate entity) throws GSSException {
		try {
			manageEstateDao.save(entity);
		} catch (GSSException e) {
			logger.debug("BusinessMenuServiceImpl：保存BusinessMenu发生错误！", e);
			e.printStackTrace();
		}
		
	}

	public void Update(ManageEstate entity) throws GSSException {
		try {
			manageEstateDao.Update(entity);
		} catch (GSSException e) {
			logger.debug("BusinessMenuServiceImpl：修改BusinessMenu发生错误！", e);
			e.printStackTrace();
		}
	}
	/**
	 * 查询所有
	 * @param entity
	 * @return
	 * @throws GSSException
	 */
	public List<ManageEstate> findAll() throws GSSException {
		List<ManageEstate> list = null;  
		try {
			list = manageEstateDao.findAll();
		} catch (GSSException e) {
			logger.debug("ManageEstateServiceImpl：查询单个ManageEstate发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按ID获取单个小区对象
	 * @param estateId
	 * @return
	 */
	public ManageEstate selectSingleManageById(Integer estateId) throws GSSException {
		ManageEstate manageEstate = null;  
		try {
			manageEstate = manageEstateDao.selectSingleManageById(estateId);
		} catch (GSSException e) {
			logger.debug("ManageEstateServiceImpl：按ID获取单个小区对象！", e);
			e.printStackTrace();
		}
		return manageEstate;
	}
	
	/**
	 * 按社区查询小区列表
	 * @param estateId
	 * @return
	 * @throws GSSException
	 */
	public List selectManageEstateByComId(Integer comId) throws GSSException {
		List list = null;
		list = manageEstateDao.selectManageEstateByComId(comId);
		return list;
	}

	public String treeData() throws GSSException {
		// TODO Auto-generated method stub
		//List<ManageBuilding> list= //manageBuildingDao.treeData(entity);
		List<ManageEstate>  list = manageEstateDao.findAll();
		TreeNode root=null;
		root = new TreeNode("0", "0", "小区", "",0);
		for (int i = 0; i < list.size(); i++) {      
			TreeNode node = null;
			node = new TreeNode(list.get(i).getEstateId().toString(), "0", list.get(i).getEstateName().toString(),"",0);   
			root.add(node);
		}
		JSONArray obj = JSONArray.fromObject(root);//(root.getChildren());// 不要根   
		return obj.toString();
		}
}
