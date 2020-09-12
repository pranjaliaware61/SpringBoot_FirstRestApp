package com.springboot.springbootFirstWebApplication.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.springboot.springbootFirstWebApplication.model.ToDo;
import com.springboot.springbootFirstWebApplication.service.ToDoService;

@Controller
@SessionAttributes("username")
public class ToDoController
{
	@Autowired
	ToDoService service;
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		// Date - dd/MM/yyyy
		SimpleDateFormat dateFormat = new SimpleDateFormat("2");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(
				dateFormat, false));
	}
	
	@RequestMapping("/list-todos")
	public String showToDos(ModelMap model)
	{	String str=(String)model.get("username");
		model.put("todos", service.retrieveUser(str));
		return "WelcomeToDos";
	}

	
	@RequestMapping(path="/add-todo",method=RequestMethod.GET)
	public String showaddToDo(ModelMap model)
	{
		model.addAttribute("todo",new ToDo(0,(String)model.get("username"),"Default Description",new Date(),false));
		return "AddToDo";
	}
	
	
	
	@RequestMapping(path="/add-todo",method=RequestMethod.POST)
	public String addToDo(ModelMap model,@Valid @ModelAttribute("todo") ToDo todo,BindingResult result)
	{
		if(result.hasErrors())
		{
			System.out.println("Inside");
			return "AddToDo";
		}
		System.out.println(todo.getDesc());
		System.out.println("TD:"+todo.getisDone());
		service.addUser((String) model.get("username"),todo.getDesc(),todo.getTargetDate(),false);
		return "redirect:/list-todos";
		
	}
	
	@RequestMapping(path="/delete",method=RequestMethod.GET)
	public String deleteToDo(@RequestParam int id)
	{
		service.DeleteById(id);
		return "redirect:/list-todos";
	}
	
	@RequestMapping(path="/update",method=RequestMethod.GET)
	public String showupdateToDo(@RequestParam int id,ModelMap model)
	{
		
		System.out.println("id:"+id);
		ToDo todo=service.UpdateById(id);
		model.addAttribute("todo",todo);
		return "AddToDo"; 
	}
	
	
	@RequestMapping(path="/update",method=RequestMethod.POST)
	public String updateToDo(@RequestParam int id,ModelMap model,@Valid @ModelAttribute("todo") ToDo todo,BindingResult result)
	{
		if(result.hasErrors())
		{
			System.out.println("Inside error");
			return "AddToDo";
		}
		System.out.println("updateToDo:"+todo.getTargetDate());
		service.DeleteById(id);
		service.addUser((String) model.get("username"),todo.getDesc(),todo.getTargetDate(),false);
		return "redirect:/list-todos"; 
	}
	
}
