package com.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.dao.UserDao;
import com.demo.entity.AcctUser;

@Service("userService")
public class UserService {
	@Autowired
	private UserDao userDao;

	public AcctUser load(String id) {
		return userDao.load(id);
	}

	public AcctUser get(String id) {
		return userDao.get(id);
	}

	public List<AcctUser> findAll() {
		return userDao.findAll();
	}

	public void persist(AcctUser entity) {
		userDao.persist(entity);
	}

	public String save(AcctUser entity) {
		return userDao.save(entity);
	}

	public void saveOrUpdate(AcctUser entity) {
		userDao.saveOrUpdate(entity);
	}

	public void delete(String id) {
		userDao.delete(id);
	}

	public void flush() {
		userDao.flush();
	}

}
