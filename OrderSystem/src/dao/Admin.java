package dao;
/**
 * 程序名：CJ1.C  VER 3.0，2017-12-10 
 * 功  能：经理实体类，提供私有变量和各自的get,set方法
 * 安全等级：2 级 
 * 编程人：陈冰；1789194307@qq.com 
 * 测试人：陈冰；1789194307@qq.com
*/
public class Admin {
	private String a_id;	//经理号
	private String a_password;	//经理密码
	
	public String getA_id() {
		return a_id;
	}
	
	public void setA_id(String a_id) {
		this.a_id = a_id;
	}
	public String getA_password() {
		return a_password;
	}
	
	public void setA_password(String a_password) {
		this.a_password = a_password;
	}
}