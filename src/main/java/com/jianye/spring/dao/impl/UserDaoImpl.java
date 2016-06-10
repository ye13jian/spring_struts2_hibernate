package com.jianye.spring.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jianye.spring.dao.UserDao;
import com.jianye.spring.entity.UserInfoSsh;

@Repository("userDao")
public class UserDaoImpl implements UserDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	private Session getCurrentSession() {
		return this.sessionFactory.getCurrentSession();
	}

	@Override
	public UserInfoSsh load(Integer id) {
		return (UserInfoSsh) this.getCurrentSession().load(UserInfoSsh.class, id);
	}

	@Override
	public UserInfoSsh get(Integer id) {
		return (UserInfoSsh) this.getCurrentSession().get(UserInfoSsh.class, id);
	}

	@Override
	public List<UserInfoSsh> findAll() {
		List<UserInfoSsh> userInfos = this.getCurrentSession().createQuery("from UserInfoSsh")
				.list();
		return userInfos;
	}

	@Override
	public void persist(UserInfoSsh entity) {
		this.getCurrentSession().persist(entity);
	}

	@Override
	public Integer save(UserInfoSsh entity) {
		return (Integer) this.getCurrentSession().save(entity);
	}

	@Override
	public void saveOrUpdate(UserInfoSsh entity) {
		this.getCurrentSession().saveOrUpdate(entity);

	}

	@Override
	public void delete(Integer id) {
		UserInfoSsh userInfo = this.load(id);
		this.getCurrentSession().delete(userInfo);
	}

	@Override
	public void flush() {
		this.getCurrentSession().flush();
	}

}
