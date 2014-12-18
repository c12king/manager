package com.manage.app.dao;

import java.util.List;

import org.ietf.jgss.GSSException;
import org.springframework.stereotype.Repository;

import com.manage.app.bean.BusinessCommunity;
import com.manage.app.bean.BusinessMenu;
import com.manage.app.bean.BusinessProperty;
import com.manage.app.bean.BusinessStation;
import com.manage.app.bean.ManageOrg;
import com.utis.Page;



@Repository
public interface ManageOrgDao {
		
	/**
	 * 保存ManageOrg数据
	 * @param entity
	 * @throws GSSException
	 */
	public String save(ManageOrg entity) throws GSSException;

	/**
	 * 修改ManageOrg数据
	 * @param entity
	 * @throws GSSException
	 */
	public void Update(ManageOrg entity) throws GSSException;
	
	/**
	 * 删除ManageOrg数据
	 * @param entity
	 * @throws GSSException
	 */
	public boolean delete(ManageOrg entity) throws GSSException;
	
	/**
	 * 查询单个ManageOrg
	 * @param id
	 * @return
	 * @throws GSSException
	 */
	public ManageOrg get(ManageOrg entity) throws GSSException;
	
	/**
	 * 根据搜索条件，搜索分页数据
	 * @param pageSize
	 * @param pageNo
	 * @return
	 * @throws GSSException
	 */
	public List<ManageOrg> findAllPage(Page page) throws GSSException;

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageSize
	 * @param pageNo
	 * @return
	 * @throws GSServiceException
	 */
	public int selectCount(ManageOrg manageOrg) throws GSSException;
	
	/**
	 * 获取菜单树形展示json数据
	 * @param id
	 * @return
	 * @throws GSSException
	 */
	public List<ManageOrg> treeData(ManageOrg manageOrg);
	
	/**
	 * 获取组织机构复选框的json格式数据
	 * @param id
	 * @return
	 * @throws GSSException
	 */
	public List<ManageOrg> getComboboxData();
	
	/**
	 * 获取该组织下的社区
	 * @param id
	 * @return
	 * @throws GSSException
	 */
	public List<BusinessCommunity> getBusinessCommunity(final Integer id);
	/**
	 * 获取该组织下的驿站
	 * @param id
	 * @return
	 * @throws GSSException
	 */
	public List<BusinessProperty> getBusinessProperty(final Integer id);
	/**
	 * 获取该组织下的物业
	 * @param id
	 * @return
	 * @throws GSSException
	 */
	public List<BusinessStation> getBusinessStation(final Integer id);
}
