package com.manage.app.dao;

import java.util.List;

import org.ietf.jgss.GSSException;
import org.springframework.stereotype.Repository;

import com.manage.app.bean.AppUser;
import com.utis.Page;



@Repository
public interface AppUserDao {
		
	/**
	 * 保存AppUser数据
	 * @param entity
	 * @throws GSSException
	 */
	public void save(AppUser entity) throws GSSException;

	/**
	 * 修改AppUser数据
	 * @param entity
	 * @throws GSSException
	 */
	public void Update(AppUser entity) throws GSSException;
	
	/**
	 * 删除AppUser数据
	 * @param entity
	 * @throws GSSException
	 */
	public boolean delete(AppUser entity) throws GSSException;
	
	/**
	 * 查询单个AppUser
	 * @param entity
	 * @return
	 * @throws GSSException
	 */
	public AppUser get(AppUser entity) throws GSSException;
	
	/**
	 * 根据搜索条件，搜索分页数据
	 * @param page
	 * @return
	 * @throws GSSException
	 */
	public List<AppUser> findAllPage(Page page) throws GSSException;

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param page
	 * @return
	 * @throws GSServiceException
	 */
	public int selectCount(Page page) throws GSSException;

}
