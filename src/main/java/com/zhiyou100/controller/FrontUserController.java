package com.zhiyou100.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.zhiyou100.model.User;
import com.zhiyou100.service.UserService;
import com.zhiyou100.util.MD5Utils;
import com.zhiyou100.util.MailUtil;

@Controller
public class FrontUserController {

	@Autowired
	UserService us;

	@RequestMapping("/front/login.action")
	public String login() {
		return "/front/index";

	}

	@RequestMapping(value = "/front/user/regist.action", method = RequestMethod.POST)
	@ResponseBody
	public String regist(User user, Model md) {

		us.regist(user);
		md.addAttribute("user", user);
		return "success";

	}

	@RequestMapping(value = "front/user/login.action", method = RequestMethod.POST)
	@ResponseBody
	public String frontLogin(User u, HttpSession session) {

		List<User> list = us.findUser(u);
		if (list.isEmpty()) {
			return "false";
		}
		session.setAttribute("_front_user", list.get(0));
		return "success";

	}

	@RequestMapping("/front/user/index.action")
	public String indexCenter(Integer id, HttpSession session) {

		User user = us.findUserById(id);
		session.setAttribute("user", user);
		return "/front/user/index";

	}

	@RequestMapping("/front/user/profile.action")
	public String updateProfile(Integer id, HttpSession session) {

		User user = us.findUserById(id);
		session.setAttribute("user", user);
		return "/front/user/profile";

	}

	@RequestMapping(value = "/front/user/profile.action", method = RequestMethod.POST)
	public String updatePropile(User u, Model md) {

		us.updatePropile(u);
		User user = us.findUserById(u.getId());

		md.addAttribute("user", user);
		return "/front/user/index";

	}

	@RequestMapping("/front/user/avatar.action")
	public String updateAvatar(Integer id, HttpSession session) {
		User user = us.findUserById(id);
		session.setAttribute("user", user);

		return "/front/user/avatar";

	}

	@RequestMapping(value = "/front/user/avatar.action", method = RequestMethod.POST)
	public String updateAvatar(User user, MultipartFile image_file, HttpSession session)
			throws IllegalStateException, IOException {
		String str = UUID.randomUUID().toString().replaceAll("-", "");
		String ext = FilenameUtils.getExtension(image_file.getOriginalFilename());
		String fileName = str + "." + ext;
		user.setHeadUrl(fileName);

		String path = "D:\\imgfile";

		image_file.transferTo(new File(path + "\\" + fileName));
		// 把数据写到数据库中
		us.updateRoleById(user);
		/*
		 * User u =us.findUserById(user.getId()); session.setAttribute("user",
		 * u);
		 */
		return "/front/user/avatar";

	}

	@RequestMapping("/front/user/password.action")
	public String changePassword(Integer id, HttpSession session) {
		User user = us.findUserById(id);
		session.setAttribute("user", user);

		return "/front/user/password";

	}

	@RequestMapping(value = "front/user/oldPassword.action")
	@ResponseBody
	public String oldpassword(String password, Model md) {
		String password1 = MD5Utils.getMD5(password.trim());
		List<User> list = us.findUserByPassword(password1);

		if (list.isEmpty()) {
			md.addAttribute("error", "密码不正确");

			return "fail";
		} else {
			System.out.println("密码正确");
			return "success";

		}

	}

	@RequestMapping(value = "/front/user/password.action", method = RequestMethod.POST)

	public String changePassword(Integer id, String newPassword, Model md, HttpSession session) {
		User user = us.findUserById(id);
		user.setPassword(newPassword);
		us.updatePropile(user);
		session.invalidate();
		return "redirect:/front/login.action";
	}

	@RequestMapping("/front/user/forgetpwd.action")
	public String forgetPassword() {
		return "/front/user/forget_pwd";

	}

	@RequestMapping(value = "front/user/ajaxforgetpwd.action", method = RequestMethod.POST)
	@ResponseBody
	public String forgetPassweord(String email) throws Exception {

		/*
		 * Random ran = new Random(); int num = ran.nextInt(10000 - 1000 + 1) +
		 * 1000; User user = us.findUserByEmail(email); user.setCaptcha("" +
		 * num); us.updateUserByUser(user); MailUtil.send("2401647373@qq.com",
		 * "验证码", "" + num);
		 */

		int num = us.IntegerCode(8);
		User user = us.findUserByEmail(email);
		user.setCaptcha("" + num);
		us.updateUserByUser(user);
		MailUtil.send("2401647373@qq.com", "验证码", "" + num);
		return "success";

	}

	@RequestMapping(value = "/front/user/resetPwd.action", method = RequestMethod.POST)
	public String resetPassword(String email, String captcha, Model md) {

		User u = us.findUserByCaptcha(email, captcha);
		if (u != null) {
			md.addAttribute("email", email);
			md.addAttribute("captcha", captcha);
		}
		return "/front/user/reset_pwd";
	}

	@RequestMapping(value = "/front/user/reset.action", method = RequestMethod.POST)
	public String reset(String email, String captcha, String password) {
		User u = us.findUserByCaptcha(email, captcha);
		u.setPassword(password);
		us.updateUserByUser(u);
		return "/front/user/forget_pwd";

	}

	@RequestMapping("/front/loginOut.action")
	public String loginOut(HttpSession session) {
		session.invalidate();
		return "redirect:/front/login.action";

	}

}
