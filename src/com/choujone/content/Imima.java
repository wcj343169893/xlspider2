package com.choujone.content;

import java.util.ArrayList;
import java.util.List;

import com.choujone.entity.Spider;
import com.choujone.util.SpiderThread;

/**
 * 爱密码网
 * 
 * @author 文朝军
 * @link http://521xunlei.com/
 */
public class Imima {
	String list_link = "http://521xunlei.com/forum-xunleihuiyuan-1.html";
	List children_links = new ArrayList();
	static String charset = "utf-8";

	public Imima() {
		
	}

	public void start(){
		
	}
	private static void message(String szMsg) {
		try {
			System.out.println(new String(szMsg.getBytes(charset), System
					.getProperty("file.encoding")));
		} catch (Exception e) {
		}
	}

	public static void main(String[] args) {
		SpiderThread st = new SpiderThread();
		Spider spider = new Spider();
		spider.setWeb_host("http://521xunlei.com/");
		spider.setWeb_list_url("http://521xunlei.com/forum-xunleihuiyuan-1.html");
		spider.setWeb_list_begin("<!-- main threadlist start -->");
		spider.setWeb_list_end("<!-- main threadlist end -->");
		spider.setWeb_content_begin("<div class=\"message\">");
		spider.setWeb_content_end("<div id=\"post_new\"></div>");
		spider.setWeb_content_title("<title>(.*)</title>");
		st.setSpider(spider);
		st.run();
//		String testString="  <a href='forum.php?mod=viewthread&amp;tid=6562&amp;extra=page%3D1&amp;mobile=2'  >6月7日迅雷分享会员号发布（第一批）<span class='by'>管理-小猪</span>";
//		testString=testString.replaceAll("&(amp;)","&");
//		System.out.println(testString);
	}
}
