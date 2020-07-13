package com.blue.servlet.salary;

import com.blue.dao.DepartmentDao;
import com.blue.dao.SalaryDao;

import javax.net.ssl.HttpsURLConnection;
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

@WebServlet("/delSalary")
public class SalaryDelServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String enumber = req.getParameter("enumber");
        SalaryDao dao = new SalaryDao();
        int b = dao.delete(enumber);
        if (b>0){
            resp.sendRedirect(req.getContextPath()+"/salary");
        }else{

        }
    }
}
