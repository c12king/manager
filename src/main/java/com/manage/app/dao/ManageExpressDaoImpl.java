package com.manage.app.dao;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.manage.app.bean.ManageExpress;
import com.manage.app.vo.ManageExpressQuery;
import com.manage.framework.exception.DaoException;

@Repository("ManageExpressDao")
@Transactional
public class ManageExpressDaoImpl implements ManageExpressDao {
	
	@Resource(name="SqlSessionTemplate") 
	SqlSessionTemplate sqlSessionTemplate;

	/**
	 * 查询单个ManageExpress
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public ManageExpress findById(final Integer id) throws DaoException {
		ManageExpress manageExpress = this.sqlSessionTemplate.selectOne("com.manage.app.dao.ManageExpressDao.findById",id);
		return manageExpress;
	}
	
	/**
	 * 无条件查询所有ManageExpress
	 * @return
	 * @throws DaoException
	 */
	public List<ManageExpress> findAll() throws DaoException {
		List<ManageExpress> list = this.sqlSessionTemplate.selectList("com.manage.app.dao.ManageExpressDao.findAll");
		return list;
	}

	/**
	 * 按Map对象条件查询所有ManageExpress
	 * @return
	 * @throws DaoException
	 */	
	public List<ManageExpress> findByMap(final Map<String, Object> paramMap) throws DaoException {
		List<ManageExpress> list = this.sqlSessionTemplate.selectList("com.manage.app.dao.ManageExpressDao.findByMap", paramMap);
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有ManageExpress-限制返回条数
	 * @return
	 * @throws DaoException
	 */	
	/*public List<ManageExpress> findByMap(final Map<String, Object> paramMap, final Integer limit) throws DaoException {
		List<ManageExpress> list = this.sqlSessionTemplate.selectList("com.manage.app.dao.ManageExpressDao.findByMap", paramMap, limit);
		return list;
	}*/
	
	/**
	 * 按VO对象条件查询所有ManageExpress
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<ManageExpress> findByExample(final ManageExpressQuery query) throws DaoException {
		List<ManageExpress> list = this.sqlSessionTemplate.selectList("com.manage.app.dao.ManageExpressDao.findByExample", query);
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有ManageExpress-限制返回条数
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	/*public List<ManageExpress> findByExample(final ManageExpressQuery query, final Integer limit) throws DaoException {
		List<ManageExpress> list = this.sqlSessionTemplate.selectList("com.manage.app.dao.ManageExpressDao.findByExample", query, limit);
		return list;
	}*/
	
	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<ManageExpress> findAllPage(final ManageExpressQuery query) throws DaoException {
		List<ManageExpress> list = this.sqlSessionTemplate.selectList("com.manage.app.dao.ManageExpressDao.findAllPage",query);
		return list;
	}

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount(final ManageExpressQuery query) throws DaoException {
		int count = this.sqlSessionTemplate.selectOne("com.manage.app.dao.ManageExpressDao.selectCount",query);
		return count;
	}
	
	/**
	 * 保存ManageExpress数据
	 * @param entity
	 * @throws DaoException
	 */
	public void save(final ManageExpress entity) throws DaoException {
		this.sqlSessionTemplate.insert("com.manage.app.dao.ManageExpressDao.save",entity);
	}

	/**
	 * 修改ManageExpress数据
	 * @param entity
	 * @throws DaoException
	 */
	public void update(final ManageExpress entity) throws DaoException {
		this.sqlSessionTemplate.update("com.manage.app.dao.ManageExpressDao.update",entity);
	}

	/**
	 * 删除ManageExpress
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public boolean delete(final Integer id) throws DaoException {
		int count=this.sqlSessionTemplate.delete("com.manage.app.dao.ManageExpressDao.delete",id);
		if(count>0){
			return true;
		}else{
			return false;
		}
	}
	
}
