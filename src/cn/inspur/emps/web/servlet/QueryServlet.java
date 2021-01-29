package cn.inspur.emps.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.inspur.emps.dao.UserDao;
import cn.inspur.emps.pojo.User;

/**
 * Servlet implementation class QueryServlet
 */
public class QueryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String username = request.getParameter("userName" );
		String sex = request.getParameter("sex");
		String education = request.getParameter("education");
		String isUpload = request.getParameter("isUpload");
		username=username.equals("")?"1=1":"userName like '%"+username+"%'";
		sex=sex.equals("")?"1=1":"sex='"+sex+"'";
		education=education.equals("")?"1=1":"education='"+education+"'";
		if(isUpload.equals("")) isUpload="1=1";
		else if(isUpload.equals("1")) isUpload="path is not null and path<>'' and filename is not null and filename<>''";
		else isUpload="(path is null or path='') and (filename is null or filename='')";
		UserDao dao=new UserDao();
		
		List<User> list = dao.query(username,sex, education, isUpload);
		System.out.println("list:"+list);
		request.setAttribute("list",list);
		request.getRequestDispatcher("/user/list.jsp").forward(request, response);
	}

}
