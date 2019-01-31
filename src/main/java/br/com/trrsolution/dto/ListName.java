package br.com.trrsolution.dto;

import java.util.List;

public class ListName {
	
	private String name;
	private List<Request> data;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Request> getData() {
		return data;
	}
	public void setData(List<Request> data) {
		this.data = data;
	}
	
}

