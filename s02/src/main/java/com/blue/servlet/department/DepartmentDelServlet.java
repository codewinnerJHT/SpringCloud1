package com.blue.servlet.department;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.blue.dao.DepartmentDao;

/**
 * @Description:部门删除
 * @Date: 2020/6/12 0012 上午 11:20
 */

@WebServlet("/delDept")
public class DepartmentDelServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String deptId = req.getParameter("deptId");
        DepartmentDao dao = new DepartmentDao();
        int b = dao.delete(deptId);
        if (b>0){
            resp.sendRedirect(req.getContextPath()+"/dept");
        }else{

        }
    }
}
