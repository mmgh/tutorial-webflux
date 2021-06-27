package com.autumn.tutorial.webflux;

public class Pay {

	private String name;

	private int id;
	
	
	public Pay(String name) {
		this.name = name;
	}
	
	
	public Pay(int id) {
		this.id = id;
	}
	
	public Pay() {
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
	@Override
	public String toString() {
		return "Pay [name=" + name + ", id=" + id + "]";
	}
	
}
