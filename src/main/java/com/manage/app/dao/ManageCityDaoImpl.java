package com.manage.app.dao;

import java.util.List;

import javax.annotation.Resource;

import org.ietf.jgss.GSSException;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.manage.app.bean.ManageCity;
import com.manage.app.bean.ManageUnit;
import com.utis.Page;

@Repository("ManageCityDao")
@Transactional
public class ManageCityDaoImpl implements ManageCityDao {
	
	@Resource(name="SqlSessionTemplate") 
	SqlSessionTemplate sqlSessionTemplate;

	
	/**
	 * 保存ManageCity数据
	 * @param entity
	 * @throws GSServiceException
	 */
	public void save(ManageCity entity) throws GSSException{
		this.sqlSessionTemplate.insert("addManageCity",entity);
	}

	/**
	 * 修改ManageCity数据
	 * @param entity
	 * @throws GSServiceException
	 */
	public void Update(ManageCity entity) throws GSSException{
		this.sqlSessionTemplate.update("updateManageCityId",entity);
	}
	
	/**
	 * 删除ManageCity数据
	 * @param entity
	 * @throws GSServiceException
	 */
	public boolean delete(ManageCity entity) throws GSSException{
		int count=this.sqlSessionTemplate.delete("deleteManageCityId",entity);
		if(count>0){
			return true;
		}else{
			return false;
		}
	}
	
	/**
	 * 查询单个ManageCity
	 * @param id
	 * @return
	 * @throws GSServiceException
	 */
	public ManageCity get(ManageCity entity) throws GSSException{
		List<ManageCity> list =this.sqlSessionTemplate.selectList("selectManageCityId",entity);
		return list.get(0);
	}
	
	/**
	 * 根据搜索条件，搜索分页数据
	 * @param pageSize
	 * @param pageNo
	 * @return
	 * @throws GSServiceException
	 */
	public List<ManageCity> findAllPage(Page page) throws GSSException{
		List<ManageCity> list =this.sqlSessionTemplate.selectList("ManageCityListData",page);
		
		return list;
	}
	/**
	 * 根据搜索条件，搜索分页总数
	 * @param page
	 * @return
	 * @throws GSServiceException
	 */
	public int selectCount(Page page) {
		int count = (Integer) this.sqlSessionTemplate.selectOne("selectManageCityCount",page);
		return count;
	}
	
	/**
	 * 获取菜单树形展示json数据
	 * @param entity
	 * @return
	 * @throws GSSException
	 */
	public List<ManageCity> treeData(ManageCity entity) {
		List<ManageCity> list =this.sqlSessionTemplate.selectList("selectManageCityTree",entity);
		return list;
	}
	
}
