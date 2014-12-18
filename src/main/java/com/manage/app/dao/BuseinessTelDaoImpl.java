package com.manage.app.dao;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;





import org.ietf.jgss.GSSException;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.manage.framework.exception.DaoException;
import com.manage.app.bean.BuseinessTel;
import com.manage.app.bean.ManageHouse;
import com.manage.app.vo.BuseinessTelQuery;
import com.utis.Page;

@Repository("BuseinessTelDao")
@Transactional
public class BuseinessTelDaoImpl implements BuseinessTelDao {
	
	@Resource(name="SqlSessionTemplate") 
	SqlSessionTemplate sqlSessionTemplate;

	/**
	 * 查询单个BuseinessTel
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public BuseinessTel findById(final Integer id) throws DaoException {
		BuseinessTel buseinessTel = this.sqlSessionTemplate.selectOne("com.manage.app.dao.BuseinessTelDao.findById",id);
		return buseinessTel;
	}
	
	/**
	 * 无条件查询所有BuseinessTel
	 * @return
	 * @throws DaoException
	 */
	public List<BuseinessTel> findAll() throws DaoException {
		List<BuseinessTel> list = this.sqlSessionTemplate.selectList("com.manage.app.dao.BuseinessTelDao.findAll");
		return list;
	}

	/**
	 * 按Map对象条件查询所有BuseinessTel
	 * @return
	 * @throws DaoException
	 */	
	public List<BuseinessTel> findByMap(final Map<String, Object> paramMap) throws DaoException {
		List<BuseinessTel> list = this.sqlSessionTemplate.selectList("com.manage.app.dao.BuseinessTelDao.findByMap", paramMap);
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BuseinessTel-限制返回条数
	 * @return
	 * @throws DaoException
	 */	
	/*public List<BuseinessTel> findByMap(final Map<String, Object> paramMap, final Integer limit) throws DaoException {
		List<BuseinessTel> list = this.sqlSessionTemplate.selectList("com.manage.app.dao.BuseinessTelDao.findByMap", paramMap, limit);
		return list;
	}*/
	
	/**
	 * 按VO对象条件查询所有BuseinessTel
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<BuseinessTel> findByExample(final BuseinessTelQuery query) throws DaoException {
		List<BuseinessTel> list = this.sqlSessionTemplate.selectList("com.manage.app.dao.BuseinessTelDao.findByExample", query);
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有BuseinessTel-限制返回条数
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	/*public List<BuseinessTel> findByExample(final BuseinessTelQuery query, final Integer limit) throws DaoException {
		List<BuseinessTel> list = this.sqlSessionTemplate.selectList("com.manage.app.dao.BuseinessTelDao.findByExample", query, limit);
		return list;
	}*/
	
	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<BuseinessTel> findAllPage(final BuseinessTelQuery query) throws DaoException {
		List<BuseinessTel> list = this.sqlSessionTemplate.selectList("com.manage.app.dao.BuseinessTelDao.findAllPage",query);
		return list;
	}

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount(final BuseinessTelQuery query) throws DaoException {
		int count = this.sqlSessionTemplate.selectOne("com.manage.app.dao.BuseinessTelDao.selectCount",query);
		return count;
	}
	
	/**
	 * 保存BuseinessTel数据
	 * @param entity
	 * @throws DaoException
	 */
	public void save(final BuseinessTel entity) throws DaoException {
		this.sqlSessionTemplate.insert("com.manage.app.dao.BuseinessTelDao.save",entity);
	}

	/**
	 * 修改BuseinessTel数据
	 * @param entity
	 * @throws DaoException
	 */
	public void update(final BuseinessTel entity) throws DaoException {
		this.sqlSessionTemplate.update("com.manage.app.dao.BuseinessTelDao.update",entity);
	}

	/**
	 * 删除BuseinessTel
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public boolean delete(final Integer id) throws DaoException {
		int count=this.sqlSessionTemplate.delete("com.manage.app.dao.BuseinessTelDao.delete",id);
		if(count>0){
			return true;
		}else{
			return false;
		}
	}
	/**
	 * 根据搜索条件，搜索分页数据
	 * @param pageSize
	 * @param pageNo
	 * @return
	 * @throws GSServiceException
	 */
	public List<ManageHouse> findAllPage(Page page) throws GSSException{
		List<ManageHouse> list =this.sqlSessionTemplate.selectList("EstTelListData",page);
		
		return list;
	}
	public int selectCount(Page page) {
		int count = (Integer) this.sqlSessionTemplate.selectOne("selectEstTelCount",page);
		return count;
	}
}
