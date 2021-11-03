package com.anodiam.LoginRESTAPI;

import com.anodiam.LoginRESTAPI.model.User;
import com.anodiam.LoginRESTAPI.serviceRepository.User.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.Assert.*;


@SpringBootTest
class JwtAuthApplicationTests {

	@Autowired
	private UserService userService;

	@Test
	void contextLoads() {
	}

//*******************************************************************************************
//	JUNIT TEST CASES for microservice001-student-signup Test Based Development Starts Here
//*******************************************************************************************
//	Following JUnits need to pass at Dev environment to be deployed to Test environment

//	Use Case 5: Given I am an unsigned user, when I fill up the fields:
//	(username, password) and click on the Login button:

//	If I enter correct username and password, I should receive a valid Authorization Hex Token
//	Also, I should get the message "Student login successful".

	@Test
	public void testPositiveSuccessfulLogin() throws Exception
	{
		String userName="pinakidas";
		String password="adcb@12AB";
		User inputUser=new User(userName, password);
//		Need to write these lines to verify login
//		User newStudent = userService.save(inputUser);
//		Need to write these lines to verify login
		assertEquals(inputUser.getMessageResponse().getMessage(),
				"Student login successful");
	}

//	Use Case 5: If I enter incorrect username / password, I should NOT receive a valid Authorization Hex Token
//	Also, I should get the message "Login failure. Incorrect username or password.".
	@Test
	public void testNegativeWrongUsername() throws Exception
	{
		String userName="abcdefgh";
		String password="adcb@12AB";
		User inputUser=new User(userName, password);
//		Need to write these lines to verify login
//		User newStudent = userService.save(inputUser);
//		Need to write these lines to verify login
		assertEquals(inputUser.getMessageResponse().getMessage(),
				"Login failure. Incorrect username or password.");
	}

	@Test
	public void testNegativeWrongPassword() throws Exception
	{
		String userName="pinakidas";
		String password="abcdefgh@12AB";
		User inputUser=new User(userName, password);
//		Need to write these lines to verify login
//		User newStudent = userService.save(inputUser);
//		Need to write these lines to verify login
		assertEquals(inputUser.getMessageResponse().getMessage(),
				"Login failure. Incorrect username or password.");
	}
}
