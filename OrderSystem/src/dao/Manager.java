package dao;
/**
 * ��������CJ1.C  VER 3.0��2017-12-10 
 * ��  �ܣ�����Աʵ���࣬�ṩ˽�б����͸��Ե�get,set����
 * ��ȫ�ȼ���2 �� 
 * ����ˣ��±���1789194307@qq.com 
 * �����ˣ��±���1789194307@qq.com
*/
public class Manager {
	private String m_id;	//����Աְ����
	private String m_password;	//����Ա����
	private String m_telephone;	//����Ա�绰
	private String m_name;	//����Ա����

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
