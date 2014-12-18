package com.manage.app.dao;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;




import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.manage.framework.exception.DaoException;
import com.manage.framework.exception.ServiceException;
import com.manage.app.bean.ManageModulemenu;
import com.manage.app.vo.ManageModulemenuQuery;

@Repository("ManageModulemenuDao")
@Transactional
public class ManageModulemenuDaoImpl implements ManageModulemenuDao {
	
	@Resource(name="SqlSessionTemplate") 
	SqlSessionTemplate sqlSessionTemplate;

	/**
	 * 查询moduleId=id的ManageModulemenu
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public List<ManageModulemenu> findById(final Integer id) throws DaoException {
		List<ManageModulemenu> list = this.sqlSessionTemplate.selectList("com.manage.app.dao.ManageModulemenuDao.findById",id);
		return list;
	}
	
	/**
	 * 查询moduleId=id的ManageModulemenu
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public List<ManageModulemenu> findByIdModuleId(final Integer id) throws DaoException {
		List<ManageModulemenu> list = this.sqlSessionTemplate.selectList("com.manage.app.dao.ManageModulemenuDao.findByIdModuleId",id);
		return list;
	}
	
	/**
	 * 无条件查询所有ManageModulemenu
	 * @return
	 * @throws DaoException
	 */
	public List<ManageModulemenu> findAll() throws DaoException {
		List<ManageModulemenu> list = this.sqlSessionTemplate.selectList("com.manage.app.dao.ManageModulemenuDao.findAll");
		return list;
	}

	/**
	 * 按Map对象条件查询所有ManageModulemenu
	 * @return
	 * @throws DaoException
	 */	
	public List<ManageModulemenu> findByMap(final Map<String, Object> paramMap) throws DaoException {
		List<ManageModulemenu> list = this.sqlSessionTemplate.selectList("com.manage.app.dao.ManageModulemenuDao.findByMap", paramMap);
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有ManageModulemenu-限制返回条数
	 * @return
	 * @throws DaoException
	 */	
	public List<ManageModulemenu> findByMap(final Map<String, Object> paramMap, final Integer limit) throws DaoException {
		List<ManageModulemenu> list = this.sqlSessionTemplate.selectList("com.manage.app.dao.ManageModulemenuDao.findByMap");
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有ManageModulemenu
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<ManageModulemenu> findByExample(final ManageModulemenuQuery query) throws DaoException {
		List<ManageModulemenu> list = this.sqlSessionTemplate.selectList("com.manage.app.dao.ManageModulemenuDao.findByExample", query);
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有ManageModulemenu-限制返回条数
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<ManageModulemenu> findByExample(final ManageModulemenuQuery query, final Integer limit) throws DaoException {
		List<ManageModulemenu> list = this.sqlSessionTemplate.selectList("com.manage.app.dao.ManageModulemenuDao.findByExample", query);
		return list;
	}
	
	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<ManageModulemenu> findAllPage(final ManageModulemenuQuery query) throws DaoException {
		List<ManageModulemenu> list = this.sqlSessionTemplate.selectList("com.manage.app.dao.ManageModulemenuDao.findAllPage",query);
		return list;
	}

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount(final ManageModulemenuQuery query) throws DaoException {
		int count = this.sqlSessionTemplate.selectOne("com.manage.app.dao.ManageModulemenuDao.selectCount",query);
		return count;
	}
	
	/**
	 * 保存ManageModulemenu数据
	 * @param entity
	 * @throws DaoException
	 */
	public void save(final ManageModulemenu entity) throws DaoException {
		this.sqlSessionTemplate.insert("com.manage.app.dao.ManageModulemenuDao.save",entity);
	}

	/**
	 * 修改ManageModulemenu数据
	 * @param entity
	 * @throws DaoException
	 */
	public void update(final ManageModulemenu entity) throws DaoException {
		this.sqlSessionTemplate.update("com.manage.app.dao.ManageModulemenuDao.update",entity);
	}

	/**
	 * 删除ManageModulemenu
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public boolean delete(final Integer id) throws DaoException {
		int count=this.sqlSessionTemplate.delete("com.manage.app.dao.ManageModulemenuDao.delete",id);
		if(count>0){
			return true;
		}else{
			return false;
		}
	}
	
}
