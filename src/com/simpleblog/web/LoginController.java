package com.simpleblog.web;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.simpleblog.cons.CommonConstant;
import com.simpleblog.dao.User;
import com.simpleblog.dao.UserDao;





/**
 * 
 * <br>
 * <b>类描述:</b>
 * 
 * <pre>
 *   论坛管理，这部分功能由论坛管理员操作，包括：创建论坛版块、指定论坛版块管理员、
 * 用户锁定/解锁。
 * </pre>
 * 
 * @see
 * @since
 */
@Controller
@RequestMapping
public class LoginController {
	/**
//	 * 自动注入
//	 */
	@Autowired
	private UserDao userDao;
	
    /**
     * 用户登陆
     * @param request
     * @param user
     * @return
     */
	@RequestMapping("/dologin")
	public ModelAndView login(HttpServletRequest request, User user) {
		User dbUser = userDao.getUserByUserName(user.getUsername());
		ModelAndView mav = new ModelAndView();
		mav.setViewName("forward:/login.jsp");
		if (dbUser == null) {
			mav.addObject("errorMsg", "用户名不存在");
		} else if (!dbUser.getPassword().equals(user.getPassword())) {
			mav.addObject("errorMsg", "用户密码不正确");
		}  else {
			dbUser.setLastip(request.getRemoteAddr());
			dbUser.setLastvisit(new Date());
			userDao.loginSuccess(dbUser);
//			setSessionUser(request,dbUser);
			//将用户信息保存在Session中
			request.getSession().setAttribute(CommonConstant.USER_CONTEXT,dbUser);
			
			String toUrl = (String)request.getSession().getAttribute(CommonConstant.LOGIN_TO_URL);
			request.getSession().removeAttribute(CommonConstant.LOGIN_TO_URL);
			//如果当前会话中没有保存登录之前的请求URL，则直接跳转到主页
			if(StringUtils.isEmpty(toUrl)){
				toUrl = "/index";
			}
			mav.setViewName("redirect:"+toUrl);
		}
		return mav;
	}

	/**
	 * 登录注销
	 * @param session
	 * @return
	 */
	@RequestMapping("/dologout")
	public String logout(HttpSession session) {
		session.removeAttribute(CommonConstant.USER_CONTEXT);
		return "forward:/index";
	}

}
