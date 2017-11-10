package com.moxi.web.admin.pachong;


import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.moxi.dao.appcontent.admin.IAppContentMapper;
import com.moxi.dao.appshishicai.admin.IShiShiCaiMapper;
import com.moxi.model.ShiShiCai;
import org.jsoup.safety.Whitelist;
import com.moxi.util.HttpRequest;



@Controller
@RequestMapping("/pashujuofssc")
public class PashujuOfsscController {
	
	
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
	 * 网络爬虫(总合单双)
	 * @throws
	 */
	@RequestMapping("/zhds")
	@ResponseBody
	public String getZhds(HttpServletRequest request,HttpServletResponse response){
		response.setContentType("text/plain; charset=UTF-8");
		response.addHeader("Access-Control-Allow-Origin", "*");
		String shuju=HttpRequest.sendPost("http://caipiaotj.com/index.php/Home/Pk10/ajax_index", "id=1&type=ssc");
		return shuju;

	}
	
	/**
	 * 网络爬虫(总合大小)
	 * @throws
	 */
	@RequestMapping("/zhdx")
	@ResponseBody
	public String getZhdx(HttpServletRequest request,HttpServletResponse response){
		response.setContentType("text/plain; charset=UTF-8");
		response.addHeader("Access-Control-Allow-Origin", "*");
		String shuju=HttpRequest.sendPost("http://caipiaotj.com/index.php/Home/Pk10/ajax_index", "id=2&type=ssc");
		return shuju;

	}
	
	/**
	 * 网络爬虫(龙虎)
	 * @throws
	 */
	@RequestMapping("/lh")
	@ResponseBody
	public String getLh(HttpServletRequest request,HttpServletResponse response){
		response.setContentType("text/plain; charset=UTF-8");
		response.addHeader("Access-Control-Allow-Origin", "*");
		String shuju=HttpRequest.sendPost("http://caipiaotj.com/index.php/Home/Pk10/ajax_index", "id=3&type=ssc");
		return shuju;

	}
	
	/**
	 * 网络爬虫(个位单双)
	 * @throws
	 */
	@RequestMapping("/gwds")
	@ResponseBody
	public String getGwds(HttpServletRequest request,HttpServletResponse response){
		response.setContentType("text/plain; charset=UTF-8");
		response.addHeader("Access-Control-Allow-Origin", "*");
		String shuju=HttpRequest.sendPost("http://caipiaotj.com/index.php/Home/Pk10/ajax_index", "id=6&type=ssc");
		return shuju;

	}
	
	/**
	 * 网络爬虫(个位大小)
	 * @throws
	 */
	@RequestMapping("/gwdx")
	@ResponseBody
	public String getGwdx(HttpServletRequest request,HttpServletResponse response){
		response.setContentType("text/plain; charset=UTF-8");
		response.addHeader("Access-Control-Allow-Origin", "*");
		String shuju=HttpRequest.sendPost("http://caipiaotj.com/index.php/Home/Pk10/ajax_index", "id=7&type=ssc");
		return shuju;

	}
	
	/**
	 * 网络爬虫(定胆个位)
	 * @throws
	 */
	@RequestMapping("/ddgw")
	@ResponseBody
	public String getDdgw(HttpServletRequest request,HttpServletResponse response){
		response.setContentType("text/plain; charset=UTF-8");
		response.addHeader("Access-Control-Allow-Origin", "*");
		String shuju=HttpRequest.sendPost("http://caipiaotj.com/index.php/Home/Pk10/ajax_index", "id=8&type=ssc");
		return shuju;

	}
	
	
	/**
	 * 网络爬虫(热门计划号码)
	 * @throws
	 */
	@RequestMapping("/rmjh")
	@ResponseBody
	public String getRmjh(HttpServletRequest request,HttpServletResponse response){
		response.setContentType("text/plain; charset=UTF-8");
		response.addHeader("Access-Control-Allow-Origin", "*");
		String shuju=HttpRequest.sendPost("http://caipiaotj.com/index.php/Home/Ssc/ajax_index", "");
		return shuju;

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
