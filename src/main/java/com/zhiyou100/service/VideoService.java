package com.zhiyou100.service;

import java.util.List;

import com.zhiyou100.model.Page;
import com.zhiyou100.model.Video;

public interface VideoService {
	

	Page<Video> findAllVideo(String videoTitle, Integer speakerId, Integer courseId, int currentPage);

	void addVideo(Video vo);

	void deleteVideo(Integer id);

	Video updateVideoById(Integer id);

	void updateVideo(Video vi);

	void deleteInVideo(List<Integer> ids);

	List<Video> findVideoList(Integer courseId);

	Video findVideoById(Integer videoId);

	List<Video> findAllVideo();

	
}
