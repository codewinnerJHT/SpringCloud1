package com.blue.servlet.staff;

import com.blue.dao.AdminDao;
import com.blue.domain.UserYGXX;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * 查询??有职工信??
 */
@WebServlet("/index")
public class SelectAll extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        AdminDao.UserYGXXDao dao=new AdminDao.UserYGXXDao();
        List<UserYGXX> list=dao.selectAll();

        request.getSession().setAttribute("users",list);    // 将数据存储到session域中
        request.getRequestDispatcher("/adminjsp.jsp").forward(request, response);;
        //response.sendRedirect("/adminjsp.jsp"); // 重定向到主页??

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       doGet(req,resp);
    }
}

