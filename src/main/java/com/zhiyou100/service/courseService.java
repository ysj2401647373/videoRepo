package com.zhiyou100.service;

import java.util.List;


import com.zhiyou100.model.Course;
import com.zhiyou100.model.Subject;

public interface courseService {

	List<Course> findAllCourse();

	void addCourse(Course course);

	void deleteCourse(Integer id);

	Course findCourseById(Integer id);

	void updateCourse(Course course);

	
	
}
