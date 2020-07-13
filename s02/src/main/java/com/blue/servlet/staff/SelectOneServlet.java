package com.blue.servlet.staff;



import com.blue.dao.AdminDao;
import com.blue.dao.DepartmentDao;
import com.blue.domain.UserBMXX;
import com.blue.domain.UserYGXX;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * 页面查询按钮功能
 */
@WebServlet("/selectOne")
public class SelectOneServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Integer enumber =-1;
        request.setCharacterEncoding("utf-8");
        if(request.getParameter("enumber")!=""){

            enumber= Integer.parseInt(request.getParameter("enumber"));
        }

        AdminDao.UserYGXXDao dao=new AdminDao.UserYGXXDao();
        List<UserYGXX> list= dao.selectByEnumber(enumber);

        if(list.size()>0) {
            request.getSession().setAttribute("users", list);

            response.sendRedirect(request.getContextPath()+"/adminjsp.jsp");
        }
        else {

            response.sendRedirect(request.getContextPath()+"/index");
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
