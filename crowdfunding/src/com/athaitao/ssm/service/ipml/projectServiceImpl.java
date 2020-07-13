package com.athaitao.ssm.service.ipml;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.athaitao.ssm.bean.Banner;
import com.athaitao.ssm.bean.Project;
import com.athaitao.ssm.mapper.projectMapper;
import com.athaitao.ssm.service.projectService;

@Service
public class projectServiceImpl implements projectService{
	
	@Autowired
	private projectMapper projectMapper;

	@Override
	public List<Project> selecthot(String hotstatus) {
		return projectMapper.selecthot(hotstatus);
	}

	@Override
	public List<Banner> selectbanneruel() {
		return projectMapper.selectbanneruel();
	}

	@Override
	public void collect(String uid, String pid) {
		projectMapper.collect(uid,pid);
		
	}

	@Override
	public List<Project> selectcollect(String uid) {
		return projectMapper.selectcollect(uid);
	}

	@Override
	public List<Project> selectsearch(String name) {
		// TODO Auto-generated method stub
		return projectMapper.selectsearch(name);
	}

	@Override
	public void follow(String uid, String pid, String price, String status) {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
        String createdate=df.format(new Date()).toString();// new Date()为获取当前系统时间
		String orderNum=UUID.randomUUID().toString();
		projectMapper.follow(uid,pid,price,status,createdate,orderNum);
//		projectMapper.follow(uid,pid,price,status);
	}

	@Override
	public void add(String name, String information, String money, String day, String briefintroduction) {
		projectMapper.add(name,information,money,day,briefintroduction);
		
	}

	@Override
	public void delcollect(String pid, String uid) {
		projectMapper.delcollect(pid,uid);
		
	}

	@Override
	public Integer selectCount(String uid) {
		
		return projectMapper.selectCount(uid);
	}

	@Override
	public Double Summoney(String uid) {
		// TODO Auto-generated method stub
		return projectMapper.Summoney(uid);
	}



}
