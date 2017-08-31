package com.zhiyou100.service;

import java.util.List;

import com.zhiyou100.model.Page;
import com.zhiyou100.model.Speaker;

public interface SpeakService {

	/*List<Speaker> findAllSpeakerByName(String speakerName, String speakerJob);*/

	List<Speaker> findAllSpeakerByName(Speaker s);

	Speaker findSpeakerById(Integer id);

	void updateSpeakerBySpeaker(Speaker sp);

	void deleteSpeakerById(Integer id);

	void addSpeakerBySpeaker(Speaker sp);

	Page<Speaker> findAllSpeakerPage(String speakerName, String speakerJob, Integer page);

	

}
