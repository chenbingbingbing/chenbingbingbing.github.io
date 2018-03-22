package dao;
/**
 * ��������CJ1.C  VER 3.0��2017-12-10 
 * ��  �ܣ���Ʒʵ���࣬�ṩ˽�б����͸��Ե�get,set����
 * ��ȫ�ȼ���2 �� 
 * ����ˣ��±���1789194307@qq.com 
 * �����ˣ��±���1789194307@qq.com
*/
public class Food {
	private int f_id;	//��Ʒ���
	private String f_name;	//��Ʒ����
	private String f_kind;	//��Ʒ����
	private int f_price;		//��Ʒ����
	private String f_picturepath;	//��ƷͼƬ·��
	private String f_describe;	//��Ʒ����	
	
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
		return "��Ʒ��ţ�"+this.getF_id()+",��Ʒ���ƣ�"+this.getF_name();
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
