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
 * @Description:
 * @Auther: Tang
 * @Date: 2020/6/12 0012 下午 13:04
 */

@WebServlet("/dept")
public class DepartmentSelectAllServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        DepartmentDao departmentDao = new DepartmentDao();
        List<UserBMXX> list=departmentDao.selectAll();

        request.getSession().setAttribute("departments",list);    // 将数据存储到session域中
        request.getRequestDispatcher("/section.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
