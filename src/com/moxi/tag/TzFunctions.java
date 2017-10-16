package com.moxi.tag;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;

import com.moxi.util.TmStringUtils;
import com.moxi.util.ip.TmIpUtil;

/**
 * 
 * 类名: TzFunctions
 * 创建人:lifan 
 * 时间：2017年7月17日 下午2:40:55 
 * @version 1.0.0
 *
 */
public class TzFunctions {

	
	/**
	 * 格式化日期(date-format)
	 * 方法名: formatDate 
	 * 创建人: lifan 
	 * 时间：2017年7月17日 下午2:41:20
	 * @param @param date
	 * @param @param pattern
	 * @param @return
	 * @return String
	 * @exception
	 * @since 1.0.0
	 * @throws
	 */
	public static String formatDate(Date date,String pattern){
		return TmStringUtils.formatDate(date, pattern);
	}
	
	/**
	 * 字符串日期格式化
	 * 方法名: dateFormat 
	 * 创建人: lifan 
	 * 时间：2017年8月2日 上午10:25:31
	 * @param @param dateString
	 * @param @param format
	 * @param @return
	 * @return String
	 * @exception
	 * @since 1.0.0
	 * @throws
	 */
	public static String dateFormat(String dateString, String format) {
		if (TmStringUtils.isEmpty(dateString))
			return "";
		try {
			Date date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
					.parse(dateString);
			String ds = new SimpleDateFormat(format).format(date);
			return ds;
		} catch (ParseException e) {
			return "";
		}
	}
	/**
	 * 获取一个集合的长度
	 * 方法名: getLength 
	 * 创建人: lifan 
	 * 时间：2017年7月17日 下午2:41:25
	 * @param @param collection
	 * @param @return
	 * @return int
	 * @exception
	 * @since 1.0.0
	 * @throws
	 */
	public static int getLength(Collection collection){
		if(collection!=null){
			return collection.size();
		}else{
			return 0;
		}
	}
	
	/**
	 * 获取日期日期多少时间以前
	 * 方法名: getTimeFormat 
	 * 创建人: lifan 
	 * 时间：2017年7月17日 下午2:41:40
	 * @param @param startTime
	 * @param @return
	 * @return String
	 * @exception
	 * @since 1.0.0
	 * @throws
	 */
	public static String getTimeFormat(Date startTime){
		try{
			long startTimeMills = startTime.getTime();
			long endTimeMills = System.currentTimeMillis();
			long diff = (endTimeMills - startTimeMills)/1000;//秒
			long day_diff  = (long) Math.floor(diff/86400);//天
			StringBuffer buffer = new StringBuffer();
			if(day_diff<0){
				return "[error],时间越界...";
			}else{
				if(day_diff==0 && diff<60){
					if(diff==0)diff=1;
					buffer.append(diff+"秒前");
				}else if(day_diff==0 && diff<120){
					buffer.append("1 分钟前");
				}else if(day_diff==0 && diff<3600){
					buffer.append(Math.round(Math.floor(diff/60))+"分钟前");
				}else if(day_diff==0 && diff<7200){
					buffer.append("1小时前");
				}else if(day_diff==0 && diff<86400){
					buffer.append(Math.round(Math.floor(diff/3600))+"小时前");
				}else if(day_diff==1){
					buffer.append("1天前");
				}else if(day_diff<7){
					buffer.append(day_diff+"天前");
				}else if(day_diff <30){
					buffer.append(Math.round(Math.ceil( day_diff / 7 )) + " 星期前");
				}else if(day_diff >=30 && day_diff<=179 ){
					buffer.append(Math.round(Math.ceil( day_diff / 30 )) + "月前");
				}else if(day_diff >=180 && day_diff<365){
					buffer.append("半年前");
				}else if(day_diff>=365){
					buffer.append(Math.round(Math.ceil( day_diff /30/12))+"年前");
				}
			}
			return buffer.toString();
		}catch(Exception ex){
			return "";
		}
	}
	
