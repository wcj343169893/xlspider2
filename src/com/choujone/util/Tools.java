package com.choujone.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Tools {
	/**
	 * @功能 转换字符串值为int型值
	 * @参数 value为要转换的字符串
	 * @返回值 int型值
	 */
	public static String changeHTML(String value) {
		/*
		 * value=value.replace("'", "''"); value=value.replace("&","&amp;");
		 * value=value.replace(" ","&nbsp;"); value=value.replace("<","&lt;");
		 * value=value.replace(">","&gt;"); value=value.replace("\r\n","<br>");
		 */
		return value;
	}

	/**
	 * @功能 移除内容的html标签，防止跨站脚本攻击漏洞
	 * */
	public static String removeHtml(String message) {
		message = message.replace('<', ' ');
		message = message.replace('>', ' ');
		message = message.replace('"', ' ');
		message = message.replace('\'', ' ');
		message = message.replace('/', ' ');
		message = message.replace('%', ' ');
		message = message.replace(';', ' ');
		message = message.replace('(', ' ');
		message = message.replace(')', ' ');
		message = message.replace('&', ' ');
		message = message.replace('+', '_');
		return message;
	}

	public static String FilterHTML(String value) {
		value = value.replace("'", "\'");
		value = value.replace("&", "&amp;");
		value = value.replace(" ", "&nbsp;");
		value = value.replace("<", "&lt;");
		value = value.replace(">", "&gt;");
		value = value.replace("\r\n", "<br>");
		return value;
	}
	

	/**
	 * @功能 转换字符串值为int型值
	 * @参数 value为要转换的字符串
	 * @返回值 int型值
	 */
	public static int strToint(String value) {
		int i = -1;
		if (value == null || value.equals(""))
			return i;
		try {
			i = Integer.parseInt(value);
		} catch (NumberFormatException e) {
			i = -1;
			e.printStackTrace();
		}
		return i;
	}

	/**
	 * string转化为long
	 * 
	 * @param value
	 * @return
	 */
	public static Long strTolong(String value) {
		Long i = -1L;
		if (value == null || value.equals(""))
			return i;
		try {
			i = Long.valueOf(value.trim());
		} catch (NumberFormatException e) {
			i = -1L;
		}
		return i;
	}

	/**
	 * @功能 解决通过提交表单产生的中文乱码
	 * @参数 value为要转换的字符串
	 * @返回值 String型值
	 */
	public static String toChinese(String value) {
		return value;
		/*
		 * if (value == null) return ""; try { value = new
		 * String(value.getBytes("ISO-8859-1"), "UTF-8"); return value; } catch
		 * (Exception e) { return ""; }
		 */
	}

	/**
	 * @功能 将Date型日期转换成指定格式的字符串形式，如“yyyy年MM月dd日 HH:mm:ss”
	 * @参数 date为要被转换的Date型日期
	 * @返回值 String型值
	 */
	public static String changeTime(Date date) {
		return changeTime(date, "yyyy年MM月dd日 HH:mm:ss");
	}

	public static String changeTime(Date date, String format) {
		SimpleDateFormat simpleformat = new SimpleDateFormat(format);
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.HOUR_OF_DAY, 8);
		return simpleformat.format(calendar.getTime());
	}

	public static Date changeTime(String date) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
		Date d = new Date();
		try {
			d = format.parse(date);
		} catch (ParseException e) {
		}
		return d;
	}


	/**
	 * 根据IP地址获取地理位置，如：北京市
	 */
	public static String getAddressByIP(String ip) {
		String addressStr = "";
		try {
			URL url = new URL("http://www.ip138.com/ips138.asp?action=2&ip="
					+ ip);
			URLConnection conn = url.openConnection();
			BufferedReader reader = new BufferedReader(new InputStreamReader(
					conn.getInputStream(), "GBK"));
			String line = null;
			StringBuffer result = new StringBuffer();
			while ((line = reader.readLine()) != null) {
				result.append(line);
			}
			reader.close();
			addressStr = result.toString();
			addressStr = addressStr.substring(addressStr.indexOf("主数据：") + 4,
					addressStr.indexOf("</li><li>参考数据"));
			char[] address = addressStr.toCharArray();
			for (int i = 0; i < address.length; i++) {
				char c = address[i];
				if (i != 0 && !Character.isLetter(c)) { // 判断是否汉字，不含中午特殊符号
					addressStr = addressStr.substring(0, i);
					break;
				}
			}
		} catch (StringIndexOutOfBoundsException indexOut) {
			System.out.println("下标越界：" + ip);
			addressStr = ip; // 获取失败，返回IP
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return addressStr;
	}


	/**
	 * 判断字符串是否为空
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isNotNull(Object str) {
		return str != null && !"".equals(str.toString().trim());
	}

	public static boolean isNotNull(Map map) {
		return map != null && !map.isEmpty();
	}

	/**
	 * 是否是邮箱
	 * 
	 * @param email
	 * @return
	 */
	public static boolean isEmail(String email) {
		boolean flag = false;
		try {
			if (isNotNull(email)) {
				Pattern pattern = Pattern
						.compile("^([a-zA-Z0-9_\\-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([a-zA-Z0-9\\-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$");
				Matcher matcher = pattern.matcher(email);
				flag = matcher.matches();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return flag;
	}

	public static String escape(String s) {
		if (!isNotNull(s)) {
			return "";
		}
		StringBuffer stringbuffer = new StringBuffer();
		int i = 0;
		for (int j = s.length(); i < j; i++) {
			char c = s.charAt(i);
			switch (c) {
			case 38: // '&'
				stringbuffer.append("&amp;");
				break;

			case 60: // '<'
				stringbuffer.append("&lt;");
				break;

			case 62: // '>'
				stringbuffer.append("&gt;");
				break;

			case 34: // '"'
				stringbuffer.append("&quot;");
				break;

			default:
				stringbuffer.append(c);
				break;
			}
		}
		return stringbuffer.toString();
	}

	public static Map<Object, Object> str2map(String input) {
		String regex = ",";
		String regex2 = "=";
		Map<Object, Object> map = new HashMap<Object, Object>();
		if (isNotNull(input)) {
			String[] strs = input.split(regex);
			for (int i = 0; i < strs.length; i++) {
				if (isNotNull(strs[i])) {
					String[] strs2 = strs[i].split(regex2);
					map.put(strs2[0], strs2[1]);
				}
			}
		}
		return map;
	}

	public static String map2str(Map<Object, Object> map) {
		String regex = ",";
		String regex2 = "=";
		StringBuffer sb = new StringBuffer();
		if (isNotNull(map)) {
			for (Object obj : map.keySet()) {
				if (isNotNull(map.get(obj))) {
					sb.append(obj + regex2 + map.get(obj));
					sb.append(regex);
				}
			}
		}
		return sb.substring(0, sb.lastIndexOf(regex));
	}

	public static String map2str2(Map<Long, Integer> map) {
		String regex = ",";
		String regex2 = "=";
		StringBuffer sb = new StringBuffer();
		if (isNotNull(map)) {
			for (Object obj : map.keySet()) {
				if (isNotNull(map.get(obj))) {
					sb.append(obj + regex2 + map.get(obj));
					sb.append(regex);
				}
			}
		}
		return sb.substring(0, sb.lastIndexOf(regex));
	}

	public static Map<Long, Integer> map2map(Map<Object, Object> obj) {
		Map<Long, Integer> map = new HashMap<Long, Integer>();
		try {
			for (Object key : obj.keySet()) {
				map.put(Long.valueOf(key.toString()),
						Integer.parseInt(obj.get(key).toString()));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return map;
	}

	public static Map<Object, Object> map2map2(Map<Long, Integer> obj) {
		Map<Object, Object> map = new HashMap<Object, Object>();
		try {
			for (Object key : obj.keySet()) {
				map.put(key.toString(), obj.get(key).toString());
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return map;
	}

	/**
	 * 修改統計map
	 * 
	 * @param map
	 * @param tid
	 * @return
	 */
	public static Map<Long, Integer> modifyMayOfStatis(Map<Long, Integer> map,
			Long tid) {
		try {
			for (Long key : map.keySet()) {
				if (key.equals(tid)) {
					if (isNotNull(map.get(key))) {
						map.put(key,
								map.get(key) != null && map.get(key) > 0 ? map
										.get(key) - 1 : 0);
					}
				}
			}
		} catch (Exception e) {
		}
		return map;
	}

	/**判断新ip是否符合旧ip,可以匹配119.122.*.135 中间加星星的地址
	 * @param ip 被匹配的地址
	 * @param newIpAddress 需要匹配的地址
	 * @return true:符合；false:不符合
	 */
	public static boolean isRightIp(String ip,String newIpAddress)
	{
        Pattern pattern = Pattern.compile(ip); 
        Matcher matcher = pattern.matcher(newIpAddress); 
        return matcher.matches(); 
	}
	/**
	 * 返回文件的预览图
	 * */
	public static String getFileThumb(String str){
		String s="/images/default_100.jpg";
		String rar_s="rar,zip,tar,cab,uue,jar,iso,z,7-zip,ace,lzh,arj,gzip,bz2";
		String pic_s="jpg,jpeg,png,gif,bmp";
		for (String string : rar_s.split(",")) {
			if(str.toLowerCase().endsWith(string)){
				return "/images/zip.png";
			}
		}
		for (String string : pic_s.split(",")) {
			if(str.toLowerCase().endsWith(string)){
				return str;
			}
		}
		//zip.png
		return s;
	}
	/**
	 * 返回文件类型
	 * */
	public static String getFileContentType(String str){
		String s="application/octet-stream";
		String pic_s="jpg,jpeg,png,gif,bmp";
		for (String string : pic_s.split(",")) {
			if(str.toLowerCase().endsWith(string)){
				return "image/jpeg";
			}
		}
		return s;
	}
	
	

	public static void main(String[] args) {
		// Map<Object, Object> map = new HashMap<Object, Object>();
		// map.put("1328885416494", "4");
		// map.put("1328885416433", "67");
		// map.put("1328885413494", "54");
		// map.put("1328885416294", "55");
		// String str = Tools.map2str(map);
		// System.out.println("str:" + str);
		// map = Tools.str2map(str);
		// for (Object obj : map.keySet()) {
		// System.out.println("key:" + obj + "  value:" + map.get(obj));
		// }
		boolean flag = Tools.isRightIp("119.122.*.135","127.0.0.1");
		System.out.println(flag);
	}
}