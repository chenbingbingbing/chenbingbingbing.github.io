package com.baidu.service;

import java.util.List;

import com.baidu.pojo.Student;

public interface PageServiceI {
		//加上模糊条件根据当前页和页条数获取每一页的值
		List<Student> getStudentPage(Integer currentnum,Integer pagesize, String noclear);
		//加上模糊条件获取数据库记录条数
		Integer getCounter(String noclear);
}
