package com.zhiyou100.service.impl;



import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou100.mapper.SpeakerMapper;
import com.zhiyou100.model.Page;
import com.zhiyou100.model.Query;
import com.zhiyou100.model.Speaker;
import com.zhiyou100.service.SpeakService;

@Service
public class SpeakerServiceImpl implements SpeakService {
    @Autowired
	SpeakerMapper sm;

	/*@Override
	public List<Speaker> findAllSpeakerByName(String speakerName, String speakerJob) {
		// TODO Auto-generated method stub
		 List<Speaker> list=sm.findAllSpeakerByName(speakerName, speakerJob);
		 
		return list;
		
	}
*/
	@Override
	public List<Speaker> findAllSpeakerByName(Speaker s) {
		// TODO Auto-generated method stub
		List<Speaker> list=sm.findAllSpeakerByName(s);
		
		return list;
	}

	@Override
	public Speaker findSpeakerById(Integer id) {
		// TODO Auto-generated method stub
		return sm.selectByPrimaryKey(id);
	}

	@Override
	public void updateSpeakerBySpeaker(Speaker speaker) {
		// TODO Auto-generated method stub
		sm.updateByPrimaryKeySelective(speaker);
		
	}

	@Override
	public void deleteSpeakerById(Integer id) {
		// TODO Auto-generated method stub
		sm.deleteByPrimaryKey(id);
	}

	@Override
	public void addSpeakerBySpeaker(Speaker sp) {
		// TODO Auto-generated method stub
		sm.insertSelective(sp);
	}

	@Override
	public Page<Speaker> findAllSpeakerPage(String speakerName, String speakerJob, Integer currentPage) {
		// TODO Auto-generated method stub
		Page<Speaker> page=new Page<>();
		page.setPage(currentPage);
		page.setSize(5);
		Query qv=new Query();
		Speaker sp=new Speaker();
		sp.setSpeakerName(speakerName);
		sp.setSpeakerJob(speakerJob);
		page.setTotal(sm.findSpeakerByNJ(sp));
		
		qv.setSpeaker(sp);
		qv.setCurrentPage((currentPage-1)*5);
		page.setRows(sm.findAllSpeakerByPage(qv));
	    return page;
	}
	
	
}
