package sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import dao.Menu;

/**
 * ��������CJ1.C  VER 3.0��2017-12-10 
 * ��  �ܣ���ѯ�����ĳ���˿�id�Ķ����Ͳ�ѯ���еĶ���
 * ��ȫ�ȼ���2 �� 
 * ����ˣ��±���1789194307@qq.com 
 * �����ˣ��±���1789194307@qq.com
*/
public class GetUserOrder {
	/**
	 *@author bing
	 *@Email:1789194307@qq.com
	 *@����: ��ѯ�����ĳ���˿�id�Ķ���
*@return-type: ArrayList<Menu>
		*/
	public ArrayList<Menu> SelectUserOrder(int userid){
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		connection=SqlConnection.getConnection();
		String sqlState="select * from Menu_Table where uf_id=?";		
		ArrayList<Menu> arrayList = new ArrayList<Menu>();//ʵ����ArrayList<Menu>����
		try {
			preparedStatement = connection.prepareStatement(sqlState);
			preparedStatement.setInt(1, userid);
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				Menu menu = new Menu();
				menu.setF_name(resultSet.getString("bf_name"));
				menu.setUf_id(resultSet.getInt("uf_id"));
				menu.setUf_price(resultSet.getInt("uf_price"));
				menu.setUf_num(resultSet.getInt("uf_num"));
				menu.setUf_totalprice(resultSet.getInt("uf_totalprice"));
				menu.setUf_date(resultSet.getString("uf_date"));
				arrayList.add(menu);//��menu������ӵ�����
			}
			return arrayList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			// �ͷ����ݼ�����
			if (resultSet != null) {
				try {
					resultSet.close();
					resultSet = null;
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
			// �ͷ�������
			if (preparedStatement != null) {
				try {
					preparedStatement.close();
					preparedStatement = null;
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}

		}	
		return null;
	}
	/**
	 *@author bing
	 *@Email:1789194307@qq.com
	 *@����: ��ѯ���еĶ���
*@return-type: ArrayList<Menu>
		*/
	public ArrayList<Menu> SelectAllUserOrder(){
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		connection=SqlConnection.getConnection();
		String sqlState="select User_Table.uf_id,bf_name,uf_price,uf_num,uf_totalprice,uf_date from Menu_Table,User_Table where User_Table.uf_id=Menu_Table.uf_id order by uf_id;";		
		ArrayList<Menu> arrayList = new ArrayList<Menu>();
		try {
			preparedStatement = connection.prepareStatement(sqlState);
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				Menu menu = new Menu();
				menu.setF_name(resultSet.getString("bf_name"));
				menu.setUf_id(resultSet.getInt("uf_id"));
				menu.setUf_price(resultSet.getInt("uf_price"));
				menu.setUf_num(resultSet.getInt("uf_num"));
				menu.setUf_totalprice(resultSet.getInt("uf_totalprice"));
				menu.setUf_date(resultSet.getString("uf_date"));
				arrayList.add(menu);
			}
			return arrayList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			// �ͷ����ݼ�����
			if (resultSet != null) {
				try {
					resultSet.close();
					resultSet = null;
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
			// �ͷ�������
			if (preparedStatement != null) {
				try {
					preparedStatement.close();
					preparedStatement = null;
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}

		}	
		return null;
	}
}
