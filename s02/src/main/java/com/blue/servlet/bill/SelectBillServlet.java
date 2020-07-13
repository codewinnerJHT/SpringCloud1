package com.blue.servlet.bill;

import com.blue.dao.CheckDao;
import com.blue.dao.SalaryDao;
import com.blue.domain.UserYGGZ;
import com.blue.domain.UserZDGL;

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
@WebServlet("/selectBill")
public class SelectBillServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        String billid = request.getParameter("billid");

        List<UserZDGL> bills = null ;
        if(billid!=""){
            CheckDao dao = new CheckDao();
            bills = dao.selectByBillid(billid);
        }
        request.getSession().setAttribute("bills", bills);

        response.sendRedirect(request.getContextPath()+"/check.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
