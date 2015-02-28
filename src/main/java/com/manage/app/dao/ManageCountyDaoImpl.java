package com.manage.app.dao;

import java.util.List;

import javax.annotation.Resource;

import org.ietf.jgss.GSSException;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.manage.app.bean.ManageCounty;
import com.utis.Page;

@Repository("ManageCountyDao")
@Transactional
public class ManageCountyDaoImpl implements ManageCountyDao {
	
	@Resource(name="SqlSessionTemplate") 
	SqlSessionTemplate sqlSessionTemplate;

	
	/**
	 * 保存ManageCounty数据
	 * @param entity
	 * @throws GSServiceException
	 */
	public void save(ManageCounty entity) throws GSSException{
		this.sqlSessionTemplate.insert("addManageCounty",entity);
	}

	/**
	 * 修改ManageCounty数据
	 * @param entity
	 * @throws GSServiceException
	 */
	public void Update(ManageCounty entity) throws GSSException{
		this.sqlSessionTemplate.update("updateManageCountyId",entity);
	}
	
	/**
	 * 删除ManageCounty数据
	 * @param entity
	 * @throws GSServiceException
	 */
	public boolean delete(ManageCounty entity) throws GSSException{
		int count=this.sqlSessionTemplate.delete("deleteManageCountyId",entity);
		if(count>0){
			return true;
		}else{
			return false;
		}
	}
	
	/**
	 * 查询单个ManageCounty
	 * @param id
	 * @return
	 * @throws GSServiceException
	 */
	public ManageCounty get(ManageCounty entity) throws GSSException{
		List<ManageCounty> list =this.sqlSessionTemplate.selectList("selectManageCountyId",entity);
		return list.get(0);
	}
	
	/**
	 * 根据搜索条件，搜索分页数据
	 * @param pageSize
	 * @param pageNo
	 * @return
	 * @throws GSServiceException
	 */
	public List<ManageCounty> findAllPage(Page page) throws GSSException{
		List<ManageCounty> list =this.sqlSessionTemplate.selectList("ManageCountyListData",page);
		
		return list;
	}
	/**
	 * 根据搜索条件，搜索分页总数
	 * @param page
	 * @return
	 * @throws GSServiceException
	 */
	public int selectCount(Page page) {
		int count = (Integer) this.sqlSessionTemplate.selectOne("selectManageCountyCount",page);
		return count;
	}
	
	/**
	 * 获取菜单树形展示json数据
	 * @param entity
	 * @return
	 * @throws GSSException
	 */
	public List<ManageCounty> treeData(ManageCounty entity) {
		List<ManageCounty> list =this.sqlSessionTemplate.selectList("selectManageCountyTree",entity);
		return list;
	}
	
	
}
