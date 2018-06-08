package com.lzw.model;

public class Booksinfo {
	private String id;//图书编号
	private String name;//图书名称
	private String author;//图书作者
	private String publish;//图书出版社
	private float price;//图书价格
	public void setid(String id){
	this.id=id;
	}
	public String getid(){
		return id;
	}
	public void setname(String name){
		this.name=name;
		}
	public String getname(){
			return name;
		}
	public void setauthor(String author){
		this.author=author;
	}
	public String getauthor(){
		return author;
	}
	public void setpublish(String publish){
		this.publish=publish;
	}
	public String getpublish(){
		return publish;
	}
	public void setprice(float price){
		this.price=price;
	}
	public float getprice(){
		return price;
	}
}

