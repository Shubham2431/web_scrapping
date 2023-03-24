package com.varaisys.intranet.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.varaisys.intranet.model.IntranetMainModel;

/**
 * @Author Kartik Khurana
 * @CreationDate - 13-10-2022
 * @ModifyDate - 13-10-2022
 * @Desc
 */
@Service
public interface IntranetMainService {

	List<IntranetMainModel> getAllEmployeeList();

}