	/**
	 * 根据数字获取大写英文
	 * 方法名: getCharacter 
	 * 创建人: lifan 
	 * 时间：2017年7月17日 下午2:42:01
	 * @param @param num
	 * @param @return
	 * @return String
	 * @exception
	 * @since 1.0.0
	 * @throws
	 */
	public static String getCharacter(int num){
		return String.valueOf((char)(64+num));
	}
	
	
	/**
	 * 将数字转换成对应的中文
	 * 方法名: chinesCharacter 
	 * 创建人: lifan 
	 * 时间：2017年7月17日 下午2:42:09
	 * @param @param num
	 * @param @return
	 * @return String
	 * @exception
	 * @since 1.0.0
	 * @throws
	 */
	public static String chinesCharacter(int num){
	    String resultNumber = null;
	    if(num > 10000 || num < 0){
	        return "";
	    }
	    HashMap chnNumbers = new HashMap();
	    chnNumbers.put(0, "零");
	    chnNumbers.put(1, "一");
	    chnNumbers.put(2, "二");
	    chnNumbers.put(3, "三");
	    chnNumbers.put(4, "四");
	    chnNumbers.put(5, "五");
	    chnNumbers.put(6, "六");
	    chnNumbers.put(7, "七");
	    chnNumbers.put(8, "八");
	    chnNumbers.put(9, "九");
	 
	    HashMap unitMap = new HashMap();
	    unitMap.put(1, "");
	    unitMap.put(10, "十");
	    unitMap.put(100, "百");
	    unitMap.put(1000, "千");
	    int[] unitArray = {1000, 100, 10, 1};
	 
	    StringBuilder result = new StringBuilder();
	    int i = 0;
	    while(num > 0){
	        int n1 = num / unitArray[i];
	        if(n1 > 0){
	            result.append(chnNumbers.get(n1)).append(unitMap.get(unitArray[i]));
	        }
	        if(n1 == 0){
	            if(result.lastIndexOf("零") != result.length()-1){
	                result.append("零");
	            }
	        }
	        num = num % unitArray[i++];
	        if(num == 0){
	            break;
	        }
	    }
	    resultNumber = result.toString();
	    if(resultNumber.startsWith("零")){
	        resultNumber = resultNumber.substring(1);
	    }
	    if(resultNumber.startsWith("一十")){
	        resultNumber = resultNumber.substring(1);
	    }
	    return resultNumber;
	}
	
	/**
	 * 金额转人民币
	 * 方法名: getMoney 
	 * 创建人: lifan 
	 * 时间：2017年7月17日 下午2:42:24
	 * @param @param money
	 * @param @return
	 * @return String
	 * @exception
	 * @since 1.0.0
	 * @throws
	 */
	public static String getMoney(Double money){
		Trans2RMB t2r = new Trans2RMB();
		String s = t2r.cleanZero(t2r.splitNum(t2r.roundString(String.valueOf(money))));
		return s;
	}
	
	/**
	 * 获取IP对应的城市信息
	 * 方法名: ipLocation 
	 * 创建人: lifan 
	 * 时间：2017年7月17日 下午2:42:40
	 * @param @param ip
	 * @param @return
	 * @return String
	 * @exception
	 * @since 1.0.0
	 * @throws
	 */
	public static String ipLocation(String ip){
		if(TmStringUtils.isEmpty(ip)){
			return "匿名";
		}
		return TmIpUtil.ipLocation(ip);
	}
	
	/**
	 * index检索方法
	 * 方法名: indexOf 
	 * 创建人: lifan 
	 * 时间：2017年8月17日 下午3:48:21
	 * @param @param content
	 * @param @param filter
	 * @param @return
	 * @return int
	 * @exception
	 * @since 1.0.0
	 * @throws
	 */
	public static int indexOf(String content,String filter){
		if(TmStringUtils.isEmpty(content))return -1;
		return content.indexOf(filter);
	}
	
	
	//主函数测试方法
	public static void main(String[] args) {
		System.out.println(getCharacter(5));
		System.out.println(getMoney(1275.48787d));
	}
}
