package dao;

/**
 * ��������CJ1.C  VER 3.0��2017-12-10 
 * ��  �ܣ�����ʵ���࣬�ṩ˽�б����͸��Ե�get,set����
 * ��ȫ�ȼ���2 �� 
 * ����ˣ��±���1789194307@qq.com 
 * �����ˣ��±���1789194307@qq.com
*/
public class Menu {	
	private String f_name;//��Ʒ��
	private int uf_id;	//�û��ĵ�ͺ�
	private int uf_price;//��Ʒ����
	private int uf_num;//��Ʒ����
	private int uf_totalprice;//���ۺ������Ļ�
	private String uf_date;	//�˿��µ�ʱ��
	
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
