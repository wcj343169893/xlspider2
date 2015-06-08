package com.choujone.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * 采集配置类 choujone'blog<br>
 * 功能描述： 2012-2-11
 */
@Entity
@Table(name="spider")
public class Spider implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id ;
	@Column(length = 50, nullable = false, name = "name")
	private String name = "";// 采集名称
	private String web_host = "";
	// 网站编码
	private String charset = "utf-8";
	// 列表地址
	private String web_list_url = "";
	// 列表开始位置和结束位置
	private String web_list_begin = "";
	private String web_list_end = "";
	// 内容标题
	private String web_content_title = "";
	// 内容开始位置和结束位置
	private String web_content_begin = "";
	private String web_content_end = "";
	// 内容保留标签
	private String clear_content_reg = "";
	private String tids = "";
	// 执行时间
	private String spider_start = "";
	// 采集次数
	private int count = 0;
	// 采集成功总数
	private int sumCount = 0;
	// 是否开始 0为停止
	private int start = 0;
	// 创建时间
	@Temporal(TemporalType.DATE)
	private Date sdTime ;
	// 最后修改时间
	@Temporal(TemporalType.DATE)
	private Date edTime ;
	// 是否显示
	private int isVisible = 0;

	public long getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getWeb_host() {
		return web_host;
	}

	public void setWeb_host(String webHost) {
		web_host = webHost;
	}

	public String getCharset() {
		return charset;
	}

	public void setCharset(String charset) {
		this.charset = charset;
	}

	public String getWeb_list_url() {
		return web_list_url;
	}

	public void setWeb_list_url(String webListUrl) {
		web_list_url = webListUrl;
	}

	public String getWeb_list_begin() {
		return web_list_begin;
	}

	public void setWeb_list_begin(String webListBegin) {
		web_list_begin = webListBegin;
	}

	public String getWeb_list_end() {
		return web_list_end;
	}

	public void setWeb_list_end(String webListEnd) {
		web_list_end = webListEnd;
	}

	public String getWeb_content_title() {
		return web_content_title;
	}

	public void setWeb_content_title(String webContentTitle) {
		web_content_title = webContentTitle;
	}

	public String getWeb_content_begin() {
		return web_content_begin;
	}

	public void setWeb_content_begin(String webContentBegin) {
		web_content_begin = webContentBegin;
	}

	public String getWeb_content_end() {
		return web_content_end;
	}

	public void setWeb_content_end(String webContentEnd) {
		web_content_end = webContentEnd;
	}

	public String getClear_content_reg() {
		return clear_content_reg;
	}

	public void setClear_content_reg(String clearContentReg) {
		clear_content_reg = clearContentReg;
	}

	public String getTids() {
		return tids;
	}

	public void setTids(String tids) {
		this.tids = tids;
	}

	public String getSpider_start() {
		return spider_start;
	}

	public void setSpider_start(String spiderStart) {
		spider_start = spiderStart;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getSumCount() {
		return sumCount;
	}

	public void setSumCount(int sumCount) {
		this.sumCount = sumCount;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}


	public Date getSdTime() {
		return sdTime;
	}

	public void setSdTime(Date sdTime) {
		this.sdTime = sdTime;
	}

	public Date getEdTime() {
		return edTime;
	}

	public void setEdTime(Date edTime) {
		this.edTime = edTime;
	}

	public int getIsVisible() {
		return isVisible;
	}

	public void setIsVisible(int isVisible) {
		this.isVisible = isVisible;
	}

}
