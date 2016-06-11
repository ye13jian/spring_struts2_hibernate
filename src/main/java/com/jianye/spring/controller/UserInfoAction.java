package com.jianye.spring.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Namespace;
import org.springframework.beans.factory.annotation.Autowired;

import com.jianye.spring.entity.UserInfoSsh;
import com.jianye.spring.service.UserService;
import com.jianye.spring.utils.AjaxUtil;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

@Namespace(value="/user")
public class UserInfoAction extends ActionSupport implements ModelDriven<UserInfoSsh>, Preparable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4459352084934659231L;

	private static final Logger logger = Logger.getLogger(UserInfoAction.class);
	
	@Autowired
	private UserService userService;
	
	private Integer id;
	
	private UserInfoSsh userInfo;
	
	private List<UserInfoSsh> userInfos;
	
	@Override
	public String execute() throws Exception {
		logger.info("查询所有用户");
		userInfos = userService.findAll();
		return SUCCESS;
	}
	
	public void detail() {
		String id = ServletActionContext.getRequest().getParameter("id");  
        logger.info("查看用户详情：" + id);  
        userInfo = userService.get(Integer.valueOf(id));  
        AjaxUtil.ajaxJSONResponse(userInfo); 
	}
	
	@Override
	public void prepare() throws Exception {

	}

	@Override
	public UserInfoSsh getModel() {
		if (null != id) {
			userInfo = userService.get(id);
 		} else {
 			userInfo = new UserInfoSsh();
 		}
		return userInfo;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public UserInfoSsh getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(UserInfoSsh userInfo) {
		this.userInfo = userInfo;
	}

	public List<UserInfoSsh> getUserInfos() {
		return userInfos;
	}

	public void setUserInfos(List<UserInfoSsh> userInfos) {
		this.userInfos = userInfos;
	}

}
