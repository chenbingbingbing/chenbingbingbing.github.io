package com.hotel.pojo;

public class OrderDetail {
	private Integer id;//订单详情id
	private Integer orderId;//订单id
	private Integer food_id;//菜品id
	private String foodName;//菜名
	private Double price;//单价
	private Integer foodCount;//数量
	public OrderDetail() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public OrderDetail(Integer id, Integer orderId, Integer food_id, String foodName, Double price, Integer foodCount) {
		super();
		this.id = id;
		this.orderId = orderId;
		this.food_id = food_id;
		this.foodName = foodName;
		this.price = price;
		this.foodCount = foodCount;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public Integer getFood_id() {
		return food_id;
	}

	public void setFood_id(Integer food_id) {
		this.food_id = food_id;
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
	public Integer getFoodCount() {
		return foodCount;
	}
	
	public void setFoodCount(Integer foodCount) {
		this.foodCount = foodCount;
	}
	@Override
	public String toString() {
		return "OrderDetail [id=" + id + ", orderId=" + orderId + ", food_id=" + food_id + ", foodName=" + foodName
				+ ", price=" + price + ", foodCount=" + foodCount + "]";
	}
		
}
