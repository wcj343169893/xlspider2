package com.choujone.util;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import com.choujone.common.WebPage;
import com.choujone.entity.Spider;

public class SpiderThread extends Thread {
	Spider spider;//采集配置
	
	public void run() {
		Timer timer=new Timer();
		/*timer.schedule(new TimerTask() {
			
			public void run() {
				System.out.println("开始运行任务");
				SpiderUtil util=new SpiderUtil();
				List<WebPage> webpages=util.run(spider);
				for (WebPage webPage : webpages) {
					System.out.println(webPage.getTitle());
				}
			}
		}, Tools.changeTime(spider.getSpider_start()), 1000);*/
		System.out.println("开始运行任务");
		SpiderUtil util=new SpiderUtil();
		List<WebPage> webpages=util.run(spider);
		for (WebPage webPage : webpages) {
			System.out.println(webPage.getTitle());
		}
	}

	public Spider getSpider() {
		return spider;
	}

	public void setSpider(Spider spider) {
		this.spider = spider;
	}

}
