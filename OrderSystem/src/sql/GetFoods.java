package sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dao.Food;

/**
 * ��������CJ1.C  VER 3.0��2017-12-10 
 * ��  �ܣ����ݲ�Ʒ�����в�ѯ�͸��ݲ�Ʒid���в�ѯ
 * ��ȫ�ȼ���2 �� 
 * ����ˣ��±���1789194307@qq.com 
 * �����ˣ��±���1789194307@qq.com
*/
public class GetFoods {
	/**
	 *@author bing
	 *@Email:1789194307@qq.com
	 *@����: ��ѯ����Ĳ�Ʒ�����������в�Ʒ
*@return-type: ArrayList<Food>
		*/
	public ArrayList<Food> getAllFoods(String foodkind) {
	Connection connection = null;
	PreparedStatement statement = null;
	ResultSet resultSet = null;
	ArrayList<Food> arrayList = new ArrayList<Food>();//ʵ����ArrayList<Food>����
	connection = SqlConnection.getConnection();
	String sql = "select * from Food_Table where f_kind=?"; // SQL��ѯ���
	try {
		statement = connection.prepareStatement(sql);
		statement.setString(1, foodkind);
		resultSet = statement.executeQuery();
		while(resultSet.next()) {
			Food food = new Food();
			food.setF_id(resultSet.getInt("f_id"));
			food.setF_name(resultSet.getString("f_name"));
			food.setF_kind(resultSet.getString("f_kind"));
			food.setF_price(resultSet.getInt("f_price"));
			food.setF_picturepath(resultSet.getString("f_picturepath"));
			food.setF_describe(resultSet.getString("f_describe"));
			arrayList.add(food);	//��food�����������		
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
		if (statement != null) {
			try {
				statement.close();
				statement = null;
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
	 *@����: ��ѯ�����ĳ����Ʒid�Ĳ�Ʒ��Ϣ
*@return-type: Food
		*/
	public Food GetFoodById(int id) {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		connection = SqlConnection.getConnection();
		String sql = "select * from Food_Table where f_id=?"; // SQL��ѯ���
		try {
			statement = connection.prepareStatement(sql);
			statement.setInt(1,id);
			resultSet = statement.executeQuery();
			if(resultSet.next()) {
				Food food = new Food();
				food.setF_id(resultSet.getInt("f_id"));
				food.setF_name(resultSet.getString("f_name"));
				food.setF_kind(resultSet.getString("f_kind"));
				food.setF_price(resultSet.getInt("f_price"));
				food.setF_picturepath(resultSet.getString("f_picturepath"));
				food.setF_describe(resultSet.getString("f_describe"));
				return food;//����food����
			}
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
			if (statement != null) {
				try {
					statement.close();
					statement = null;
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}

		}	
		return null;
	}
}
