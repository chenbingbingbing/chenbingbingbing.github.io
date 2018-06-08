package com.baidu.service;

import java.util.List;

import com.baidu.dao.PageDaoI;
import com.baidu.dao.PageDaoImpl;
import com.baidu.pojo.Student;

public class PageServiceImpl implements PageServiceI{
	private PageDaoI pagedao = new PageDaoImpl();
	@Override
	public List<Student> getStudentPage(Integer currentnum, Integer pagesize,String noclear) {
		return pagedao.getStudentPage(currentnum, pagesize,noclear);
	}

	@Override
	public Integer getCounter(String noclear) {
		return pagedao.getCounter(noclear);
	}

}
