package com.athaitao.food.action;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.athaitao.food.bean.User;
import com.athaitao.food.service.UserServiceImp;

public class LoginAction{
	private String successView;
	private String failView;
	
	private ApplicationContext ctx = null;    
	private UserServiceImp adminService=null;	
    public void init() {  
    	ctx = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");  
    	adminService = (UserServiceImp) ctx.getBean("userService"); 
         
    } 
	public String getSuccessView() {
		return successView;
	}
	public void setSuccessView(String successView) {
		this.successView = successView;
	}
	public String getFailView() {
		return failView;
	}
	public void setFailView(String failView) {
		this.failView = failView;
	}
	@RequestMapping("/adminlogin")
	public ModelAndView getAdminLogin(String adminid,String adminpass)
	{
		init();
		Map<String ,Object> model=new HashMap<String,Object>();
		int result=0;
		if("admin".equals(adminid)&&"11".equals(adminpass)){
			
			return new ModelAndView(getSuccessView(),null);
		}else{
			model.put("error", "�Ñ��������벻��ȷ");
			return new ModelAndView(getFailView(),model);
		}		
	}
}
