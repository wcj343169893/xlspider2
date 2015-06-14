<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="com.choujone.dao.SpiderDao"%>
<%@page import="java.util.List"%>
<%@page import="com.choujone.entity.Spider"%><html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>采集内容</title>
<script type="text/javascript" charset="utf-8" src="js/jquery.js"></script>

    <link rel="stylesheet" type="text/css" href="css/admin-style.css" />
    <link rel="stylesheet" type="text/css" href="css/ui-lightness/jquery-ui.css" />
	<link rel="stylesheet" type="text/css" href="jscal/css/jscal2.css" />
    <link rel="stylesheet" type="text/css" href="jscal/css/border-radius.css" />
    <link rel="stylesheet" type="text/css" href="jscal/css/steel/steel.css" />
</head>
<body>
<%
	int p=request.getParameter("p")!= null ? Integer.parseInt(request.getParameter("p").toString()) : 1;
	SpiderDao sd=new SpiderDao();
	List<Spider> spiders=sd.getSpiderByPages();
%>
<div class="main">
<div class="top">
	<div class="bord"> 
		<a title="后台管理" href="/admin/">控制面板</a>
		<a href="/user">[注销]</a>
	</div>
	 <div class="headings">
      	<h1><a href="/" > </a></h1>
      	<h2> </h2>
      	<div class="clear">
      	</div>
    </div>
	<div class="menu">
		<ul>
			<li>
				<a href="spider.jsp">采集任务</a>
			</li>
		</ul>
	</div>
