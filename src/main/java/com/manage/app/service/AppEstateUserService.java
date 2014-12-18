package com.manage.app.service;

import java.util.List;

import org.ietf.jgss.GSSException;

import com.manage.app.bean.AppEstateUser;
import com.utis.Page;


public interface AppEstateUserService {
	/**
	 * 保存BusinessMenu数据
	 * @param entity
	 * @throws GSSException
	 */
	public void save(AppEstateUser entity) throws GSSException;
	
	/**
	 * 修改BusinessMenu数据
	 * @param entity
	 * @throws GSSException
	 */
	public void Update(AppEstateUser entity) throws GSSException;

	/**
	 * 删除AppEstateUser
	 * @param entity
	 * @return
	 * @throws GSSException
	 */
	public boolean delete(AppEstateUser entity) throws GSSException;

	/**
	 * 查询单个AppEstateUser
	 * @param entity
	 * @return
	 * @throws GSSException
	 */
	public AppEstateUser findById(AppEstateUser entity) throws GSSException;
	/**
	 * 查询AppEstateUser列表展示数据
	 * @param page
	 * @return
	 * @throws GSSException
	 */
	public Page findAllPage(Page page) throws GSSException;
	
	/**
	 * 查看用户所属小区
	 * @param entity
	 * @return
	 * @throws GSSException
	 */
	public List<AppEstateUser> estateUserList(AppEstateUser entity) throws GSSException;
}
