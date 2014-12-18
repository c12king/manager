package com.manage.app.service;

import org.ietf.jgss.GSSException;

import com.manage.app.bean.AppUser;
import com.utis.Page;


public interface AppUserService {
	/**
	 * 保存BusinessMenu数据
	 * @param entity
	 * @throws GSSException
	 */
	public void save(AppUser entity) throws GSSException;
	
	/**
	 * 修改BusinessMenu数据
	 * @param entity
	 * @throws GSSException
	 */
	public void Update(AppUser entity) throws GSSException;

	/**
	 * 删除AppUser
	 * @param entity
	 * @return
	 * @throws GSSException
	 */
	public boolean delete(AppUser entity) throws GSSException;

	/**
	 * 查询单个AppUser
	 * @param entity
	 * @return
	 * @throws GSSException
	 */
	public AppUser findById(AppUser entity) throws GSSException;
	/**
	 * 查询AppUser列表展示数据
	 * @param page
	 * @return
	 * @throws GSSException
	 */
	public Page findAllPage(Page page) throws GSSException;
}
