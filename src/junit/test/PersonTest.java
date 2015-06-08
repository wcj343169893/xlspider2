package junit.test;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.junit.BeforeClass;
import org.junit.Test;

import com.pojo.Gender;
import com.pojo.Person;

public class PersonTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Test
	public void save() {
		EntityManagerFactory factory=Persistence.createEntityManagerFactory("myJPA");//-->sessionFactory
		EntityManager manager=factory.createEntityManager(); //-->session
		manager.getTransaction().begin();//-->开始事务
		Person pr = new Person();
		pr.setName("王宝强他哥");
		pr.setGender(Gender.Man);
		manager.persist(pr);//new person 是新建状态
		
		manager.getTransaction().commit();
		manager.close();
		factory.close();
	}
	
	
	@Test
	public void getPerson1() {
		EntityManagerFactory factory=Persistence.createEntityManagerFactory("myJPA");//-->sessionFactory
		EntityManager manager=factory.createEntityManager(); //-->session
		
		Person person=manager.find(Person.class, 1);
		System.out.println(person.getName());
		manager.close();
		factory.close();
	}
	
	@Test
	public void getPerson2() {
		EntityManagerFactory factory=Persistence.createEntityManagerFactory("myJPA");//-->sessionFactory
		EntityManager manager=factory.createEntityManager(); //-->session
		
		Person person=manager.getReference(Person.class, 1);//load延迟加载
		System.out.println(person.getName());
		manager.close();
		factory.close();
	}
	
	//new 新建
	//托管
	//游离（脱管）
	//删除
	@Test
	public void update1() {
		EntityManagerFactory factory=Persistence.createEntityManagerFactory("myJPA");//-->sessionFactory
		EntityManager manager=factory.createEntityManager(); //-->session
		manager.getTransaction().begin();//-->开始事务
		Person person=manager.find(Person.class, 1);//person 属于托管状态
		person.setName("哈哈1");
		person.setBrithday(new Date());
//		manager.flush();
		manager.getTransaction().commit();
		manager.close();
		factory.close();
	}
	
	@Test
	public void update2() {
		EntityManagerFactory factory=Persistence.createEntityManagerFactory("myJPA");//-->sessionFactory
		EntityManager manager=factory.createEntityManager(); //-->session
		manager.getTransaction().begin();//-->开始事务
//		Person person=manager.find(Person.class, 1);//person 属于托管状态
//		
//		manager.clear();//把实体管理器中的所有实体转成游离态
		
		Person person=new Person();
		person.setId(1);
		person.setName("哈哈");
		manager.merge(person);
		manager.getTransaction().commit();
		manager.close();
		factory.close();
	}
	
	@Test
	public void delete() {
		EntityManagerFactory factory=Persistence.createEntityManagerFactory("myJPA");//-->sessionFactory
		EntityManager manager=factory.createEntityManager(); //-->session
		manager.getTransaction().begin();//-->开始事务
		
		Person person=manager.find(Person.class, 2);
		manager.remove(person);//托管状态下的删除
		manager.getTransaction().commit();
		manager.close();
		factory.close();
	}
	
	@Test
	public void delete2() {
		EntityManagerFactory factory=Persistence.createEntityManagerFactory("myJPA");//-->sessionFactory
		EntityManager manager=factory.createEntityManager(); //-->session
		manager.getTransaction().begin();//-->开始事务
		
		Person person=new Person();
		person.setId(1);
//		manager.remove(person);//游离状态下的删除
		
		manager.getTransaction().commit();
		manager.close();
		factory.close();
	}
	@Test
	public void query() {
		EntityManagerFactory factory=Persistence.createEntityManagerFactory("myJPA");//-->sessionFactory
		EntityManager manager=factory.createEntityManager(); //-->session
		Query query= manager.createQuery("select p from Person p where p.id=?1");
		query.setParameter(1, 1);
//		List list=query.getResultList();
		Person person=(Person)query.getSingleResult();//单结果查询 必须有结果
		System.out.println(person.getName());
		manager.close();
		factory.close();
	}
	
	@Test
	public void queryDelete() {
		EntityManagerFactory factory=Persistence.createEntityManagerFactory("myJPA");//-->sessionFactory
		EntityManager manager=factory.createEntityManager(); //-->session
		manager.getTransaction().begin();//-->开始事务
		
		Query query= manager.createQuery("delete from Person p where p.name=:name");
		query.setParameter("name", "你好JPA");
		int i=query.executeUpdate();
		System.out.println(i);
		manager.getTransaction().commit();
		manager.close();
		factory.close();
	}
	
	@Test
	public void queryUpdate() {
		EntityManagerFactory factory=Persistence.createEntityManagerFactory("myJPA");//-->sessionFactory
		EntityManager manager=factory.createEntityManager(); //-->session
		manager.getTransaction().begin();//-->开始事务
		
		Query query= manager.createQuery("update Person p set p.name=?1 where p.id=?2");
		query.setParameter(1, "基本了解");
		query.setParameter(2, 6);
		int i=query.executeUpdate();
		System.out.println(i);
		manager.getTransaction().commit();
		manager.close();
		factory.close();
	}

}
