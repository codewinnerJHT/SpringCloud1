package com.athaitao.food.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.athaitao.food.bean.Admin;
import com.athaitao.food.bean.Shop;

public class ShopServiceImp{
	private JdbcTemplate jdbcTemplate;
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
		}
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
		}

	public List<Shop> getAllShops(){
		String sql="select * from shop";
		return jdbcTemplate.query(sql, new ShopMapper());
	}
	public Shop getShopById(String shop_id) {
		String sql="select * from shop where shop_id="+shop_id+"";
		List<Shop> shops= jdbcTemplate.query(sql, new ShopMapper());
		if(shops!=null&&shops.size()>0)
			return shops.get(0);
		else
			return null;
	}
	public int insertShop(Shop shop) {
		String sql="insert into shop values(null,?,?,?,?,?,?,?)";
		return jdbcTemplate.update(sql,new Object[]{shop.getShopname(),shop.getAddress(),
				shop.getPhonenum(),shop.getIntro(),shop.getPic(),shop.getComment(),shop.getLevel()});
	}

	private static final class ShopMapper implements RowMapper{		

		public Shop mapRow(ResultSet rs, int rowNum) throws SQLException {
			Shop shop=new Shop();
			shop.setShop_id(rs.getInt("shop_id"));
			shop.setLevel(rs.getInt("level"));
			shop.setShopname(rs.getString("shopname"));
			shop.setPhonenum(rs.getString("phonenum"));
			shop.setAddress(rs.getString("address"));
			shop.setIntro(rs.getString("intro"));
			shop.setPic(rs.getString("pic"));
			shop.setComment(rs.getString("comment"));
			
			return shop;
		}
		
	
	}

	public int deleteShop(String shop_id) {
		return jdbcTemplate.update("delete from shop where shop_id="+shop_id);
	}
	public int updateShop(Shop shop) {		
		System.out.println(shop);
		return jdbcTemplate.update("update shop set shopname=?,phonenum=?,address=?,intro=?,pic=?,level=? where shop_id=?",
				new Object[]{shop.getShopname(),shop.getPhonenum(),shop.getAddress(),shop.getIntro(),shop.getPic(),shop.getLevel(),shop.getShop_id()});
	}
	
	
	
}
