package com.zhiyou100.util;

public class VideoTime {

	public  static String ConverTime(Integer time){
		int a=(time/3600);
		String str1=null;
		if(a<10){
			str1="0"+a;
		}else{
			str1=""+a;
		}
		int b=(time%3600)/60;
		String str2=null;
		if(b<10){
			str2="0"+b;
		}else{
			str2=""+b;
		}
		int c=(time%3600)%60;
		String str3=null;
		if(c<10){
			str3="0"+c;
		}else{
			str3=""+c;
		}
		String str=str1+":"+str2+":"+str3;
		return str;

	}
	
	
	
}
