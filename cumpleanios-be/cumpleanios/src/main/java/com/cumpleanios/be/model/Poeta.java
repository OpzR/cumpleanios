package com.cumpleanios.be.model;

import java.io.Serializable;

public class Poeta implements Serializable {
	private static final long serialVersionUID = -2609589286749761222L;
	
	private String name;
	private String url;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
	
}
