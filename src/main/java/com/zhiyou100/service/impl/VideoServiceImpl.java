package com.zhiyou100.service.impl;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou100.mapper.VideoMapper;
import com.zhiyou100.model.Page;
import com.zhiyou100.model.Query;
import com.zhiyou100.model.Video;
import com.zhiyou100.model.VideoExample;
import com.zhiyou100.service.VideoService;
;
@Service
public class VideoServiceImpl implements VideoService {
     
	@Autowired
	VideoMapper vm;

	@Override
	public Page<Video> findAllVideo(String videoTitle,Integer speakerId, Integer courseId, int currentPage) {
		// TODO Auto-generated method stub
		Page<Video> page=new Page<>();
		page.setSize(10);
		Query qv=new Query();
		Video vi=new Video();
		vi.setVideoTitle(videoTitle);
		vi.setSpeakerId(speakerId);
		vi.setCourseId(courseId);
		page.setTotal(vm.countAllVideo(vi));
		page.setPage(currentPage);
		qv.setCurrentPage((currentPage-1)*10);
		qv.setVi(vi);
		page.setRows(vm.seleteAllVideoByQuery(qv));
	    return page;

	}

	@Override
	public void addVideo(Video vo) {
		vm.insertSelective(vo);
	}

	@Override
	public void deleteVideo(Integer id) {
		// TODO Auto-generated method stub
		vm.deleteByPrimaryKey(id);
	}

	@Override
	public Video updateVideoById(Integer id) {
		// TODO Auto-generated method stub
		Video vi=vm.selectByPrimaryKey(id);
		return vi;
	}

	@Override
	public void updateVideo(Video vi) {
		// TODO Auto-generated method stub
		vm.updateByPrimaryKeySelective(vi);
	}

	@Override
	public void deleteInVideo(List<Integer> ids) {
		// TODO Auto-generated method stub
		 VideoExample example = new VideoExample();
		 example.createCriteria().andIdIn(ids);
		 
		 vm.deleteByExample(example);
	
	}

	@Override
	public List<Video> findVideoList(Integer courseId) {
		// TODO Auto-generated method stub
		VideoExample example=new VideoExample();
		example.createCriteria().andCourseIdEqualTo(courseId);
		List<Video> list = vm.selectByExample(example);
	
		
		return list;
	}

	@Override
	public Video findVideoById(Integer videoId) {
		// TODO Auto-generated method stub
		
		Video video=vm.selectByPrimaryKey(videoId);
		return video;
	}

	@Override
	public List<Video> findAllVideo() {
		// TODO Auto-generated method stub
		
		
		List<Video> list=vm.selectAllVideo();
		
		return list;
	}

	
}
