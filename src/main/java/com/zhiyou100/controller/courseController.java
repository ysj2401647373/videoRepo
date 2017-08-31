package com.zhiyou100.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.zhiyou100.model.Course;
import com.zhiyou100.model.Page;
import com.zhiyou100.model.Subject;
import com.zhiyou100.service.courseService;
import com.zhiyou100.service.subjectService;

@Controller
public class courseController {
   @Autowired
	courseService cs;
   @Autowired
   subjectService ss;
	@RequestMapping("/course/courseList.action")
   public ModelAndView courseList(@RequestParam(defaultValue="1")Integer page){

	/*List<Course> list=cs.findAllCourse();
	ModelAndView mv=new ModelAndView();
	mv.addObject("course",list);
	mv.setViewName("/course/courseList");*/
		Page<Course> page1=cs.findAllCourse(page);
		ModelAndView mv=new ModelAndView();
		mv.addObject("page",page1);
		mv.setViewName("/course/courseList");

	    return mv;	
	}
	@RequestMapping(value="/course/addCourse.action",method=RequestMethod.GET)
	public ModelAndView addCourse(){
		List<Subject> subject=ss.findAllSubject();
		ModelAndView mv=new ModelAndView();
		mv.addObject("subject", subject);
		mv.setViewName("/course/addCourse");
		return mv;	
	}
	@RequestMapping(value="/course/addCourse.action",method=RequestMethod.POST)
	public String addCourse(Course course){
		cs.addCourse(course);
		return "redirect:/course/courseList.action";	
	}
	@RequestMapping("/course/deleteCourse.action")
	public String deleteCourseById(Integer id){	
		cs.deleteCourse(id);
		return "redirect:/course/courseList.action";	
	}
	@RequestMapping(value="/course/updateCourse.action",method=RequestMethod.GET)
	public ModelAndView updateCourse(Integer id){
		Course course=cs.findCourseById(id);
		List<Subject> subject=ss.findAllSubject();
		ModelAndView mv=new ModelAndView();
		mv.addObject("course", course);
		mv.addObject("subject1", subject);
		mv.setViewName("/course/updateCourse");
		return mv;	
	}
	@RequestMapping(value="/course/updateCourse.action",method=RequestMethod.POST)
	public String updateCourse(Course course){	
		cs.updateCourse(course);
		return "redirect:/course/courseList.action";	
	}
	
	
}
