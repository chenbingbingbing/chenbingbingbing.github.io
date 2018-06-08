package com.hotel.pojo;

public class Cuisine {
	private Integer id;//菜系id
	private String typeName;//菜系名称
	public Cuisine() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Cuisine(Integer id, String typeName) {
		super();
		this.id = id;
		this.typeName = typeName;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	@Override
	public String toString() {
		return "Cuisine [id=" + id + ", typeName=" + typeName + "]";
	}
	
}
