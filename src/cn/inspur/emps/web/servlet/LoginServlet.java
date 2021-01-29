package cn.inspur.emps.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.inspur.emps.dao.UserDao;
import cn.inspur.emps.pojo.User;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       



	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String logonName = request.getParameter("logonName");
		String logonPwd = request.getParameter("logonPwd");
		UserDao dao = new UserDao();
		User user = dao.login(logonName, logonPwd);
		if(user!=null) {
			request.getSession().setAttribute("loginUser", user);
			response.sendRedirect(request.getContextPath()+"/login/home.jsp"); //在浏览器上执行
		}
		else {
			request.getSession().setAttribute("errormsg","用户密码输入错误");
			response.sendRedirect(request.getContextPath()+"/login/login.jsp");
		}
	}

}
