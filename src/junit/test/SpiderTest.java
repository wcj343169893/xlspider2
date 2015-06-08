package junit.test;

import static org.junit.Assert.fail;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.Test;

import com.choujone.entity.Spider;

public class SpiderTest {

	@Test
	public void test() {
		fail("Not yet implemented");
	}
	@Test
	public void save() {
		EntityManagerFactory factory=Persistence.createEntityManagerFactory("myJPA");//-->sessionFactory
		EntityManager manager=factory.createEntityManager(); //-->session
		manager.getTransaction().begin();//-->开始事务
		Spider sp= new Spider();
		sp.setName("第一次采集测试");
		
		manager.persist(sp);//new person 是新建状态
		
		manager.getTransaction().commit();
		manager.close();
		factory.close();
	}
}
