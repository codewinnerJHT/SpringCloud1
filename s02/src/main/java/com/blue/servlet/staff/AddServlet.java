package com.blue.servlet.staff;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.BeanUtils;

import com.blue.dao.AdminDao;
import com.blue.domain.UserYGXX;

/**
 *
 */
@WebServlet("/add")
public class AddServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        Map<String, String[]> map = request.getParameterMap();
        UserYGXX userYGXX=new UserYGXX();
        try {
            BeanUtils.populate(userYGXX,map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        System.out.println(userYGXX);

        AdminDao.UserYGXXDao dao=new AdminDao.UserYGXXDao();
        int count=dao.add(userYGXX);

        if(count>0){
            response.sendRedirect(request.getContextPath()+"/index");
        }
        else{
            request.getSession().setAttribute("errormsg","添加失败");
            request.getRequestDispatcher("/create.jsp").forward(request,response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
