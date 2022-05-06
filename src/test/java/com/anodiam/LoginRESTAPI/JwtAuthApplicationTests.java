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

	//	Role should not be fetched against invalid Role Name
	@Test
	public void testNegativeFindRoleByInvalidRoleName() throws Exception
	{
		String roleName="INVALID_ROLE";
		Role role = roleService.findByRoleName(roleName).get();
		assertEquals(ResponseCode.ROLE_NAME_INVALID.getMessage() + roleName,
				role.getMessageResponse().getMessage());
	}

	//	Correct Role should be fetched against valid Role Name
	@Test
	public void testPositiveFindRoleByValidRoleName() throws Exception
	{
		String roleName="USER";
		Role role = roleService.findByRoleName(roleName).get();
		assertEquals(ResponseCode.ROLE_NAME_EXISTS.getMessage() + role.getRoleName(),
				role.getMessageResponse().getMessage());
	}

	//	Permission should not be fetched against invalid Permission Name
	@Test
	public void testNegativeFindPermissionByInvalidPermissionName() throws Exception
	{
		String permissionName="INVALID_ACCESS";
		Permission permission = permissionService.findByPermissionName(permissionName).get();
		assertEquals(ResponseCode.PERMISSION_NAME_INVALID.getMessage() + permissionName,
				permission.getMessageResponse().getMessage());
	}

	//	Correct Permission should be fetched against valid Permission Name
	@Test
	public void testPositiveFindPermissionByValidPermissionName() throws Exception
	{
		String permissionName="STUDENT_ACCESS";
		Permission permission = permissionService.findByPermissionName(permissionName).get();
		assertEquals(ResponseCode.PERMISSION_NAME_EXISTS.getMessage()
				+ permission.getPermissionName(), permission.getMessageResponse().getMessage());
	}

	//	User should NOT be fetched against invalid Email
	@Test
	public void testNegativeFindUserByWrongEmail() throws Exception
	{
		String email="invalidemail@gmail.com";
		User foundUser = userService.findByUsername(email).get();
		assertEquals(ResponseCode.USER_NOT_REGISTERED.getMessage() + email,
				foundUser.getMessageResponse().getMessage());
	}

	//	Correct User should be fetched against valid Email
	@Test
	public void testPositiveFindUserByCorrectEmail() throws Exception
	{
		String email="pinaki.sen@gmail.com";
		User foundUser = userService.findByUsername(email).get();
		assertEquals(ResponseCode.USER_EXISTS.getMessage() + foundUser.getUsername(),
				foundUser.getMessageResponse().getMessage());
	}
}
