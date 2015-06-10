package com.choujone.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class SDao {
	EntityManagerFactory factory;
	EntityManager manager;

	public void init() {
		factory = Persistence.createEntityManagerFactory("myJPA");
		manager = factory.createEntityManager(); // -->session
	}
	public void close(){
		manager.close();
		factory.close();
	}

}
