package com.varaisys.intranet.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.varaisys.intranet.dao.IntranetMainDao;
import com.varaisys.intranet.model.IntranetMainModel;
import com.varaisys.intranet.service.IntranetMainService;

/**
 * @Author Kartik Khurana
 * @CreationDate - 13-10-2022
 * @ModifyDate - 13-10-2022
 * @Desc
 */

@Service
@Transactional("mydb")
public class IntranetMainServiceImpl implements IntranetMainService {

	@Autowired
	private IntranetMainDao intranetMainDao;

	@Override
	public List<IntranetMainModel> getAllEmployeeList() {
		System.out.println("serviceimpl");
		return intranetMainDao.getAllEmployeeList();
	}

}
