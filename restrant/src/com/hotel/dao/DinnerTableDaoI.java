package com.hotel.dao;

import java.util.List;

import com.hotel.pojo.DinnerTable;

/**
 * 
* @ClassName: DinnerTableDaoI 
* <p>Description:餐桌管理dao接口</p>
* <p>Company:baidu</p> 
* @author laomiu
* @date 2018年1月30日
 */
public interface DinnerTableDaoI {

	List<DinnerTable> getDinnerTableList() throws Exception;
	//退桌
	void update(Integer id,Integer isBook) throws Exception;
	//添加餐桌
	void saveBoard(String tableName) throws Exception;
	
}
