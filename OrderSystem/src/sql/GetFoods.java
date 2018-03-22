package sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dao.Food;

/**
 * 程序名：CJ1.C  VER 3.0，2017-12-10 
 * 功  能：根据菜品类别进行查询和根据菜品id进行查询
 * 安全等级：2 级 
 * 编程人：陈冰；1789194307@qq.com 
 * 测试人：陈冰；1789194307@qq.com
*/
public class GetFoods {
	/**
	 *@author bing
	 *@Email:1789194307@qq.com
	 *@功能: 查询传入的菜品类别参数的所有菜品
*@return-type: ArrayList<Food>
		*/
	public ArrayList<Food> getAllFoods(String foodkind) {
	Connection connection = null;
	PreparedStatement statement = null;
	ResultSet resultSet = null;
	ArrayList<Food> arrayList = new ArrayList<Food>();//实例化ArrayList<Food>对象
	connection = SqlConnection.getConnection();
	String sql = "select * from Food_Table where f_kind=?"; // SQL查询语句
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
			arrayList.add(food);	//将food对象存入数组		
		}
		return arrayList;
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally {
		// 释放数据集对象
		if (resultSet != null) {
			try {
				resultSet.close();
				resultSet = null;
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		// 释放语句对象
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
	 *@功能: 查询具体的某个菜品id的菜品信息
*@return-type: Food
		*/
	public Food GetFoodById(int id) {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		connection = SqlConnection.getConnection();
		String sql = "select * from Food_Table where f_id=?"; // SQL查询语句
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
				return food;//返回food对象
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			// 释放数据集对象
			if (resultSet != null) {
				try {
					resultSet.close();
					resultSet = null;
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
			// 释放语句对象
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
