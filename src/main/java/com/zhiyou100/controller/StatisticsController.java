package com.zhiyou100.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zhiyou100.model.Statistics;
import com.zhiyou100.service.StatisticsService;

@Controller
public class StatisticsController {
    @Autowired
	StatisticsService ss;
	@RequestMapping("/video/StatisticList.action")
    public String statistics(Model md){
    	List<Statistics> list=ss.findStatisticsVideoAvgTimes();
    	StringBuffer dataBuffer = new StringBuffer();
		StringBuffer timeBuffer = new StringBuffer();
    	for(int i=0;i<list.size();i++){
    		Statistics st=list.get(i);
    		dataBuffer.append(st.getCourseName());
    		timeBuffer.append(st.getAvgTimes());	
    		if(i!=list.size()-1){
    			dataBuffer.append(",");
        		timeBuffer.append(",");	
    		}
    	}
    md.addAttribute("data",dataBuffer.toString());
    md.addAttribute("times",timeBuffer.toString());
    	
		return "analysis/statistics";
    	
    	
    }
    
    
}
