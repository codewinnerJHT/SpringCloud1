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
 * 修改职工信息
 */
@WebServlet("/update")
public class UpdateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //System.out.println(111111111111111111L);
        request.setCharacterEncoding("UTF-8");

        Map<String, String[]> map = request.getParameterMap();
        UserYGXX userYGXX=new UserYGXX();
        try {
            BeanUtils.populate(userYGXX,map);   // 将获取到的map参数转换成JavaBean
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        System.out.println(userYGXX.toString());

        // 调用dao�?
        AdminDao.UserYGXXDao dao=new AdminDao.UserYGXXDao();
        int count=dao.update(userYGXX);

        if(count>0){

            response.sendRedirect("/index");
        }
        else {

            request.getSession().setAttribute("errormsg","修改失败");
            request.getRequestDispatcher("update.jsp").forward(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
