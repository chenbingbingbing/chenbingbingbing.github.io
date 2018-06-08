package com.hotel.service.impl;

import java.util.List;

import com.hotel.dao.FoodDaoI;
import com.hotel.dao.impl.FoodDaoImpl;
import com.hotel.pojo.Food;
import com.hotel.service.FoodServiceI;

public class FoodServiceImpl implements FoodServiceI{
	private FoodDaoI foodDaoI = new FoodDaoImpl();
	@Override
	public List<Food> getFoodList() {
		return foodDaoI.getFoodList();
	}
	@Override
	public Food prepareFoodById(Integer id) {
		return foodDaoI.prepareFoodById(id);
	}
	@Override
	public void updateFoodInfo(List<String> arr) {		
		Integer foodType_id = Integer.parseInt(arr.get(0));
		Integer id = Integer.parseInt(arr.get(1));
		String foodName = arr.get(2);
		Double price = Double.parseDouble(arr.get(3));
		Double mprice = Double.parseDouble(arr.get(4));
		String remark = arr.get(5);
		String img = arr.get(arr.size()-1);
		Food food = new Food(id, foodName, price, mprice, remark, img, foodType_id, null);
		foodDaoI.updateFoodInfo(food);
	}
	@Override
	public void deleteFoodById(Integer id) {
		foodDaoI.deleteFoodById(id);
	}
	@Override
	public void addFoodInfo(List<String> arr) {
		Integer foodType_id = Integer.parseInt(arr.get(0));
		String foodName = arr.get(2);
		Double price = Double.parseDouble(arr.get(3));
		Double mprice = Double.parseDouble(arr.get(4));
		String remark = arr.get(5);
		String img = arr.get(arr.size()-1);
		Food food = new Food(null, foodName, price, mprice, remark, img, foodType_id, null);
		foodDaoI.addFoodInfo(food);
	}
	@Override
	public List<Food> searchFoodList(String keyword) {
		return foodDaoI.searchFoodList(keyword);
	}
	@Override
	public Food getFoodById(Integer id) {
		return foodDaoI.getFoodById(id);
	}
	@Override
	public List<Food> getFoodListById(Integer foodTypeId) {
		return foodDaoI.getFoodListById(foodTypeId);
	}
	@Override
	public Integer getFoodCount() {
		return foodDaoI.getFoodCount();
	}
	@Override
	public List<Food> getFoodListByPage(Integer i, Integer j) {
		return foodDaoI.getFoodListByPage(i,j);
	}
	@Override
	public List<Food> getFoodListByPage(Integer i, Integer j, Integer foodtypeid) {
		return foodDaoI.getFoodListByPage(i,j,foodtypeid);
	}

}
