package com.baidu.pojo;
/*
 * 爱好实体类
 */
public class Hobby {
	private Integer hid;//爱好id
	private String hname;//爱好名称
	public Hobby() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Hobby(Integer hid, String hname) {
		super();
		this.hid = hid;
		this.hname = hname;
	}
	public Integer getHid() {
		return hid;
	}
	public void setHid(Integer hid) {
		this.hid = hid;
	}
	public String getHname() {
		return hname;
	}
	public void setHname(String hname) {
		this.hname = hname;
	}
	@Override
	public String toString() {
		return "Hobby [hid=" + hid + ", hname=" + hname + "]";
	}
	
}
