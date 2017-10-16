
package com.moxi.core;

import javax.servlet.http.HttpServletRequest;
import static com.moxi.util.TzConstant.*;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.moxi.model.AdminUser;

/**
 * 后台登录拦截
 * 类名: LoginIntercetor
 * 创建人:lifan 
 * 时间：2017年8月2日 下午4:18:53 
 * @version 1.0.0
 *
 */
public class LoginIntercetor implements HandlerInterceptor{

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		AdminUser user =(AdminUser)request.getSession().getAttribute(SESSION_USER);
		if(user!=null){
			return true;
		}else{
			response.sendRedirect(request.getContextPath()+"/login");	
			return false;
		}
	}

	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
	}
	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		
	}

}
