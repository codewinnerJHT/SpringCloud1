package com.atguigu.atcrowdfunding.controller;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.atguigu.atcrowdfunding.bean.TRole;
import com.atguigu.atcrowdfunding.service.impl.TRoleService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;


@Controller
public class TRoleController {
	
	
	Logger log=LoggerFactory.getLogger(TRoleController.class);
	@Autowired
	TRoleService roleService;
	@RequestMapping("/role/index")
	public String index() {
		
		return "/role/index";
	}
	/**
	 * 启用消息转化器：httpMessageConverter
	 * 如果返回为对象（Entity Class，List，Map）
	 * 
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/role/loadData")
	public PageInfo<TRole> loadData(@RequestParam(value="pageNum",required=false,defaultValue="1") Integer pageNum,
									@RequestParam(value="pageSize",required=false,defaultValue="2") Integer pageSize,
									@RequestParam(value="condition",required=false,defaultValue="") String condition) {
		
		PageHelper.startPage(pageNum,pageSize);
		Map<String, Object> paramMap=new HashMap<String, Object>();
		
		paramMap.put("condition", condition);
		PageInfo<TRole> page=roleService.listRolePage(paramMap);
		log.debug("page信息"+page);
		return page;
	}
	
	@ResponseBody
	@RequestMapping("/role/doAdd")
	public String doAdd(TRole role) {
		roleService.saveTRole(role);
		return "ok";
	}

	@ResponseBody
	@RequestMapping("/role/getRoleById")
	public TRole doAdd(Integer id) {
		TRole role= roleService.getRoleById(id);
		return role;
	}
	
	@ResponseBody
	@RequestMapping("/role/doUpdate")
	public String doUpdate(TRole role) {
		roleService.doUpdate(role);
		return "ok";
	}
	@ResponseBody
	@RequestMapping("/role/doDelete")
	public String doDelete(Integer id) {
		roleService.doDelete(id);
		return "ok";
	}
}
