package dao;
/**
 * 程序名：CJ1.C  VER 3.0，2017-12-10 
 * 功  能：管理员实体类，提供私有变量和各自的get,set方法
 * 安全等级：2 级 
 * 编程人：陈冰；1789194307@qq.com 
 * 测试人：陈冰；1789194307@qq.com
*/
public class Manager {
	private String m_id;	//管理员职工号
	private String m_password;	//管理员密码
	private String m_telephone;	//管理员电话
	private String m_name;	//管理员姓名

	public String getM_id() {
		return m_id;
	}
	
	public void setM_id(String m_id) {
		this.m_id = m_id;
	}
	
	public String getM_password() {
		return m_password;
	}
	
	public void setM_password(String m_password) {
		this.m_password = m_password;
	}
	
	public String getM_telephone() {
		return m_telephone;
	}
	
	public void setM_telephone(String m_telephone) {
		this.m_telephone = m_telephone;
	}
	
	public String getM_name() {
		return m_name;
	}
	
	public void setM_name(String m_name) {
		this.m_name = m_name;
	}	
}
