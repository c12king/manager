package com.manage.app.dao;

import java.util.List;
import java.util.Map;







import org.ietf.jgss.GSSException;
import org.springframework.stereotype.Repository;

import com.manage.framework.exception.DaoException;
import com.manage.app.bean.ManageHouse;
import com.manage.app.bean.ManageSendMsg;
import com.manage.app.vo.ManageSendMsgQuery;
import com.utis.Page;

@Repository
public interface ManageSendMsgDao {
		
	/**
	 * 查询单个ManageSendMsg
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public ManageSendMsg findById(final Integer id) throws DaoException;
	
	/**
	 * 无条件查询所有ManageSendMsg
	 * @return
	 * @throws DaoException
	 */
	public List<ManageSendMsg> findAll() throws DaoException;

	/**
	 * 按Map对象条件查询所有ManageSendMsg
	 * @return
	 * @throws DaoException
	 */	
	public List<ManageSendMsg> findByMap(final Map<String, Object> paramMap) throws DaoException;
	
	/**
	 * 按Map对象条件查询所有ManageSendMsg-限制返回条数
	 * @return
	 * @throws DaoException
	 */	
	//public List<ManageSendMsg> findByMap(final Map<String, Object> paramMap, final Integer limit) throws DaoException;
	
	/**
	 * 按VO对象条件查询所有ManageSendMsg
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<ManageSendMsg> findByExample(final ManageSendMsgQuery query) throws DaoException;	

	/**
	 * 按VO对象条件查询所有ManageSendMsg-限制返回条数
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	//public List<ManageSendMsg> findByExample(final ManageSendMsgQuery query, final Integer limit) throws DaoException;	

	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<ManageSendMsg> findAllPage(final ManageSendMsgQuery query) throws DaoException;

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount(final ManageSendMsgQuery query) throws DaoException;
	
	/**
	 * 保存ManageSendMsg数据
	 * @param entity
	 * @throws DaoException
	 */
	public void save(final ManageSendMsg entity) throws DaoException;
	
	/**
	 * 修改ManageSendMsg数据
	 * @param entity
	 * @throws DaoException
	 */
	public void update(final ManageSendMsg entity) throws DaoException;

	/**
	 * 删除ManageSendMsg
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public boolean delete(final Integer id) throws DaoException;

	public List<ManageSendMsg> SendMsgListData(Page page) throws GSSException;;

	public int selectSendMsgCount(Page page)  throws GSSException;;

}
