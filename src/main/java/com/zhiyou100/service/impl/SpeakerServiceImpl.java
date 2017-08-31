package com.zhiyou100.service.impl;



import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou100.mapper.SpeakerMapper;
import com.zhiyou100.model.Speaker;
import com.zhiyou100.model.SpeakerExample;
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
	
	
}
