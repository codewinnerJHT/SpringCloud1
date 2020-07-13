package com.blue.dao;

import com.blue.domain.UserBMXX;
import com.blue.domain.UserYGXX;
import com.blue.utils.DruidUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/**
 * @Description:部门数据库操作
 * @Date: 2020/6/12 0012 上午 11:24
 */

public class DepartmentDao {

    private static JdbcTemplate tmp=new JdbcTemplate(DruidUtils.getDateSource());

    public int add(UserBMXX userBMXX) {

        return  tmp.update("insert into bmxx(departmentid,departmentname,posiion) values(?,?,?)",
                userBMXX.getDepartmentid(),userBMXX.getDepartmentname(),userBMXX.getPosiion());
    }

    public List<UserBMXX> selectAll() {

        return tmp.query("select * from bmxx", new BeanPropertyRowMapper<>(UserBMXX.class));
    }

    public int delete(String deptId) {

        return tmp.update("delete from bmxx where departmentid=?",deptId);
    }

    public List<UserBMXX> selectByDepartmentid(String departmentid) {

        String ssql="select * from bmxx where departmentid = ?";

        return tmp.query(ssql,new Object[]{departmentid},new BeanPropertyRowMapper<>(UserBMXX.class));
    }

    public int update(UserBMXX userBMXX) {

        JdbcTemplate tmp=new JdbcTemplate(DruidUtils.getDateSource());
        return  tmp.update("update bmxx set departmentname=?,posiion=? where departmentid=?",
               userBMXX.getDepartmentname(),userBMXX.getPosiion(),userBMXX.getDepartmentid());
    }

//    根据部门编号查询部门信息

    public UserBMXX getBMXXById(String deptId){
        JdbcTemplate tmp=new JdbcTemplate(DruidUtils.getDateSource());

        return new UserBMXX();
    }
}
