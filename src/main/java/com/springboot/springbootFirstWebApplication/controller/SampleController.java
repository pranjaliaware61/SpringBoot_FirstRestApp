package com.springboot.springbootFirstWebApplication.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.springboot.springbootFirstWebApplication.model.SampleDetail;

@Controller
public class SampleController 
{
	@RequestMapping(path="/sample",method=RequestMethod.GET)
	public String sampleGet(ModelMap model)
	{
		model.addAttribute("samp", new SampleDetail(5,"gene"));
		return "Sample";
	}
	
	@RequestMapping(path="/sample",method=RequestMethod.POST)
	public String samplePost(SampleDetail samp,ModelMap model)
	{
		System.out.println("Id:"+samp.getId());
		System.out.println("Name:"+samp.getName());
		SampleDetail object=new SampleDetail(samp.getId(),samp.getName());
		model.addAttribute("object",object);
		return "form";
	}

}
