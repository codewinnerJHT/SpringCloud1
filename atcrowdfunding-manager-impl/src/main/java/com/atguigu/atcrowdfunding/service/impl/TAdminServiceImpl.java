package com.atguigu.atcrowdfunding.service.impl;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atguigu.atcrowdfunding.bean.TAdmin;
import com.atguigu.atcrowdfunding.bean.TAdminExample;
import com.atguigu.atcrowdfunding.bean.TAdminExample.Criteria;
import com.atguigu.atcrowdfunding.exception.LoginException;
import com.atguigu.atcrowdfunding.mapper.TAdminMapper;
import com.atguigu.atcrowdfunding.util.AppDateUtils;
import com.atguigu.atcrowdfunding.util.Const;
import com.atguigu.atcrowdfunding.util.MD5Util;
import com.github.pagehelper.PageInfo;

@Service
public class TAdminServiceImpl  implements TAdminService{
	
	@Autowired
	TAdminMapper adminMapper;
	
	Logger log=LoggerFactory.getLogger(TAdminServiceImpl.class);
	
	@Override
	public TAdmin getTAdminByLogin(Map<String, Object> paramMap){
		
//		String loginacct=(String) paramMap.get("loginacct");
//		String userpswd=(String) paramMap.get("userpswd");
//		TAdminExample example=new TAdminExample();
//		example.createCriteria().andLoginacctEqualTo(loginacct);
//		List<TAdmin> list = adminMapper.selectByExample(example);		
//		if (list!=null && list.size()==1) {
//			TAdmin admin=list.get(0);
//			if (admin.getUserpswd().equals(userpswd)) {
//				return admin;
//			}else {
//				throw new LoginException(Const.LOGIN_USERPSWD_ERROR);
//			}
//		}else {
//			throw new LoginException(Const.LOGIN_LOGINACCT_ERROR);
//		}
//
//	}			
		String loginacct=(String) paramMap.get("loginacct");
		String userpswd=(String) paramMap.get("userpswd");
		TAdminExample example=new TAdminExample();
		example.createCriteria().andLoginacctEqualTo(loginacct);
		List<TAdmin> list = adminMapper.selectByExample(example);	
		if (list==null || list.size()==0) {
			throw new LoginException(Const.LOGIN_LOGINACCT_ERROR);
		}
		TAdmin admin=list.get(0);
		if (!admin.getUserpswd().equals(MD5Util.digest(userpswd))) {
			throw new LoginException(Const.LOGIN_USERPSWD_ERROR);
		}
		return admin;
	}

	@Override
	public PageInfo<TAdmin> listAdminPage(Map<String, Object> paramMap) {
		TAdminExample example=new TAdminExample();
		String condition=(String)paramMap.get("condition");
		if (!"".equals(condition)) {
			example.createCriteria().andLoginacctLike("%"+condition+"%");
			
			Criteria criteria2=example.createCriteria();
			criteria2.andUsernameLike("%"+condition+"%");
			
			Criteria criteria3=example.createCriteria();
			criteria3.andEmailLike("%"+condition+"%");
			
			example.or(criteria2);
			example.or(criteria3);
			
		}
		List<TAdmin> list=adminMapper.selectByExample(example);
		PageInfo<TAdmin> page=new PageInfo<TAdmin>(list,5);
		return page;
	}

	@Override
	public void saveTAdmin(TAdmin admin) {
		admin.setUserpswd(MD5Util.digest(Const.DEFAULT_USERPSWD));
		admin.setCreatetime(AppDateUtils.getFormatTime());
		adminMapper.insertSelective(admin);
		
	}

	@Override
	public TAdmin getTAdminByid(Integer id) {
		return adminMapper.selectByPrimaryKey(id);
	}

	@Override
	public void updateTAdmin(TAdmin admin) {

		int updateByPrimaryKeySelective = adminMapper.updateByPrimaryKeySelective(admin);
	}

	@Override
	public void delectTAdmin(Integer id) {
		adminMapper.deleteByPrimaryKey(id);
		
	}

	@Override
	public void deleteBatch(List<Integer> idList) {
		adminMapper.deleteBatch(idList);
		
	}


}
