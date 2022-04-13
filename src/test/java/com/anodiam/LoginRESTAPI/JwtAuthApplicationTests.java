package com.anodiam.LoginRESTAPI;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class JwtAuthApplicationTests {

//*******************************************************************************************
//	JUNIT TEST CASES for microservice002-login Test Based Development Starts Here
//*******************************************************************************************
//	Following JUnits need to pass at Dev environment to be deployed to Test environment

	@Test
	public void testPositiveSuccessfulLogin() throws Exception
	{
		String userName="pinaki.sen@gmail.com";
		String password="Pinaki@123";
//		**************************************************
//		**************************************************
	}

	@Test
	public void testNegativeWrongUsernamePassword() throws Exception
	{
		String userName="abcdefgh";
		String password="adcb@12AB";
//		**************************************************
//		**************************************************
	}

	@Test
	public void testNegativeWrongUsername() throws Exception
	{
		String userName="pinakidas";
		String password="Pinaki@123";
//		**************************************************
//		**************************************************
	}

	@Test
	public void testNegativeWrongPassword() throws Exception
	{
		String userName="pinakidas";
		String password="abcdefgh@12AB";
//		**************************************************
//		**************************************************
	}
}
