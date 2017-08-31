package com.zhiyou100.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou100.mapper.StatisticsMapper;
import com.zhiyou100.model.Statistics;
import com.zhiyou100.service.StatisticsService;
@Service
public class StatisticsServiceImpl implements StatisticsService {

	@Autowired
	StatisticsMapper  sm;

	@Override
	public List<Statistics> findStatisticsVideoAvgTimes() {
		// TODO Auto-generated method stub
		
		List<Statistics> list=sm.findStatisticsAvgTimes();
		return list;
	}
	
	
	
	
}
