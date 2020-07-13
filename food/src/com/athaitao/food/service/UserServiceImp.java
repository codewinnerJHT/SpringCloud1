package com.athaitao.food.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.athaitao.food.bean.Admin;
import com.athaitao.food.bean.User;

public class UserServiceImp{
	private JdbcTemplate jdbcTemplate;
	
	public User getValidUser(String username,String userpass){
		String sql="select * from user where username='"+username+"' and userpass=md5('"+userpass+"')";
		System.out.println(sql);
		List<User> users=jdbcTemplate.query(sql, new UserMapper());
		if(users!=null&&users.size()>0)
			return users.get(0);
		else
			return null;
	}
	public int insertUser(User user)
	{
		return jdbcTemplate.update("insert into user select null,?,md5(?),?,?,? from dual where not exists(select * from user where username=?)"
				,new Object[]{user.getUsername(),user.getUserpass(),
						user.getMobilenum(),user.getAddress(),user.getComment(),user.getUsername()});
	}

	
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
		}
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
		}


	public User getUserById(String user_id) {
		String sql="select * from user where user_id="+user_id;
		List<User> users=jdbcTemplate.query(sql, new UserMapper());
		if(users!=null&&users.size()>0)
			return users.get(0);
		else
			return null;
	}

	public int updateUserById(String user_id,String username,String userpass,String address,String mobilenum) {
		String sql="update user set username=?,userpass=md5(?),address=?,mobilenum=? where user_id=?";
		return jdbcTemplate.update(sql,new Object[]{username,userpass,address,mobilenum,user_id});
	}

	public List<User> getAllUsers() {
		String sql="select * from user";
		return jdbcTemplate.query(sql, new UserMapper());
	}

	public Object resetPassword(String user_id) {
		String sql="update user set userpass=md5('123456') where user_id=?";
		return jdbcTemplate.update(sql,new Object[]{user_id});
	}
	
	private static final class UserMapper implements RowMapper{		

		public User mapRow(ResultSet rs, int rowNum) throws SQLException {
			// TODO Auto-generated method stub
			User user=new User();
			user.setUser_id(rs.getInt("user_id"));
			user.setUsername(rs.getString("username"));
			user.setUserpass(rs.getString("userpass"));
			user.setAddress(rs.getString("address"));
			user.setComment(rs.getString("comment"));
			user.setMobilenum(rs.getString("mobilenum"));
			return user;
		}			
	}

}
