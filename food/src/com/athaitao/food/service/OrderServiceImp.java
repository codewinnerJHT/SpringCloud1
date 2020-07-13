package com.athaitao.food.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.athaitao.food.bean.Order;

public class OrderServiceImp{
	private JdbcTemplate jdbcTemplate;
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
		}
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
		}
	

	private static final class OrderMapper implements RowMapper{		

		public Order mapRow(ResultSet rs, int rowNum) throws SQLException {
			Order order=new Order();
			order.setOrder_id(rs.getInt("order_id"));
            order.setFood_id(rs.getInt("food_id"));
            order.setUser_id(rs.getInt("user_id"));
            order.setNum(rs.getInt("num"));
            order.setSum(rs.getDouble("sum"));
            order.setSuggesttime(rs.getString("suggesttime"));
            order.setOrdertime(rs.getString("ordertime"));
            order.setFoodname(rs.getString("foodname"));
            order.setUsername(rs.getString("username"));
            order.setShopaddress(rs.getString("shopaddress"));
            order.setShopname(rs.getString("shopname"));
            order.setPrice(rs.getDouble("price"));
            order.setContent(rs.getString("content"));
            order.setComment_time(rs.getString("comment_time"));
            
			
			return order;
		}
		
	
	}

public int insertOrder(Order order)
{
	String sql="insert into user_order values(null,?,?,?,?,now(),?,null,null)";
	return jdbcTemplate.update(sql,new Object[]{order.getUser_id(),order.getFood_id(),order.getNum(),order.getSum(),order.getSuggesttime()});
}
public int insertComment(int order_id,String content)
{
	//content=content.substring(0,content.length()-1);
	String sql="update user_order set content=?,comment_time=now() where order_id=?";
	return jdbcTemplate.update(sql,new Object[]{content,order_id});
}
public List<Order> getAllUserOrder(String user_id) {
	String sql="select f.*,u.*,o.order_id,o.sum,o.num,o.ordertime,o.suggesttime,o.content,o.comment_time,s.shopname,s.address as shopaddress "
			+ "from food f,user u,user_order o,shop s "
			+ "where f.food_id=o.food_id and u.user_id=o.user_id and u.user_id=? and f.shop_id=s.shop_id";
	return jdbcTemplate.query(sql, new Object[]{user_id},new OrderMapper());
}
public List<Order> getAllUserComment(String user_id) {
	String sql="select f.*,u.*,o.order_id,o.sum,o.num,o.ordertime,o.suggesttime,o.content,o.comment_time,s.shopname,s.address as shopaddress "
			+ "from food f,user u,user_order o,shop s "
			+ "where f.food_id=o.food_id and u.user_id=o.user_id and u.user_id=? and f.shop_id=s.shop_id"
			+ " and o.comment_time is not null";
	System.out.println(sql);
	return jdbcTemplate.query(sql, new Object[]{user_id},new OrderMapper());
}
public int updateComment(int order_id, String content) {
	content=content.substring(1,content.length()-1);
	String sql="update user_order set content=?,comment_time=now() where order_id=?";
	return jdbcTemplate.update(sql,new Object[]{content,order_id});
}
public int deleteComment(int order_id) {
	String sql="update user_order set content=null,comment_time=null where order_id=?";
	return jdbcTemplate.update(sql,new Object[]{order_id});
}
//��ȡĳʳ�����������
public List<Order> getAllFoodOrder(String food_id) {
	String sql="select f.*,u.*,o.order_id,o.sum,o.num,o.ordertime,o.suggesttime,o.content,o.comment_time,s.shopname,s.address as shopaddress "
			+ "from food f,user u,user_order o,shop s "
			+ "where f.food_id=o.food_id and u.user_id=o.user_id  and f.shop_id=s.shop_id and o.food_id=? "
			+ "and o.comment_time is not null";
	return jdbcTemplate.query(sql,new Object[]{food_id},new OrderMapper());
}
public List<Order> getAllOrder() {
	String sql="select f.*,u.*,o.order_id,o.sum,o.num,o.ordertime,o.suggesttime,o.content,o.comment_time,s.shopname,s.address as shopaddress "
			+ "from food f,user u,user_order o,shop s "
			+ "where f.food_id=o.food_id and u.user_id=o.user_id and f.shop_id=s.shop_id";
	return jdbcTemplate.query(sql, new OrderMapper());
}


	
	
}
