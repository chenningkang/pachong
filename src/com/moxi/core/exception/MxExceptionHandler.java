package com.moxi.core.exception;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

public class MxExceptionHandler extends SimpleMappingExceptionResolver{

	@Override
	protected ModelAndView doResolveException(
			javax.servlet.http.HttpServletRequest httpServletRequest,
			javax.servlet.http.HttpServletResponse httpServletResponse,
			java.lang.Object o, java.lang.Exception e) {
		HandlerMethod handlerMethod = (HandlerMethod) o;
		System.out.println("执行类是：==============="+handlerMethod.getBean().getClass().getName());
		System.out.println("执行的方法是：==============="+handlerMethod.getMethod().getName());
		httpServletRequest.setAttribute("ex", e);
		System.out.println("出现的异常是：=================" + o);
		e.printStackTrace();
		return super.doResolveException(httpServletRequest,
				httpServletResponse, o, e);
	}
}
