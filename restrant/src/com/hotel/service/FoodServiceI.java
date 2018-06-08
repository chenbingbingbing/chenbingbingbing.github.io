package com.hotel.service;

import java.util.List;

import com.hotel.pojo.Food;

public interface FoodServiceI {
	//获取菜品列表信息
	List<Food> getFoodList();
	//根据id获取要更新数据
	Food prepareFoodById(Integer id);
	//更新菜品信息
	void updateFoodInfo(List<String> arr);
	//删除菜品信息
	void deleteFoodById(Integer id);
	//添加菜品信息
	void addFoodInfo(List<String> arr);
	//根据关键词搜索菜品信息
	List<Food> searchFoodList(String keyword);
	//根据菜品id获取菜品详细信息
	Food getFoodById(Integer id);
	//根据菜品类型id获取对应分类的所有菜品
	List<Food> getFoodListById(Integer foodTypeId);
	//获取菜品总量
	Integer getFoodCount();
	//分页获取菜品信息
	List<Food> getFoodListByPage(Integer i, Integer j);
	//分页获取菜品信息
	List<Food> getFoodListByPage(Integer i, Integer j, Integer foodtypeid);
	
}
