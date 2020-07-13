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
 * @Description:跳转工资界面
 * @Date: 2020/6/12 0012 下午 14:53
 */
@WebServlet("/salary")
public class SalarySelectAllServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        SalaryDao dao = new SalaryDao();
        List<UserYGGZ> list=dao.selectAll();

        request.getSession().setAttribute("salaryList",list);    // 将数据存储到session域中
        request.getRequestDispatcher("/salary.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
