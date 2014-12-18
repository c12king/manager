package com.manage.app.dao;

import java.util.List;

import javax.annotation.Resource;

import org.ietf.jgss.GSSException;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.manage.app.bean.ManageOrg;
import com.manage.app.bean.BusinessPosition;
import com.utis.Page;

@Repository("ManagePositionDao")
@Transactional
public class BusinessPositionDaoImpl implements BusinessPositionDao {
	
	@Resource(name="SqlSessionTemplate") 
	SqlSessionTemplate sqlSessionTemplate;

	
	/**
	 * 保存BusinessPosition数据
	 * @param entity
	 * @throws GSServiceException
	 */
	public String save(BusinessPosition entity) throws GSSException{
		this.sqlSessionTemplate.update("updateBusinessPositionLeaf",entity);
		this.sqlSessionTemplate.insert("addBusinessPosition",entity);
		return entity.getPositionId().toString();
	}

	/**
	 * 修改BusinessPosition数据
	 * @param entity
	 * @throws GSServiceException
	 */
	public void Update(BusinessPosition entity) throws GSSException{
		this.sqlSessionTemplate.update("updateBusinessPositionId",entity);
	}
	
	/**
	 * 删除BusinessPosition数据
	 * @param entity
	 * @throws GSServiceException
	 */
	public boolean delete(BusinessPosition entity) throws GSSException{
		int count=this.sqlSessionTemplate.delete("deleteBusinessPositionId",entity);
		if(count>0){
			return true;
		}else{
			return false;
		}
	}
	
	/**
	 * 查询单个ManagePosition
	 * @param id
	 * @return
	 * @throws GSServiceException
	 */
	public BusinessPosition get(BusinessPosition entity) throws GSSException{
		List<BusinessPosition> list =this.sqlSessionTemplate.selectList("selectBusinessPositionId",entity);
		return list.get(0);
	}
	
	/**
	 * 根据搜索条件，搜索分页数据
	 * @param pageSize
	 * @param pageNo
	 * @return
	 * @throws GSServiceException
	 */
	public List<BusinessPosition> findAllPage(Page page) throws GSSException{
		List<BusinessPosition> list =this.sqlSessionTemplate.selectList("BusinessPositionListData",page);
		
		return list;
	}
	
	public int selectCount(BusinessPosition entity) {
		int count = (Integer) this.sqlSessionTemplate.selectOne("selectBusinessPositionCount",entity);
		return count;
	}

	public List<BusinessPosition> treeData(BusinessPosition entity) {
		List<BusinessPosition> list =this.sqlSessionTemplate.selectList("selectPositionTree",entity);
		return list;
	}
	
}
