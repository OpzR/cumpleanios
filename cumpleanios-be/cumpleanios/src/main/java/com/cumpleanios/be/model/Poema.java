package com.cumpleanios.be.model;

import java.io.Serializable;

public class Poema implements Serializable {

	private static final long serialVersionUID = 1077099292867569383L;
	
	private String title;
	private String content;
	private String url;
	private Poeta poet;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public Poeta getPoet() {
		return poet;
	}
	public void setPoet(Poeta poet) {
		this.poet = poet;
	}	
	
}
