package com.blue.servlet;


import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.BeanUtils;

import com.blue.dao.AdminDao;
import com.blue.domain.Admin;

/**
 * 登录
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        Map ma = request.getParameterMap();
        Admin admin=new Admin();
        try {
            BeanUtils.populate(admin,ma);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        AdminDao dao=new AdminDao();
        Boolean boo=dao.login(admin);

        if(boo){
            response.sendRedirect("/index");    // 跳转到adminjsp页面之前的servlet
        }
        else{
            request.getSession().setAttribute("msg","登录失败");
            request.getRequestDispatcher("/login.jsp").forward(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
