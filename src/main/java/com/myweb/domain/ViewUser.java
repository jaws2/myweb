package com.myweb.domain;

public class ViewUser {
	private Integer id;
	private String name;
	
	//空构造方法
	public ViewUser(){};
	
	public ViewUser(int id,String name){
		this.id = id;
		this.name = name;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		StringBuilder strBuilder = new StringBuilder("id :").append(id)
				.append(" name: ").append(name);
		return strBuilder.toString();
	}
	
}
