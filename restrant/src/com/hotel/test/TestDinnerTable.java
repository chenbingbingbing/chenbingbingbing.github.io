package com.hotel.test;

import java.util.List;

import org.junit.Test;

import com.hotel.dao.DinnerTableDaoI;
import com.hotel.dao.impl.DinnerTableDaoImpl;
import com.hotel.pojo.DinnerTable;

public class TestDinnerTable {
	@Test
	public void test1() throws Exception{
		
		DinnerTableDaoI dinnerTableDao = new DinnerTableDaoImpl();
		List<DinnerTable> dinnerTableList = dinnerTableDao.getDinnerTableList();
		for (DinnerTable dinnerTable : dinnerTableList) {
			System.out.println(dinnerTable);
		}
	}
	
}
