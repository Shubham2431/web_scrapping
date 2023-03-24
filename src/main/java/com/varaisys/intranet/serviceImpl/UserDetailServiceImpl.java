package com.varaisys.intranet.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.varaisys.intranet.dao.UserDetailDao;
import com.varaisys.intranet.model.UserDetail;
import com.varaisys.intranet.service.UserDetailService;

/**
 * @Author Kartik Khurana
 * @CreationDate - 09-11-2022
 * @ModifyDate - 09-11-2022
 * @Desc
 */
@Service
@Transactional("mydb")
public class UserDetailServiceImpl implements UserDetailService {

	@Autowired
	UserDetailDao userDetailDao;

	@Override
	public UserDetail loadUserbyUserName(String userName) {
		System.out.println("UserDetailServiceImpl");
		UserDetail userDetail = userDetailDao.loadUserbyUserName(userName);
		return userDetail;
	}

}
