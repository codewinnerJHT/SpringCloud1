package com.blue.servlet.bill;

import com.blue.dao.CheckDao;
import com.blue.dao.DepartmentDao;
import com.blue.domain.UserZDGL;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @Description:账单回显
 * @Date: 2020/6/12 0012 下午 16:19
 */

@WebServlet("/toCheckPageServlet")
public class ToCheckPageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        CheckDao dao = new CheckDao();
        String billid = req.getParameter("billid");
        List<UserZDGL> userZDGLS = dao.selectByBillid(billid);

        req.setAttribute("bill",userZDGLS.get(0));
//        req.getSession().setAttribute("bill",userZDGLS.get(0));    // 将数据存储到session域中
        req.getRequestDispatcher("/che.jsp").forward(req, resp);;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
