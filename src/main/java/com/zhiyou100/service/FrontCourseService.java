package com.zhiyou100.service;

import java.util.List;

import com.zhiyou100.model.Course;

public interface FrontCourseService {

	List<Course> findCourseBySubject(Integer subjectId);
   
}
