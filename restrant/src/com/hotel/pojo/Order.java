package com.hotel.pojo;

public class Order {
	private Integer id;//订单编号
	private Integer table_id;//餐桌号
	private String orderDate;//订单日期
	private Double totalPrice;//总金额
	private Integer orderStatus;//订单状态
	
	private String tableName;//餐桌名称

	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Order(Integer id, Integer table_id, String orderDate, Double totalPrice, Integer orderStatus,
			String tableName) {
		super();
		this.id = id;
		this.table_id = table_id;
		this.orderDate = orderDate;
		this.totalPrice = totalPrice;
		this.orderStatus = orderStatus;
		this.tableName = tableName;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getTable_id() {
		return table_id;
	}

	public void setTable_id(Integer table_id) {
		this.table_id = table_id;
	}

	public String getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}

	public Double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Integer getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(Integer orderStatus) {
		this.orderStatus = orderStatus;
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", table_id=" + table_id + ", orderDate=" + orderDate + ", totalPrice=" + totalPrice
				+ ", orderStatus=" + orderStatus + ", tableName=" + tableName + "]";
	}
	
}
