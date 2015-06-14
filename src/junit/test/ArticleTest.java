package junit.test;

import java.util.Random;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.Test;

import com.choujone.entity.Article;

public class ArticleTest {
	@Test
	public void save() {
		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("myJPA");// -->sessionFactory
		EntityManager manager = factory.createEntityManager(); // -->session
		manager.getTransaction().begin();// -->开始事务
		Article article = new Article();
		long id=System.currentTimeMillis();
		Random random = new Random(id);
		article.setoId(id + "" + random.nextInt());
		article.setArticleTitle("标题");
		article.setArticleContent("内容太");

		manager.persist(article);// new person 是新建状态

		manager.getTransaction().commit();
		manager.close();
		factory.close();
	}
}
