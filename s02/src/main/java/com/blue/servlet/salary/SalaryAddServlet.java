package com.blue.servlet.salary;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.BeanUtils;

import com.blue.dao.SalaryDao;
import com.blue.domain.UserYGGZ;

/**
 * @Description:员工工资新增与修改
 * @Date: 2020/6/12 0012 上午 11:20
 */

@WebServlet("/addOrUpdateSalary")
public class SalaryAddServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        Map<String, String[]> map = req.getParameterMap();
        UserYGGZ userYGGZ = new UserYGGZ();
        try {
            BeanUtils.populate(userYGGZ,map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        SalaryDao salaryDao = new SalaryDao();

        int isSuccess ;
//        根据账单id查询，如果无此账单则执行添加操作  否则执行修改操作
        if (salaryDao.selectByEnumber(userYGGZ.getEnumber()).isEmpty()){
            isSuccess = salaryDao.add(userYGGZ);
        }else{
            isSuccess = salaryDao.update(userYGGZ);
        }

        if(isSuccess>0){
            resp.sendRedirect(req.getContextPath()+"/salary");
        }
        else{
            req.getSession().setAttribute("errormsg","操作失败！请重试");
        }
    }
}
