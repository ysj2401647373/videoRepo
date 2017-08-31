package com.zhiyou100.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou100.mapper.UserMapper;
import com.zhiyou100.model.User;
import com.zhiyou100.model.UserExample;
import com.zhiyou100.service.UserService;
@Service
public class UserServiceImpl implements UserService {
    @Autowired
	UserMapper um;

	@Override
	public void regist(User user) {
		// TODO Auto-generated method stub
		
		um.insert(user);
		
	}

	@Override
	public List<User> findUser(User u) {
		// TODO Auto-generated method stub
		  UserExample example=new UserExample();
		example.createCriteria().andEmailEqualTo(u.getEmail()).andPasswordEqualTo(u.getPassword());
		   List<User> list=um.selectByExample(example);
		   
			return list;
		  	
	}

	@Override
	public User findUserById(Integer id) {
		// TODO Auto-generated method stub
  
		return um.selectByPrimaryKey(id);
	}

	@Override
	public void updatePropile(User u) {
		// TODO Auto-generated method stub
		um.updateByPrimaryKeySelective(u);
	}
	@Override
	public void updateRoleById(User u) {
		// TODO Auto-generated method stub
		um.updateByPrimaryKeySelective(u);
	}

	@Override
	public List<User> findUserByPassword(String password) {
		// TODO Auto-generated method stub
		
		UserExample example=new UserExample();
		example.createCriteria().andPasswordEqualTo(password);
		List<User> list = um.selectByExample(example);
		System.out.println(list);
		return list;
	}

	@Override
	public void updatePassword(User u) {
		// TODO Auto-generated method stub
		um.updateByPrimaryKeySelective(u);
	}

	@Override
	public User findUserByEmail(String email) {
		// TODO Auto-generated method stub
		UserExample example=new UserExample();
		example.createCriteria().andEmailEqualTo(email);
		List<User> list=um.selectByExample(example);
		User u=null;
		 for (User user : list) {
			  u=user;
			}
			 if(u==null){	
			 }
			return u;
		
	}

	@Override
	public void updateUserByUser(User user) {
		// TODO Auto-generated method stub
		um.updateByPrimaryKeySelective(user);
	}

	@Override
	public User findUserByCaptcha(String email, String captcha) {
		// TODO Auto-generated method stub
		UserExample example=new UserExample();
		example.createCriteria().andEmailEqualTo(email).andCaptchaEqualTo(captcha);
		List<User> list=um.selectByExample(example);
		User u=null;
		 for (User user : list) {
			  u=user;
			}
			 if(u==null){	
			 }
			return u;

	}
	
	
}
