package com.anodiam.LoginRESTAPI.model;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Table(name = "mst_permission")
public class Permission {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private BigInteger permissionId;

	private String permissionName;

	@ManyToMany(mappedBy = "permissionList")
	private Collection<User> userList = new ArrayList<>();

	public Permission(String permissionName) {
		this.permissionName = permissionName;
	}

	public Permission() {
	}

	public void setPermissionId(BigInteger permissionId) {
		this.permissionId = permissionId;
	}

	public BigInteger getPermissionId() {
		return permissionId;
	}

	public String getPermissionName() {
		return permissionName;
	}

	public void setPermissionName(String permissionName) {
		this.permissionName = permissionName;
	}

	public Collection<User> getUserList() {
		return userList;
	}

	public void setUserList(Collection<User> userList) {
		this.userList = userList;
	}
}
