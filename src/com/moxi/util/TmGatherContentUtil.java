 package com.moxi.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashSet;
import java.util.Set;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.safety.Whitelist;
import org.jsoup.select.Elements;

import com.moxi.core.ServiceResult;
import com.opensymphony.xwork2.validator.annotations.RegexFieldValidator;

public class TmGatherContentUtil {

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
     * 根据网页和网页编码获取网页内容.
     * 
     * @param url
     * @param encoding
     * @return
     */
    public static String getHtmlResourceByURL(String url, String encoding) {
        StringBuffer buffer = new StringBuffer();
        BufferedReader reader = null;
        InputStreamReader in = null;
        URLConnection uc = null;
        URL urlObj = null;
        try {
            urlObj = new URL(url);
            uc = urlObj.openConnection();
            uc.setRequestProperty("User-Agent", "java");
            in = new InputStreamReader(uc.getInputStream(), encoding);
            reader = new BufferedReader(in);
            String line = null;
            while ((line = reader.readLine()) != null) {
                buffer.append(line + "\r\n");
            }
        } catch (Exception e) {
            return "connection timeout....";
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return buffer.toString();
    }
    
	public static void main(String[] args) throws MalformedURLException, IOException {
		String url = "https://www.800820.net/ssq/list_38.html";
		
		//第二步：根据URL获取网页源代码。
		Document document = Jsoup.parse(getHtmlResourceByURL(url,"UTF-8"));
		
		Elements links2 = document.getElementsByClass("list");
		
		Set<String> urls = new HashSet<String>();
		for (Element element : links2) {
			Elements href2 = element.getElementsByTag("li");
			for (Element element2 : href2) {
				String title = element2.text();
				Elements alink = element2.getElementsByTag("a");
				String href = alink.attr("href");
				urls.add(href);
				//System.out.println(title+"=="+href);
			}
		}
		
		for (String string : urls) {
			try {
				String link = "https://www.800820.net"+string;
				//System.out.println(link);
				Document document2 = Jsoup.parse(getHtmlResourceByURL(link,"UTF-8"));
				String title = document2.getElementsByTag("h2").get(0).text();
				//System.out.println(title);
				Elements content = document2.getElementsByClass("text");
				for (Element element : content) {
					element.getElementsByTag("p").empty();
				}
				String content2 = content.html();
//				System.out.println(title);
//				System.out.println(content2);
//				//System.out.println(Jsoup.clean(content, Whitelist.simpleText()));
			} catch (Exception e) {
				continue;
			}
		}
		
	}
}
