package com.manage.app.dao;

import java.util.List;

import org.ietf.jgss.GSSException;
import org.springframework.stereotype.Repository;

import com.manage.app.bean.BusinessUser;
import com.manage.app.bean.ManagePositionUser;
import com.utis.Page;



@Repository
public interface BusinessUserDao {
		
	/**
	 * 保存BusinessUser数据
	 * @param entity
	 * @throws GSSException
	 */
	public int save(BusinessUser entity) throws GSSException;
	
	/**
	 * 保存ManagePositionUser数据
	 * @param entity
	 * @throws GSSException
	 */
	public int save(ManagePositionUser entity) throws GSSException;

	/**
	 * 修改BusinessUser数据
	 * @param entity
	 * @throws GSSException
	 */
	public void Update(BusinessUser entity) throws GSSException;
	
	/**
	 * 删除BusinessUser数据
	 * @param entity
	 * @throws GSSException
	 */
	public boolean delete(BusinessUser entity) throws GSSException;
	
	/**
	 * 删除ManagePositionUser中该用户的所以职位
	 * @param entity
	 * @throws GSSException
	 */
	public boolean deleteManagePositionUserAll(ManagePositionUser entity) throws GSSException;

	/**
	 * 查询单个BusinessUser
	 * @param id
	 * @return
	 * @throws GSSException
	 */
	public BusinessUser get(BusinessUser entity) throws GSSException;
	
	/**
	 * 根据搜索条件，搜索分页数据
	 * @param pageSize
	 * @param pageNo
	 * @return
	 * @throws GSSException
	 */
	public List<BusinessUser> findAllPage(Page page) throws GSSException;

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageSize
	 * @param pageNo
	 * @return
	 * @throws GSServiceException
	 */
	public int selectCount(Page page) throws GSSException;
	
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
	 * 将该职位下默认负责人取消
	 * @param entity
	 * @throws GSSException
	 */
	public void noIsCharge(BusinessUser entity) throws GSSException;
	
	/**
	 * 修改职位
	 * @param entity
	 * @throws GSSException
	 */
	public void updatePosition(BusinessUser entity) throws GSSException;
}
