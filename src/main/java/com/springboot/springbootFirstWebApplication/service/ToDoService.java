package com.springboot.springbootFirstWebApplication.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Service;

import com.springboot.springbootFirstWebApplication.model.ToDo;

@Service
public class ToDoService 
{
	static List<ToDo> ToDoList=new ArrayList<>();
	static int count=3;
	
	static
	{
		System.out.println("Inside static block adding three records");
		ToDoList.add(new ToDo(1,"Pranjali","Spring Boot",new Date(),false));
		ToDoList.add(new ToDo(2,"Pranjali","MBA",new Date(),false));
		ToDoList.add(new ToDo(3,"Pranjali","FrontEnd Developer",new Date(),false));
	}

	public void addUser(String user,String desc,Date targetDate,boolean isDone)
	{
		System.out.println("targetDate:"+targetDate);
		System.out.println("Added Successfully or not:"+ToDoList.add(new ToDo(++count,user,desc,targetDate,isDone)));
		
	}
	
	public  List<ToDo> retrieveUser(String user)
	{
		List<ToDo> record=new ArrayList<>();
		for(ToDo ToDoTemp :ToDoList)//ToDoList is an List which holds objects of type ToDo
			//array contains data of type int then for(int temp:arr)
		{
	
			if(ToDoTemp.getUser().equalsIgnoreCase(user))
			{
				record.add(ToDoTemp);
				//System.out.println("returning");
				
				
			}
		}
		System.out.println("Record Size:"+record.size());
		return record;
        //return record;
	}
	
	
	
	public List<ToDo> DeleteById(int id)
	{
		/*for(ToDo ToDoTemp:ToDoList)
		{
			if(ToDoTemp.getId()==id)
			{
				ToDoList.remove(ToDoTemp);
			}
		}*/
		
		/*Iterator<ToDo> iterator=ToDoList.iterator();
		while(iterator.hasNext())
		{
			ToDo todo=iterator.next();
			if(todo.getId()==id)
			{
				ToDoList.remove(todo);
			}
		}*/
		
		//Don't use advanced for loop or iterator for traversing the list and at the same time removing the object from list
		//gives ConcurrentModification error.(removing by object)
		//go for simple for loop(here removing by index)
		
		for(int i=0;i<ToDoList.size();i++)
				{
					if(ToDoList.get(i).getId()==id)
					{
						ToDoList.remove(i);
						System.out.println("Deleted Successfully");
					}
				}
		
		return ToDoList;
	}
	
	
	public ToDo UpdateById(int id)
	{
		System.out.println("Inside UpdateById");
		for(int i=0;i<ToDoList.size();i++)
		{
			if(ToDoList.get(i).getId()==id)
			{
				System.out.println("id"+ToDoList.get(i).getId()+"is found");
				return ToDoList.get(i);
			}
		}

		return null;
		
	}

}
