package com.varaisys.intranet.daoImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;

import com.varaisys.intranet.dao.AbstractDao;
import com.varaisys.intranet.dao.IntranetMainDao;
import com.varaisys.intranet.model.IntranetMainModel;

/**
 * @Author Kartik Khurana
 * @CreationDate - 13-10-2022
 * @ModifyDate - 13-10-2022
 * @Desc
 */

@Repository("intranetMainDao")
public class IntranetMainDaoImpl extends AbstractDao<Integer, IntranetMainModel> implements IntranetMainDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<IntranetMainModel> getAllEmployeeList() {
		System.out.println("dao");
		Criteria criteria = createEntityCriteria();
		return criteria.list();
	}

}
