package com.varaisys.intranet.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.varaisys.intranet.model.UserDetail;
import com.varaisys.intranet.service.UserDetailService;

/**
 * @Author Kartik Khurana
 * @CreationDate - 09-11-2022
 * @ModifyDate - 09-11-2022
 * @Desc
 */
@Service
public class CustomUsersDetailService implements UserDetailsService {

	@Autowired
	UserDetailService usersDetailService;

	UserDetail userDetail;

	/**
	 * @Author Kartik Khurana
	 * @CreationDate - 09-11-2022
	 * @ModifyDate - 09-11-2022
	 * @Desc - Loading User by Username
	 * @param -
	 */
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println("CustomUsersDetailService parameter" + username);

		try {
			userDetail = this.usersDetailService.loadUserbyUserName(username);
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println(userDetail.getUser_name() + "CustomUsersDetailService");
		List<SimpleGrantedAuthority> authorities = new ArrayList<>();
		if (userDetail != null) {
			authorities.add(new SimpleGrantedAuthority("ROLE_" + userDetail.getUser_role()));
			return new User(userDetail.getUser_name(), userDetail.getUser_password(), authorities);
		} else {
			return null;
		}
	}

}
