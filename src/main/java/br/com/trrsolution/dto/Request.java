package br.com.trrsolution.dto;

public class Request {
	
	private String name;
	private Integer age;
	private boolean coder;
	private char gender;
	private boolean us;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public char getGender() {
		return gender;
	}
	public void setGender(char gender) {
		this.gender = gender;
	}
	public boolean isUs() {
		return us;
	}
	public void setUs(boolean us) {
		this.us = us;
	}
	public boolean isCoder() {
		return coder;
	}
	public void setCoder(boolean coder) {
		this.coder = coder;
	}

}

