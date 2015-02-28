package com.manage.app.dao;

import java.util.List;

import javax.annotation.Resource;

import org.ietf.jgss.GSSException;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.manage.app.bean.BusinessDepartment;
import com.utis.Page;

@Repository("BusinessDepartmentDao")
@Transactional
public class BusinessDepartmentDaoImpl implements BusinessDepartmentDao {
	
	@Resource(name="SqlSessionTemplate") 
	SqlSessionTemplate sqlSessionTemplate;

	
	/**
	 * 保存BusinessDepartment数据
	 * @param entity
	 * @throws GSServiceException
	 */
	public void save(BusinessDepartment entity) throws GSSException{
		this.sqlSessionTemplate.insert("addBusinessDepartment",entity);
	}

	/**
	 * 修改BusinessDepartment数据
	 * @param entity
	 * @throws GSServiceException
	 */
	public void Update(BusinessDepartment entity) throws GSSException{
		this.sqlSessionTemplate.update("updateBusinessDepartmentId",entity);
	}
	
	/**
	 * 删除BusinessDepartment数据
	 * @param entity
	 * @throws GSServiceException
	 */
	public boolean delete(BusinessDepartment entity) throws GSSException{
		int count=this.sqlSessionTemplate.delete("deleteBusinessDepartmentId",entity);
		if(count>0){
			return true;
		}else{
			return false;
		}
	}
	
	/**
	 * 查询单个BusinessDepartment
	 * @param id
	 * @return
	 * @throws GSServiceException
	 */
	public BusinessDepartment get(BusinessDepartment entity) throws GSSException{
		List<BusinessDepartment> list =this.sqlSessionTemplate.selectList("selectBusinessDepartmentId",entity);
		return list.get(0);
	}
	
	/**
	 * 根据搜索条件，搜索分页数据
	 * @param pageSize
	 * @param pageNo
	 * @return
	 * @throws GSServiceException
	 */
	public List<BusinessDepartment> findAllPage(Page page) throws GSSException{
		List<BusinessDepartment> list =this.sqlSessionTemplate.selectList("BusinessDepartmentListData",page);
		
		return list;
	}
	/**
	 * 根据搜索条件，搜索分页总数
	 * @param page
	 * @return
	 * @throws GSServiceException
	 */
	public int selectCount(Page page) {
		int count = (Integer) this.sqlSessionTemplate.selectOne("selectBusinessDepartmentCount",page);
		return count;
	}
	
	/**
	 * 获取菜单树形展示json数据
	 * @param entity
	 * @return
	 * @throws GSSException
	 */
	public List<BusinessDepartment> treeData(BusinessDepartment entity) {
		List<BusinessDepartment> list =this.sqlSessionTemplate.selectList("selectBusinessDepartmentTree",entity);
		return list;
	}
}
