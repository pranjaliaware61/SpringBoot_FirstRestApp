package com.springboot.springbootFirstWebApplication.model;

public class SampleDetail 
{
	private int id;
	private String name;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public SampleDetail()
	{
		
	}
	
	public SampleDetail(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	@Override
	public String toString() {
		return "SampleDetail [id=" + id + ", name=" + name + "]";
	}
	
	

}
