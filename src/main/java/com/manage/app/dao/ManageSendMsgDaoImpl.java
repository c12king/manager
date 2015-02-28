package com.manage.app.dao;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.ietf.jgss.GSSException;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.manage.app.bean.ManageSendMsg;
import com.manage.app.vo.ManageSendMsgQuery;
import com.manage.framework.exception.DaoException;
import com.utis.Page;

@Repository("ManageSendMsgDao")
@Transactional
public class ManageSendMsgDaoImpl implements ManageSendMsgDao {
	
	@Resource(name="SqlSessionTemplate") 
	SqlSessionTemplate sqlSessionTemplate;

	/**
	 * 查询单个ManageSendMsg
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public ManageSendMsg findById(final Integer id) throws DaoException {
		ManageSendMsg manageSendMsg = this.sqlSessionTemplate.selectOne("com.manage.app.dao.ManageSendMsgDao.findById",id);
		return manageSendMsg;
	}
	
	/**
	 * 无条件查询所有ManageSendMsg
	 * @return
	 * @throws DaoException
	 */
	public List<ManageSendMsg> findAll() throws DaoException {
		List<ManageSendMsg> list = this.sqlSessionTemplate.selectList("com.manage.app.dao.ManageSendMsgDao.findAll");
		return list;
	}

	/**
	 * 按Map对象条件查询所有ManageSendMsg
	 * @return
	 * @throws DaoException
	 */	
	public List<ManageSendMsg> findByMap(final Map<String, Object> paramMap) throws DaoException {
		List<ManageSendMsg> list = this.sqlSessionTemplate.selectList("com.manage.app.dao.ManageSendMsgDao.findByMap", paramMap);
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有ManageSendMsg-限制返回条数
	 * @return
	 * @throws DaoException
	 */	
	/*public List<ManageSendMsg> findByMap(final Map<String, Object> paramMap, final Integer limit) throws DaoException {
		List<ManageSendMsg> list = this.sqlSessionTemplate.selectList("com.manage.app.dao.ManageSendMsgDao.findByMap", paramMap, limit);
		return list;
	}*/
	
	/**
	 * 按VO对象条件查询所有ManageSendMsg
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<ManageSendMsg> findByExample(final ManageSendMsgQuery query) throws DaoException {
		List<ManageSendMsg> list = this.sqlSessionTemplate.selectList("com.manage.app.dao.ManageSendMsgDao.findByExample", query);
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有ManageSendMsg-限制返回条数
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	/*public List<ManageSendMsg> findByExample(final ManageSendMsgQuery query, final Integer limit) throws DaoException {
		List<ManageSendMsg> list = this.sqlSessionTemplate.selectList("com.manage.app.dao.ManageSendMsgDao.findByExample", query, limit);
		return list;
	}*/
	
	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<ManageSendMsg> findAllPage(final ManageSendMsgQuery query) throws DaoException {
		List<ManageSendMsg> list = this.sqlSessionTemplate.selectList("com.manage.app.dao.ManageSendMsgDao.findAllPage",query);
		return list;
	}

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount(final ManageSendMsgQuery query) throws DaoException {
		int count = this.sqlSessionTemplate.selectOne("com.manage.app.dao.ManageSendMsgDao.selectCount",query);
		return count;
	}
	
	/**
	 * 保存ManageSendMsg数据
	 * @param entity
	 * @throws DaoException
	 */
	public void save(final ManageSendMsg entity) throws DaoException {
		this.sqlSessionTemplate.insert("com.manage.app.dao.ManageSendMsgDao.save",entity);
	}

	/**
	 * 修改ManageSendMsg数据
	 * @param entity
	 * @throws DaoException
	 */
	public void update(final ManageSendMsg entity) throws DaoException {
		this.sqlSessionTemplate.update("com.manage.app.dao.ManageSendMsgDao.update",entity);
	}

	/**
	 * 删除ManageSendMsg
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public boolean delete(final Integer id) throws DaoException {
		int count=this.sqlSessionTemplate.delete("com.manage.app.dao.ManageSendMsgDao.delete",id);
		if(count>0){
			return true;
		}else{
			return false;
		}
	}

	public List<ManageSendMsg> SendMsgListData(Page page) throws GSSException {

		
		List<ManageSendMsg> list = this.sqlSessionTemplate.selectList("SendMsgListData",page);
		return list;
	}

	public int selectSendMsgCount(Page page) throws GSSException {
		int count = (Integer) this.sqlSessionTemplate.selectOne("selectSendMsgCount",page);
		return count;
	}
	
}
