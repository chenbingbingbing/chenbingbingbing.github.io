package com.lzw.model;

public class Userrent {
	private String username;//用户姓名
	private String rentdate;//借阅日期
	private String rentbookid;//借阅图书编号
	public void setusername(String username){
		this.username=username;
	}
	public String getusername(){
		return username;
	}
	public void setrentdate(String rentdate){
		this.rentdate=rentdate;
	}
	public String getrentdate(){
		return rentdate;
	}
	public void setrentbookid(String rentbookid){
		this.rentbookid=rentbookid;
	}
	public String getrentbookid(){
		return rentbookid;
	}
}
