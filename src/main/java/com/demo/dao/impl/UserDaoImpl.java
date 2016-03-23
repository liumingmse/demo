package com.demo.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.demo.dao.UserDao;
import com.demo.entity.AcctUser;


@Repository("userDao")
public class UserDaoImpl implements UserDao {

	@Autowired
	private SessionFactory sessionFactory;

	private Session getCurrentSession() {
		return this.sessionFactory.getCurrentSession();
	}

	
	public AcctUser load(String id) {
		return (AcctUser) this.getCurrentSession().load(AcctUser.class, id);
	}
	
	
	public AcctUser get(String id) {
		return (AcctUser) this.getCurrentSession().get(AcctUser.class, id);
	}

	@SuppressWarnings("unchecked")
	public List<AcctUser> findAll() {
		List<AcctUser> acctUsers = this.getCurrentSession().createQuery("from AcctUser").setCacheable(true).list();
		return acctUsers;
	}

	
	public void persist(AcctUser entity) {
		this.getCurrentSession().persist(entity);
	}

	
	public String save(AcctUser entity) {
		return (String) this.getCurrentSession().save(entity);
	}

	
	public void saveOrUpdate(AcctUser entity) {
		this.getCurrentSession().saveOrUpdate(entity);
	}

	
	public void delete(String id) {
		AcctUser entity = this.load(id);
		this.getCurrentSession().delete(entity);
	}

	
	public void flush() {
		this.getCurrentSession().flush();

	}

}
