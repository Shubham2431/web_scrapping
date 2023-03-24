package com.varaisys.intranet.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.varaisys.intranet.serviceImpl.CustomUsersDetailService;
import com.varaisys.intranet.utils.JwtRequest;
import com.varaisys.intranet.utils.JwtUtil;

/**
 * @Author Kartik Khurana
 * @CreationDate - 9-11-2022
 * @ModifyDate - 10-11-2022
 * @Desc Class for Controlling Security API'S
 */
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class SecurityRestController {

	@Autowired
	AuthenticationManager authenticationManager;
	@Autowired
	CustomUsersDetailService customUsersDetailService;
	@Autowired
	JwtUtil jwtUtil;

	/**
	 * @Author Kartik Khurana
	 * @CreationDate - 9-11-2022
	 * @ModifyDate - 10-11-2022
	 * @Desc Api to generate Token
	 */
	@RequestMapping(value = { "/token" }, method = RequestMethod.GET)
	public ResponseEntity<?> generateToken(@RequestBody JwtRequest jwtRequest) {
		Map<String, Object> map = new HashMap<String, Object>();
		System.out.println("username and password=>>>>" + jwtRequest.getUser_name() + jwtRequest.getUser_password());
		try {
			this.authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(jwtRequest.getUser_name(), jwtRequest.getUser_password()));
			UserDetails userDetails = customUsersDetailService.loadUserByUsername(jwtRequest.getUser_name());
			String token = jwtUtil.generateToken(userDetails);
			map.put("status", "successfull");
			map.put("token", token);
		} catch (Exception e) {
			map.put("STATUS", "error");
			map.put("MESSAGE", "Provide Valid Credentials.");
		}
		return ResponseEntity.ok().body(map);

	}

	@RequestMapping(value = { "/ADMIN" }, method = RequestMethod.GET)
	public String getAdmin() {
		return "Your Role ==> Admin";
	}

}
