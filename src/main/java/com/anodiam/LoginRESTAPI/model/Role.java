package com.anodiam.LoginRESTAPI.model;

import com.anodiam.LoginRESTAPI.model.common.MessageResponse;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Table(name = "mst_role")
public class Role {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private BigInteger role_id;

	@Column(name="role_name")
	private String roleName;

	@ManyToMany(mappedBy = "roleList")
	private Collection<User> userList = new ArrayList<>();

	@Transient
	private MessageResponse messageResponse;

	public Role() {
	}

	public MessageResponse getMessageResponse() {
		return messageResponse;
	}

	public void setMessageResponse(MessageResponse messageResponse) {
		this.messageResponse = messageResponse;
	}

	public BigInteger getRole_id() {
		return role_id;
	}

	public void setRole_id(BigInteger role_id) {
		this.role_id = role_id;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public Collection<User> getUserList() {
		return userList;
	}

	public void setUserList(Collection<User> userList) {
		this.userList = userList;
	}
}
