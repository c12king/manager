package com.manage.app.dao;

import java.util.List;

import javax.annotation.Resource;

import org.ietf.jgss.GSSException;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.manage.app.bean.BusinessCommunity;
import com.manage.app.bean.ManageFunction;
import com.manage.framework.exception.DaoException;
import com.utis.Page;

@Repository("ManageFunctionDao")
@Transactional
public class ManageFunctionDaoImpl implements ManageFunctionDao {
	
	@Resource(name="SqlSessionTemplate") 
	SqlSessionTemplate sqlSessionTemplate;
	
	/**
	 * 保存ManageFunction数据
	 * @param entity
	 * @throws GSServiceException
	 */
	public void save(ManageFunction entity) throws GSSException{
		this.sqlSessionTemplate.insert("addManageFunction",entity);
	}

	/**
	 * 修改ManageFunction数据
	 * @param entity
	 * @throws GSServiceException
	 */
	public void Update(ManageFunction entity) throws GSSException{
		this.sqlSessionTemplate.update("updateManageFunctionId",entity);
	}
	
	/**
	 * 删除ManageFunction数据
	 * @param entity
	 * @throws GSServiceException
	 */
	public boolean delete(ManageFunction entity) throws GSSException{
		int count=this.sqlSessionTemplate.delete("deleteManageFunctionId",entity);
		if(count>0){
			return true;
		}else{
			return false;
		}
	}
	
	/**
	 * 查询单个ManageFunction
	 * @param id
	 * @return
	 * @throws GSServiceException
	 */
	public ManageFunction get(ManageFunction entity) throws GSSException{
		List<ManageFunction> list =this.sqlSessionTemplate.selectList("selectManageFunctionId",entity);
		return list.get(0);
	}
	
	/**
	 * 根据搜索条件，搜索分页数据
	 * @param pageSize
	 * @param pageNo
	 * @return
	 * @throws GSServiceException
	 */
	public List<ManageFunction> findAllPage(Page page) throws GSSException{
		List<ManageFunction> list =this.sqlSessionTemplate.selectList("ManageFunctionListData",page);
		
		return list;
	}
	public int selectCount(Page page) {
		int count = (Integer) this.sqlSessionTemplate.selectOne("selectManageFunctionCount",page);
		return count;
	}
	

	/**
	 * 查询菜单所属功能
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public List<ManageFunction> findById(final Integer id) throws DaoException {
		List<ManageFunction> list = this.sqlSessionTemplate.selectList("findFunctionByMneuId",id);
		return list;
	}
	
	/**
	 * 根据功能id查询功能
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public ManageFunction findByFunctionId(final Integer id) throws DaoException {
		ManageFunction manageFunction = this.sqlSessionTemplate.selectOne("findByFunctionId",id);
		return manageFunction;
	}
}
