package com.zhiyou100.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou100.mapper.CourseMapper;
import com.zhiyou100.model.Course;
import com.zhiyou100.model.CourseExample;
import com.zhiyou100.service.FrontCourseService;
@Service
public class FrontCourseServiceImpl implements FrontCourseService {

	@Autowired
	CourseMapper cm;

	@Override
	public List<Course> findCourseBySubject(Integer subjectId) {
		// TODO Auto-generated method stub
		CourseExample example=new CourseExample();
		example.createCriteria().andSubjectIdEqualTo(subjectId);
		List<Course> list=cm.selectByExample(example);
		return list;
	}
	
	
	
}
