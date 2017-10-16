 package com.moxi.util;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.Random;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.moxi.model.LotteryPojo;

import net.sf.json.JSONObject;
import sun.misc.BASE64Decoder;

public class Utils {
	
	//资源文件的位置
	private static String fileName="service.properties";
	
	/**
	 * 把当前系统时间转换为Timestamp类型
	 * 方法名: getTimestampTime 
	 * 创建人: lifan 
	 * 时间：2017年8月30日 上午9:57:33
	 * @param @return
	 * @return Timestamp
	 * @exception
	 * @since 1.0.0
	 * @throws
	 */
	public static Timestamp getTimestampTime(){
		Timestamp time = new Timestamp(System.currentTimeMillis());
		return time;
	}

	/**
	 * 把Timestamp类型转换为string
	 * 方法名: getStrTime 
	 * 创建人: lifan 
	 * 时间：2017年8月30日 上午9:58:01
	 * @param @param time
	 * @param @return
	 * @return String
	 * @exception
	 * @since 1.0.0
	 * @throws
	 */
	public static String getStrTime(Timestamp time) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String strtime = dateFormat.format(time);
		return strtime;
	}
	
	/**
	 * 把Timestamp类型的时间转换为string类型的年月日时分秒
	 * 方法名: getFilePath 
	 * 创建人: lifan 
	 * 时间：2017年8月30日 上午10:00:58
	 * @param @param time
	 * @param @return
	 * @return String
	 * @exception
	 * @since 1.0.0
	 * @throws
	 */
	public static String getFilePath(Timestamp time) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
		String strtime = dateFormat.format(time);
		return strtime;
	}
	
	/**
	 * Timestamp转换为string类型的年月日
	 * 方法名: getStrTimeBySign 
	 * 创建人: lifan 
	 * 时间：2017年8月30日 上午10:01:36
	 * @param @param time
	 * @param @return
	 * @return String
	 * @exception
	 * @since 1.0.0
	 * @throws
	 */
	public static String getStrTimeBySign(Timestamp time) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String strtime = dateFormat.format(time);
		return strtime;
	}
	
	/**
	 * 把string类型转换为Timestamp
	 * 方法名: changeStrTimeToTimeStamp 
	 * 创建人: lifan 
	 * 时间：2017年8月30日 上午10:02:17
	 * @param @param strtime
	 * @param @return
	 * @param @throws ParseException
	 * @return Timestamp
	 * @exception
	 * @since 1.0.0
	 * @throws
	 */
    public static Timestamp changeStrTimeToTimeStamp(String strtime) throws ParseException{
		Timestamp time=Timestamp.valueOf(strtime);
		return time;
	}
	
	public static String writeFile(CommonsMultipartFile file) throws IOException{
	    //用来检测程序运行时间
        long  startTime=System.currentTimeMillis();
        //System.out.println("fileName："+file.getOriginalFilename());
        String newFilePath="E:/"+new Date(startTime).getTime()+file.getOriginalFilename();
        try {
            //获取输出流
            OutputStream os=new FileOutputStream(newFilePath);
            //获取输入流 CommonsMultipartFile 中可以直接得到文件的流
            InputStream is=file.getInputStream();
            int temp;
            //一个一个字节的读取并写入
            while((temp=is.read())!=(-1))
            {
                os.write(temp);
            }
           os.flush();
           os.close();
           is.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        long  endTime=System.currentTimeMillis();
        //System.out.println("方法一的运行时间："+String.valueOf(endTime-startTime)+"ms");
		return newFilePath;
	}
	
	/**
	 * 生成0-9的随机数（四位验证码）
	 * 方法名: createRandomNumber 
	 * 创建人: lifan 
	 * 时间：2017年8月30日 上午10:06:44
	 * @param @return
	 * @return StringBuilder
	 * @exception
	 * @since 1.0.0
	 * @throws
	 */
	public static StringBuilder createRandomNumber(){
		String str="0123456789";
		StringBuilder sb=new StringBuilder(4);
		for(int i=0;i<4;i++)
		{
			char ch=str.charAt(new Random().nextInt(str.length()));
			sb.append(ch);
		}
		return sb;
	}

	/**
	 * 读取资源文件（传入的是资源文件的地址）
	 * 方法名: readProperryFile 
	 * 创建人: lifan 
	 * 时间：2017年8月30日 上午10:07:35
	 * @param @param key 
	 * @param @return
	 * @return String
	 * @exception
	 * @since 1.0.0
	 * @throws
	 */
    public static String  readProperryFile(String key){
      String value="";
  	  Properties prop = new Properties(); 
      try{
         //读取属性文件a.properties
         InputStream in = SendMassageUtil.class.getClassLoader().getResourceAsStream(fileName);  
         prop.load(in);//加载属性列表
         value = prop.getProperty(key); 
         //保存属性到b.properties文件
         FileOutputStream oFile = new FileOutputStream("b.properties", true);//true表示追加打开
         oFile.close();
      }
      catch(Exception e){
         e.printStackTrace();
      }
    	return value;
    }
    
	/**
	 * 截取开奖信息方法
	 * 方法名: manipulation 
	 * 创建人: lifan 
	 * 时间：2017年8月30日 上午9:32:00
	 * @param @param content
	 * @param @param shaungseqiu
	 * @param @param size
	 * @param @return
	 * @return List<LotteryPojo>
	 * @exception
	 * @since 1.0.0
	 * @throws
	 */
	public static List<LotteryPojo> manipulation(String content,String shaungseqiu,int size){
		//拿到内容的长度
	    int countlength=content.toString().length()-1;
		content=content.substring(1, countlength);
		String str_content="";
		//实例化一个list用来存储彩票开奖信息
		List<LotteryPojo> list= new ArrayList<LotteryPojo>();
		//循环内容
		for(int i=0;i<size;i++){
			LotteryPojo pojo= new LotteryPojo();
			if(i==0){
				str_content=content;
				String qihao = str_content.substring(0,str_content.indexOf(":"));
				String line = content.substring(str_content.indexOf(":")+1,str_content.indexOf("}")+1);
				str_content = str_content.substring(str_content.indexOf("}")+1,str_content.length());
			    JSONObject obj = JSONObject.fromObject(line);
			    pojo = (LotteryPojo)JSONObject.toBean(obj, LotteryPojo.class);
			    pojo.setType(shaungseqiu);
				pojo.setQihao(qihao.substring(1,qihao.length()-1));
				pojo.setSysCreateTime(Utils.getTimestampTime());
			    list.add(pojo);
			}else{
				String qihao=str_content.substring(1,str_content.indexOf(":"));
				String line=str_content.substring(str_content.indexOf(":")+1,str_content.indexOf("}")+1);
				str_content=str_content.substring(str_content.indexOf("}")+1,str_content.length());
			    JSONObject obj = JSONObject.fromObject(line);
			    pojo = (LotteryPojo)JSONObject.toBean(obj, LotteryPojo.class);
			    pojo.setType(shaungseqiu);
				pojo.setQihao(qihao.substring(1,qihao.length()-1));
				pojo.setSysCreateTime(Utils.getTimestampTime());
			    list.add(pojo);
			}
		}
		return list;
	}
	
	/**
	 * 把string时间转换为date类型
	 * 方法名: getDate 
	 * 创建人: lifan 
	 * 时间：2017年8月30日 上午9:33:51
	 * @param @param strTime
	 * @param @return
	 * @return Date
	 * @exception
	 * @since 1.0.0
	 * @throws
	 */
	public static Date getDate(String strTime) {
		Date date = null;
		SimpleDateFormat sdf = new SimpleDateFormat("YYYY-mm-dd HH:MM:SS");
		try {
			date = sdf.parse(strTime);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return (Date) date;
	}
	
	/**
	 * 把string类型的时间转化为Timestamp类型
	 * 方法名: syscreateTimeChange 
	 * 创建人: lifan 
	 * 时间：2017年8月30日 上午9:35:05
	 * @param @param time
	 * @param @return
	 * @return Timestamp
	 * @exception
	 * @since 1.0.0
	 * @throws
	 */
	public static Timestamp syscreateTimeChange(String time) {
		Timestamp ts = Timestamp.valueOf(time);
		return ts;
	}
	
	/**
	 * 通过时间生成订单id
	 * 方法名: getorderID 
	 * 创建人: lifan 
	 * 时间：2017年8月30日 上午9:34:33
	 * @param @return
	 * @return String
	 * @exception
	 * @since 1.0.0
	 * @throws
	 */
	public static String getorderID() {
		Timestamp time = new Timestamp(System.currentTimeMillis());
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
		String strtime = dateFormat.format(time);
		return strtime;
	}
	
	/**
	 * 随机生成指定数量的1-31内的字符串，逗号隔开
	 * 方法名: randomLine 
	 * 创建人: lifan 
	 * 时间：2017年8月30日 上午9:36:23
	 * @param @param size
	 * @param @return
	 * @return String
	 * @exception
	 * @since 1.0.0
	 * @throws
	 */
	public static String randomLine(int size) {
		int max = 31;
		int min = 1;
		Random random = new Random();
		StringBuilder randimLine = new StringBuilder();
		for (int i = 0; i < size; i++) {
			int s = random.nextInt(max) % (max - min + 1) + min;
			randimLine.append(s);
			randimLine.append(",");
		}
		return randimLine.substring(0, randimLine.length() - 1);
	}
    
    
	public static boolean sendImg(String imgStr, String path) {
		BASE64Decoder decoder = new BASE64Decoder();
		try {
			// 解密
			byte[] b = decoder.decodeBuffer(imgStr);

			// 处理数据
			for (int i = 0; i < b.length; ++i) {
				if (b[i] < 0) {
					b[i] += 256;
				}
			}
			OutputStream out = new FileOutputStream(path);
			out.write(b);
			out.flush();
			out.close();
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	/**
	 * 格式化时间
	 * 方法名: formateDate 
	 * 创建人: lifan 
	 * 时间：2017年8月30日 上午9:55:48
	 * @param @param date
	 * @param @param format
	 * @param @return
	 * @return String
	 * @exception
	 * @since 1.0.0
	 * @throws
	 */
	public static String formateDate(Date date, String format) {
		if (date == null)
			return "";
		String ds = new SimpleDateFormat(format).format(date);
		return ds;
	}
	
	/**
	 * 判断字符串是否为空
	 * 方法名: isEmpty 
	 * 创建人: lifan 
	 * 时间：2017年8月30日 上午9:55:58
	 * @param @param str
	 * @param @return
	 * @return boolean
	 * @exception
	 * @since 1.0.0
	 * @throws
	 */
	public static boolean isEmpty(String str) {
		return null == str || str.length() == 0 || "".equals(str)
				|| str.matches("\\s*");
	}
	
	/**
	 * 判断字符串是否为非空
	 * 方法名: isNotEmpty 
	 * 创建人: lifan 
	 * 时间：2017年8月30日 上午9:56:10
	 * @param @param str
	 * @param @return
	 * @return boolean
	 * @exception
	 * @since 1.0.0
	 * @throws
	 */
	public static boolean isNotEmpty(String str) {
		return !isEmpty(str);
	}
	
	/**
	 * 模拟浏览器get请求
	 * 方法名: get 
	 * 创建人: lifan 
	 * 时间：2017年8月15日 上午9:35:17
	 * @param @param urlAll
	 * @param @param charset
	 * @param @return
	 * @return String
	 * @exception
	 * @since 1.0.0
	 * @throws
	 */
	public static String get(String urlAll, String charset) {
		BufferedReader reader = null;
		String result = null;
		StringBuffer sbf = new StringBuffer();
		String userAgent = "Mozilla/5.0 (Windows NT 6.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/29.0.1547.66 Safari/537.36";// 模拟浏览器
		try {
			URL url = new URL(urlAll);
			HttpURLConnection connection = (HttpURLConnection) url
					.openConnection();
			connection.setRequestMethod("GET");
			connection.setReadTimeout(30000);
			connection.setConnectTimeout(30000);
			connection.setRequestProperty("User-agent", userAgent);
			connection.connect();
			InputStream is = connection.getInputStream();
			reader = new BufferedReader(new InputStreamReader(is, charset));
			String strRead = null;
			while ((strRead = reader.readLine()) != null) {
				sbf.append(strRead);
				sbf.append("\r\n");
			}
			reader.close();
			result = sbf.toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	//ceshi
	public static void main(String[] args) {
//		System.out.println(randomLine(20));
//		System.out.println(getTimestampTime());
		System.out.println(getFilePath(new Timestamp(System.currentTimeMillis())));
	}
	
}
