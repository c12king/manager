package com.manage.app.service;

import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.ietf.jgss.GSSException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.manage.app.bean.BusinessCommunity;
import com.manage.app.bean.BusinessProperty;
import com.manage.app.bean.BusinessStation;
import com.manage.app.bean.ManageOrg;
import com.manage.app.common.ModuleConst;
import com.manage.app.dao.BusinessCommunityDao;
import com.manage.app.dao.BusinessPropertyDao;
import com.manage.app.dao.BusinessStationDao;
import com.manage.app.dao.ManageOrgDao;
import com.utis.Page;
import com.utis.TreeNode;

@Service("ManageOrgService")
@Transactional
public class ManageOrgServiceImpl implements ManageOrgService {
	
	private static Logger logger = LoggerFactory.getLogger(ManageOrgServiceImpl.class);
	@Autowired
	private ManageOrgDao manageOrgDao;
	@Autowired
	private BusinessCommunityDao businessCommunityDao;
	@Autowired
	private BusinessPropertyDao businessPropertyDao;
	@Autowired
	private BusinessStationDao businessStationDao;

	
	@Transactional("transactionManager")
	public String delete(ManageOrg entity) throws GSSException {
		try {
			
			if(manageOrgDao.selectCount(entity)>0){
				return "0";
			}else{
				manageOrgDao.delete(entity);
				return "1";
			}
		} catch (GSSException e) {
			logger.debug("ManageOrgServiceImpl：删除ManageOrg发生错误！", e);
			e.printStackTrace();
		}
		return "0";
	}
	
	@Transactional(readOnly = true)
	public ManageOrg findById(ManageOrg entity) throws GSSException {
		try {
			entity = manageOrgDao.get(entity);
		} catch (GSSException e) {
			logger.debug("ManageOrgServiceImpl：查询单个ManageOrg发生错误！", e);
			e.printStackTrace();
		}
		return entity;
	}
	public Page findAllPage(Page page) throws GSSException {
		return page;
	}
	
	public String save(ManageOrg entity) throws GSSException {
		String json="";
		try {
			json=manageOrgDao.save(entity);
		} catch (GSSException e) {
			logger.debug("BusinessMenuServiceImpl：保存BusinessMenu发生错误！", e);
			e.printStackTrace();
		}
		return json;
	}

	public void Update(ManageOrg entity) throws GSSException {
		try {
			manageOrgDao.Update(entity);
		} catch (GSSException e) {
			logger.debug("BusinessMenuServiceImpl：修改BusinessMenu发生错误！", e);
			e.printStackTrace();
		}
	}

	public String treeData(ManageOrg manageOrg) {
		List<ManageOrg> list=manageOrgDao.treeData(manageOrg);
		TreeNode root=null;
		if(list.size()==0){
			 root = new TreeNode(manageOrg.getOrgId().toString(), "0", "组织机构", "",0);
		}else{
			 root = new TreeNode(manageOrg.getOrgId().toString(), "0", "组织机构", "",0);

		}
		for (int i = 0; i < list.size(); i++) {
			TreeNode node = null;
			node = new TreeNode(list.get(i).getOrgId().toString(), list.get(i).getParentId().toString(), list.get(i).getOrgName(),"",list.get(i).getLeaf(),ModuleConst.OPERATION_CODE);   
			root.add(node);
		}
		
		
		if(manageOrg.getOrgId()==0){
			JSONObject obj = JSONObject.fromObject(root);//有根
			return "["+obj.toString()+"]";
		}else{
			JSONArray obj = JSONArray.fromObject(root.getChildren());// 不要根   
			return obj.toString();
		}
		
	}
	/**
	 * 获取组织机构、社区、物业、驿站tree数据
	 * @param id
	 * @return
	 * @throws GSSException
	 */
	public String fullOrgTreeData(ManageOrg manageOrg) {
		List<ManageOrg> list=manageOrgDao.treeData(manageOrg);
		List<BusinessCommunity> businessCommunityList=manageOrgDao.getBusinessCommunity(manageOrg.getOrgId());
		List<BusinessProperty> businessPropertyList=manageOrgDao.getBusinessProperty(manageOrg.getOrgId());
		List<BusinessStation> businessStationList=manageOrgDao.getBusinessStation(manageOrg.getOrgId());
		TreeNode root=null;
		if(list.size()==0){
			 root = new TreeNode(manageOrg.getOrgId().toString(), "0", "组织机构", "",0);
		}else{
			 root = new TreeNode(manageOrg.getOrgId().toString(), "0", "组织机构", "",0);

		}
		for (int i = 0; i < list.size(); i++) {
			TreeNode node = null;
			node = new TreeNode(list.get(i).getOrgId().toString(), list.get(i).getParentId().toString(), list.get(i).getOrgName(),"",1,ModuleConst.OPERATION_CODE);   
			root.add(node);
		}
		
		for (int i = 0; i < businessCommunityList.size(); i++) {
			TreeNode node = null;
			node = new TreeNode(businessCommunityList.get(i).getComId().toString(), manageOrg.getOrgId().toString(), businessCommunityList.get(i).getComName(),"",0,ModuleConst.COMMUNITY_CODE);   
			root.add(node);
		}
		
		for (int i = 0; i < businessPropertyList.size(); i++) {
			TreeNode node = null;
			node = new TreeNode(businessPropertyList.get(i).getProId().toString(), manageOrg.getOrgId().toString(), businessPropertyList.get(i).getProName(),"",0,ModuleConst.PROPERTY_CODE);   
			root.add(node);
		}
		
		for (int i = 0; i < businessStationList.size(); i++) {
			TreeNode node = null;
			node = new TreeNode(businessStationList.get(i).getStationId().toString(), manageOrg.getOrgId().toString(), businessStationList.get(i).getStaName(),"",0,ModuleConst.STATION_CODE);   
			root.add(node);
		}
		
		if(manageOrg.getOrgId()==0){
			JSONObject obj = JSONObject.fromObject(root);//有根
			return "["+obj.toString()+"]";
		}else{
			JSONArray obj = JSONArray.fromObject(root.getChildren());// 不要根   
			return obj.toString();
		}
		
	}
	
	/**
	 * 获取组织结构复选框的json格式数据
	 * @param id
	 * @return
	 * @throws GSSException
	 */
	public String getComboboxData() {
		// TODO Auto-generated method stub
		String json="";
		List<ManageOrg> list=manageOrgDao.getComboboxData();
		StringBuilder result = new StringBuilder();
		result.append("[");
		for (ManageOrg org : list) {
			result.append("{");
			result.append("\"label\":").append(org.getOrgId()).append(",");
			result.append("\"value\":").append("\""+org.getOrgName()+"\"");
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
