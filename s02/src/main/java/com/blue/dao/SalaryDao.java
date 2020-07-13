package com.blue.dao;

import com.blue.domain.UserBMXX;
import com.blue.domain.UserYGGZ;
import com.blue.domain.UserYGXX;
import com.blue.utils.DruidUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/**
 * @Description:操作工资表数据库
 * @Date: 2020/6/12 0012 下午 14:56
 */
public class SalaryDao {

    private static JdbcTemplate tmp=new JdbcTemplate(DruidUtils.getDateSource());

    public int add(UserYGGZ userYGGZ) {

        return  tmp.update("insert into yggz values(?,?,?)",
                userYGGZ.getEnumber(),userYGGZ.getEname(),userYGGZ.getSalry());
    }

    public List<UserYGGZ> selectAll() {

        JdbcTemplate tmp=new JdbcTemplate(DruidUtils.getDateSource());
        return tmp.query("select * from yggz", new BeanPropertyRowMapper<>(UserYGGZ.class));
    }

    public int delete(String enumber) {
        JdbcTemplate tmp=new JdbcTemplate(DruidUtils.getDateSource());
        return tmp.update("delete from yggz where enumber=?",enumber);
    }

    public List<UserYGGZ> selectByEnumber(String enumber) {

        String ssql="select * from yggz where enumber=?";

        JdbcTemplate tmp=new JdbcTemplate(DruidUtils.getDateSource());
        return tmp.query(ssql,new BeanPropertyRowMapper<>(UserYGGZ.class),new Object[]{enumber});
    }

    public int update(UserYGGZ userYGGZ) {

        JdbcTemplate tmp=new JdbcTemplate(DruidUtils.getDateSource());
        return  tmp.update("update yggz set ename=?,salry=? where enumber=?",
                userYGGZ.getEname(),userYGGZ.getSalry(),userYGGZ.getEnumber());
    }

}
