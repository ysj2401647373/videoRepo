package com.zhiyou100.service;

import java.util.List;

import com.zhiyou100.model.Subject;

public interface subjectService {

	List<Subject> findAllSubject();

	Subject findSubject(Integer subjectId);

}
