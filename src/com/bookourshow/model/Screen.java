package com.bookourshow.model;

public class Screen {
	
	private int screenId;
	private String screenCode;
	
	public int getScreenId() {
		return screenId;
	}
	public Screen(int screenId, String screenCode) {
		super();
		this.screenId = screenId;
		this.screenCode = screenCode;
	}
	public void setScreenId(int screenId) {
		this.screenId = screenId;
	}
	public String getScreenCode() {
		return screenCode;
	}
	public void setScreenCode(String screenCode) {
		this.screenCode = screenCode;
	}
	@Override
	public String toString() {
		return "Screen [screenId=" + screenId + ", screenCode=" + screenCode + "]";
	}
	

}
