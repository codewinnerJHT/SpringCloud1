package com.atguigu.atcrowdfunding.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.log;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.druid.support.logging.Log;
import com.alibaba.fastjson.JSONObject;
import com.atguigu.atcrowdfunding.bean.TMenu;
import com.atguigu.atcrowdfunding.service.impl.TMenuService;

@Controller
public class TMenuController {
	
	Logger Log=LoggerFactory.getLogger(TMenuController.class);
	
	@Autowired
	TMenuService menuService;
	
	@RequestMapping("/menu/index")
	public String index() {
		return "/menu/index";
	}
	
	@ResponseBody
	@RequestMapping("/menu/loadTree")
	public List<TMenu> loadTree() {
		return menuService.listMenuAllTree();
	}
	
	@ResponseBody
	@RequestMapping("/menu/doAdd")
	public String doAdd(TMenu menu) {
		Log.debug("菜单数据：{}",menu);
		menuService.saveTMenu(menu);
		return "ok";
	}
	@ResponseBody
	@RequestMapping("/menu/getMenuById")
	public List<TMenu> getMenuById(Integer id) {
		return menuService.getMenuById(id);
	}
	
	@ResponseBody
	@RequestMapping(value="/menu/getMenu",produces = "text/html;charset=utf-8")
	public String getMenu(Integer id) {
		Log.debug("@@@@@@@@@@@@@@@@@@@@@@@{}",id);
		Log.debug("22222222222222222222222222{}",menuService.listMenuAllTree());
		String aString=JSONObject.toJSONString(menuService.listMenuAllTree());
		Log.debug("1111111111111111111111111111{}",aString);
		return aString;
	}
	@ResponseBody
	@RequestMapping("/getjson")
	public Object getjson() {
		Log.debug("3333333333333333333333333333333333333333333333");
		return new Object().toString();
	}
}
