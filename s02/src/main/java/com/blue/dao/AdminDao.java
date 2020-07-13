package com.blue.dao;


import com.blue.domain.Admin;
import com.blue.domain.UserYGXX;
import com.blue.utils.DruidUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class AdminDao {
    public Boolean login(Admin admin) {

        JdbcTemplate tmp=new JdbcTemplate(DruidUtils.getDateSource());
        List<Admin> query = tmp.query("select * from admin where username=? and password=?", new BeanPropertyRowMapper<>(Admin.class), admin.getUsername(), admin.getPassword());
        if(query.size()>0){

            return true;
        }
        else {

            return false;
        }
    }

    public static class UserYGXXDao {
        public int add(UserYGXX userYGXX) {

            JdbcTemplate tmp=new JdbcTemplate(DruidUtils.getDateSource());
            return  tmp.update("insert into ygxx values(?,?,?,?,?,?,?)", userYGXX.getEnumber(), userYGXX.getEname(), userYGXX.getSex(), userYGXX.getAddress(), userYGXX.getBirthdate(), userYGXX.getPhone(), userYGXX.getPosition());
        }

        public List<UserYGXX> selectAll() {

            JdbcTemplate tmp=new JdbcTemplate(DruidUtils.getDateSource());
            return tmp.query("select * from ygxx", new BeanPropertyRowMapper<>(UserYGXX.class));
        }
        public int delete(Integer enumber) {
            JdbcTemplate tmp=new JdbcTemplate(DruidUtils.getDateSource());
            return tmp.update("delete from ygxx where enumber=?",enumber);
        }

        public List<UserYGXX> selectByEnumber(Integer enumber) {

            String ssql="select * from ygxx ";
            if(enumber>=0){

                ssql+=" where enumber="+enumber;
            }

            JdbcTemplate tmp=new JdbcTemplate(DruidUtils.getDateSource());
            return tmp.query(ssql,new BeanPropertyRowMapper<>(com.blue.domain.UserYGXX.class));
        }

        public int update(UserYGXX userYGXX) {

            JdbcTemplate tmp=new JdbcTemplate(DruidUtils.getDateSource());
            return  tmp.update("update ygxx set ename=?,sex=?,address=?,birthdate=?,phone=?,position=? where enumber=?",
                    userYGXX.getEname(),userYGXX.getSex(),userYGXX.getAddress(),userYGXX.getBirthdate(),userYGXX.getPhone(),userYGXX.getPosition(),userYGXX.getEnumber());
        }
    }
}
