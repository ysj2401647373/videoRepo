package com.zhiyou100.service;

import java.util.List;

import com.zhiyou100.model.User;

public interface UserService {

	void regist(User user);

	List<User> findUser(User u);

	User findUserById(Integer id);

	void updatePropile(User u);

	void updateRoleById(User u);

	List<User> findUserByPassword(String oldPassword);

	void updatePassword(User u);

	User findUserByEmail(String email);

	void updateUserByUser(User user);

	User findUserByCaptcha(String email, String captcha);

	int IntegerCode(Integer length);

	

}
