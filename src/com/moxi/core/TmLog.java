package com.moxi.core;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import com.moxi.util.TzConstant;


/**
 * 封装 Logger
 * 类名: Log
 * 创建人:lifan 
 * 时间：2017年9月14日 上午11:38:03 
 * @version 1.0.0
 *
 */
public class TmLog {
	private static Map<String,Logger> loggerMap = new HashMap<String,Logger>();

    //自定义logo和方法前缀
    private static final String INFOLOGO = "彩票圈 INFO";
    private static final String DEBUGLOGO = "彩票圈 DEBUG";
    private static final String WARNLOGO = "彩票圈 WARN";
    private static final String ERRORLOGO = "彩票圈 ERROR";
    private static final String INTOMETHOD1 = "进入了 ";
    private static final String INTOMETHOD2 = " 方法 ";
    private static final String OUTMETHOD = " 方法执行完了 ";
    
    //获取debug的log信息
//    public static void debug(Object message){
//        String className = getClassName();
//        Logger log = getLogger(className);
//        if(log.isDebugEnabled()){
//            log.debug(message);
//        }
//    }
//    //获取带logo的debug信息
//    public static void debug(String tag, Object message){
//        String className = getClassName();
//        Logger log = getLogger(className);
//        if(log.isDebugEnabled()){
//            log.debug(new StringBuffer().append("【").append(tag).append("】").append(message).toString());
//        }
//    }
  //进入方法（debug）
    public static void debugInTo(){
        String className = getClassName();
        String methodName = getMethodName();
        Logger log = getLogger(className);
        if(log.isDebugEnabled()){
            log.debug(new StringBuffer().append("【").append(DEBUGLOGO).append("】").append(INTOMETHOD1).append(methodName).append(INTOMETHOD2).toString());
        }
    }
    //执行完方法(debug)
    public static void debugOut(){
        String className = getClassName();
        String methodName = getMethodName();
        Logger log = getLogger(className);
        if(log.isDebugEnabled()){
            log.debug(new StringBuffer().append("【").append(DEBUGLOGO).append("】").append(methodName).append(OUTMETHOD).toString());
        }
    }
    
    //获取info的log信息
    public static void info(Object message){
        String className = getClassName();
        Logger log = getLogger(className);
        if(log.isInfoEnabled()){
        	log.info(new StringBuffer().append("【").append(INFOLOGO).append("】").append(message).toString());
        }
    }
    
    public static void infoUser(Object message,HttpServletRequest request){
    	String username = (String) request.getSession().getAttribute(TzConstant.SESSION_USER_USERNAME);
        String className = getClassName();
        Logger log = getLogger(className);
        if(log.isInfoEnabled()){
        	log.info(new StringBuffer().append("【").append(INFOLOGO).append("】").append(username).append(message).toString());
        }
    }
    //获取带logo的info信息（进入方法）
    
//    public static void info(String tag, Object message){
//        String className = getClassName();
//        String methodName = getMethodName();
//        Logger log = getLogger(className);
//        if(log.isInfoEnabled()){
//            log.info(new StringBuffer().append("【").append(tag).append("】").append(methodName).append(message).toString());
//        }
//    }
    //开始执行方法(info)
    public static void infoInTo(){
        String className = getClassName();
        String methodName = getMethodName();
        Logger log = getLogger(className);
        if(log.isInfoEnabled()){
            log.info(new StringBuffer().append("【").append(INFOLOGO).append("】").append(INTOMETHOD1).append(methodName).append(INTOMETHOD2).toString());
        }
    }
    //执行完方法(info)
    public static void infoOut(){
        String className = getClassName();
        String methodName = getMethodName();
        Logger log = getLogger(className);
        if(log.isInfoEnabled()){
            log.info(new StringBuffer().append("【").append(INFOLOGO).append("】").append(methodName).append(OUTMETHOD).toString());
        }
    }
    
    //获取警告信息
//    public static void warn(Object message){
//        String className = getClassName();
//        Logger log = getLogger(className);
//        log.warn(message);
//    }
//    //获取带logo的警告信息
//    public static void warn(String tag, Object message){
//        String className = getClassName();
//        Logger log = getLogger(className);
//        log.warn(new StringBuffer().append("【").append(tag).append("】").append(message).toString());
//    }
    //警告
    public static void warn(Object message){
        String className = getClassName();
        Logger log = getLogger(className);
        log.warn(new StringBuffer().append("【").append(WARNLOGO).append("】").append(message).toString());
    }
    
    
    //获取错误信息
//    public static void error(Object message){
//        String className = getClassName();
//        Logger log = getLogger(className);
//        log.error(message);
//    }
//    //获取带logo的警告信息
//    public static void error(String tag, Object message){
//        String className = getClassName();
//        Logger log = getLogger(className);
//        log.error(new StringBuffer().append("【").append(tag).append("】").append(message).toString());
//    }
    //警告信息
    public static void error(Object message){
        String className = getClassName();
        Logger log = getLogger(className);
        log.error(new StringBuffer().append("【").append(ERRORLOGO).append("】").append(message).toString());
    }
    
    /**
     * 获取类名
     * @param getClassName
     * @return
     */
    private static String getClassName(){
        Throwable th = new Throwable();
        StackTraceElement[] stes = th.getStackTrace();
        StackTraceElement ste = stes[2];
        return ste.getClassName();
    }
    
    /**
     * 获取方法名
     * @param getClassName
     * @return
     */
    public static String getMethodName(){
    	return Thread.currentThread().getStackTrace()[3].getMethodName();
    }
    
    /**
     * 根据类名获得logger对象
     * @param className
     * @return
     */
    private static Logger getLogger(String className){
        Logger log = null;
        if(loggerMap.containsKey(className)){
            log = loggerMap.get(className);
        }else{
            try {
                log = Logger.getLogger(Class.forName(className));
                loggerMap.put(className, log);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        return log;
    }
}