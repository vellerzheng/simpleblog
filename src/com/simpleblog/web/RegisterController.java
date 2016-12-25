package com.simpleblog.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.simpleblog.cons.CommonConstant;
import com.simpleblog.dao.User;
import com.simpleblog.dao.UserDao;


@Controller
public class RegisterController {

	@Autowired
	private UserDao userDao;


	
	/**
	 * 用户登录
	 * @param request
	 * @param response
	 * @param user
	 * @return
	 */
	@RequestMapping(value = "/doregister", method = RequestMethod.POST)
	public ModelAndView register(HttpServletRequest request,User user){
		ModelAndView view = new ModelAndView();
		view.setViewName("redirect:/index");
		userDao.register(user);
//		try {
//			userDao.register(user);
//		} catch (Exception e) {
//			view.addObject("errorMsg", "用户名已经存在，请换其他名字");
//			view.setViewName("forward:/register.jsp");
//		}
		request.getSession().setAttribute(CommonConstant.USER_CONTEXT,user);
		return view;
	}
}
