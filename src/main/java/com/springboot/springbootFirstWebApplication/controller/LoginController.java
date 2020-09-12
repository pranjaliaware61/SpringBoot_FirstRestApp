package com.springboot.springbootFirstWebApplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.sample.Sample;
import com.springboot.Dummy;
import com.springboot.springbootFirstWebApplication.service.LoginService;

@Controller
@SessionAttributes("username")
public class LoginController 
{
	@Autowired
	Sample sample;
	
	@Autowired
	Dummy dummy;
	
	@Autowired
	LoginService loginservice;
	
	@RequestMapping(path="/login")
	//@ResponseBody
	public String LoginMessage(@RequestParam String username,ModelMap model)
	{
		System.out.println("Username is:"+username);
		model.put("username",username);
		return "login";
	}
	
	@RequestMapping(path="/form",method=RequestMethod.GET)
	public String FormDisplay()
	{
		return "form";
	}
	
	@RequestMapping(path="/form",method=RequestMethod.POST)
	public String FormContents(@RequestParam String username,@RequestParam String password,ModelMap map)
	{
		boolean isvalid=loginservice.UserValidation(username,password);
		if(!isvalid)
		{
			map.put("ErrorMessage","Invalid Credentials");
			return "login";
		}
		map.put("username",username);
		map.put("password", password);
		return "Welcome";
	}

}
