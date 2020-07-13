package com.atguigu.atcrowdfunding.service.impl;

import java.util.List;
import java.util.Map;

import com.alibaba.druid.support.logging.Log;
import com.atguigu.atcrowdfunding.bean.TRole;
import com.atguigu.atcrowdfunding.bean.TRoleExample;
import com.atguigu.atcrowdfunding.mapper.TRoleMapper;
import com.atguigu.atcrowdfunding.util.StringUtil;
import com.github.pagehelper.PageInfo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TRoleServiceImpl implements TRoleService{
	
	Logger log=LoggerFactory.getLogger(TRoleServiceImpl.class);
	
	@Autowired
	TRoleMapper roleMapper;

	@Override
	public PageInfo<TRole> listRolePage(Map<String, Object> paramMap) {
		
		String condition=(String)paramMap.get("condition");
		List<TRole> list=null;
		if (StringUtil.isEmpty(condition)) {
			list=roleMapper.selectByExample(null);
		}else {
			TRoleExample example=new TRoleExample();
			example.createCriteria().andNameLike("%"+condition+"%");
			list=roleMapper.selectByExample(example);
		}	
		PageInfo<TRole> listRole=new PageInfo<>(list,5);
		return listRole;
	}

	@Override
	public void saveTRole(TRole role) {
		int insertSelective = roleMapper.insert(role);
		log.debug("添加角色的返回结果：{}",insertSelective);
		
	}

	@Override
	public TRole getRoleById(Integer id) {
		return roleMapper.selectByPrimaryKey(id);
	}

	@Override
	public void doUpdate(TRole role) {
		roleMapper.updateByPrimaryKeySelective(role);
		
	}

	@Override
	public void doDelete(Integer id) {
		roleMapper.deleteByPrimaryKey(id);
		
	}


}

