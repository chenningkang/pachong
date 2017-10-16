package com.moxi.core;

/**
 * @Description: (系统状态码)
 * @Author: lgl(lgl1012dream@foxmail.com)
 * @date:2016年12月1日 上午11:59:15
 * @Version:1.0
 */
public class StateCodeConstant {

	/**
	 * 成功
	 */
	public static final String SUCCESS_CODE = "1000";

	/**
	 * 错误
	 */
	public static final String ERROR_CODE = "1001";

	/**
	 * token过期或丢失
	 */
	public static final String ERROR_CODE_TOKEN = "1002";

	/**
	 * 账户不存在
	 */
	public static final String ERROR_CODE_ACCOUNT_NULL = "1003";

	/**
	 * 账户或密码错误
	 */
	public static final String ERROR_CODE_ACCOUNT_PWD = "1004";

	/**
	 * 账户非正常状态
	 */
	public static final String ERROR_CODE_ACCOUNT_STATE = "1005";

	/**
	 * 已经存在
	 */
	public static final String ERROR_CODE_HAVE = "1006";

	/**
	 * 参数为空
	 */
	public static final String ERROR_CODE_PARAM_NULL = "1007";

	/**
	 * 删除失败
	 */
	public static final String ERROR_CODE_DEL = "1008";

	/**
	 * 账户或密码错误（AD域）
	 */
	public static final String ERROR_CODE_ACCOUNT_PWD_AD = "1009";

	/**
	 * 权限发生更改
	 */
	public static final String ERROR_CODE_POWER_UPDATE = "1010";

	/**
	 * 强制登录
	 */
	public static final String ERROR_CODE_LOGIN = "1011";

	/**
	 * 验证码错误
	 */
	public static final String ERROR_CODE_NULL = "1012";
	
	/**
	 * 已有上架app(,添加app的时候用到,数据库中只能有一个上架app)
	 */
	public static final String ERROR_CODE_HAVE_APP = "1013";
	
	/**
	 * 已经有上架app(修改app的fileState 时候用到,数据库中只能有一个上架app)
	 */
	public static final String ERROR_CODE_HAVE_UPDATE ="1014";
	
	/*
	 * 修改视频名字和宣传册名字时,没有输入直接点击修改按钮了.
	 */
	public static final String  ERROR_CODE_UPDATE_NAME ="1015";
	
	/*
	 * 表示没有上架的app
	 */
	public static final String ERROR_CODE_NOT_APP ="1016";

}
