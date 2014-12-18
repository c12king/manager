package com.manage.app.service;

import java.util.List;
import java.util.Map;

import org.ietf.jgss.GSSException;

import com.manage.app.bean.BusinessUser;
import com.manage.app.bean.ManagePositionUser;
import com.utis.Page;


public interface BusinessUserService {
	/**
	 * 保存BusinessMenu数据
	 * @param entity
	 * @throws GSSException
	 */
	public void save(BusinessUser entity) throws GSSException;
	

	/**
	 * 修改职位
	 * @param entity
	 * @throws GSSException
	 */
	public void saveJOB(BusinessUser entity) throws GSSException;

	/**
	 * 修改BusinessMenu数据
	 * @param entity
	 * @throws GSSException
	 */
	public void Update(BusinessUser entity) throws GSSException;

	/**
	 * 删除BusinessUser
	 * @param BusinessUser
	 * @return
	 * @throws GSSException
	 */
	public boolean delete(BusinessUser entity) throws GSSException;

	/**
	 * 查询单个BusinessUser
	 * @param BusinessUser
	 * @return
	 * @throws GSSException
	 */
	public BusinessUser findById(BusinessUser entity) throws GSSException;
	/**
	 * 查询BusinessUser列表展示数据
	 * @param Page
	 * @return
	 * @throws GSSException
	 */
	public Page findAllPage(Page page) throws GSSException;
	
	/**
	 * 查询ManagePositionUser
	 * @param BusinessUser
	 * @return
	 * @throws GSSException
	 */
	public List<ManagePositionUser> selectManagePositionUser(BusinessUser entity) throws GSSException;
	
	
	/**
	 * 给用户设置为默认负责人
	 * @param entity
	 * @throws GSSException
	 */
	public void isCharge(BusinessUser entity) throws GSSException;
	

	/**
	 * 获取用户已拥有权限和用户所属机构全部权限
	 * @param entity
	 * @throws GSSException
	 */
	public Map getFunction(BusinessUser entity) throws GSSException;

}
