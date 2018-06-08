package com.hotel.dao;

import java.util.List;

import com.hotel.pojo.Cuisine;

public interface CuisineDaoI {
	//获取菜系列表
	List<Cuisine> getCuisineList();

	Cuisine getCuisine(Integer id);

	void updateCuisine(Cuisine cuisine);

	void deleteCuisine(Integer id);

	void addCuisine(Cuisine cuisine);

	List<Cuisine> searchCuisineList(String keyword);

	
}
