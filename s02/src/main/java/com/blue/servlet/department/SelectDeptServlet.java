package com.blue.servlet.department;



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
 * 部门页面查询按钮功能
 */
@WebServlet("/selectDept")
public class SelectDeptServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        String departmentid = request.getParameter("departmentid");
        List<UserBMXX> departments = null;
        if(departmentid!=""){
            DepartmentDao dao = new DepartmentDao();
            departments = dao.selectByDepartmentid(departmentid);
        }

        request.getSession().setAttribute("departments", departments);

        response.sendRedirect(request.getContextPath()+"/section.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