</div>

	<script type="text/javascript" charset="utf-8" src="js/jquery-ui.js"></script>
 	<script src="jscal/js/jscal2.js"></script>
    <script src="js/spider.js"></script>
    <script src="jscal/js/lang/en.js"></script>
	<div class="address">
			采集中心(<a href="javascript:void(0)" id="newSpider" class="spider_btn ui-state-default ui-corner-all"><span class="ui-icon ui-icon-newwin"></span>新建任务</a>)
	</div>
	<div class="main-title">
		所有任务(<%=spiders.size() %>)
	</div>
	<div class="tools">
		<span class="tools-left">
			<input type="button" value="删除" onclick="deletes('/spider')">
		</span>
	</div>
	<div class="vito-content">	
		<table cellpadding="0" cellspacing="0">
			<tr>
				<th class="vito-content-check"><input type="checkbox" id="input_check_all" onclick="allCheckFlag(this)"/></th>
				<th width="200px">标题</th>
				<th width="300px">采集网站/地址</th>
				<th>文章分类</th>
				<th>定时时间</th>
				<th>采集总数/采集次数</th>
				<th>执行/显示</th>
				<th>操作</th>
			</tr><%if(spiders!=null){ for(Spider spider : spiders){%>
			<tr>
				<td class="vito-content-check"><input type="checkbox" id="rid_<%=spider.getId() %>" class="input_check_single" onclick="singleDeleteFlag(this)" name="deleteFlag" value="<%=spider.getId() %>"/></td>
				<td><%=spider.getName() %></td>
				<td><%=spider.getWeb_host() %><br/><%=spider.getWeb_list_url() %></td>
				<td><%=spider.getTids() %></td>
				<td><%=spider.getSpider_start() %></td>
				<td><%=spider.getSumCount() %>/<%=spider.getCount() %></td>
				<td><%=spider.getStart()!=0 ? "等待":"停止" %>/<%=spider.getIsVisible()!=0 ? "隐藏":"显示" %></td>
				<td><a href="javascript:void(0)" class="start_spider" name="<%=spider.getId() %>">开始</a></td>
			</tr><%}}else{ %>
			<tr>
				<td colspan="6">暂无内容</td>
			</tr>
			<%} %>
		</table>
	</div>
	<div id="spider_setting" class="spider" title="新增采集任务" style="margin: 0;">
		<p class="validateTips">所有内容都必填</p>
		<div class="">
				<div class="container-title-header">名称：</div><input type="text" name="spider_name" id="spider_name">
		</div>
		<div class="">
				<div class="container-title-header">运行时间：</div><input type="text" name="spider_start" id="spider_start">
		</div>
		<div class="">
			<div class="container-title-header">文章分类：</div><div id="typelist"></div> 
		</div>
		 <div class="tabs">
		    <ul>
		        <li><a href="#web_list"><span>列表</span></a></li>
		        <li><a href="#web_content"><span>内容</span></a></li>
		    </ul>
		<div id="web_list">
			<div class="">
				<div class="container-title-header">网址：</div><input type="text" name="web_host" id="web_host" value="http://521xunlei.com/" size="50"> 
			</div>
			<div>
			<div class="container-title-header">网站编码：</div>
				<select name="web_charSet" id="web_charSet">
					<option value="utf-8" selected="selected">utf-8</option>
					<option value="gbk">gbk</option>
					<option value="gb2312" >gb2312</option>
					<option value="ISO8859-1">ISO8859-1</option>
				</select>
			
			</div>
			<div>
				<div class="container-title-header">包含字符串：</div><input type="text"	name="web_list_contain" id="web_list_contain" size="50" value="viewthread">
			</div>
			<div>
				<div class="container-title-header">列表页地址：</div><input type="text"	name="web_list_url" id="web_list_url" size="50" value="http://521xunlei.com/forum-xunleihuiyuan-1.html"> 
			</div>
			<div>
				<div class="container-title-header">列表页开始位置：</div><textarea rows="5" cols="50" name="web_list_begin" id="web_list_begin"><!-- main threadlist start --></textarea>
			</div>
			<div>
				<div class="container-title-header">列表页结束位置：</div><textarea rows="5" cols="50" name="web_list_end" id="web_list_end"><!-- main threadlist end --></textarea>
			</div>
			<div>
				<a href="javascript:void(0)" class="spider_btn ui-state-default ui-corner-all" id="test_list_btn"><span class="ui-icon ui-icon-newwin"></span>测试列表页</a>
			</div>
		</div>
		<div id="web_content">
			<div>
				<div class="container-title-header">内容标题：</div><input type="text" name="web_content_title" id="web_content_title" value="<title>(.*)</title>">(正则) 
			</div>
			<div>
				<div class="container-title-header">保留标签：</div>
				<input type="checkbox" value="p,/p" id="tag_p" checked class="web_content_tags"><label for="tag_p">P</label>
				<input type="checkbox" value="span,/span" id="tag_span" checked class="web_content_tags"><label for="tag_span">SPAN</label>
				<input type="checkbox" value="img" id="tag_img" checked class="web_content_tags"><label for="tag_img">IMG</label>
				<input type="checkbox" value="br,/br" id="tag_br" checked class="web_content_tags"><label for="tag_br">BR</label>
				<input type="checkbox" value="div,/div" id="tag_div" class="web_content_tags"><label for="tag_div">DIV</label>
			</div>
			<div>
				<div class="container-title-header">内容开始位置：</div><textarea rows="5" cols="50" name="web_content_begin" id="web_content_begin"><div class="message"</textarea>
			</div>
			<div>
				<div class="container-title-header">内容结束位置：</div><textarea rows="5" cols="50" name="web_content_end" id="web_content_end"><div id="post_new"></div></textarea>
			</div>
			<div>
				<a href="javascript:void(0)" class="spider_btn ui-state-default ui-corner-all" id="test_content_btn"><span class="ui-icon ui-icon-newwin"></span>测试内容页</a>
			</div>
		</div>
		</div>
	</div>
	<div id="test_result" title="运行结果">
		<div class="result_content"><div class='loading'><img src='images/loading.gif'/></div></div>
	</div>
	
	<script type="text/javascript">
		
	</script>
<div class="footer">
	<div class="content">Powered By choujone 版权所有.Some Rights Reserved </div>
</div>
</div>
</body>
</html>