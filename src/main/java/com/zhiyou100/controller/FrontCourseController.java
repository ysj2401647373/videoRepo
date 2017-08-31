package com.zhiyou100.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zhiyou100.model.Course;
import com.zhiyou100.model.Speaker;
import com.zhiyou100.model.Subject;
import com.zhiyou100.model.Video;
import com.zhiyou100.service.FrontCourseService;
import com.zhiyou100.service.SpeakService;
import com.zhiyou100.service.VideoService;
import com.zhiyou100.service.courseService;
import com.zhiyou100.service.subjectService;
@Controller
public class FrontCourseController {
   @Autowired
	FrontCourseService fcs;
   @Autowired
   VideoService vs;
   @Autowired
   subjectService ss;
   @Autowired
   courseService cs;
   @Autowired
   SpeakService sp;
	@RequestMapping("/front/course/index.action")
	public String webCourse(Integer subjectId,Model md){
	      
		          Subject s=ss.findSubject(subjectId);
		
		
		List<Course> list=fcs.findCourseBySubject(subjectId);
	    for(Course course:list){
	    	course.setVideoList(vs.findVideoList(course.getId()));               
	    }
	    md.addAttribute("subject",s);
		md.addAttribute("subjectId", subjectId);
		md.addAttribute("courses", list);
		return "/front/course/index";
		
	}
	
	@RequestMapping("front/video/index.action")
	public String courseJ(Integer videoId,Integer subjectId,Model md){
		 Subject s=ss.findSubject(subjectId);
		 md.addAttribute("videoId", videoId);
		 md.addAttribute("subject",s);
		
		return "/front/video/index";
		
	}
	@RequestMapping("front/video/videoData.action")
	public String courseContent(Integer videoId,Model md){
		Video vi=vs.findVideoById(videoId);
		
		Speaker speaker=sp.findSpeakerById(vi.getSpeakerId());
	
		Course course=cs.findCourseById(vi.getCourseId());
		List<Video> list=vs.findAllVideo();

		md.addAttribute("video", vi);
		md.addAttribute("speaker", speaker);
		md.addAttribute("course", course);
		md.addAttribute("videoList", list);
		return "/front/video/content";
		
		
	}
	
	
}
