package dao;

/**
 * 程序名：CJ1.C  VER 3.0，2017-12-10 
 * 功  能：订单实体类，提供私有变量和各自的get,set方法
 * 安全等级：2 级 
 * 编程人：陈冰；1789194307@qq.com 
 * 测试人：陈冰；1789194307@qq.com
*/
public class Menu {	
	private String f_name;//菜品名
	private int uf_id;	//用户的点餐号
	private int uf_price;//菜品单价
	private int uf_num;//菜品数量
	private int uf_totalprice;//单价和数量的积
	private String uf_date;	//顾客下单时间
	
	public String getF_name() {
		return f_name;
	}
	
	public void setF_name(String f_name) {
		this.f_name = f_name;
	}
	
	public void setUf_id(int uf_id) {
		this.uf_id = uf_id;
	}
	
	public int getUf_id() {
		return uf_id;
	}
	
	public int getUf_price() {
		return uf_price;
	}
	
	public void setUf_price(int uf_price) {
		this.uf_price = uf_price;
	}
	
	public int getUf_num() {
		return uf_num;
	}
	
	public void setUf_num(int uf_num) {
		this.uf_num = uf_num;
	}
	
	public int getUf_totalprice() {
		return uf_totalprice;
	}
	
	public void setUf_totalprice(int uf_totalprice) {
		this.uf_totalprice = uf_totalprice;
	}
	
	public String getUf_date() {
		return uf_date;
	}
	
	public void setUf_date(String datetime) {
		this.uf_date = datetime;
	}	
}
