package com.zhiyou100.controller;


import java.util.Arrays;
import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.zhiyou100.model.Course;
import com.zhiyou100.model.Page;
import com.zhiyou100.model.Query;
import com.zhiyou100.model.Speaker;
import com.zhiyou100.model.Subject;
import com.zhiyou100.model.Video;
import com.zhiyou100.service.SpeakService;
import com.zhiyou100.service.VideoService;
import com.zhiyou100.service.courseService;
import com.zhiyou100.service.subjectService;

@Controller
public class VideoController {
   @Autowired
	VideoService vs;
   @Autowired
   SpeakService ss;
   @Autowired
   courseService cs;
   @Autowired
   subjectService sj;
   @RequestMapping("/video/videoList.action")
   public ModelAndView videoList(@RequestParam(defaultValue="0")Integer speakerId,
		   @RequestParam(defaultValue="0")Integer courseId,
		   @RequestParam(defaultValue="1")int page,
		 
		   @RequestParam(defaultValue="")String videoTitle
		  ){
	Page<Video> page1=vs.findAllVideo(videoTitle,speakerId,courseId,page);
	Speaker s=new Speaker();
    List<Speaker> speaker=ss.findAllSpeakerByName(s);
     
	List<Course> course=cs.findAllCourse();
	ModelAndView mv=new ModelAndView();
	mv.addObject("page",page1);
	mv.addObject("speaker",speaker);
	mv.addObject("course",course);
	mv.addObject("videoTitle",videoTitle);
	mv.addObject("speakerId",speakerId);
	mv.addObject("courseId",courseId);
	mv.setViewName("/video/videoList");
	return mv;   
   }

   @RequestMapping(value="/video/addVideo.action",method=RequestMethod.GET)
   public ModelAndView addVideo(){
	   Speaker s=new Speaker();
	   List<Speaker> speaker=ss.findAllSpeakerByName(s);
       List<Subject> subject=sj.findAllSubject();
	   ModelAndView mv=new ModelAndView();
	   mv.addObject("speaker",speaker);
	   mv.addObject("subject",subject);
	   mv.setViewName("/video/addVideo");
	   return mv;
	   
   }
   @RequestMapping(value="/video/addVideo.action",method=RequestMethod.POST)
   public String addVideo(Video vo){
	   System.out.println(vo);
	   vs.addVideo(vo);      
	return "redirect:/video/videoList.action";
	   
   }
  @RequestMapping("/video/deleteVideo.action")
  @ResponseBody
   public String deleteVideo(Integer id){
	  vs.deleteVideo(id);

	 return "success"; 
	  
   }
   
  @RequestMapping(value="/video/updateVideo.action",method=RequestMethod.GET)
  public ModelAndView updateVideo(Integer id){
	  Speaker s=new Speaker();
	   List<Speaker> speaker=ss.findAllSpeakerByName(s);
      List<Subject> subject=sj.findAllSubject();
      Video vi=vs.updateVideoById(id);
      ModelAndView mv=new ModelAndView();
      mv.addObject("speaker2", speaker);
      mv.addObject("subject2",subject);
      mv.addObject("video", vi);
      mv.setViewName("/video/updateVideo");
	  return mv;  
  }
  @RequestMapping(value="/video/updateVideo.action",method=RequestMethod.POST)
  public String updateVideo(Video vi){	  
	  vs.updateVideo(vi);  
	return "redirect:/video/videoList.action";
	  
  }
 
  @RequestMapping(value="/video/deleteInVideo.action")
  @ResponseBody
  public String deleteInVideo(Integer[] ids){
	        //将数组转成list     
	  System.out.println(Arrays.toString(ids));
	  List<Integer> list = Arrays.asList(ids);
	  vs.deleteInVideo(list);
	 
	/*return "redirect:/video/videoList.action";  */
    return "success"; 
  }
  
}
