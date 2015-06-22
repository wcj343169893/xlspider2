package com.choujone.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HtmlUtil {
	private static final String regEx_script = "<script[^>]*?>[\\s\\S]*?<\\/script>"; // 定义script的正则表达式
	private static final String regEx_style = "<style[^>]*?>[\\s\\S]*?<\\/style>"; // 定义style的正则表达式
	//private static final String regEx_html = "<[^>]+>"; // 定义HTML标签的正则表达式
	private static final String regEx_html = "<font[^>]*?>[\\s\\S]*?<\\/font>"; // font
	private static final String regEx_space = "\\s*|\t|\r|\n";// 定义空格回车换行符

	/**
	 * @param htmlStr
	 * @return 删除Html标签
	 */
	public static String delHTMLTag(String htmlStr) {
		Pattern p_script = Pattern.compile(regEx_script,
				Pattern.CASE_INSENSITIVE);
		Matcher m_script = p_script.matcher(htmlStr);
		htmlStr = m_script.replaceAll(""); // 过滤script标签

		Pattern p_style = Pattern
				.compile(regEx_style, Pattern.CASE_INSENSITIVE);
		Matcher m_style = p_style.matcher(htmlStr);
		htmlStr = m_style.replaceAll(""); // 过滤style标签

		Pattern p_html = Pattern.compile(regEx_html, Pattern.CASE_INSENSITIVE);
		Matcher m_html = p_html.matcher(htmlStr);
		htmlStr = m_html.replaceAll(""); // 过滤html标签

//		Pattern p_space = Pattern
//				.compile(regEx_space, Pattern.CASE_INSENSITIVE);
		
		//htmlStr=htmlStr.replaceAll("</?(?!br|/?p)[^>]*>", "");
		//Matcher m_space = p_space.matcher(htmlStr);
		//htmlStr = m_space.replaceAll(""); // 过滤空格回车标签
		return htmlStr.trim(); // 返回文本字符串
	}

	public static String getTextFromHtml(String htmlStr) {
		htmlStr = delHTMLTag(htmlStr);
		//htmlStr = htmlStr.replaceAll("&nbsp;", "");
		//htmlStr = htmlStr.substring(0, htmlStr.indexOf("。") + 1);
		return htmlStr;
	}

	public static void main(String[] args) {
		System.out.println("开始");
		String str = "<div class='message'>                	                                                            	                                                                                                                                    <script type='text/javascript'>replyreload += ',' + 141533;</script><font size='4'><font color='#006400'>深度提醒：账号内包括:1或者:2，需要与账号一起输入</font><br />爱密码迅雷账号分享789494362:1全网首发密码5517779<br />爱密码迅雷账号分享811914390:2全网首发密码1173359<br /><font size='4'><font size='4'><font size='4'><font size='4'><font size='4'><font size='4'><font size='4'><font size='4'><font size='4'><font size='4'><font size='4'><font size='4'><font size='4'><font size='4'><font size='4'><font size='4'><font size='4'><font size='4'><font size='4'><font size='4'><font size='4'><font size='4'><font size='4'><font face='Tahoma'><font style='font-size:14px'><font size='4'><font face='Tahoma'><font style='font-size:14px'><font size='4'><font face='Tahoma'><font style='font-size:14px'><font size='4'><font face='Tahoma'><font style='font-size:14px'><font size='4'><font face='Tahoma, Helvetica, SimSun, sans-serif'><font style='font-size:14px'><a href='http://item.taobao.com/item.htm?&amp;id=520032645667' target='_blank'><font face='Tahoma'><font size='4'><font size='4'><font face='Tahoma, Helvetica, SimSun, sans-serif'><font size='4'><font size='4'><font color='#336699'><font style='font-size:14px'><u><font color='#336699'><u><font color='#336699'><u><font color='#336699'><u><font color='#336699'><u><font size='2'><font color='#000000'><font color='#336699'><u><font color='#336699'><u><font color='#444444'><font size='5'><font color='#ff0000'>【独享不挤迅雷白金会员帐号</font></font></font><font color='#336699'><font color='#336699'><font color='#336699'><font color='#ff0000'><font size='5'>一年只要18元，</font><font color='#336699'><font color='#336699'><font color='#336699'><font color='#336699'><font size='5'><font color='#336699'>点击查看</font></font></font></font></font></font></font></font></font></font></u></font></u></font></font></font></u></font></u></font></u></font></u></font></u></font></font></font></font></font></font></font></font></a></font></font></font></font></font></font></font></font></font></font></font></font></font></font></font></font></font></font></font></font></font></font></font></font></font></font></font></font></font></font></font></font></font></font></font></font></font></font><font face='Tahoma, Helvetica, SimSun, sans-serif'><font style='font-size:14px'><font face='Tahoma, Helvetica, SimSun, sans-serif'><font face='Tahoma, Helvetica, SimSun, sans-serif'><a href='http://item.taobao.com/item.htm?&amp;id=520032645667' target='_blank'><font color='#336699'><font face='Tahoma, Helvetica, SimSun, sans-serif'><u><font color='#336699'><u><font color='#336699'><u><font color='#336699'><u><font color='#336699'><u><font color='#336699'><u><font color='#336699'><u><font color='#336699'><u><font color='#336699'><u><font color='#336699'><u><font color='#336699'><u><font color='#336699'><u><font color='#336699'><u><font color='#336699'><u><font color='#336699'><u><font color='#336699'><u><u><font color='#336699'><u><u><font color='#336699'><u><font color='#336699'><u><font color='#336699'><u><font color='#336699'><u><font color='#336699'><u><font color='#336699'><u><font color='#336699'><u><u><font color='#336699'><u><font color='#336699'><u><font color='#336699'><u><font color='#336699'><u><font color='#336699'><u><u><font color='#336699'><u><font color='#336699'><u><font color='#336699'><u><font color='#336699'><u><font color='#336699'><u><font color='#336699'><u><font color='#336699'><u><font color='#336699'><u><font color='#336699'><u><font color='#336699'><u><font color='#336699'><u><font color='#336699'><u><u><font color='#336699'><font color='#336699'><font color='#336699'><font color='#336699'><font color='#336699'><font color='#336699'><font color='#336699'><font color='#336699'><font color='#336699'><font color='#336699'><font color='#336699'><font color='#336699'><font color='#336699'><font color='#336699'><font color='#336699'><font color='#336699'><font color='#336699'><font color='#336699'><font color='#336699'><font color='#336699'><font color='#336699'><font size='5'><font color='#ff00'>】</font></font></font></font></font></font></font></font></font></font></font></font></font></font></font></font></font></font></font></font></font></font></font></u></u></font></u></font></u></font></u></font></u></font></u></font></u></font></u></font></u></font></u></font></u></font></u></font></u></u></font></u></font></u></font></u></font></u></font></u></u></font></u></font></u></font></u></font></u></font></u></font></u></font></u></u></font></u></u></font></u></font></u></font></u></font></u></font></u></font></u></font></u></font></u></font></u></font></u></font></u></font></u></font></u></font></u></font></u></font></font></a></font></font></font></font><br /><font size='4'><font face='Tahoma, Helvetica, SimSun, sans-serif'><font face='Tahoma, Helvetica, SimSun, sans-serif'><font face='Tahoma, Helvetica, SimSun, sans-serif'><font face='Tahoma, Helvetica, SimSun, sans-serif'><font face='Tahoma, Helvetica, SimSun, sans-serif'><font color='#000080'>(近期购买加送迅雷影视vip一个用)</font></font></font></font></font></font></font><br /><font size='4'>爱密码迅雷账号分享336993379:1全网首发密码5957379<br />爱密码迅雷账号分享752393363:1全网首发密码7759953<br />爱密码迅雷账号分享814293419:1全网首发密码9519573</font><br /><u><a href='http://1.baidu.com/?invite_code=KNAV9VFV' target='_blank'><font size='5'><font color='#ff0000'><u><strong>1分钱购买100M手机流量（百度官方活动），点击进入</strong></u></font></font></a></u><br /><font size='4'>爱密码迅雷账号分享830222548:2全网首发密码7737999<br />爱密码迅雷账号分享786214187:1全网首发密码5953319<br />爱密码迅雷账号分享495133263:1全网首发密码7999553<br />爱密码迅雷账号分享398758870:2全网首发密码9591795<br />爱密码迅雷账号分享895758352:2全网首发密码7993911<br />爱密码迅雷账号分享yangbin12334:2全网首发密码7517359<br />爱密码迅雷账号分享niukekkk:2全网首发密码7991179<br />爱密码迅雷账号分享464818202:1全网首发密码9595397<br />爱密码迅雷账号分享113675958:1全网首发密码3173571<br />爱密码迅雷账号分享892949167:2全网首发密码5153599<br />爱密码迅雷账号分享568549080:1全网首发密码5133319<br />爱密码迅雷账号分享lucky15:2全网首发密码9759795<br />爱密码迅雷账号分享140600680:1全网首发密码5991511<br />爱密码迅雷账号分享753873631:1全网首发密码5355717<br />爱密码迅雷账号分享815019800:1全网首发密码9199797<br />爱密码迅雷账号分享as297200713:1全网首发密码7771339<br />爱密码迅雷账号分享12812222:1全网首发密码9193519<br />爱密码迅雷账号分享515713886:2全网首发密码9555193<br />爱密码迅雷账号分享834229482:1全网首发密码3377317<br />爱密码迅雷账号分享freeray:1全网首发密码7715171<br />爱密码迅雷账号分享828964606:2全网首发密码1577937<br />爱密码迅雷账号分享xulongjun:2全网首发密码9933195<br />爱密码迅雷账号分享347251825:1全网首发密码5199355<br />爱密码迅雷账号分享817904408:2全网首发密码7957713<br />爱密码迅雷账号分享215704688:2全网首发密码9331515<br />爱密码迅雷账号分享473159133:1全网首发密码1577553<br />爱密码迅雷账号分享786214187:2全网首发密码1977757<br />爱密码迅雷账号分享798302213:2全网首发密码3115155<br />爱密码迅雷账号分享791658849:2全网首发密码5373193<br />爱密码迅雷账号分享896218388:1全网首发密码7575973<br />爱密码迅雷账号分享810570736:1全网首发密码3151995<br />爱密码迅雷账号分享672885610:1全网首发密码9335157<br />爱密码迅雷账号分享491065310:1全网首发密码1995557<br />爱密码迅雷账号分享786744475:2全网首发密码7573531<br />";
		System.out.println(getTextFromHtml(str));
	}
}
