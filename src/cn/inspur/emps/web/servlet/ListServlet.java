package cn.inspur.emps.web.servlet;

import java.io.IOException;
import java.util.List;
import cn.inspur.emps.pojo.User;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.inspur.emps.dao.UserDao;

/**
 * Servlet implementation class ListServlet
 */
public class ListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	UserDao dao = new UserDao();
	List<User> list =  dao.list();
	request.setAttribute("list", list);
	request.getRequestDispatcher("/user/list.jsp").forward(request, response);
	}

	
	

}
