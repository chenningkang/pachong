package com.moxi.util;

public class MoxiConstant {

	/**新用户注册*/
	public static final Integer SCORETYPE1 = 1;
	/**签到一次*/
	public static final Integer SCORETYPE2 = 2;
	/**绑定真实信息*/
	public static final Integer SCORETYPE3 = 3;
	/**收藏购彩信息*/
	public static final Integer SCORETYPE4 = 4;
	/**默认签到次数*/
	public static final Integer DEFAULT_SIGNTIMES = 1;
	
	
	/**不排序*/
	public static final String ALLTOP1 = "userId DESC";
	/**按照奖励积分排序*/
	public static final String WINSCORETOP2 = "awardScore DESC";
	/**按照中奖率排序*/
	public static final String HITLOTTERTOP3 = "hitRate DESC";
	/**按照盈利率排序*/
	public static final String EARNSCORETOP4 = "earnRate DESC";
	/**连红榜*/
	public static final String REDCOUNTTOP5 = "redCount DESC";
	
	/**
	 * 成功
	 */
	public static final String SUCCESS_CODE = "0";

	/**
	 * 错误
	 */
	public static final String ERROR_CODE = "1";

	/**
	 * token过期或丢失
	 */
	public static final String ERROR_CODE_TOKEN = "2";

	/**
	 * 账户不存在
	 */
	public static final String ERROR_CODE_ACCOUNT_NULL = "3";

	/**
	 * 账户或密码错误
	 */
	public static final String ERROR_CODE_ACCOUNT_PWD = "4";

	/**
	 * 账户非正常状态
	 */
	public static final String ERROR_CODE_ACCOUNT_STATE = "5";

	/**
	 * 账号已经存在
	 */
	public static final String ERROR_CODE_HAVE = "6";

	/**
	 * 参数为空
	 */
	public static final String ERROR_CODE_PARAM_NULL = "7";

	/**
	 * 删除失败
	 */
	public static final String ERROR_CODE_DEL = "8";

	/**
	 * 账户或密码错误（AD域）
	 */
	public static final String ERROR_CODE_ACCOUNT_PWD_AD = "9";

	/**
	 * 权限发生更改
	 */
	public static final String ERROR_CODE_POWER_UPDATE = "10";

	/**
	 * 强制登录
	 */
	public static final String ERROR_CODE_LOGIN = "11";

	/**
	 * 验证码错误
	 */
	public static final String ERROR_CODE_NULL = "12";
	/**
	 * 操作失败
	 */
	public static final String ERROR_OPTION_FAIL = "13";
	/**
	 * 用户名已存在
	 */
	public static final String ERROR_CODE_EXIST = "14";
	/**
	 * 用户名不存在
	 */
	public static final String ERROR_CODE_NO_EXIST = "15";
	/**
	 * 暂无内容
	 */
	public static final String ERROR_CODE_NO_CONTENT = "16";
	
}
