package com.zhiyou100.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou100.mapper.CourseMapper;
import com.zhiyou100.model.Course;
import com.zhiyou100.model.Page;
import com.zhiyou100.model.Query;
import com.zhiyou100.service.courseService;
@Service
public class courseServiceImpl implements courseService {
    @Autowired
	CourseMapper cm;

	@Override
	public List<Course> findAllCourse() {
		// TODO Auto-generated method stub
		List<Course> list=cm.findAllCourse();
		return list;
	}

	@Override
	public void addCourse(Course course) {
		// TODO Auto-generated method stub
		cm.insertSelective(course);
	}

	@Override
	public void deleteCourse(Integer id) {
		// TODO Auto-generated method stub
		cm.deleteByPrimaryKey(id);
	}

	@Override
	public Course findCourseById(Integer id) {
		// TODO Auto-generated method stub
		Course course=cm.selectByPrimaryKey(id);
		return course;
	}

	@Override
	public void updateCourse(Course course) {
		// TODO Auto-generated method stub
		cm.updateByPrimaryKeySelective(course);
	}

	@Override
	public Page<Course> findAllCourse(Integer currentPage) {
		// TODO Auto-generated method stub
		Page<Course> page=new Page<>();
		page.setPage(currentPage);
		page.setSize(5);
		page.setTotal(cm.countCourse());
		Query qv=new Query();
		qv.setCurrentPage((currentPage-1)*5);
		page.setRows(cm.findAllCoursePage(qv));
		
		
		
		
		
		
		return page;
	}

	
	
	
	
}
