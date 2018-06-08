package com.hotel.service.impl;

import java.util.List;

import com.hotel.dao.DinnerTableDaoI;
import com.hotel.dao.impl.DinnerTableDaoImpl;
import com.hotel.pojo.DinnerTable;
import com.hotel.service.DinnerTableServiceI;

public class DinnerTableServiceImpl implements DinnerTableServiceI{

	private DinnerTableDaoI dinnerTableDao=new DinnerTableDaoImpl();
	
	
	public List<DinnerTable> getDinnerTableList() throws Exception {
		// TODO Auto-generated method stub
		return dinnerTableDao.getDinnerTableList();
	}


	//退桌
	public void update(Integer id, Integer isBook) throws Exception {
		// TODO Auto-generated method stub
		dinnerTableDao.update(id, isBook);
	}


	@Override
	public void saveBoard(String tableName) throws Exception {
		// TODO Auto-generated method stub
		dinnerTableDao.saveBoard(tableName);
	}

}
