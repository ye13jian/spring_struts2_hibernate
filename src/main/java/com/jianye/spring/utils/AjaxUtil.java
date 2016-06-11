package com.jianye.spring.utils;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.apache.struts2.ServletActionContext;

import com.alibaba.fastjson.JSON;
import com.jianye.spring.entity.UserInfoSsh;

public class AjaxUtil {

	/**
	 * 返回JSON数据
	 * @param userInfo
	 */
	public static void ajaxJSONResponse(UserInfoSsh userInfo) {
		HttpServletResponse response=ServletActionContext.getResponse();  
	    /* 
	     * 在调用getWriter之前未设置编码(既调用setContentType或者setCharacterEncoding方法设置编码), 
	     * HttpServletResponse则会返回一个用默认的编码(既ISO-8859-1)编码的PrintWriter实例。这样就会 
	     * 造成中文乱码。而且设置编码时必须在调用getWriter之前设置,不然是无效的。 
	     * */  
	    response.setContentType("text/html;charset=utf-8");  
	    //response.setCharacterEncoding("UTF-8");  
	    PrintWriter out = null;
		try {
			out = response.getWriter();
			//JSON在传递过程中是普通字符串形式传递的，这里简单拼接一个做测试  
			String jsonString = JSON.toJSONString(userInfo);  
		    out.println(jsonString);  
		    out.flush();  
		    out.close();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			IOUtils.closeQuietly(out);
		}
	}

}
