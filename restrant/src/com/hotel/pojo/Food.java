package com.hotel.pojo;

import java.io.Serializable;

public class Food implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;//菜品编号
	private String foodName;//菜名
	private Double price;//价格
	private Double mprice;//会员价
	private String remark;//备注
	private String img;//图片
	private Integer foodType_id;//菜品类型id
	private String foodType_name;//菜品名称	
	public Food() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Food(Integer id, String foodName, Double price, Double mprice, String remark, String img,
			Integer foodType_id, String foodType_name) {
		super();
		this.id = id;
		this.foodName = foodName;
		this.price = price;
		this.mprice = mprice;
		this.remark = remark;
		this.img = img;
		this.foodType_id = foodType_id;
		this.foodType_name = foodType_name;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getFoodName() {
		return foodName;
	}
	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Double getMprice() {
		return mprice;
	}
	public void setMprice(Double mprice) {
		this.mprice = mprice;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public Integer getFoodType_id() {
		return foodType_id;
	}
	public void setFoodType_id(Integer foodType_id) {
		this.foodType_id = foodType_id;
	}
	public String getFoodType_name() {
		return foodType_name;
	}
	public void setFoodType_name(String foodType_name) {
		this.foodType_name = foodType_name;
	}
	@Override
	public String toString() {
		return "Food [id=" + id + ", foodName=" + foodName + ", price=" + price + ", mprice=" + mprice + ", remark="
				+ remark + ", img=" + img + ", foodType_id=" + foodType_id + ", foodType_name=" + foodType_name + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((foodName == null) ? 0 : foodName.hashCode());
		result = prime * result + ((foodType_id == null) ? 0 : foodType_id.hashCode());
		result = prime * result + ((foodType_name == null) ? 0 : foodType_name.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((img == null) ? 0 : img.hashCode());
		result = prime * result + ((mprice == null) ? 0 : mprice.hashCode());
		result = prime * result + ((price == null) ? 0 : price.hashCode());
		result = prime * result + ((remark == null) ? 0 : remark.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Food other = (Food) obj;
		if (foodName == null) {
			if (other.foodName != null)
				return false;
		} else if (!foodName.equals(other.foodName))
			return false;
		if (foodType_id == null) {
			if (other.foodType_id != null)
				return false;
		} else if (!foodType_id.equals(other.foodType_id))
			return false;
		if (foodType_name == null) {
			if (other.foodType_name != null)
				return false;
		} else if (!foodType_name.equals(other.foodType_name))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (img == null) {
			if (other.img != null)
				return false;
		} else if (!img.equals(other.img))
			return false;
		if (mprice == null) {
			if (other.mprice != null)
				return false;
		} else if (!mprice.equals(other.mprice))
			return false;
		if (price == null) {
			if (other.price != null)
				return false;
		} else if (!price.equals(other.price))
			return false;
		if (remark == null) {
			if (other.remark != null)
				return false;
		} else if (!remark.equals(other.remark))
			return false;
		return true;
	}
	
}
