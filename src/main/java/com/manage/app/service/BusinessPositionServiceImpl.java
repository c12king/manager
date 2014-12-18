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

import com.manage.app.bean.ManageOrg;
import com.manage.app.bean.BusinessPosition;
import com.manage.app.dao.BusinessPositionDao;
import com.utis.Page;
import com.utis.TreeNode;

@Service("BusinessPositionService")
@Transactional
public class BusinessPositionServiceImpl implements BusinessPositionService {
	
	private static Logger logger = LoggerFactory.getLogger(BusinessPositionServiceImpl.class);
	@Autowired
	private BusinessPositionDao businessPositionDao;

	
	@Transactional("transactionManager")
	public String delete(BusinessPosition entity) throws GSSException {
		try {
			
			if(businessPositionDao.selectCount(entity)>0){
				return "0";
			}else{
				businessPositionDao.delete(entity);
				return "1";
			}
		} catch (GSSException e) {
			logger.debug("ManageOrgServiceImpl：删除ManageOrg发生错误！", e);
			e.printStackTrace();
		}
		return "0";
	}
	
	@Transactional(readOnly = true)
	public BusinessPosition findById(BusinessPosition entity) throws GSSException {
		try {
			entity = businessPositionDao.get(entity);
		} catch (GSSException e) {
			logger.debug("ManagePositionServiceImpl：查询单个ManagePosition发生错误！", e);
			e.printStackTrace();
		}
		return entity;
	}
	public Page findAllPage(Page page) throws GSSException {
		return page;
	}
	
	public String save(BusinessPosition entity) throws GSSException {
		String json="";
		try {
			json=businessPositionDao.save(entity);
		} catch (GSSException e) {
			logger.debug("BusinessMenuServiceImpl：保存BusinessMenu发生错误！", e);
			e.printStackTrace();
		}
		return json;
		
	}

	public void Update(BusinessPosition entity) throws GSSException {
		try {
			businessPositionDao.Update(entity);
		} catch (GSSException e) {
			logger.debug("BusinessMenuServiceImpl：修改BusinessMenu发生错误！", e);
			e.printStackTrace();
		}
	}
	
	public String treeData(BusinessPosition businessPosition) {
		List<BusinessPosition> list=businessPositionDao.treeData(businessPosition);
		TreeNode root=null;
		if(list.size()==0){
			 root = new TreeNode(businessPosition.getPositionId().toString(), "0", "职位", "",0);
		}else{
			 root = new TreeNode(businessPosition.getPositionId().toString(), "0", "职位", "",0);

		}
		for (int i = 0; i < list.size(); i++) {
			TreeNode node = null;
			node = new TreeNode(list.get(i).getPositionId().toString(), list.get(i).getParentId().toString(), list.get(i).getPositionName(),"",list.get(i).getLeaf());   
			root.add(node);
		}
		if(businessPosition.getPositionId()==0){
			JSONObject obj = JSONObject.fromObject(root);//有根
			return "["+obj.toString()+"]";
		}else{
			JSONArray obj = JSONArray.fromObject(root.getChildren());// 不要根   
			return obj.toString();
		}
		
	}
	
	
}
