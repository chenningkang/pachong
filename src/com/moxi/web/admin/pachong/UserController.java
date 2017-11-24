package com.moxi.web.admin.pachong;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.moxi.core.JsonResult;
import com.moxi.dao.user.WcbUserMapper;
import com.moxi.model.WcbUser;
import com.moxi.util.HttpRequest;
import com.moxi.util.MoxiConstant;
import com.moxi.util.TmStringUtils;


@Controller
@RequestMapping("/user")
public class UserController extends MoxiConstant {
	
	@Autowired
	private WcbUserMapper wcbUserMapper;
	
	
	/**
	 * 
	 * 注册接口
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 */
	@ResponseBody
	@RequestMapping("/register")
	public Object register(HttpServletRequest request,HttpServletResponse response)throws  IOException {
		
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/plain; charset=UTF-8");
		response.addHeader("Access-Control-Allow-Origin", "*");
		Map<String, Object> result = new HashMap<String, Object>();
		// 手机号码
		String phone = request.getParameter("phone");
		// 用户名
		String username = request.getParameter("username");
		// 用户密码
		String password = request.getParameter("password");
		
				//验证手机号是否已经注册过
				WcbUser wcbUser = wcbUserMapper.checkUserPhone(phone);
				if (wcbUser != null) {
					result.put("message", "该手机号码已经注册");
					result.put("errorcode", ERROR_CODE_HAVE);
					return result;
				}
				
				//密码加密
				String MD5userpwd = TmStringUtils.md5Base64(password);
				Date datas=new Date();
				//开始保存用户信息
				WcbUser user = new WcbUser();
				user.setPhone(phone);
				user.setUsername(username);
				user.setPassword(MD5userpwd);
				user.setCreatTime(datas);
				// 存储用户数据
				wcbUserMapper.insertSelective(user);		
				//把需要返回的信息放入到map中
				HashMap<String, Object> resMap = new HashMap<String, Object>();
				resMap.put("username", username);
				result.put("result", resMap);
				result.put("message", "注册成功");
				result.put("errorcode", SUCCESS_CODE);
				
		        return result;
	}

	
	/**
	 * 
	 * 登陆接口
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/login")
	public Object login(HttpServletRequest request,HttpServletResponse response) throws  IOException{
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/plain; charset=UTF-8");
		response.addHeader("Access-Control-Allow-Origin", "*");
		
		Map<String, Object> result = new HashMap<String, Object>();
		String phone = request.getParameter("phone");
		String password = request.getParameter("password");
		
		
			if (TmStringUtils.isNotEmpty(phone) && TmStringUtils.isNotEmpty(password)) {
				//密码加密
				password = TmStringUtils.md5Base64(password);
				//登录查询
				WcbUser wcbUser = wcbUserMapper.getLogin(phone, password);
				
				//用户不存在
				if (wcbUser == null) {
					result.put("result", "");
					result.put("message", "手机号码或密码不正确");
					result.put("errorcode", ERROR_CODE_ACCOUNT_PWD_AD);
					return result;
				}
				//有该用户，然后就返回该用户的一些信息
				result.put("result", "");
				result.put("message", "登陆成功");
				result.put("errorcode", SUCCESS_CODE);
				return result;

	   }
			return result;
    
 }
	
	/**
	 * 查询用户是否注册
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 */
	@ResponseBody
	@RequestMapping("/select")
	public Object select(HttpServletRequest request,HttpServletResponse response)throws  IOException{
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/plain; charset=UTF-8");
		response.addHeader("Access-Control-Allow-Origin", "*");
		
		Map<String, Object> result = new HashMap<String, Object>();
		// 手机号码
		String phone = request.getParameter("phone");
		
		//验证手机号是否已经注册过
		WcbUser wcbUser = wcbUserMapper.checkUserPhone(phone);
		if (wcbUser != null) {
			result.put("message", "数据库里面有这个手机号");
			result.put("errorcode", ERROR_CODE_HAVE);
			return result;
		}
		
			//这个手机号码还没有注册
			result.put("message", "该手机号还没有注册");
			result.put("errorcode", ERROR_CODE_ACCOUNT_PWD);
			return result;
	}
	
	
	/**
	 * 
	 * (忘记密码)修改密码
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/forgetPwd")
	public Object updateUserPwd(HttpServletRequest request,
			HttpServletResponse response) throws IOException {

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/plain; charset=UTF-8");
		response.addHeader("Access-Control-Allow-Origin", "*");

		Map<String, Object> result = new HashMap<String, Object>();

		// String strTime = request.getParameter("strTime");// 验证码生成时间
		String phone = request.getParameter("phone");// 手机号码
		String password = request.getParameter("password");// 用户新密码

		WcbUser wcbUser = new WcbUser();

		// 拿到新密码,然后加密
		String newPassword = TmStringUtils.md5Base64(password);
		wcbUser.setPhone(phone);
		wcbUser.setUpdateTime(new Date());
		wcbUser.setPassword(newPassword);
		// 修改用户密码
		wcbUserMapper.updateUserPassword(wcbUser);
		HashMap<String, Object> pwdMap = new HashMap<String, Object>();
		pwdMap.put("pwdFlg", "1");
		// 密码清空
		result.put("result", pwdMap);
		result.put("message", "密码重置成功");
		result.put("errorcode", SUCCESS_CODE);

		return result;
	}
	
	
	/**
	 * 
	 * 查询所有的用户
	 * 
	 */
	@ResponseBody
	@RequestMapping("/alluser")
	public JsonResult allUser(HttpServletRequest request,HttpServletResponse response){
		response.setContentType("text/plain; charset=UTF-8");
		response.addHeader("Access-Control-Allow-Origin", "*");
		JsonResult jsonResult = new JsonResult();
		WcbUser wcbUser = new WcbUser();
		
		List<WcbUser> list= wcbUserMapper.allUser();
		jsonResult.setData(list);
		return jsonResult;

	}
	
	
		
	
}
