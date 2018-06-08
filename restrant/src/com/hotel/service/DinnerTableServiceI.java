package com.hotel.service;

import java.util.List;

import com.hotel.pojo.DinnerTable;
/**
 * 
* @ClassName: DinnerTableServiceI 
* <p>Description:dinnerTableservice </p>
* <p>Company:baidu</p> 
* @author laomiu
* @date 2018年1月30日
 */
public interface DinnerTableServiceI {

	List<DinnerTable> getDinnerTableList() throws Exception;
	//退桌
	void update(Integer id,Integer isBook) throws Exception;
	//添加餐桌
	void saveBoard(String tableName) throws Exception;
	
}
