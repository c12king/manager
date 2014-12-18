package com.manage.app.dao;

import java.util.List;

import javax.annotation.Resource;

import org.ietf.jgss.GSSException;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.manage.app.bean.ManageBuilding;
import com.manage.app.bean.ManageUnit;
import com.utis.Page;

@Repository("ManageUnitDao")
@Transactional
public class ManageUnitDaoImpl implements ManageUnitDao {
	
	@Resource(name="SqlSessionTemplate") 
	SqlSessionTemplate sqlSessionTemplate;

	
	/**
	 * 保存ManageUnit数据
	 * @param entity
	 * @throws GSServiceException
	 */
	public void save(ManageUnit entity) throws GSSException{
		this.sqlSessionTemplate.insert("addManageUnit",entity);
	}

	/**
	 * 修改ManageUnit数据
	 * @param entity
	 * @throws GSServiceException
	 */
	public void Update(ManageUnit entity) throws GSSException{
		this.sqlSessionTemplate.update("updateManageUnitId",entity);
	}
	
	/**
	 * 删除ManageUnit数据
	 * @param entity
	 * @throws GSServiceException
	 */
	public boolean delete(ManageUnit entity) throws GSSException{
		int count=this.sqlSessionTemplate.delete("deleteManageUnitId",entity);
		if(count>0){
			return true;
		}else{
			return false;
		}
	}
	
	/**
	 * 查询单个ManageUnit
	 * @param id
	 * @return
	 * @throws GSServiceException
	 */
	public ManageUnit get(ManageUnit entity) throws GSSException{
		List<ManageUnit> list =this.sqlSessionTemplate.selectList("selectManageUnitId",entity);
		return list.get(0);
	}
	
	/**
	 * 根据搜索条件，搜索分页数据
	 * @param pageSize
	 * @param pageNo
	 * @return
	 * @throws GSServiceException
	 */
	public List<ManageUnit> findAllPage(Page page) throws GSSException{
		List<ManageUnit> list =this.sqlSessionTemplate.selectList("ManageUnitListData",page);
		
		return list;
	}
	public int selectCount(Page page) {
		int count = (Integer) this.sqlSessionTemplate.selectOne("selectManageUnitCount",page);
		return count;
	}
	
	/**
	 * 获取菜单树形展示json数据
	 * @param entity
	 * @return
	 * @throws GSSException
	 */
	public List<ManageUnit> treeData(ManageUnit entity) {
		List<ManageUnit> list =this.sqlSessionTemplate.selectList("selectManageUnitTree",entity);
		return list;
	}
	
}
