package com.atguigu.atcrowdfunding.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.atguigu.atcrowdfunding.bean.TAdmin;
import com.atguigu.atcrowdfunding.bean.TMenu;
import com.atguigu.atcrowdfunding.service.impl.TAdminService;
import com.atguigu.atcrowdfunding.service.impl.TMenuService;
import com.atguigu.atcrowdfunding.util.Const;

@Controller
public class DispatchController {
	
	Logger log=	LoggerFactory.getLogger(DispatchController.class);
	@Autowired
	TMenuService menuService;
	@Autowired
	TAdminService adminService;
	
	@RequestMapping("/index")
	public String index() {
		log.debug("跳转到主页面......");
		return "index";
	}
	
	@RequestMapping("/login")
	public String login() {
		log.debug("跳转到登录页面......");
		return "login";
	}
	
	@RequestMapping("/main")
	public String main(HttpSession session) {
		log.debug("跳转到后台系统main页面......");
		
		if (session==null) {
			return "redirect:/login";
		}
		List<TMenu> menuList=(List<TMenu>)session.getAttribute("menuList");
		
		if (menuList==null) {
			menuList=menuService.listMenuAll();
			session.setAttribute("menuList", menuList);
		}
		
		return "main";
	}
	
	
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		log.debug("退出到登录页面......");
		if (session!=null) {
			session.removeAttribute(Const.LOGIN_ADMIN);
			session.invalidate();
		}
		return "redirect:/index";
	}

	@RequestMapping("/doLogin")
	public String doLogin(String loginacct,String userpswd,HttpSession session,Model model) {
		log.debug("开始登录......");
		log.debug("跳转到主页面");
		log.debug("用户名：{}",loginacct);
		log.debug("密码：{}",userpswd);
		
		Map<String,Object> paramMap=new HashMap<String,Object>();
		paramMap.put("loginacct",loginacct);
		paramMap.put("userpswd",userpswd);
		
		try {
			TAdmin admin=adminService.getTAdminByLogin(paramMap);
			session.setAttribute(Const.LOGIN_ADMIN, admin);
			log.debug("登录成功......");
			//return "main";//避免表单重复提交
			return "redirect:/main";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			log.debug("登录失败={}......",e.getMessage());
			model.addAttribute("message",e.getMessage());
			return "login";
		}
	}
	
}
