package com.atguigu.atcrowdfunding.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.varia.FallbackErrorHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.WebRequest;

import com.atguigu.atcrowdfunding.bean.TAdmin;
import com.atguigu.atcrowdfunding.service.impl.TAdminService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Controller
public class TAdminServiceController {

	
	Logger log= LoggerFactory.getLogger(TAdminServiceController.class);
	@Autowired
	TAdminService adminService;
	
	@RequestMapping("/admin/index")
	public String index(@RequestParam(value="pageNum",required=false,defaultValue="1") Integer pageNum,
						@RequestParam(value="pageSize",required=false,defaultValue="10") Integer pageSize,
						Model model,
						@RequestParam(value="condition",required=false,defaultValue="")String condition) {
		
		PageHelper.startPage(pageNum,pageSize);
		
		Map<String, Object> paramMap=new HashMap<String, Object>();
		
		paramMap.put("condition", condition);
		
		log.debug("条件{}",condition);
		
		PageInfo<TAdmin> page = adminService.listAdminPage(paramMap);
		
		model.addAttribute("page",page);
		log.debug("分页信息:{}",page);
		return "admin/index";
	}
	
	@RequestMapping("/admin/toadd")
	public String toadd() {
		return "/admin/toadd";
	}
	
	@RequestMapping("/admin/doDeleteBatch")
	public String doDeleteBatch(String ids,Integer pageNum) {
		List<Integer> idList=new ArrayList<Integer>();
		
		String[] spilt=ids.split(",");
		for (String idStr : spilt) {
			int id=Integer.parseInt(idStr);
			idList.add(id);
		}
		adminService.deleteBatch(idList);
		return "redirect:/admin/index?pageNum="+pageNum;
	}
	
	@RequestMapping("/admin/doadd")
	public String doadd(TAdmin admin) {
		adminService.saveTAdmin(admin);
		return "redirect:/admin/index?pageNum="+Integer.MAX_VALUE;
	}
	
	@RequestMapping("/admin/toUpdate")
	public String toUpdate(Integer id,Model model) {
		log.debug("当前id{}",id);
		TAdmin admin=adminService.getTAdminByid(id);
		model.addAttribute("admin", admin);
		log.debug("当前用户信息：{}",admin.toString());
		return "/admin/toUpdate";
	}
	
	
	
	@RequestMapping("/admin/doupdate")
	public String doupdate(TAdmin admin,Integer pageNum) {
		log.debug("要修改的信息：{}",admin);
		adminService.updateTAdmin(admin);
		return "redirect:/admin/index/?pageNum="+pageNum;
	}
	
	
	@RequestMapping("/admin/dodelect")
	public String dodelect(Integer id,Integer pageNum) {
		adminService.delectTAdmin(id);
		return "redirect:/admin/index/?pageNum="+pageNum;
	}
}

