package com.jianye.spring.service;

import java.util.List;

import com.jianye.spring.entity.UserInfoSsh;

public interface UserService {
	UserInfoSsh load(Integer id);

	UserInfoSsh get(Integer id);

	List<UserInfoSsh> findAll();

	void persist(UserInfoSsh entity);

	Integer save(UserInfoSsh entity);

	void saveOrUpdate(UserInfoSsh entity);

	void delete(Integer id);

	void flush();
}
