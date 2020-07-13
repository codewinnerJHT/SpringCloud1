package com.blue.servlet.staff;

import com.blue.dao.AdminDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 批量删除职工信息
 */
@WebServlet("/deleteAll")
public class DeleteAllServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        AdminDao.UserYGXXDao dao=new AdminDao.UserYGXXDao();
        String[] enumbers = request.getParameterValues("enumber");

        for(String str:enumbers){

            dao.delete(Integer.parseInt(str));
        }
        response.sendRedirect(request.getContextPath()+"/index");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
