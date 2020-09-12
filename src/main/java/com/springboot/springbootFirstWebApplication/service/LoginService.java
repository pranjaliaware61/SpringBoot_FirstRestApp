package com.springboot.springbootFirstWebApplication.service;

import org.springframework.stereotype.Component;

@Component
public class LoginService
{
	public boolean UserValidation(String username,String password)
	{
		return username.equalsIgnoreCase("pranjali") && password.equalsIgnoreCase("newgen@9090");
	}

}
