package com.choujone.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.persistence.Query;

import com.choujone.common.Operation;
import com.choujone.entity.Article;

public class ArticleDao extends SDao {

	@SuppressWarnings("unchecked")
	public List<Article> getArticleList() {
		this.init();
		List<Article> articleList = new ArrayList<Article>();
		Query query = manager
				.createQuery("select arti from Article arti order by oId desc");
		// query.setParameter(1, 1);
		// List list=query.getResultList();
		articleList = (List<Article>) query.getResultList();// 单结果查询 必须有结果
		return articleList;
	}

	public boolean operationArticle(Operation operation, Article article) {
		boolean flag = false;
		this.init();
		Date dt = new Date(System.currentTimeMillis());
		if (operation.equals(Operation.add)) {// 新增
			try {
				manager.getTransaction().begin();// -->开始事务
				article.setoId(dt.getTime() + "");
				article.setArticleCreateDate(dt);// 创建时间
				article.setArticleUpdateDate(dt);// 修改时间
				manager.persist(article);// new person 是新建状态
				manager.getTransaction().commit();
				flag = true;
			} catch (Exception e) {
				flag = false;
			}
		}
		close();
		return flag;
	}

	public boolean operationArticle(Operation operation,
			List<Article> articleList) {
		boolean flag = false;
		this.init();
		Date dt = new Date();
		if (operation.equals(Operation.add)) {// 新增
			try {
				manager.getTransaction().begin();// -->开始事务
				int index=1;
				for (Article article : articleList) {
					long id = System.currentTimeMillis();
					article.setoId(id +""+index);
					System.out.println(article.getoId());
					article.setArticleContent(article.getArticleContent().replaceAll("www.521xunlei.com", "www.choujone.com"));
					article.setArticleCommentCount(0);
					article.setArticleCommentable('0');
					article.setArticleHadBeenPublished('1');
					article.setArticleIsPublished('1');
					article.setArticlePutTop('0');
					article.setArticleRandomDouble(0);
					article.setArticleViewCount(100);
					article.setArticleCreateDate(dt);// 创建时间
					article.setArticleUpdateDate(dt);// 修改时间
					manager.persist(article);// new person 是新建状态
					index++;
				}
				// manager.flush();
				// manager.clear();
				manager.getTransaction().commit();
				flag = true;
			} catch (Exception e) {
				e.printStackTrace();
				flag = false;
			}
		}
		close();
		return flag;
	}
}
