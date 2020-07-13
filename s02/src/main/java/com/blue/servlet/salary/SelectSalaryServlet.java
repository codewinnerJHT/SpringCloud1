package com.blue.servlet.salary;

import com.blue.dao.DepartmentDao;
import com.blue.dao.SalaryDao;
import com.blue.domain.UserBMXX;
import com.blue.domain.UserYGGZ;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * 工资页面查询按钮功能
 */
@WebServlet("/selectSalary")
public class SelectSalaryServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        String enumber = request.getParameter("enumber");

        List<UserYGGZ> salaryList = null ;
        if(enumber!=""){
            SalaryDao dao = new SalaryDao();
            salaryList = dao.selectByEnumber(enumber);
        }

        request.getSession().setAttribute("salaryList", salaryList);

        response.sendRedirect(request.getContextPath()+"/salary.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
