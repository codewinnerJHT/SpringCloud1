package com.blue.servlet.department;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.BeanUtils;

import com.blue.dao.DepartmentDao;
import com.blue.domain.UserBMXX;

/**
 * @Description:员工部门新增与修改
 * @Date: 2020/6/12 0012 上午 11:20
 */

@WebServlet("/addOrUpdateDepartment")
public class DepartmentAddOrUpdateServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        Map<String, String[]> map = req.getParameterMap();
        UserBMXX userBMXX = new UserBMXX();
        try {
            BeanUtils.populate(userBMXX,map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        DepartmentDao dao = new DepartmentDao();

        int isSuccess ;
//        根据账单id查询，如果无此账单则执行添加操作  否则执行修改操作
        if (dao.selectByDepartmentid(userBMXX.getDepartmentid()).isEmpty()){
            isSuccess = dao.add(userBMXX);
        }else{
            isSuccess = dao.update(userBMXX);
        }

        if(isSuccess>0){
            resp.sendRedirect(req.getContextPath()+"/dept");
        }
        else{
            req.getSession().setAttribute("errormsg","操作失败！请重试");
        }
    }
}
