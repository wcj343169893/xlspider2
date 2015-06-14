package com.choujone.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.choujone.common.Operation;
import com.choujone.common.Pages;
import com.choujone.entity.Spider;
import com.choujone.util.Tools;
import com.pojo.Person;

public class SpiderDao extends SDao {

	String key = "";// 缓存key
	String page_key = "";// 分页

	/**
	 * 增加，删除，修改
	 * 
	 * @param operation
	 * @param blog
	 * @return
	 */
	public boolean operationSpider(Operation operation, Spider spider) {
		boolean flag = false;
		Spider b = null;
		this.init();
		Date dt = new Date(System.currentTimeMillis());
		if (operation.equals(Operation.add)) {// 新增
			try {
				manager.getTransaction().begin();//-->开始事务
				// spider.setId(dt.getTime());
				spider.setSdTime(dt);// 创建时间
				spider.setEdTime(dt);// 修改时间
				manager.persist(spider);// new person 是新建状态
				manager.getTransaction().commit();
				flag = true;
			} catch (Exception e) {
				flag = false;
			}
			b = spider;
		} else if (operation.equals(Operation.delete)) {// 隐藏
			try {
				b = this.getSpiderById(spider.getId());
				b.setStart(0);
				b.setIsVisible(1);
				b.setEdTime(dt);// 修改时间
				flag = true;
			} catch (Exception e) {
				flag = false;
			}
		} else if (operation.equals(Operation.modify)) {// 修改
			try {
				b = this.getSpiderById(spider.getId());
				b.setEdTime(dt);// 修改时间
				b.setName(spider.getName());
				b.setCharset(spider.getCharset());
				b.setClear_content_reg(spider.getClear_content_reg());
				b.setCount(spider.getCount());
				b.setIsVisible(spider.getIsVisible());
				b.setSpider_start(spider.getSpider_start());
				b.setStart(spider.getStart());
				b.setSumCount(spider.getSumCount());
				b.setTids(spider.getTids());
				b.setWeb_content_begin(spider.getWeb_content_begin());
				b.setWeb_content_end(spider.getWeb_content_end());
				b.setWeb_content_title(spider.getWeb_content_title());
				b.setWeb_host(spider.getWeb_host());
				b.setWeb_list_begin(spider.getWeb_list_begin());
				b.setWeb_list_end(spider.getWeb_list_end());
				b.setWeb_list_url(spider.getWeb_list_url());
				flag = true;
			} catch (Exception e) {
				flag = false;
			}
		}
		key = "adDao_getSpiderByPages_1";
		close();
		return flag;
	}

	/**
	 * 分页查询
	 * 
	 * @param pages
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Spider> getSpiderByPages() {
		List<Spider> spiders = new ArrayList<Spider>();
		this.init();
		try {
			Query query = manager.createQuery("SELECT sp FROM Spider sp");
			// query.setParameter(1, 1);
			spiders = (List<Spider>) query.getResultList();// 单结果查询 必须有结果
		} catch (Exception e) {
			e.printStackTrace();
		}
		return spiders;
	}

	/**
	 * 根据编号查询采集任务
	 * 
	 * @param id
	 * @return
	 */
	public Spider getSpiderById(int id) {
		Spider spider = null;
		this.init();
		try {
			spider = manager.find(Spider.class, id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return spider;
	}

}
