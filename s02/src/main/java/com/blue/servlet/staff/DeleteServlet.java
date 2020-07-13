package com.blue.servlet.staff;


import com.blue.dao.AdminDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 删除职工信息
 */
@WebServlet("/delete")
public class DeleteServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        Integer enumber = Integer.parseInt(request.getParameter("enumber"));

        AdminDao.UserYGXXDao dao=new AdminDao.UserYGXXDao();
        int count=dao.delete(enumber);

        if (count>0) {
            response.sendRedirect(request.getContextPath()+"/index");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
