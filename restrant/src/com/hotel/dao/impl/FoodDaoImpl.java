package com.hotel.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.baidu.util.DButil;
import com.hotel.dao.FoodDaoI;
import com.hotel.pojo.Food;

public class FoodDaoImpl implements FoodDaoI{
	private Connection connection = null;
	private PreparedStatement pst=null;
	private ResultSet rs=null;
	@Override
	public List<Food> getFoodList() {
		List<Food> foodList=new ArrayList<>();
		String sql="select f.*,ft.typeName from food f,foodtype ft where f.foodType_id=ft.id";		
		try {
			connection = DButil.getConnection();
			pst= connection.prepareStatement(sql);			
			rs = pst.executeQuery();
			Food food=null;
			while(rs.next()){
				food= new Food(rs.getInt("id"), rs.getString("foodName"), rs.getDouble("price"), rs.getDouble("mprice"), rs.getString("remark"), rs.getString("img"), rs.getInt("foodType_id"), rs.getString("typeName"));
				foodList.add(food);				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DButil.closeDB(connection, pst, rs);
		}				
		return foodList;
	}
	@Override
	public Food prepareFoodById(Integer id) {
		Food food=null;
		String sql="select f.*,ft.typeName from food f,foodtype ft where f.foodType_id=ft.id and f.id=?";		
		try {
			connection = DButil.getConnection();
			pst= connection.prepareStatement(sql);
			pst.setInt(1, id);
			rs = pst.executeQuery();			
			if(rs.next()){
				food= new Food(rs.getInt("id"), rs.getString("foodName"), rs.getDouble("price"), rs.getDouble("mprice"), rs.getString("remark"), rs.getString("img"), rs.getInt("foodType_id"), rs.getString("typeName"));		
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DButil.closeDB(connection, pst, rs);
		}				
		return food;
	}
	@Override
	public void updateFoodInfo(Food food) {
		String sql = "update food set foodName=?,foodType_id=?,price=?,mprice=?,remark=?,img=? where id=?";	
		try {
		connection = DButil.getConnection();
		pst = connection.prepareStatement(sql);
		pst.setString(1,food.getFoodName());
		pst.setInt(2, food.getFoodType_id());
		pst.setDouble(3, food.getPrice());
		pst.setDouble(4, food.getMprice());
		pst.setString(5, food.getRemark());
		pst.setString(6, food.getImg());
		pst.setInt(7, food.getId());
		pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DButil.closeDB2(connection, pst);
		}
	}
	@Override
	public void deleteFoodById(Integer id) {
		String sql = "delete from food where id=?";	
		try {
		connection = DButil.getConnection();
		pst = connection.prepareStatement(sql);
		pst.setInt(1, id);
		pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DButil.closeDB2(connection, pst);
		}
	}
	@Override
	public void addFoodInfo(Food food) {
		String sql = "insert into food set foodName=?,foodType_id=?,price=?,mprice=?,remark=?,img=?";	
		try {
		connection = DButil.getConnection();
		pst = connection.prepareStatement(sql);
		pst.setString(1,food.getFoodName());
		pst.setInt(2, food.getFoodType_id());
		pst.setDouble(3, food.getPrice());
		pst.setDouble(4, food.getMprice());
		pst.setString(5, food.getRemark());
		pst.setString(6, food.getImg());
		pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DButil.closeDB2(connection, pst);
		}
	}
	@Override
	public List<Food> searchFoodList(String keyword) {
		List<Food> foodList=new ArrayList<>();
		String sql="select f.*,ft.typeName from food f,foodtype ft where f.foodType_id=ft.id and f.foodName like ?";		
		try {
			connection = DButil.getConnection();
			pst= connection.prepareStatement(sql);
			pst.setString(1, "%"+keyword+"%");
			rs = pst.executeQuery();
			Food food = null;
			while(rs.next()){
				food = new Food(rs.getInt("id"), rs.getString("foodName"), rs.getDouble("price"), rs.getDouble("mprice"), rs.getString("remark"), rs.getString("img"), rs.getInt("foodType_id"), rs.getString("typeName"));
				foodList.add(food);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DButil.closeDB(connection, pst, rs);
		}				
		return foodList;
	}
	@Override
	public Food getFoodById(Integer id) {
		Food food=null;
		String sql="select f.*,ft.typeName from food f,foodtype ft where f.foodType_id=ft.id and f.id=?";		
		try {
			connection = DButil.getConnection();
			pst= connection.prepareStatement(sql);	
			pst.setInt(1, id);
			rs = pst.executeQuery();		
			if(rs.next()){
				food= new Food(rs.getInt("id"), rs.getString("foodName"), rs.getDouble("price"), rs.getDouble("mprice"), rs.getString("remark"), rs.getString("img"), rs.getInt("foodType_id"), rs.getString("typeName"));					
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DButil.closeDB(connection, pst, rs);
		}				
		return food;
	}
	@Override
	public List<Food> getFoodListById(Integer foodTypeId) {
		List<Food> foodList=new ArrayList<>();
		String sql="select f.*,ft.typeName from food f,foodtype ft where f.foodType_id=ft.id and foodType_id=?";		
		try {
			connection = DButil.getConnection();
			pst= connection.prepareStatement(sql);
			pst.setInt(1, foodTypeId);
			rs = pst.executeQuery();
			Food food=null;
			while(rs.next()){
				food= new Food(rs.getInt("id"), rs.getString("foodName"), rs.getDouble("price"), rs.getDouble("mprice"), rs.getString("remark"), rs.getString("img"), rs.getInt("foodType_id"), rs.getString("typeName"));
				foodList.add(food);				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DButil.closeDB(connection, pst, rs);
		}				
		return foodList;
	}
	@Override
	public Integer getFoodCount() {
		Integer count = null;
		String sql="select count(*) from food";		
		try {
			connection = DButil.getConnection();
			pst= connection.prepareStatement(sql);			
			rs = pst.executeQuery();
			if(rs.next()){
				count = rs.getInt(1);			
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DButil.closeDB(connection, pst, rs);
		}				
		return count;
	}
	@Override
	public List<Food> getFoodListByPage(int i, int j) {
		List<Food> foodList=new ArrayList<>();
		String sql="select f.*,ft.typeName from food f,foodtype ft where f.foodType_id=ft.id limit ?,?";		
		try {
			connection = DButil.getConnection();
			pst= connection.prepareStatement(sql);	
			pst.setInt(1, i);
			pst.setInt(2, j);
			rs = pst.executeQuery();
			Food food=null;
			while(rs.next()){
				food= new Food(rs.getInt("id"), rs.getString("foodName"), rs.getDouble("price"), rs.getDouble("mprice"), rs.getString("remark"), rs.getString("img"), rs.getInt("foodType_id"), rs.getString("typeName"));
				foodList.add(food);				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DButil.closeDB(connection, pst, rs);
		}				
		return foodList;
	}
	@Override
	public List<Food> getFoodListByPage(Integer i, Integer j, Integer foodtypeid) {
		List<Food> foodList=new ArrayList<>();
		String sql="select f.*,ft.typeName from food f,foodtype ft where f.foodType_id=ft.id and foodType_id=? limit ?,?";		
		try {
			connection = DButil.getConnection();
			pst= connection.prepareStatement(sql);
			pst.setInt(1, foodtypeid);
			pst.setInt(2, i);
			pst.setInt(3, j);
			rs = pst.executeQuery();
			Food food=null;
			while(rs.next()){
				food= new Food(rs.getInt("id"), rs.getString("foodName"), rs.getDouble("price"), rs.getDouble("mprice"), rs.getString("remark"), rs.getString("img"), rs.getInt("foodType_id"), rs.getString("typeName"));
				foodList.add(food);				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DButil.closeDB(connection, pst, rs);
		}				
		return foodList;
	}

}
