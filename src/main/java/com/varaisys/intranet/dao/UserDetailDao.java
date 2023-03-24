package com.varaisys.intranet.dao;

import org.springframework.stereotype.Repository;

import com.varaisys.intranet.model.UserDetail;

/**
 * @Author Kartik Khurana
 * @CreationDate - 09-11-2022
 * @ModifyDate - 09-11-2022
 * @Desc
 */
@Repository
public interface UserDetailDao {

	UserDetail loadUserbyUserName(String userName);
}
