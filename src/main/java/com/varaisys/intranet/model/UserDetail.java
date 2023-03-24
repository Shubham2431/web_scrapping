package com.varaisys.intranet.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @Author Kartik Khurana
 * @CreationDate - 09-11-2022
 * @Desc - Entity to store data in database
 */
@Entity
@Table(name = "user_mst")
public class UserDetail implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private int userId;

	@Column(name = "user_name")
	private String user_name;

	@Column(name = "user_password")
	private String user_password;

	@Column(name = "user_role")
	private String user_role;

	@Column(name = "employee_name")
	private String employee_name;

	@Column(name = "employee_status")
	private String employee_status;

	@Column(name = "crt_date")
	private String crt_date;

	@Column(name = "mod_date")
	private String mod_date;

	@Column(name = "emp_code")
	private String emp_code;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getUser_password() {
		return user_password;
	}

	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}

	public String getUser_role() {
		return user_role;
	}

	public void setUser_role(String user_role) {
		this.user_role = user_role;
	}

	public String getEmployee_name() {
		return employee_name;
	}

	public void setEmployee_name(String employee_name) {
		this.employee_name = employee_name;
	}

	public String getEmployee_status() {
		return employee_status;
	}

	public void setEmployee_status(String employee_status) {
		this.employee_status = employee_status;
	}

	public String getCrt_date() {
		return crt_date;
	}

	public void setCrt_date(String crt_date) {
		this.crt_date = crt_date;
	}

	public String getMod_date() {
		return mod_date;
	}

	public void setMod_date(String mod_date) {
		this.mod_date = mod_date;
	}

	public String getEmp_code() {
		return emp_code;
	}

	public void setEmp_code(String emp_code) {
		this.emp_code = emp_code;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}