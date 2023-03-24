package com.varaisys.intranet.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.varaisys.intranet.model.IntranetMainModel;

/**
 * @Author Kartik Khurana
 * @CreationDate - 13-10-2022
 * @ModifyDate - 13-10-2022
 * @Desc
 */
@Repository
public interface IntranetMainDao {

	List<IntranetMainModel> getAllEmployeeList();

}
