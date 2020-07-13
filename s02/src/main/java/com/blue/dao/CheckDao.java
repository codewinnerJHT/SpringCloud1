package com.blue.dao;

import com.blue.domain.UserYGGZ;
import com.blue.domain.UserZDGL;
import com.blue.utils.DruidUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.util.List;

/**
 * @Description:操作工资表数据库
 * @Date: 2020/6/12 0012 下午 14:56
 */
public class CheckDao {

    private static JdbcTemplate tmp=new JdbcTemplate(DruidUtils.getDateSource());

    public int add(UserZDGL userZDGL) {

        return  tmp.update("insert into zdgl values(?,?,?,?,?)",
                userZDGL.getBillid(),userZDGL.getBillacount(),userZDGL.getBilltime(),
                userZDGL.getBilltransactionamount(),userZDGL.getPayment());
    }

    public List<UserZDGL> selectAll() {

        return tmp.query("select * from zdgl", new BeanPropertyRowMapper<>(UserZDGL.class));
    }

    public int delete(String billid) {

        return tmp.update("delete from zdgl where billid=?",billid);
    }

    public List<UserZDGL> selectByBillid(String billid) {

        String ssql="select * from zdgl where billid= ?";

        return tmp.query(ssql,new Object[]{billid},new BeanPropertyRowMapper<>(UserZDGL.class));
    }

    public int update(UserZDGL userZDGL) {

        return  tmp.update("update zdgl set billacount=?,billtime=? ,billtransactionamount=? ," +
                        "payment = ? where billid=?",
                userZDGL.getBillacount(),userZDGL.getBilltime(),
                userZDGL.getBilltransactionamount(),userZDGL.getPayment(),userZDGL.getBillid());
    }

}
