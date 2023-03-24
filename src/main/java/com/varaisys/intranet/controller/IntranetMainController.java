package com.varaisys.intranet.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.varaisys.intranet.model.IntranetMainModel;
//import com.varaisys.intranet.model.UserDetail;
import com.varaisys.intranet.service.IntranetMainService;
//import com.varaisys.intranet.service.UserDetailService;

/**
 * @Author Kartik Khurana
 * @CreationDate - 13-10-2022
 * @ModifyDate - 13-10-2022
 * @Desc
 */
@RestController
@RequestMapping("/api")
public class IntranetMainController {

	@Autowired
	private IntranetMainService intranetMainService;

//	@Autowired
//	private UserDetailService userDetailService;
	@GetMapping(value = "/")
	public String hello() {

		return "hello";
	}

	@RequestMapping(value = { "/allEmployee" }, method = RequestMethod.GET)
	public ResponseEntity<?> getAllEmployee() {
		System.out.println("controller");
		Map<String, Object> map = new HashMap<String, Object>();
		List<IntranetMainModel> intranetMainModel = intranetMainService.getAllEmployeeList();
		if (intranetMainModel != null) {
			map.put("STATUS", 1);
			map.put("MESSAGE", "All Employee Details");
			map.put("EMPLOYEES", intranetMainModel);
		} else {
			map.put("STATUS", 0);
			map.put("MESSAGE", "Something went error.");
		}
		return ResponseEntity.ok().body(map);
	}

//	@RequestMapping(value = { "/userName" }, method = RequestMethod.GET)
//	public ResponseEntity<?> userName() {
//		System.out.println("controller");
//		Map<String, Object> map = new HashMap<String, Object>();
//		UserDetail userDetail = userDetailService.loadUserbyUserName("kartik123");
//		if (userDetail != null) {
//			map.put("STATUS", 1);
//			map.put("MESSAGE", "All Employee Details");
//			map.put("EMPLOYEES", userDetail.getUser_password());
//		} else {
//			map.put("STATUS", 0);
//			map.put("MESSAGE", "Something went error.");
//		}
//		return ResponseEntity.ok().body(map);
//	}

}
