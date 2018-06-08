package com.baidu.pojo;
/**
 * 
 * @author bing
 *部门实体类
 */
public class Dept {
	private Integer did;//部门id
	private String dname;//部门名称
	public Dept() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Dept(Integer did, String dname) {
		super();
		this.did = did;
		this.dname = dname;
	}
	public Integer getDid() {
		return did;
	}
	public void setDid(Integer did) {
		this.did = did;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	@Override
	public String toString() {
		return "Dept [did=" + did + ", dname=" + dname + "]";
	}
	
}
