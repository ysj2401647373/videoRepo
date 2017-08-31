package com.zhiyou100.controller;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.zhiyou100.model.admin;
import com.zhiyou100.service.AdminService;
@Controller
public class LoginController {
	@Autowired
	AdminService as;
   @RequestMapping("/video/login.action")
	public String login(){
		return "index";	
	}
	@RequestMapping(value="/video/login.action",method=RequestMethod.POST)
	public String login(String loginName,String loginPwd,HttpSession session) throws NoSuchAlgorithmException{
		MessageDigest md=MessageDigest.getInstance("MD5");
		md.update(loginPwd.getBytes());
		String pwd=new BigInteger(1,md.digest()).toString(16);
		admin admin=as.videoLogin(loginName,pwd);
		if(admin==null){
			return "redirect:/video/login.action";
		}else{
			session.setAttribute("admin", admin);
			return "admin";
		}
		
	
		
	}
	
}
