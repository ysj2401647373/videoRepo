package com.zhiyou100.model;

public class Statistics {

	
	private String courseName;
	private  int  avgTimes;
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public int getAvgTimes() {
		return avgTimes;
	}
	public void setAvgTimes(int avgTimes) {
		this.avgTimes = avgTimes;
	}
	@Override
	public String toString() {
		return "Statistics [courseName=" + courseName + ", avgTimes=" + avgTimes + "]";
	}
	
	
}
