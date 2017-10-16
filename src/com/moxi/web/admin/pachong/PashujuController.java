package com.moxi.web.admin.pachong;

import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.moxi.core.JsonResult;
import com.moxi.core.ServiceResult;
import com.moxi.core.StateCodeConstant;
import com.moxi.core.TmLog;
import com.moxi.dao.appcontent.admin.IAppContentMapper;
import com.moxi.dao.appshishicai.admin.IShiShiCaiMapper;
import com.moxi.model.AppContent;
import com.moxi.model.MXParams;
import com.moxi.model.ShiShiCai;
import com.moxi.util.TmGatherContentUtil;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.jsoup.safety.Whitelist;

import com.moxi.util.TzConstant;
import com.moxi.util.TmStringUtils;


@Controller
@RequestMapping("/pashuju")
public class PashujuController {
	
	
	@Autowired
	private IAppContentMapper appContentMapper;
	
	@Autowired
	private IShiShiCaiMapper shiShiCaiMapper;
	
	private final static Whitelist user_content_filter = Whitelist.relaxed(); 
	static {       
		//增加可信标签到白名单        
		user_content_filter.addTags("embed","object","param","span","div");     //增加可信属性    
		user_content_filter.addAttributes(":all", "style", "class", "id", "name");      
		user_content_filter.addAttributes("object", "width", "height","classid","codebase");      
		user_content_filter.addAttributes("param", "name", "value");      
		user_content_filter.addAttributes("embed", "src","quality","width","height","allowFullScreen","allowScriptAccess","flashvars","name","type","pluginspage"); 
	}
	
