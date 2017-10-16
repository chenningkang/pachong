package com.moxi.core;

import javax.servlet.ServletContext;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.ServletContextAware;

import com.moxi.util.TmStringUtils;

/**
 * 全路径配置
 * 类名: BasePathExpsoer
 * 创建人:lifan 
 * 时间：2017年8月2日 下午4:19:50 
 * @version 1.0.0
 *
 */
public class BasePathExpsoer  implements ServletContextAware{

	private ServletContext application;
	private ApplicationContext context;

	private String rootPath;
	public void init(){
		if(TmStringUtils.isEmpty(rootPath)){
			rootPath = application.getContextPath();
		}
		application.setAttribute("rootPath", rootPath);//项目根目录
		application.setAttribute("resPath", rootPath+"/resources");//资源文件的根目录
	}
	
	@Override
	public void setServletContext(ServletContext application) {
		this.application = application;
	}

	public void setRootPath(String rootPath) {
		this.rootPath = rootPath;
	}
	
}
