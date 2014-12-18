package com.manage.app.dao;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.ietf.jgss.GSSException;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.manage.app.bean.ManageBuilding;
import com.manage.app.bean.BusinessPosition;
import com.utis.Page;

@Repository("ManageBuildingDao")
@Transactional
public class ManageBuildingDaoImpl implements ManageBuildingDao {
	
	@Resource(name="SqlSessionTemplate") 
	SqlSessionTemplate sqlSessionTemplate;

	
	/**
	 * 保存ManageBuilding数据
	 * @param entity
	 * @throws GSServiceException
	 */
	public void save(ManageBuilding entity) throws GSSException{
		this.sqlSessionTemplate.insert("addManageBuilding",entity);
	}

	/**
	 * 修改ManageBuilding数据
	 * @param entity
	 * @throws GSServiceException
	 */
	public void Update(ManageBuilding entity) throws GSSException{
		this.sqlSessionTemplate.update("updateManageBuildingId",entity);
	}
	
	/**
	 * 删除ManageBuilding数据
	 * @param entity
	 * @throws GSServiceException
	 */
	public boolean delete(ManageBuilding entity) throws GSSException{
		int count=this.sqlSessionTemplate.delete("deleteManageBuildingId",entity);
		if(count>0){
			return true;
		}else{
			return false;
		}
	}
	
	/**
	 * 查询单个ManageBuilding
	 * @param id
	 * @return
	 * @throws GSServiceException
	 */
	public ManageBuilding get(ManageBuilding entity) throws GSSException{
		List<ManageBuilding> list =this.sqlSessionTemplate.selectList("selectManageBuildingId",entity);
		return list.get(0);
	}
	
	/**
	 * 根据搜索条件，搜索分页数据
	 * @param pageSize
	 * @param pageNo
	 * @return
	 * @throws GSServiceException
	 */
	public List<ManageBuilding> findAllPage(Page page) throws GSSException{
		List<ManageBuilding> list =this.sqlSessionTemplate.selectList("ManageBuildingListData",page);
		
		return list;
	}
	
	public int selectCount(Page page) {
		int count = (Integer) this.sqlSessionTemplate.selectOne("selectManageBuildingCount",page);
		return count;
	}
	
	public List<ManageBuilding> treeData(ManageBuilding entity) {
		List<ManageBuilding> list =this.sqlSessionTemplate.selectList("selectManageBuildingTree",entity);
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有ManageBuilding
	 * @return
	 * @throws ServiceException
	 */	
	public List<ManageBuilding> findByMap(final Map<String, Object> paramMap) throws GSSException {
		List<ManageBuilding> list =this.sqlSessionTemplate.selectList("manage_building_findByMap",paramMap);
		return list;
	}
	
}
