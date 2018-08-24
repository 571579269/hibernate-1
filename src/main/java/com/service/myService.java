package com.service;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Service;

import com.bean.Student;
import com.dao.BaseDao;

@Transactional
@Service
public class myService {
	private final Logger LOG = LoggerFactory.getLogger(myService.class);
	@Autowired
	public BaseDao dao;
	public void save(Student student) {
		dao.getSessionFactory().openSession().save(student);
	}
	public Student findOne(Integer id) {
		HibernateTemplate hibernateTemplate = dao.getHibernateTemplate();
        Student student = hibernateTemplate.get(Student.class, id);  
        System.out.println(student);  
        return student;
		}   
	 
	}
