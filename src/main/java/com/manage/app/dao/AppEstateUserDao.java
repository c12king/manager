package com.manage.app.dao;

import java.util.List;

import org.ietf.jgss.GSSException;
import org.springframework.stereotype.Repository;

import com.manage.app.bean.AppEstateUser;
import com.utis.Page;



@Repository
public interface AppEstateUserDao {
		
	/**
	 * 保存AppEstateUser数据
	 * @param entity
	 * @throws GSSException
	 */
	public void save(AppEstateUser entity) throws GSSException;

	/**
	 * 修改AppEstateUser数据
	 * @param entity
	 * @throws GSSException
	 */
	public void Update(AppEstateUser entity) throws GSSException;
	
	/**
	 * 删除AppEstateUser数据
	 * @param entity
	 * @throws GSSException
	 */
	public boolean delete(AppEstateUser entity) throws GSSException;
	
	/**
	 * 查询单个AppEstateUser
	 * @param entity
	 * @return
	 * @throws GSSException
	 */
	public AppEstateUser get(AppEstateUser entity) throws GSSException;
	
	/**
	 * 根据搜索条件，搜索分页数据
	 * @param page
	 * @return
	 * @throws GSSException
	 */
	public List<AppEstateUser> findAllPage(Page page) throws GSSException;

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param page
	 * @return
	 * @throws GSServiceException
	 */
	public int selectCount(Page page) throws GSSException;

	/**
	 * 查看用户所属小区
	 * @param entity
	 * @return
	 * @throws GSSException
	 */
	public List<AppEstateUser> estateUserList(AppEstateUser entity) throws GSSException;

}