	/**
	 * 网络爬虫
	 * @throws
	 */
	@RequestMapping("/grab")
	@ResponseBody
	public void incomeContent(MXParams mxParams,HttpServletRequest request){
		TmLog.info("==================开始网络爬虫处理");
		JsonResult jsonResult = new JsonResult();

		mxParams.setGatherUrl("http://caipiaotj.com/");
		//第二步：根据URL获取网页源代码。
		Document document = Jsoup.parse(TmGatherContentUtil.getHtmlResourceByURL(mxParams.getGatherUrl(),"UTF-8"));
		//采集class为list的内容
//		String atitle = document.getElementsByTag("table").html();
		Elements atitle = document.getElementsByTag("table").select("tr").removeAttr("onclick");
		System.out.println(atitle);
		
		Elements atitles = document.getElementsByTag("table").select("tr").removeAttr("id");
		
		System.out.println(atitles);
		System.out.println("========================");
	
		
		Elements atitless1 = document.getElementsByTag("table").select("tr.content > td");
	//	Elements atitless = document.getElementsByTag("table").select("tr").first().children().remove();
		
		System.out.println(atitless1);
		
		Integer typeId= appContentMapper.selectTypeId(0);
		if(typeId >0){
			
			appContentMapper.deleteByPrimaryKey(0);
		}
		AppContent  appContent	=	new AppContent();
		appContent.setContents(atitles.toString());
		appContent.setTypeId(0);
		try {
			appContentMapper.savepachong(appContent);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		TmLog.info("================爬虫处理完成");
	}
	
	
	/**
	 * 网络爬虫
	 * @throws
	 */
	@RequestMapping("/guanjun")
	@ResponseBody
	public void guanjun(MXParams mxParams,HttpServletRequest request){
		TmLog.info("==================开始网络爬虫处理");
		JsonResult jsonResult = new JsonResult();
		mxParams.setGatherUrl("http://caipiaotj.com/index.php/Home/Pk10/pk10?id=1");
		//第二步：根据URL获取网页源代码。
		Document document = Jsoup.parse(TmGatherContentUtil.getHtmlResourceByURL(mxParams.getGatherUrl(),"UTF-8"));
		//采集class为list的内容
//		String atitle = document.getElementsByTag("table").html();
		Elements atitle = document.getElementsByTag("table").select("tr").removeAttr("onclick");
		Elements atitles = document.getElementsByTag("table").select("tr").removeAttr("id");
		
		System.out.println(atitles);
		
		Integer typeId= appContentMapper.selectTypeId(1);
		if(typeId >0){
			
			appContentMapper.deleteByPrimaryKey(1);
		}
		AppContent  appContent	=	new AppContent();
		appContent.setContents(atitles.toString());
		appContent.setTypeId(1);
		try {
			appContentMapper.savepachong(appContent);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		TmLog.info("================爬虫处理完成");
	}
	
	
	/**
	 * 网络爬虫
	 * @throws
	 */
	@RequestMapping("/yajun")
	@ResponseBody
	public void yajun(MXParams mxParams,HttpServletRequest request){
		TmLog.info("==================开始网络爬虫处理");
		JsonResult jsonResult = new JsonResult();
		mxParams.setGatherUrl("http://caipiaotj.com/index.php/Home/Pk10/pk10?id=2");
		//第二步：根据URL获取网页源代码。
		Document document = Jsoup.parse(TmGatherContentUtil.getHtmlResourceByURL(mxParams.getGatherUrl(),"UTF-8"));
		//采集class为list的内容
//		String atitle = document.getElementsByTag("table").html();
//		Elements atitle = document.getElementsByTag("table").select("tr").removeAttr("onclick");
		Elements atitles = document.getElementsByTag("table").select("tr").removeAttr("id");
		
		System.out.println(atitles);
		
		Integer typeId= appContentMapper.selectTypeId(2);
		if(typeId >0){
			
			appContentMapper.deleteByPrimaryKey(2);
		}
		AppContent  appContent	=	new AppContent();
		appContent.setContents(atitles.toString());
		appContent.setTypeId(2);
		try {
			appContentMapper.savepachong(appContent);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		TmLog.info("================爬虫处理完成");
	}
	
	
	
	/**
	 * 网络爬虫  
	 * @throws
	 */
	@RequestMapping("/jijun")
	@ResponseBody
	public void jijun(MXParams mxParams,HttpServletRequest request){
		TmLog.info("==================开始网络爬虫处理");
		JsonResult jsonResult = new JsonResult();
		mxParams.setGatherUrl("http://caipiaotj.com/index.php/Home/Pk10/pk10?id=3");
		//第二步：根据URL获取网页源代码。
		Document document = Jsoup.parse(TmGatherContentUtil.getHtmlResourceByURL(mxParams.getGatherUrl(),"UTF-8"));
		//采集class为list的内容
//		String atitle = document.getElementsByTag("table").html();
//		Elements atitle = document.getElementsByTag("table").select("tr").removeAttr("onclick");
		Elements atitles = document.getElementsByTag("table").select("tr").removeAttr("id");
		
		System.out.println(atitles);
		
		Integer typeId= appContentMapper.selectTypeId(3);
		if(typeId >0){
			
			appContentMapper.deleteByPrimaryKey(3);
		}
		AppContent  appContent	=	new AppContent();
		appContent.setContents(atitles.toString());
		appContent.setTypeId(3);
		try {
			appContentMapper.savepachong(appContent);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		TmLog.info("================爬虫处理完成");
	}
	
	
	/**
	 * 网络爬虫  http://caipiaotj.com/index.php/Home/Pk10/pk10?id=4
	 * @throws
	 */
	@RequestMapping("/fourth")
	@ResponseBody
	public void fourth(MXParams mxParams,HttpServletRequest request){
		TmLog.info("==================开始网络爬虫处理");
		JsonResult jsonResult = new JsonResult();
		mxParams.setGatherUrl("http://caipiaotj.com/index.php/Home/Pk10/pk10?id=4");
		//第二步：根据URL获取网页源代码。
		Document document = Jsoup.parse(TmGatherContentUtil.getHtmlResourceByURL(mxParams.getGatherUrl(),"UTF-8"));
		//采集class为list的内容
//		String atitle = document.getElementsByTag("table").html();
//		Elements atitle = document.getElementsByTag("table").select("tr").removeAttr("onclick");
		Elements atitles = document.getElementsByTag("table").select("tr").removeAttr("id");
		
		System.out.println(atitles);
		
		Integer typeId= appContentMapper.selectTypeId(4);
		if(typeId >0){
			
			appContentMapper.deleteByPrimaryKey(4);
		}
		AppContent  appContent	=	new AppContent();
		appContent.setContents(atitles.toString());
		appContent.setTypeId(4);
		try {
			appContentMapper.savepachong(appContent);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		TmLog.info("================爬虫处理完成");
	}
	
	
	/**
	 * 网络爬虫  
	 * @throws
	 */
	@RequestMapping("/bigandsmall")
	@ResponseBody
	public void bigandsmall(MXParams mxParams,HttpServletRequest request){
		TmLog.info("==================开始网络爬虫处理");
		JsonResult jsonResult = new JsonResult();
		mxParams.setGatherUrl("http://caipiaotj.com/index.php/Home/Pk10/pk10?id=5");
		//第二步：根据URL获取网页源代码。
		Document document = Jsoup.parse(TmGatherContentUtil.getHtmlResourceByURL(mxParams.getGatherUrl(),"UTF-8"));
		//采集class为list的内容
//		String atitle = document.getElementsByTag("table").html();
//		Elements atitle = document.getElementsByTag("table").select("tr").removeAttr("onclick");
		Elements atitles = document.getElementsByTag("table").select("tr").removeAttr("id");
		
		System.out.println(atitles);
		
		Integer typeId= appContentMapper.selectTypeId(5);
		if(typeId >0){
			
			appContentMapper.deleteByPrimaryKey(5);
		}
		AppContent  appContent	=	new AppContent();
		appContent.setContents(atitles.toString());
		appContent.setTypeId(5);
		try {
			appContentMapper.savepachong(appContent);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		TmLog.info("================爬虫处理完成");
	}
	
	
	/**
	 * 网络爬虫  
	 * @throws
	 */
	@RequestMapping("/ceshi")
	@ResponseBody
	public void ceshi(MXParams mxParams,HttpServletRequest request){
		TmLog.info("==================开始网络爬虫处理");
		JsonResult jsonResult = new JsonResult();
		mxParams.setGatherUrl("http://caipiaotj.com/index.php/Home/Ssc/ssc?id=4");
		//第二步：根据URL获取网页源代码。
		Document document = Jsoup.parse(TmGatherContentUtil.getHtmlResourceByURL(mxParams.getGatherUrl(),"UTF-8"));
		//采集class为list的内容
//		String atitle = document.getElementsByTag("table").html();
//		Elements atitle = document.getElementsByTag("table").select("tr").removeAttr("onclick");
		Elements atitles = document.getElementsByTag("table").select("tr").removeAttr("id");
		
		System.out.println(atitles);
		
		Integer typeId= shiShiCaiMapper.selectTypeId(5);
		if(typeId >0){
			
			shiShiCaiMapper.deleteByPrimaryKey(5);
		}
		ShiShiCai  shiShiCai	=	new ShiShiCai();
		shiShiCai.setContents(atitles.toString());
		shiShiCai.setTypeId(5);
		try {
			shiShiCaiMapper.savepachong(shiShiCai);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		TmLog.info("================爬虫处理完成");
	}
	
//	/**
//	 * 取数据的方法
//	 */
//	@ResponseBody
//	@RequestMapping("/getgrab")
//	public JsonResult  getgrab(HttpServletRequest request,HttpServletResponse response){
//		JsonResult  jsonResult = new JsonResult();
//		String typeId = request.getParameter("typeId");
//		AppContent  appContent = appContentMapper.selectType(Integer.parseInt(typeId));
//		jsonResult.setData(appContent);
//		jsonResult.setStateCode(StateCodeConstant.SUCCESS_CODE);
//		return jsonResult;
//		
//	}
//	
	
	
	
	/**
	 * 取数据的方法
	 */
//	@ResponseBody
//	@RequestMapping("/getgrab/{typeId}")
//	public JsonResult  getgrab(@PathVariable("typeId")Integer typeId){
//		JsonResult  jsonResult = new JsonResult();
//		AppContent  appContent = appContentMapper.selectType(typeId);
//		jsonResult.setResult(appContent);
//		jsonResult.setStateCode(StateCodeConstant.SUCCESS_CODE);
//		return jsonResult;
//		
//	}
//	
	@ResponseBody
	@RequestMapping("/getgrab/{typeId}")
	public Object  getgrab(@PathVariable("typeId")Integer typeId,HttpServletRequest request,HttpServletResponse response){
		response.setContentType("text/plain; charset=UTF-8");
		response.addHeader("Access-Control-Allow-Origin", "*");
		Map<String, Object> result = new HashMap<String, Object>();
		AppContent  appContent = appContentMapper.selectType(typeId);
		result.put("result", appContent);
		return result;
		
	}
	
	
	@ResponseBody
	@RequestMapping("/getssc/{typeId}")
	public Object  getssc(@PathVariable("typeId")Integer typeId,HttpServletRequest request,HttpServletResponse response){
		response.setContentType("text/plain; charset=UTF-8");
		response.addHeader("Access-Control-Allow-Origin", "*");
		Map<String, Object> result = new HashMap<String, Object>();
		ShiShiCai  shiShiCai = shiShiCaiMapper.selectType(typeId);
		result.put("result", shiShiCai);
		return result;
		
	}
	


}
