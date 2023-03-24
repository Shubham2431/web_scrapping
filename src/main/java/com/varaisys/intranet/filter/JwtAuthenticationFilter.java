package com.varaisys.intranet.filter;

import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Service;
import org.springframework.web.filter.OncePerRequestFilter;
import com.varaisys.intranet.serviceImpl.CustomUsersDetailService;
import com.varaisys.intranet.utils.JwtUtil;

/**
 * @Author Kartik Khurana
 * @CreationDate - 9-11-2022
 * @ModifyDate - 9-11-2022
 * @Desc Filter class for Authenticating Jwt Token
 */
@Service
public class JwtAuthenticationFilter extends OncePerRequestFilter {
	@Autowired
	private JwtUtil jwtUtil;
	@Autowired
	private CustomUsersDetailService customUsersDetailService;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		System.out.println("doFilterInternal");
		String requestTokenHeader = request.getHeader("Authorization");
		System.out.println("======>>>>>>" + requestTokenHeader);
		String username = null;
		String jwtToken = null;
		UserDetails userDetails = null;
		if (requestTokenHeader != null && requestTokenHeader.startsWith("Bearer ")) {
			jwtToken = requestTokenHeader.substring(7);
			System.out.println(jwtToken);
			try {
				System.out.println("filter");
				username = this.jwtUtil.extractUsername(jwtToken);
				System.out.println(username);
				userDetails = customUsersDetailService.loadUserByUsername(username);
				System.out.println(userDetails.getPassword() + "  from usd");
			} catch (Exception e) {
//						e.printStackTrace();
				System.out.println("token is not valid");
			}
			// security
			if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
				System.out.println("filter if");
				UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
						userDetails, null, userDetails.getAuthorities());
				usernamePasswordAuthenticationToken
						.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
			} else {
				System.out.println("Token is not Valid");
			}

		} else {
//			System.out.println("Credentials are not Valid");
		}
		request.setAttribute("username", username);
		filterChain.doFilter(request, response);
	}
}