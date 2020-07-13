package com.athaitao.food.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.athaitao.food.bean.Collection;

public class CollectServiceImp{
	private JdbcTemplate jdbcTemplate;
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
		}
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
		}
	

	private static final class FoodMapper implements RowMapper{		

		public Collection mapRow(ResultSet rs, int rowNum) throws SQLException {
			Collection collection=new Collection();
			collection.setCollect_id(rs.getInt("collect_id"));						
			int flag=rs.getInt("flag");
			if(flag==1)
			{
				collection.setFoodname(rs.getString("foodname"));
				collection.setFood_id(rs.getInt("food_id"));
				collection.setShop_id(rs.getInt("shop_id"));
				collection.setPic(rs.getString("pic"));
				collection.setPrice(rs.getDouble("price"));
			}
			else
			{
				collection.setShopname(rs.getString("shopname"));
				collection.setShop_id(rs.getInt("shop_id"));
				collection.setPic(rs.getString("pic"));
				collection.setAddress(rs.getString("address"));
			}
			collection.setUser_id(rs.getInt("user_id"));
			collection.setUsername(rs.getString("username"));
			collection.setFlag(flag);
			
			return collection;
		}
		
	
	}

	public List<Collection> getAllUserCollection(int user_id, int flag) {
		List<Collection> list=new ArrayList<Collection>();
		if(flag==0)
		{
			String sql="select u.user_id,u.username,s.*,uc.collect_id,uc.flag from user_collect uc,user u,shop s where u.user_id=uc.user_id and s.shop_id=uc.shop_id "
					+ "and u.user_id=? and flag=?";
			list= jdbcTemplate.query(sql, new Object[]{user_id,flag},new FoodMapper());
			
		}
		else
		{
			String sql="select u.user_id,u.username,f.*,uc.collect_id,uc.flag from user_collect uc,user u,food f where u.user_id=uc.user_id and f.food_id=uc.food_id "
					+ "and u.user_id=? and flag=?";
			list= jdbcTemplate.query(sql, new Object[]{user_id,flag},new FoodMapper());
		}
		return list;
	}


	/*
	 * �����ղ�״̬
	 * �������ʧ�ܣ���ɾ��
	 * */
		public int changeFoodCollection(int user_id, int food_id) {
			System.out.println(user_id);
			System.out.println(food_id);
			int insert=jdbcTemplate.update("insert into user_collect select null,?,null,?,now(),1 from dual where "
					+ "not exists(select * from user_collect where user_id=? and food_id=?)"
					,new Object[]{user_id,food_id,user_id,food_id});
			if(insert==0)
				return jdbcTemplate.update("delete from user_collect where user_id=? and food_id=?"
						,new Object[]{user_id,food_id});
				else
					return insert;
		}
		public int changeShopCollection(int user_id, int shop_id) {
			int insert=jdbcTemplate.update("insert into user_collect select null,?,?,null,now(),0 from dual where "
					+ "not exists(select * from user_collect where user_id=? and shop_id=?)"
					,new Object[]{user_id,shop_id,user_id,shop_id});
			if(insert==0)
				return jdbcTemplate.update("delete from user_collect where user_id=? and shop_id=?"
						,new Object[]{user_id,shop_id});
				else
					return insert;
		}

		public int isCollected(int user_id, int shop_food_id,int flag) {
			if(flag==0)			
				return jdbcTemplate.queryForInt("select count(*) from user_collect where user_id=? and shop_id=? and flag=?",
					new Object[]{user_id,shop_food_id,flag});
			else
				return jdbcTemplate.queryForInt("select count(*) from user_collect where user_id=? and food_id=? and flag=?",
						new Object[]{user_id,shop_food_id,flag});

		}
	
}
