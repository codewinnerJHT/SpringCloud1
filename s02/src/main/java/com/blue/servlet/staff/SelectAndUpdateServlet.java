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
 * 修改信息时，获取职工号进行回写数�?
 */
@WebServlet("/updateSelect")
public class SelectAndUpdateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        Integer enumber=Integer.parseInt(request.getParameter("enumber"));

        AdminDao.UserYGXXDao dao=new AdminDao.UserYGXXDao();
        List<UserYGXX> list = dao.selectByEnumber(enumber);

        request.getSession().setAttribute("updateuser",list.get(0));
        response.sendRedirect("update.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
