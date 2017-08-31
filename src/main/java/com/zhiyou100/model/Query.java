package com.zhiyou100.model;

public class Query {
private Speaker speaker;
private Video vi;
private String speakerName;
private String courseName;
private Course course;
private int currentPage;
private String headUrl;
private User u;



public User getU() {
	return u;
}
public void setU(User u) {
	this.u = u;
}
public String getHeadUrl() {
	return headUrl;
}
public void setHeadUrl(String headUrl) {
	this.headUrl = headUrl;
}
public int getCurrentPage() {
	return currentPage;
}
public void setCurrentPage(int currentPage) {
	this.currentPage = currentPage;
}
public Course getCourse() {
	return course;
}
public void setCourse(Course course) {
	this.course = course;
}
public Speaker getSpeaker() {
	return speaker;
}
public void setSpeaker(Speaker speaker) {
	this.speaker = speaker;
}
public Video getVi() {
	return vi;
}
public void setVi(Video vi) {
	this.vi = vi;
}

public String getSpeakerName() {
	return speakerName;
}
public void setSpeakerName(String speakerName) {
	this.speakerName = speakerName;
}
public String getCourseName() {
	return courseName;
}
public void setCourseName(String courseName) {
	this.courseName = courseName;
}
@Override
public String toString() {
	return "Query [speaker=" + speaker + ", vi=" + vi + ", speakerName=" + speakerName + ", courseName=" + courseName
			+ ", course=" + course + ", currentPage=" + currentPage + ", headUrl=" + headUrl + ", u=" + u + "]";
}



}
