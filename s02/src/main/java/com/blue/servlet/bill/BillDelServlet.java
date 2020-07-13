package com.blue.servlet.bill;

import com.blue.dao.CheckDao;
import com.blue.dao.SalaryDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Description:
 * @Auther: Tang
 * @Date: 2020/6/12 0012 下午 15:30
 */

@WebServlet("/delBill")
public class BillDelServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String billid = req.getParameter("billid");
        CheckDao dao = new CheckDao();
        int b = dao.delete(billid);
        if (b>0){
            resp.sendRedirect(req.getContextPath()+"/check");
        }else{

        }
    }
}
