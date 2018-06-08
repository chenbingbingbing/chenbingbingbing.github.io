package com.hotel.test;

import org.junit.Test;

import com.hotel.dao.CuisineDaoI;
import com.hotel.dao.impl.CuisineDaoImpl;
import com.hotel.pojo.Cuisine;

public class TestCuisine {

	@Test
	public void Test() throws Exception{
		CuisineDaoI cuisineDaoI = new CuisineDaoImpl();
		Cuisine cuisine = new Cuisine(null, "中餐");
		cuisineDaoI.addCuisine(cuisine);
	}

}
