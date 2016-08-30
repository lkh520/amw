/**
 *=========================================================
 * project:amw
 * package:com.lkh.amw.controller
 * class:UserController.java
 *=========================================================
 * @author:lkh
 * @since:JDK1.7
 * @version:1.0
 *=========================================================
 * create time:2016年8月18日-下午9:08:49
 */
package com.lkh.amw.controller;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lkh.amw.pojo.User;
import com.lkh.amw.service.UserService;

/**
 * @author lkh
 * @createTime 2016年8月18日 下午9:08:49
 */
@Controller
@RequestMapping("/user")
public class UserController {
	@Resource(name = "userServiceImpl")
	private UserService userService;

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@RequestMapping(value = "/showuser.do", method = RequestMethod.POST)
	public String toIndex(HttpServletRequest request, Model model) {
		User userLogin = new User();
		userLogin.setUserName(request.getParameter("username"));
		userLogin.setPassWord(request.getParameter("password"));
		User user = this.userService.getUserByusername(userLogin.getUserName());
		if (null != user) {
			
			model.addAttribute("user", user);
		} else {
			model.addAttribute("user", null);
		}
		return "indexuser";
	}

	@RequestMapping(value = "/register.do", method = RequestMethod.POST)
	public String registerIndex(HttpServletRequest request, Model model) {
		// ModelAndView mav=new ModelAndView();
		User userRegister = new User();
		String username2 = request.getParameter("username");
		String password2 = request.getParameter("password");
		userRegister.setUserName(username2);
		userRegister.setPassWord(password2);
		if (userRegister.getUserName() != null) {
//			if (request.getParameter("age") == null) {
//				userRegister.setAge(25);
//			} else {
//				userRegister.setAge(Integer.parseInt(request
//						.getParameter("age")));
//			}
		}

		int id;
		try {
			id = this.userService.createUser(userRegister);
			User user = this.userService.getUserById(id);
			model.addAttribute("user", user);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "indexuser";
	}
}
