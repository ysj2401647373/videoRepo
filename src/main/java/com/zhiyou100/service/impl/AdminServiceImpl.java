package com.zhiyou100.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou100.mapper.adminMapper;
import com.zhiyou100.model.admin;
import com.zhiyou100.model.adminExample;
import com.zhiyou100.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService {
@Autowired
	adminMapper am;
	
	@Override
	public admin videoLogin(String loginName, String loginPwd) {
		// TODO Auto-generated method stub
		adminExample example=new adminExample();
		example.createCriteria().andLoginNameLike(loginName).andLoginPwdLike(loginPwd);
		 List<admin> list = am.selectByExample(example);
		 admin u=null;
		 for (admin admin : list) {
		  u=admin;
		}
		 if(u==null){
			 System.out.println("1111");
		 }
		return u;
	}

	
	
}
