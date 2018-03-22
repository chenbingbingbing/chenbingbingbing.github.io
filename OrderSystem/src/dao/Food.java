package dao;
/**
 * 程序名：CJ1.C  VER 3.0，2017-12-10 
 * 功  能：菜品实体类，提供私有变量和各自的get,set方法
 * 安全等级：2 级 
 * 编程人：陈冰；1789194307@qq.com 
 * 测试人：陈冰；1789194307@qq.com
*/
public class Food {
	private int f_id;	//菜品编号
	private String f_name;	//菜品名称
	private String f_kind;	//菜品种类
	private int f_price;		//菜品单价
	private String f_picturepath;	//菜品图片路径
	private String f_describe;	//菜品描述	
	
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return this.getF_id()+this.getF_name().hashCode();
	}
	
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		if(this==obj)
		{
			return true;
		}
		if(obj instanceof Food)
		{
			Food i = (Food)obj;
			if(this.getF_id()==i.getF_id()&&this.getF_name().equals(i.getF_name()))
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		else
		{
			return false;
		}
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "商品编号："+this.getF_id()+",商品名称："+this.getF_name();
	}
	
	public String getF_name() {
		return f_name;
	}
	
	public void setF_name(String f_name) {
		this.f_name = f_name;
	}
	
	public String getF_kind() {
		return f_kind;
	}
	
	public void setF_kind(String f_kind) {
		this.f_kind = f_kind;
	}
	
	public int getF_id() {
		return f_id;
	}
	
	public void setF_id(int f_id) {
		this.f_id = f_id;
	}
	
	public int getF_price() {
		return f_price;
	}
	
	public void setF_price(int f_price) {
		this.f_price = f_price;
	}
	
	public String getF_picturepath() {
		return f_picturepath;
	}
	
	public void setF_picturepath(String f_picturepath) {
		this.f_picturepath = f_picturepath;
	}
	
	public String getF_describe() {
		return f_describe;
	}

	public void setF_describe(String f_describe) {
		this.f_describe = f_describe;
	}	
}
