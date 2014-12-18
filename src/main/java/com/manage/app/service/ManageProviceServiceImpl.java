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

import com.manage.app.bean.ManageProvice;
import com.manage.app.bean.ManageUnit;
import com.manage.app.dao.ManageProviceDao;
import com.utis.Page;
import com.utis.TreeNode;

@Service("ManageProviceService")
@Transactional
public class ManageProviceServiceImpl implements ManageProviceService {
	
	private static Logger logger = LoggerFactory.getLogger(ManageProviceServiceImpl.class);
	@Autowired
	private ManageProviceDao manageProviceDao;

	/**
	 * 删除ManageProvice
	 * @param entity
	 * @return
	 * @throws GSSException
	 */
	@Transactional("transactionManager")
	public boolean delete(ManageProvice entity) throws GSSException {
		try {
			return manageProviceDao.delete(entity);
		} catch (GSSException e) {
			logger.debug("ManageProviceServiceImpl：删除ManageProvice发生错误！", e);
			e.printStackTrace();
		}
		return false;
	}
	/**
	 * 查询单个ManageProvice
	 * @param entity
	 * @return
	 * @throws GSSException
	 */
	@Transactional(readOnly = true)
	public ManageProvice findById(ManageProvice entity) throws GSSException {
		try {
			entity = manageProviceDao.get(entity);
		} catch (GSSException e) {
			logger.debug("ManageProviceServiceImpl：查询单个ManageProvice发生错误！", e);
			e.printStackTrace();
		}
		return entity;
	}
	/**
	 * 查询ManageProvice列表展示数据
	 * @param page
	 * @return
	 * @throws GSSException
	 */
	@Transactional(readOnly = true)
	public Page findAllPage(Page page) throws GSSException {
		int count=manageProviceDao.selectCount(page);
		List<ManageProvice> list=manageProviceDao.findAllPage(page);
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
	public void save(ManageProvice entity) throws GSSException {
		try {
			manageProviceDao.save(entity);
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
	public void Update(ManageProvice entity) throws GSSException {
		try {
			manageProviceDao.Update(entity);
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
	public String treeData(ManageProvice entity) {
		List<ManageProvice> list=manageProviceDao.treeData(entity);
		TreeNode root=null;
		root = new TreeNode("0", "0", "职位", "",0);
		for (int i = 0; i < list.size(); i++) {
			TreeNode node = null;
			node = new TreeNode(list.get(i).getProviceId().toString(), "0", list.get(i).getProvinceName(),"",0);   
			root.add(node);
		}
		JSONArray obj = JSONArray.fromObject(root.getChildren());// 不要根   
		return obj.toString();
		
	}
	
	
}
