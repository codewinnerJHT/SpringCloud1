package com.athaitao.food.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.athaitao.food.bean.Food;
import com.athaitao.food.bean.FoodType;

public class FoodServiceImp{
	private JdbcTemplate jdbcTemplate;
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
		}
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
		}

	public List<Food> getFoodsByShop(String shop_id){
		String sql="select * from food where shop_id='"+shop_id+"'";
		return jdbcTemplate.query(sql, new FoodMapper());
	}
	
	public List<Food> getFoodsBySearch(String search) {
		String sql="select * from food where foodname like '%"+search+"%' "
				+ "or food.type_id in(select t.type_id from foodtype t where t.typename like '%"+search+"%')";
		return jdbcTemplate.query(sql, new FoodMapper());
	}
	

	private static final class FoodMapper implements RowMapper{		

		public Food mapRow(ResultSet rs, int rowNum) throws SQLException {
			Food food=new Food();
			food.setShop_id(rs.getInt("shop_id"));
			food.setFood_id(rs.getInt("food_id"));
			food.setType_id(rs.getInt("type_id"));
			food.setFoodname(rs.getString("foodname"));
			food.setIntro(rs.getString("intro"));
			food.setPrice(rs.getDouble("price"));
			food.setIntro(rs.getString("intro"));
			food.setPic(rs.getString("pic"));
			food.setRecommand(rs.getInt("recommand"));			
			return food;
		}		
	
	}
	
	private static final class FoodTypeMapper implements RowMapper{		

		public FoodType mapRow(ResultSet rs, int rowNum) throws SQLException {
			FoodType food=new FoodType();
			food.setType_id(rs.getInt("type_id"));
			food.setTypename(rs.getString("typename"));
				
			return food;
		}		
	
	}


	public Food getFoodById(String food_id) {
		String sql="select * from food where food_id="+food_id;
		List<Food> lists=jdbcTemplate.query(sql, new FoodMapper());
		if(lists.size()>0)
			return lists.get(0);
		else
			return null;
	}
	public List<FoodType> getFoodType() {
		String sql="select * from foodtype";
		return jdbcTemplate.query(sql, new FoodTypeMapper());
	}
	public int insertFood(String shop_id, String foodname, String type_id,String pic,
			double price, String intro, String recommand) {
		String sql="insert into food values(null,?,?,?,?,?,?,?)";
		return jdbcTemplate.update(sql,new Object[]{foodname,price,intro,pic,shop_id,type_id,recommand});
	}
	public int updateFood(Food food) {
		String sql="update food set foodname=?,price=?,intro=?,pic=?,type_id=?,recommand=? where food_id=?";
		return jdbcTemplate.update(sql,new Object[]{food.getFoodname(),food.getPrice(),food.getIntro(),food.getPic(),food.getType_id(),food.getRecommand(),food.getFood_id()});
	}
	public int deleteFood(String food_id) {
		String sql="delete from food where food_id=?";
		return jdbcTemplate.update(sql,new Object[]{food_id});
	}


	
	
}
