package com.hotel.service;

import java.util.List;

import com.hotel.pojo.Cuisine;

public interface CuisineServiceI {
	//获取菜系列表
	List<Cuisine> getCuisineList();
	//获取准备更新的菜系数据
	Cuisine getCuisine(Integer id);
	//更新菜系信息
	void updateCuisine(Cuisine cuisine);
	//删除菜系信息
	void deleteCuisine(Integer id);
	//添加菜系信息
	void addCuisine(Cuisine cuisine);
	//搜索菜系列表
	List<Cuisine> searchCuisineList(String keyword);

}
