package com.athaitao.ssm.service;

import java.util.List;

import com.athaitao.ssm.bean.Banner;
import com.athaitao.ssm.bean.Project;

public interface projectService {

	List<Project> selecthot(String hotstatus);

	List<Banner> selectbanneruel();

	void collect(String uid, String pid);

	List<Project> selectcollect(String uid);

	List<Project> selectsearch(String name);

	void follow(String uid, String pid, String price, String status);

	void add(String name, String information, String money, String day, String briefintroduction);

	void delcollect(String pid, String uid);

	Integer selectCount(String uid);

	Double Summoney(String uid);

}
