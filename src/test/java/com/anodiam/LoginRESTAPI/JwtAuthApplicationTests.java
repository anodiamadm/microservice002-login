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
//	JUNIT TEST CASES for microservice002-login Test Based Development Starts Here
//*******************************************************************************************
//	Following JUnits need to pass at Dev environment to be deployed to Test environment

//	Use Case 5: Given I am an unsigned user, when I fill up the fields:
//	(username, password) and click on the Login button:
//	If I enter correct username and password, I should receive response status = 200 Ok, and
//	a valid JWT Authorization Token
	@Test
	public void testPositiveSuccessfulLogin() throws Exception
	{
		String userName="pinakidas";
		String password="adcb@12AB";
		User inputUser=new User(userName, password);
//		************************* Need to write these lines to verify login *************************
//		Call login function (username, password) that returns JSON with response message and JWT token
//		1. Check if the response status is 200, Ok
//		2. Check if JWT Bearer Authorization token is output in the Response JSON body:
//			format of JWT token should be ('Bearer' followed by few chars)
//		If both conditions 1 & 2 above pass, consider test case successful.
//		************************* Need to write these lines to verify login *************************
	}

//	Use Case 5.1: If I enter incorrect username, (correct or wrong password) I should NOT receive
//	a JWT Token, I should get the response status as 403 unauthorized.
	@Test
	public void testNegativeWrongUsername() throws Exception
	{
		String userName="abcdefgh";
		String password="adcb@12AB";
		User inputUser=new User(userName, password);
//		**************************************************
//		Call login function (Wrong-Username, password)
//		1. Check if no JWT token is output
//		2. Check if response status as 403 unauthorized
//		If both conditions 1 & 2 above pass, consider test case successful.
//		**************************************************
	}

//	Use Case 5.2: If I enter incorrect password (correct username),  I should NOT receive
//	a JWT Token, I should get the response status as 403 unauthorized.
	@Test
	public void testNegativeWrongPassword() throws Exception
	{
		String userName="pinakidas";
		String password="abcdefgh@12AB";
		User inputUser=new User(userName, password);
//		**************************************************
//		Call login function (username, Wrong-Password) that returns JSON with response message and JWT token
//		1. Check if no JWT token is output
//		2. Check if response status as 403 unauthorized
//		If both conditions 1 & 2 above pass, consider test case successful.
//		**************************************************
		}
}
