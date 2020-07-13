package com.atguigu.atcrowdfunding.service.impl;

import java.util.List;

import com.atguigu.atcrowdfunding.bean.TMenu;

public interface TMenuService {

	List<TMenu> listMenuAll();

	
	List<TMenu> listMenuAllTree();


	void saveTMenu(TMenu menu);


	List<TMenu> getMenuById(Integer id);
}
