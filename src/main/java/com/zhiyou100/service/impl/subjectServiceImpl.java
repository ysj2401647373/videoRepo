package com.zhiyou100.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou100.mapper.SubjectMapper;
import com.zhiyou100.model.Subject;
import com.zhiyou100.service.subjectService;
@Service
public class subjectServiceImpl implements subjectService {
    @Autowired
	SubjectMapper sm;

	@Override
	public List<Subject> findAllSubject() {
		// TODO Auto-generated method stub
		List<Subject> list=sm.findAllSubject();
		
		return list;
	}

	@Override
	public Subject findSubject(Integer id) {
		// TODO Auto-generated method stub
		Subject s = sm.selectByPrimaryKey(id);
		
		return s;
	}
    
    
}
