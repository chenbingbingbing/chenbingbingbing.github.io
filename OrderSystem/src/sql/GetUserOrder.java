package sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import dao.Menu;

/**
 * 程序名：CJ1.C  VER 3.0，2017-12-10 
 * 功  能：查询具体的某个顾客id的订单和查询所有的订单
 * 安全等级：2 级 
 * 编程人：陈冰；1789194307@qq.com 
 * 测试人：陈冰；1789194307@qq.com
*/
public class GetUserOrder {
	/**
	 *@author bing
	 *@Email:1789194307@qq.com
	 *@功能: 查询具体的某个顾客id的订单
*@return-type: ArrayList<Menu>
		*/
	public ArrayList<Menu> SelectUserOrder(int userid){
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		connection=SqlConnection.getConnection();
		String sqlState="select * from Menu_Table where uf_id=?";		
		ArrayList<Menu> arrayList = new ArrayList<Menu>();//实例化ArrayList<Menu>对象
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
				arrayList.add(menu);//将menu对象添加到数组
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
	 *@功能: 查询所有的订单
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
