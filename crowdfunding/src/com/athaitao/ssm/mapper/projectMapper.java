package com.athaitao.ssm.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.athaitao.ssm.bean.Banner;
import com.athaitao.ssm.bean.Project;

public interface projectMapper {
	//查询热门商品
	List<Project> selecthot(@Param("hotstatus")String hotstatus);
	//查询bannerurl
	List<Banner> selectbanneruel();
	//收藏接口
	void collect(@Param("uid")String uid,@Param("pid") String pid);
	
	//查询收藏接口
	List<Project> selectcollect(@Param("uid")String uid);
	
	//查询项目接口
	List<Project> selectsearch(@Param("name")String name);
	//跟投接口
	void follow(@Param("uid")String uid,@Param("pid") String pid,@Param("price") String price,@Param("status") String status,@Param("createdate")String createdate,@Param("orderNum")String orderNum);
//	void follow(@Param("uid")String uid,@Param("pid") String pid,@Param("price") String price,@Param("status") String status);
	void add(@Param("name")String name,@Param("information") String information,@Param("money") String money,@Param("day") String day,@Param("briefintroduction") String briefintroduction);
	void delcollect(@Param("pid")String pid, @Param("uid")String uid);
	
	Integer selectCount(@Param("uid")String uid);
	Double Summoney(@Param("uid")String uid);
}
