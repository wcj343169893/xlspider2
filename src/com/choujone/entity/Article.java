package com.choujone.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "article")
public class Article implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String oId = "";

	private String articleTitle = " ";
	private String articleAbstract = " ";
	private String articleTypeId = "0";
	private String articleTags = " ";
	private String articleAuthorEmail = "343169893@qq.com";
	private int articleCommentCount = 0;
	private int articleViewCount = 0;
	private String articleContent = "";
	private String articlePermalink = "";
	private char articleHadBeenPublished = 1;
	private char articleIsPublished = 1;
	private char articlePutTop = 0;
	@Temporal(TemporalType.DATE)
	private Date articleCreateDate;
	@Temporal(TemporalType.DATE)
	private Date articleUpdateDate;
	private double articleRandomDouble = 0;
	private String articleSignId = "1";
	private char articleCommentable = 1;
	private String articleViewPwd = "";
	private String articleEditorType = "tinyMCE";
	private String source = "";

	public String getoId() {
		return oId;
	}

	public void setoId(String oId) {
		this.oId = oId;
	}

	public String getArticleTitle() {
		return articleTitle;
	}

	public void setArticleTitle(String articleTitle) {
		this.articleTitle = articleTitle;
	}

	public String getArticleAbstract() {
		return articleAbstract;
	}

	public void setArticleAbstract(String articleAbstract) {
		this.articleAbstract = articleAbstract;
	}

	public String getArticleTypeId() {
		return articleTypeId;
	}

	public void setArticleTypeId(String articleTypeId) {
		this.articleTypeId = articleTypeId;
	}

	public String getArticleTags() {
		return articleTags;
	}

	public void setArticleTags(String articleTags) {
		this.articleTags = articleTags;
	}

	public String getArticleAuthorEmail() {
		return articleAuthorEmail;
	}

	public void setArticleAuthorEmail(String articleAuthorEmail) {
		this.articleAuthorEmail = articleAuthorEmail;
	}

	public int getArticleCommentCount() {
		return articleCommentCount;
	}

	public void setArticleCommentCount(int articleCommentCount) {
		this.articleCommentCount = articleCommentCount;
	}

	public int getArticleViewCount() {
		return articleViewCount;
	}

	public void setArticleViewCount(int articleViewCount) {
		this.articleViewCount = articleViewCount;
	}

	public String getArticleContent() {
		return articleContent;
	}

	public void setArticleContent(String articleContent) {
		this.articleContent = articleContent;
	}

	public String getArticlePermalink() {
		return articlePermalink;
	}

	public void setArticlePermalink(String articlePermalink) {
		this.articlePermalink = articlePermalink;
	}

	public char getArticleHadBeenPublished() {
		return articleHadBeenPublished;
	}

	public void setArticleHadBeenPublished(char articleHadBeenPublished) {
		this.articleHadBeenPublished = articleHadBeenPublished;
	}

	public char getArticleIsPublished() {
		return articleIsPublished;
	}

	public void setArticleIsPublished(char articleIsPublished) {
		this.articleIsPublished = articleIsPublished;
	}

	public char getArticlePutTop() {
		return articlePutTop;
	}

	public void setArticlePutTop(char articlePutTop) {
		this.articlePutTop = articlePutTop;
	}

	public Date getArticleCreateDate() {
		return articleCreateDate;
	}

	public void setArticleCreateDate(Date articleCreateDate) {
		this.articleCreateDate = articleCreateDate;
	}

	public Date getArticleUpdateDate() {
		return articleUpdateDate;
	}

	public void setArticleUpdateDate(Date articleUpdateDate) {
		this.articleUpdateDate = articleUpdateDate;
	}

	public double getArticleRandomDouble() {
		return articleRandomDouble;
	}

	public void setArticleRandomDouble(double articleRandomDouble) {
		this.articleRandomDouble = articleRandomDouble;
	}

	public String getArticleSignId() {
		return articleSignId;
	}

	public void setArticleSignId(String articleSignId) {
		this.articleSignId = articleSignId;
	}

	public char getArticleCommentable() {
		return articleCommentable;
	}

	public void setArticleCommentable(char articleCommentable) {
		this.articleCommentable = articleCommentable;
	}

	public String getArticleViewPwd() {
		return articleViewPwd;
	}

	public void setArticleViewPwd(String articleViewPwd) {
		this.articleViewPwd = articleViewPwd;
	}

	public String getArticleEditorType() {
		return articleEditorType;
	}

	public void setArticleEditorType(String articleEditorType) {
		this.articleEditorType = articleEditorType;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
