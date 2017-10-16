package com.moxi.web.admin.pachong;



import javax.servlet.http.HttpServletRequest;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.moxi.core.JsonResult;
import com.moxi.core.TmLog;
import com.moxi.dao.appcontent.admin.IAppContentMapper;
import com.moxi.dao.appshishicai.admin.IShiShiCaiMapper;
import com.moxi.model.AppContent;
import com.moxi.model.ShiShiCai;
import com.moxi.model.LotteryPojo;
import com.moxi.model.MXParams;
import com.moxi.util.SendMassageUtil;
import com.moxi.util.TmGatherContentUtil;
import com.moxi.util.Utils;

@Component
public class PachongCreate {
	
	@Autowired
	private IShiShiCaiMapper shiShiCaiMapper;
	
	@Autowired
	private IAppContentMapper appContentMapper;
	
	
	
	/**
	 * 网络爬虫
	 * @throws
	 */
	@Scheduled(cron = "0 0 10,14 * * ?")   //每天上午11.15准时抓取数据。（方法里面不能携带任何的参数。） 0 0 10,14 * * ? 每天上午10点，下午2点，
	public void incomeContent(){
		TmLog.info("==================开始网络爬虫处理");
		JsonResult jsonResult = new JsonResult();
		//第二步：根据URL获取网页源代码。
		Document document = Jsoup.parse(TmGatherContentUtil.getHtmlResourceByURL("http://caipiaotj.com/","UTF-8"));
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
	@Scheduled(cron = "0 10 10,14 * * ?")   //每天上午11.15准时抓取数据。（方法里面不能携带任何的参数。） 0 0 10,14 * * ? 每天上午10点，下午2点，
	public void guanjun(){
		TmLog.info("==================开始网络爬虫处理");
		JsonResult jsonResult = new JsonResult();
		//第二步：根据URL获取网页源代码。
		Document document = Jsoup.parse(TmGatherContentUtil.getHtmlResourceByURL("http://caipiaotj.com/index.php/Home/Pk10/pk10?id=1","UTF-8"));
		//采集class为list的内容
//		String atitle = document.getElementsByTag("table").html();
		Elements atitle = document.getElementsByTag("table").select("tr").removeAttr("onclick");
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
	@Scheduled(cron = "0 20 10,14 * * ?")   //每天上午11.15准时抓取数据。（方法里面不能携带任何的参数。） 0 0 10,14 * * ? 每天上午10点，下午2点，
	public void yajun(){
		TmLog.info("==================开始网络爬虫处理");
		JsonResult jsonResult = new JsonResult();
		//第二步：根据URL获取网页源代码。
		Document document = Jsoup.parse(TmGatherContentUtil.getHtmlResourceByURL("http://caipiaotj.com/index.php/Home/Pk10/pk10?id=2","UTF-8"));
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
	 * 网络爬虫  
	 * @throws
	 */
	@Scheduled(cron = "0 30 10,14 * * ?")   //每天上午11.15准时抓取数据。（方法里面不能携带任何的参数。） 0 0 10,14 * * ? 每天上午10点，下午2点，
	public void jijun(){
		TmLog.info("==================开始网络爬虫处理");
		JsonResult jsonResult = new JsonResult();
		//第二步：根据URL获取网页源代码。
		Document document = Jsoup.parse(TmGatherContentUtil.getHtmlResourceByURL("http://caipiaotj.com/index.php/Home/Pk10/pk10?id=3","UTF-8"));
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
	 * 网络爬虫  http://caipiaotj.com/index.php/Home/Pk10/pk10?id=4
	 * @throws
	 */
	@Scheduled(cron = "0 40 10,14 * * ?")   //每天上午11.15准时抓取数据。（方法里面不能携带任何的参数。） 0 0 10,14 * * ? 每天上午10点，下午2点，
	public void fourth(){
		TmLog.info("==================开始网络爬虫处理");
		JsonResult jsonResult = new JsonResult();
		//第二步：根据URL获取网页源代码。
		Document document = Jsoup.parse(TmGatherContentUtil.getHtmlResourceByURL("http://caipiaotj.com/index.php/Home/Pk10/pk10?id=4","UTF-8"));
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
	@Scheduled(cron = "0 50 10,14 * * ?")   //每天上午11.15准时抓取数据。（方法里面不能携带任何的参数。） 0 0 10,14 * * ? 每天上午10点，下午2点，
	public void bigandsmall(){
		TmLog.info("==================开始网络爬虫处理");
		JsonResult jsonResult = new JsonResult();
		//第二步：根据URL获取网页源代码。
		Document document = Jsoup.parse(TmGatherContentUtil.getHtmlResourceByURL("http://caipiaotj.com/index.php/Home/Pk10/pk10?id=5","UTF-8"));
		//采集class为list的内容
//		String atitle = document.getElementsByTag("table").html();
//		Elements atitle = document.getElementsByTag("table").select("tr").removeAttr("onclick");
		Elements atitles = document.getElementsByTag("table").select("tr").removeAttr("id");
		
		System.out.println(atitles);
		
		Integer typeId= appContentMapper.selectTypeId(6);
		if(typeId >0){
			
			appContentMapper.deleteByPrimaryKey(6);
		}
		AppContent  appContent	=	new AppContent();
		appContent.setContents(atitles.toString());
		appContent.setTypeId(6);
		try {
			appContentMapper.savepachong(appContent);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		TmLog.info("================爬虫处理完成");
	}
	
	
	// ====================================================================================================================================
	

	/**
	 * 网络爬虫
	 * @throws
	 */
	@Scheduled(cron = "0 0 11,15 * * ?")   //每天上午11.15准时抓取数据。（方法里面不能携带任何的参数。） 0 0 10,14 * * ? 每天上午11点，下午3点，
	public void Survey(){
		TmLog.info("==================开始网络爬虫处理");
		JsonResult jsonResult = new JsonResult();
		//第二步：根据URL获取网页源代码。
		Document document = Jsoup.parse(TmGatherContentUtil.getHtmlResourceByURL("http://caipiaotj.com/index.php/Home/Ssc/index","UTF-8"));
		//采集class为list的内容
//		String atitle = document.getElementsByTag("table").html();
		Elements atitle = document.getElementsByTag("table").select("tr").removeAttr("onclick");
		Elements atitles = document.getElementsByTag("table").select("tr").removeAttr("id");
		
		System.out.println(atitles);
		Integer typeId= shiShiCaiMapper.selectTypeId(1);
		if(typeId >0){
			
			shiShiCaiMapper.deleteByPrimaryKey(1);
		}
		ShiShiCai  shiShiCai	=	new ShiShiCai();
		shiShiCai.setContents(atitles.toString());
		shiShiCai.setTypeId(1);
		try {
			shiShiCaiMapper.savepachong(shiShiCai);
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
	@Scheduled(cron = "0 10 11,15 * * ?")   //每天上午11.15准时抓取数据。（方法里面不能携带任何的参数。） 0 0 10,14 * * ? 每天上午11点，下午3点，
	public void danshuang(){
		TmLog.info("==================开始网络爬虫处理");
		JsonResult jsonResult = new JsonResult();
		//第二步：根据URL获取网页源代码。
		Document document = Jsoup.parse(TmGatherContentUtil.getHtmlResourceByURL("http://caipiaotj.com/index.php/Home/Ssc/ssc?id=1","UTF-8"));
		//采集class为list的内容
//		String atitle = document.getElementsByTag("table").html();
		Elements atitle = document.getElementsByTag("table").select("tr").removeAttr("onclick");
		Elements atitles = document.getElementsByTag("table").select("tr").removeAttr("id");
		
		System.out.println(atitles);
		
		Integer typeId= shiShiCaiMapper.selectTypeId(2);
		if(typeId >0){
			
			shiShiCaiMapper.deleteByPrimaryKey(2);
		}
		ShiShiCai  shiShiCai	=	new ShiShiCai();
		shiShiCai.setContents(atitles.toString());
		shiShiCai.setTypeId(2);
		try {
			shiShiCaiMapper.savepachong(shiShiCai);
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
	@Scheduled(cron = "0 20 11,15 * * ?")   //每天上午11.15准时抓取数据。（方法里面不能携带任何的参数。） 0 0 10,14 * * ? 每天上午11点，下午3点，
	public void daxiao(){
		TmLog.info("==================开始网络爬虫处理");
		JsonResult jsonResult = new JsonResult();
		//第二步：根据URL获取网页源代码。
		Document document = Jsoup.parse(TmGatherContentUtil.getHtmlResourceByURL("http://caipiaotj.com/index.php/Home/Ssc/ssc?id=2","UTF-8"));
		//采集class为list的内容
//		String atitle = document.getElementsByTag("table").html();
		Elements atitle = document.getElementsByTag("table").select("tr").removeAttr("onclick");
		Elements atitles = document.getElementsByTag("table").select("tr").removeAttr("id");
		
		System.out.println(atitles);
		
		Integer typeId= shiShiCaiMapper.selectTypeId(3);
		if(typeId >0){
			
			shiShiCaiMapper.deleteByPrimaryKey(3);
		}
		ShiShiCai  shiShiCai	=	new ShiShiCai();
		shiShiCai.setContents(atitles.toString());
		shiShiCai.setTypeId(3);
		try {
			shiShiCaiMapper.savepachong(shiShiCai);
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
	@Scheduled(cron = "0 30 11,15 * * ?")   //每天上午11.15准时抓取数据。（方法里面不能携带任何的参数。） 0 0 10,14 * * ? 每天上午11点，下午3点，
	public void longhu(){
		TmLog.info("==================开始网络爬虫处理");
		JsonResult jsonResult = new JsonResult();
		//第二步：根据URL获取网页源代码。
		Document document = Jsoup.parse(TmGatherContentUtil.getHtmlResourceByURL("http://caipiaotj.com/index.php/Home/Ssc/ssc?id=3","UTF-8"));
		//采集class为list的内容
//		String atitle = document.getElementsByTag("table").html();
		Elements atitle = document.getElementsByTag("table").select("tr").removeAttr("onclick");
		Elements atitles = document.getElementsByTag("table").select("tr").removeAttr("id");
		
		System.out.println(atitles);
		
		Integer typeId= shiShiCaiMapper.selectTypeId(4);
		if(typeId >0){
			
			shiShiCaiMapper.deleteByPrimaryKey(4);
		}
		ShiShiCai  shiShiCai	=	new ShiShiCai();
		shiShiCai.setContents(atitles.toString());
		shiShiCai.setTypeId(4);
		try {
			shiShiCaiMapper.savepachong(shiShiCai);
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
	@Scheduled(cron = "0 40 11,15 * * ?")   //每天上午11.15准时抓取数据。（方法里面不能携带任何的参数。） 0 0 10,14 * * ? 每天上午11点，下午3点，
	public void houerzuxian(){
		TmLog.info("==================开始网络爬虫处理");
		JsonResult jsonResult = new JsonResult();
		//第二步：根据URL获取网页源代码。
		Document document = Jsoup.parse(TmGatherContentUtil.getHtmlResourceByURL("http://caipiaotj.com/index.php/Home/Ssc/ssc?id=4","UTF-8"));
		//采集class为list的内容
//		String atitle = document.getElementsByTag("table").html();
		Elements atitle = document.getElementsByTag("table").select("tr").removeAttr("onclick");
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
	
	
	/**
	 * 网络爬虫
	 * @throws
	 */
	@Scheduled(cron = "0 50 11,15 * * ?")   //每天上午11.15准时抓取数据。（方法里面不能携带任何的参数。） 0 0 10,14 * * ? 每天上午11点，下午3点，
	public void housanzuxian(){
		TmLog.info("==================开始网络爬虫处理");
		JsonResult jsonResult = new JsonResult();
		//第二步：根据URL获取网页源代码。
		Document document = Jsoup.parse(TmGatherContentUtil.getHtmlResourceByURL("http://caipiaotj.com/index.php/Home/Ssc/ssc?id=5","UTF-8"));
		//采集class为list的内容
//		String atitle = document.getElementsByTag("table").html();
		Elements atitle = document.getElementsByTag("table").select("tr").removeAttr("onclick");
		Elements atitles = document.getElementsByTag("table").select("tr").removeAttr("id");
		
		System.out.println(atitles);
		
		Integer typeId= shiShiCaiMapper.selectTypeId(6);
		if(typeId >0){
			
			shiShiCaiMapper.deleteByPrimaryKey(6);
		}
		ShiShiCai  shiShiCai	=	new ShiShiCai();
		shiShiCai.setContents(atitles.toString());
		shiShiCai.setTypeId(6);
		try {
			shiShiCaiMapper.savepachong(shiShiCai);
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
	@Scheduled(cron = "0 0 12,16 * * ?")   //每天上午11.15准时抓取数据。（方法里面不能携带任何的参数。） 0 0 12,16 * * ? 每天上午12点，下午4点，
	public void geweidanshaung(){
		TmLog.info("==================开始网络爬虫处理");
		JsonResult jsonResult = new JsonResult();
		//第二步：根据URL获取网页源代码。
		Document document = Jsoup.parse(TmGatherContentUtil.getHtmlResourceByURL("http://caipiaotj.com/index.php/Home/Ssc/ssc?id=6","UTF-8"));
		//采集class为list的内容
//		String atitle = document.getElementsByTag("table").html();
		Elements atitle = document.getElementsByTag("table").select("tr").removeAttr("onclick");
		Elements atitles = document.getElementsByTag("table").select("tr").removeAttr("id");
		
		System.out.println(atitles);
		
		Integer typeId= shiShiCaiMapper.selectTypeId(7);
		if(typeId >0){
			
			shiShiCaiMapper.deleteByPrimaryKey(7);
		}
		ShiShiCai  shiShiCai	=	new ShiShiCai();
		shiShiCai.setContents(atitles.toString());
		shiShiCai.setTypeId(7);
		try {
			shiShiCaiMapper.savepachong(shiShiCai);
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
	@Scheduled(cron = "0 10 12,16 * * ?")   //每天上午11.15准时抓取数据。（方法里面不能携带任何的参数。） 0 0 12,16 * * ? 每天上午12点，下午4点，
	public void geweidaxiao(){
		TmLog.info("==================开始网络爬虫处理");
		JsonResult jsonResult = new JsonResult();
		//第二步：根据URL获取网页源代码。
		Document document = Jsoup.parse(TmGatherContentUtil.getHtmlResourceByURL("http://caipiaotj.com/index.php/Home/Ssc/ssc?id=7","UTF-8"));
		//采集class为list的内容
//		String atitle = document.getElementsByTag("table").html();
		Elements atitle = document.getElementsByTag("table").select("tr").removeAttr("onclick");
		Elements atitles = document.getElementsByTag("table").select("tr").removeAttr("id");
		
		System.out.println(atitles);
		
		Integer typeId= shiShiCaiMapper.selectTypeId(8);
		if(typeId >0){
			
			shiShiCaiMapper.deleteByPrimaryKey(8);
		}
		ShiShiCai  shiShiCai	=	new ShiShiCai();
		shiShiCai.setContents(atitles.toString());
		shiShiCai.setTypeId(8);
		try {
			shiShiCaiMapper.savepachong(shiShiCai);
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
	@Scheduled(cron = "0 20 12,16 * * ?")   //每天上午11.15准时抓取数据。（方法里面不能携带任何的参数。） 0 0 12,16 * * ? 每天上午12点，下午4点，
	public void gewei(){
		TmLog.info("==================开始网络爬虫处理");
		JsonResult jsonResult = new JsonResult();
		//第二步：根据URL获取网页源代码。
		Document document = Jsoup.parse(TmGatherContentUtil.getHtmlResourceByURL("http://caipiaotj.com/index.php/Home/Ssc/ssc?id=8","UTF-8"));
		//采集class为list的内容
//		String atitle = document.getElementsByTag("table").html();
		Elements atitle = document.getElementsByTag("table").select("tr").removeAttr("onclick");
		Elements atitles = document.getElementsByTag("table").select("tr").removeAttr("id");
		
		System.out.println(atitles);
		
		Integer typeId= shiShiCaiMapper.selectTypeId(9);
		if(typeId >0){
			
			shiShiCaiMapper.deleteByPrimaryKey(9);
		}
		ShiShiCai  shiShiCai	=	new ShiShiCai();
		shiShiCai.setContents(atitles.toString());
		shiShiCai.setTypeId(9);
		try {
			shiShiCaiMapper.savepachong(shiShiCai);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		TmLog.info("================爬虫处理完成");
	}
	
	
	
}
