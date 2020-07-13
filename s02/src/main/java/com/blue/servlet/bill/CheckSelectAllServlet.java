package com.blue.servlet.bill;

import com.blue.dao.CheckDao;
import com.blue.dao.DepartmentDao;
import com.blue.domain.UserBMXX;
import com.blue.domain.UserZDGL;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @Description:
 * @Date: 2020/6/12 0012 下午 13:04
 */

@WebServlet("/check")
public class CheckSelectAllServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        CheckDao checkDao = new CheckDao();
        List<UserZDGL> list = checkDao.selectAll();

        request.getSession().setAttribute("bills",list);    // 将数据存储到session域中
        request.getRequestDispatcher("/check.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
