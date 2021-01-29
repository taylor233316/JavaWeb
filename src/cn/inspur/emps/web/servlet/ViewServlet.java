package cn.inspur.emps.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.inspur.emps.dao.UserDao;
import cn.inspur.emps.pojo.User;

/**
 * Servlet implementation class ViewServlet
 */
public class ViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userID = request.getParameter("userID");
		UserDao dao = new UserDao();
		User user = dao.findById(userID);
		request.setAttribute("user", user);
		String flag = request.getParameter("flag");
		if(flag.equals("view")) {
			request.getRequestDispatcher("/user/view.jsp").forward(request, response);
		}else {
			request.getRequestDispatcher("/user/edit.jsp").forward(request, response);
		}
		
		
	
	}

}
