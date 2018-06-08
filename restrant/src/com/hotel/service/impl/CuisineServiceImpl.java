package com.hotel.service.impl;

import java.util.List;

import com.hotel.dao.CuisineDaoI;
import com.hotel.dao.impl.CuisineDaoImpl;
import com.hotel.pojo.Cuisine;
import com.hotel.service.CuisineServiceI;

public class CuisineServiceImpl implements CuisineServiceI{
	private CuisineDaoI cuisineDaoI = new CuisineDaoImpl();
	@Override
	public List<Cuisine> getCuisineList() {
		return cuisineDaoI.getCuisineList();
	}
	@Override
	public Cuisine getCuisine(Integer id) {
		return cuisineDaoI.getCuisine(id);
	}
	@Override
	public void updateCuisine(Cuisine cuisine) {
		cuisineDaoI.updateCuisine(cuisine);
	}
	@Override
	public void deleteCuisine(Integer id) {
		cuisineDaoI.deleteCuisine(id);
	}
	@Override
	public void addCuisine(Cuisine cuisine) {
		cuisineDaoI.addCuisine(cuisine);
	}
	@Override
	public List<Cuisine> searchCuisineList(String keyword) {
		return cuisineDaoI.searchCuisineList(keyword);
	}

}
