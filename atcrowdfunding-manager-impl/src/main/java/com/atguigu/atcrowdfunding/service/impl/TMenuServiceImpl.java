package com.atguigu.atcrowdfunding.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atguigu.atcrowdfunding.bean.TMenu;
import com.atguigu.atcrowdfunding.mapper.TMenuMapper;

@Service
public class TMenuServiceImpl implements TMenuService {
	@Autowired
	TMenuMapper menuMapper;

	@Override
	public List<TMenu> listMenuAll() {
		
		
		Logger log = LoggerFactory.getLogger(TMenuServiceImpl.class);
		List<TMenu> menusList=new ArrayList<TMenu>();
		Map<Integer, TMenu> cache=new HashMap<Integer, TMenu>();
		List<TMenu> allList= menuMapper.selectByExample(null);
		for (TMenu tMenu : allList) {
			if (tMenu.getPid()==0) {
				menusList.add(tMenu);
				cache.put(tMenu.getId(), tMenu);
			}
		}
		for (TMenu tMenu : allList) {
			if (tMenu.getPid()!=0) {
				Integer pid=tMenu.getPid();
				TMenu parent=cache.get(pid);
				parent.getChildren().add(tMenu);
			}
		}
		log.debug("菜单：{}",menusList);
		return menusList;
	}

	@Override
	public List<TMenu> listMenuAllTree() {
		return menuMapper.selectByExample(null);
	}

	@Override
	public void saveTMenu(TMenu menu) {
		menuMapper.insertSelective(menu);		
	}

	@Override
	public List<TMenu> getMenuById(Integer id) {
		
		return (List<TMenu>)menuMapper.selectByPrimaryKey(id);
	}
}
