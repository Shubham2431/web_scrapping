package com.varaisys.intranet.service;

import org.springframework.stereotype.Service;

import com.varaisys.intranet.model.UserDetail;

/**
 * @Author Kartik Khurana
 * @CreationDate - 09-11-2022
 * @ModifyDate - 09-11-2022
 * @Desc
 */
@Service
public interface UserDetailService {

	UserDetail loadUserbyUserName(String userName);
}
