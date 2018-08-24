package com.dao;


import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;

@Repository
public class BaseDao {
	@Autowired
	private LocalSessionFactoryBean localSessionFactory;
	
	public void setSessionFactoryBase(SessionFactory sessionFactory) {
		this.setSessionFactoryBase(sessionFactory);
	}
	public SessionFactory getSessionFactory() {
		return localSessionFactory.getObject().getCurrentSession().getSessionFactory();
	}
	@Autowired
	private HibernateTemplate hibernateTemplate;
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}
}
