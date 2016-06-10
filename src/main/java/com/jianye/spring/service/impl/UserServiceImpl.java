package com.jianye.spring.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jianye.spring.dao.UserDao;
import com.jianye.spring.entity.UserInfoSsh;
import com.jianye.spring.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao userDao;

	@Override
	public UserInfoSsh load(Integer id) {
		return userDao.load(id);
	}

	@Override
	public UserInfoSsh get(Integer id) {
		return userDao.get(id);
	}

	@Override
	public List<UserInfoSsh> findAll() {
		return userDao.findAll();
	}

	@Override
	public void persist(UserInfoSsh entity) {
		userDao.persist(entity);
	}

	@Override
	public Integer save(UserInfoSsh entity) {
		return userDao.save(entity);
	}

	@Override
	public void saveOrUpdate(UserInfoSsh entity) {
		userDao.saveOrUpdate(entity);
	}

	@Override
	public void delete(Integer id) {
		userDao.delete(id);
	}

	@Override
	public void flush() {
		userDao.flush();
	}

}
