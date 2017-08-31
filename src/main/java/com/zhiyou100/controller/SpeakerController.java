package com.zhiyou100.controller;


import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.zhiyou100.model.Page;
import com.zhiyou100.model.Speaker;
import com.zhiyou100.service.SpeakService;

@Controller
public class SpeakerController {
    @Autowired
	SpeakService ss;
  /*  @RequestMapping("/speaker/speakerList.action")
    public String speakerList(){
		return "/speaker/speakerList";	
    }   
    */
   /* @RequestMapping(value="/speaker/speakerList.action")
    public ModelAndView speakerList(@RequestParam(defaultValue="",required=true)String speakerName,
    		@RequestParam(defaultValue="")String speakerJob,
    		HttpServletRequest req){
    	req.setAttribute("speakerName",speakerName);
    	req.setAttribute("speakerJob",speakerJob);
    	//System.out.println(speakerName+".."+speakerJob);
    	Speaker s=new Speaker();
    	s.setSpeakerName(speakerName);
    	s.setSpeakerJob(speakerJob);
    	List<Speaker> speaker=ss.findAllSpeakerByName(s);
    	//System.out.println(speaker);
    	ModelAndView mv=new ModelAndView();
    	mv.addObject("speaker", speaker);
    	mv.setViewName("/speaker/speakerList");
		return mv;	
    }*/
    @RequestMapping(value="/speaker/speakerList.action")
    public ModelAndView speakerList(@RequestParam(defaultValue="",required=true)String speakerName,
    		@RequestParam(defaultValue="")String speakerJob,
    		@RequestParam(defaultValue="1")Integer page
    		){
    	
    	Page<Speaker> page1=ss.findAllSpeakerPage(speakerName,speakerJob,page);
    	
    	ModelAndView mv=new ModelAndView();
    	mv.addObject("page",page1);
    	mv.addObject("speakerName",speakerName);
    	mv.addObject("speakerJob",speakerJob);
    	mv.setViewName("/speaker/speakerList");
    	return mv;	
    }
    @RequestMapping(value="/speaker/updateSpeaker.action",method=RequestMethod.GET)
    public ModelAndView updateSpeaker(Integer id){
	
    	Speaker speaker=ss.findSpeakerById(id);
    	ModelAndView mv=new ModelAndView();
    	mv.addObject("speaker", speaker);
    	mv.setViewName("/speaker/updateSpeaker");
    	return mv;	
    }
     @RequestMapping(value="/speaker/updateSpeaker.action",method=RequestMethod.POST)
     public String updateSpeaker(Speaker speaker){
    	System.out.println(speaker);
    	 ss.updateSpeakerBySpeaker(speaker);
 		
    	 return "redirect:/speaker/speakerList.action";	 
     }
     
     @RequestMapping("/speaker/deleteSpeaker.action")
     public String delete(Integer id){
    	 
    	 ss.deleteSpeakerById(id);
    	 
		return "redirect:/speaker/speakerList.action";
    	 
     }
     @RequestMapping("/speaker/addSpeaker.action")
     public String addSpeaker(){
		return "speaker/addSpeaker";	 
     }
     @RequestMapping(value="/speaker/addSpeaker.action",method=RequestMethod.POST)
     public String addSpeaker(Speaker speaker){
    	 ss.addSpeakerBySpeaker(speaker);
		return "redirect:/speaker/speakerList.action";	 
     }
     
}
