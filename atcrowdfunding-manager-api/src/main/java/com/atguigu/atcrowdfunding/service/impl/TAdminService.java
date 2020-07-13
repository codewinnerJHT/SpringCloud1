package com.atguigu.atcrowdfunding.service.impl;

import java.util.List;
import java.util.Map;

import com.atguigu.atcrowdfunding.bean.TAdmin;
import com.github.pagehelper.PageInfo;

public interface TAdminService {

	TAdmin getTAdminByLogin(Map<String, Object> paramMap);

	PageInfo<TAdmin> listAdminPage(Map<String, Object> paramMap);

	void saveTAdmin(TAdmin admin);

	TAdmin getTAdminByid(Integer id);
	void updateTAdmin(TAdmin admin);

	void delectTAdmin(Integer id);

	void deleteBatch(List<Integer> idList);


}
