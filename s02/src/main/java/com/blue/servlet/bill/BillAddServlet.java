package com.blue.servlet.bill;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.BeanUtils;

import com.blue.dao.CheckDao;
import com.blue.domain.UserZDGL;

/**
 * @Description:账单添加
 * @Date: 2020/6/12 0012 上午 11:20
 */

@WebServlet("/addOrUpdateBill")
public class BillAddServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        Map<String, String[]> map = req.getParameterMap();
        UserZDGL userZDGL = new UserZDGL();
        try {
            BeanUtils.populate(userZDGL,map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        System.out.println(userZDGL);
        CheckDao checkDao = new CheckDao();

        int isSuccess ;
//        根据账单id查询，如果无此账单则执行添加操作  否则执行修改操作
        if (checkDao.selectByBillid(userZDGL.getBillid()).isEmpty()){
            isSuccess = checkDao.add(userZDGL);
        }else{
            isSuccess = checkDao.update(userZDGL);
        }

        if(isSuccess>0){
            resp.sendRedirect(req.getContextPath()+"/check");
        }
        else{
            req.getSession().setAttribute("errormsg","操作失败！请重试");
        }
    }
}
