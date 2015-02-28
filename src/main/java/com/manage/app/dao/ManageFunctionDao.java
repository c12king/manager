package com.manage.app.dao;

import java.util.List;

import org.ietf.jgss.GSSException;
import org.springframework.stereotype.Repository;

import com.manage.app.bean.ManageFunction;
import com.manage.framework.exception.DaoException;
import com.utis.Page;



@Repository
public interface ManageFunctionDao {
		
	/**
	 * 保存ManageFunction数据
	 * @param entity
	 * @throws GSSException
	 */
	public void save(ManageFunction entity) throws GSSException;

	/**
	 * 修改ManageFunction数据
	 * @param entity
	 * @throws GSSException
	 */
	public void Update(ManageFunction entity) throws GSSException;
	
	/**
	 * 删除ManageFunction数据
	 * @param entity
	 * @throws GSSException
	 */
	public boolean delete(ManageFunction entity) throws GSSException;
	
	/**
	 * 查询单个ManageFunction
	 * @param id
	 * @return
	 * @throws GSSException
	 */
	public ManageFunction get(ManageFunction entity) throws GSSException;
	
	/**
	 * 根据搜索条件，搜索分页数据
	 * @param pageSize
	 * @param pageNo
	 * @return
	 * @throws GSSException
	 */
	public List<ManageFunction> findAllPage(Page page) throws GSSException;

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageSize
	 * @param pageNo
	 * @return
	 * @throws GSServiceException
	 */
	public int selectCount(Page page) throws GSSException;
	
	/**
	 * 查询菜单所属功能
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public List<ManageFunction> findById(final Integer id) throws DaoException;
	
	/**
	 * 根据功能id查询功能
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public ManageFunction findByFunctionId(final Integer id) throws DaoException;
	
	/**
	 * 获取菜单下的功能
	 * @param pageSize
	 * @param pageNo
	 * @return
	 * @throws GSServiceException
	 */
	public List<ManageFunction> findFunctionByMenu(Integer menuId) throws GSSException;
	
}
