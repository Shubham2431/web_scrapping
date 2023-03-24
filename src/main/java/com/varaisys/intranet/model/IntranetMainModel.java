package com.varaisys.intranet.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @Author Kartik Khurana
 * @CreationDate - 13-10-2022
 * @Desc - Entity to store data in database
 */
@Entity
@Table(name = "intranetmain")
public class IntranetMainModel {

	@Id
	@Column(name = "id")
	private int id;
	@Column(name = "name")
	private String name;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
