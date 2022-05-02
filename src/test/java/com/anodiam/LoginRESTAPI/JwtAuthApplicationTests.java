package com.anodiam.LoginRESTAPI;

import com.anodiam.LoginRESTAPI.model.Permission;
import com.anodiam.LoginRESTAPI.model.Role;
import com.anodiam.LoginRESTAPI.model.User;
import com.anodiam.LoginRESTAPI.model.common.ResponseCode;
import com.anodiam.LoginRESTAPI.serviceRepository.Permission.PermissionService;
import com.anodiam.LoginRESTAPI.serviceRepository.Role.RoleService;
import com.anodiam.LoginRESTAPI.serviceRepository.User.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.Assert.assertEquals;

//*******************************************************************************************
//	NEEDS MANUAL UNIT TESTING.
//	Because ONLY BEARER token and status code are returned. No message response to compare.
//*******************************************************************************************

@SpringBootTest
class JwtAuthApplicationTests {

	@Autowired
	private UserService userService;

	@Autowired
	private PermissionService permissionService;

	@Autowired
	private RoleService roleService;

	@Test
	public void testNegativeFindByInvalidRoleName() throws Exception
	{
		String roleName="INVALID_ROLE";
		Role role = roleService.findByRoleName(roleName).get();
		assertEquals(ResponseCode.ROLE_NAME_INVALID.getMessage() + role.getRoleName(),
				role.getMessageResponse().getMessage());
	}

	@Test
	public void testPositiveFindByValidRoleName() throws Exception
	{
		String roleName="USER";
		Role role = roleService.findByRoleName(roleName).get();
		assertEquals(ResponseCode.ROLE_NAME_EXISTS.getMessage() + role.getRoleName(),
				role.getMessageResponse().getMessage());
	}

	@Test
	public void testNegativeFindByInvalidPermissionName() throws Exception
	{
		String permissionName="INVALID_ACCESS";
		Permission permission = permissionService.findByPermissionName(permissionName).get();
		assertEquals(ResponseCode.PERMISSION_NAME_INVALID.getMessage()
				+ permission.getPermissionName(), permission.getMessageResponse().getMessage());
	}

	@Test
	public void testPositiveFindByValidPermissionName() throws Exception
	{
		String permissionName="STUDENT_ACCESS";
		Permission permission = permissionService.findByPermissionName(permissionName).get();
		assertEquals(ResponseCode.PERMISSION_NAME_EXISTS.getMessage()
				+ permission.getPermissionName(), permission.getMessageResponse().getMessage());
	}

	@Test
	public void testNegativeFindByWrongEmail() throws Exception
	{
		String email="invalidemail@gmail.com";
		User foundUser = userService.findByUsername(email).get();
		assertEquals(ResponseCode.USER_NOT_REGISTERED.getMessage() + email,
				foundUser.getMessageResponse().getMessage());
	}

	@Test
	public void testPositiveFindByCorrectEmail() throws Exception
	{
		String email="pinaki.sen@gmail.com";
		User foundUser = userService.findByUsername(email).get();
		assertEquals(ResponseCode.USER_EXISTS.getMessage() + foundUser.getUsername(),
				foundUser.getMessageResponse().getMessage());
	}
}
