package com.baidu.pojo;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author bing
 *员工实体类
 */
public class Emp {
	private Integer id;//员工id
	private String name;//员工姓名
	private Integer sex;//员工性别
	private Integer age;//员工年龄
	private Integer did;//员工所在部门id
	private String dname;//员工所在部门名称
	private List<Hobby> hobbylist = new ArrayList<Hobby>();//用于存Hobby类的对象
	private String[] hobbies;//用于存多个爱好
	
	
	public Emp() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Emp(Integer id, String name, Integer sex, Integer age, Integer did) {
		super();
		this.id = id;
		this.name = name;
		this.sex = sex;
		this.age = age;
		this.did = did;
	}
	
	public Emp(Integer id, String name, Integer sex, Integer age, Integer did, String dname) {
		super();
		this.id = id;
		this.name = name;
		this.sex = sex;
		this.age = age;
		this.did = did;
		this.dname = dname;
	}
	
	public Emp(Integer id, String name, Integer sex, Integer age, Integer did, String dname, List<Hobby> hobbylist,
			String[] hobbies) {
		super();
		this.id = id;
		this.name = name;
		this.sex = sex;
		this.age = age;
		this.did = did;
		this.dname = dname;
		this.hobbylist = hobbylist;
		this.hobbies = hobbies;
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
	public Integer getSex() {
		return sex;
	}
	public void setSex(Integer sex) {
		this.sex = sex;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
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
	public String[] getHobbies() {
		return hobbies;
	}
	public void setHobbies(String[] hobbies) {
		this.hobbies = hobbies;
	}
	public List<Hobby> getHobbylist() {
		return hobbylist;
	}
	public void setHobbylist(List<Hobby> hobbylist) {
		this.hobbylist = hobbylist;
	}
	@Override
	public String toString() {
		return "Emp [id=" + id + ", name=" + name + ", sex=" + sex + ", age=" + age + ", did=" + did + "]";
	}
	
}
