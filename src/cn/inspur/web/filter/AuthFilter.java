package cn.inspur.web.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.inspur.emps.pojo.User;

/**
 * Servlet Filter implementation class AuthFilter
 */
public class AuthFilter implements Filter {


	
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest hreq =(HttpServletRequest) request;
		HttpServletResponse hresp =(HttpServletResponse) response;
		HttpSession session = hreq.getSession();
		String uri = hreq.getRequestURI();
		User user = (User)session.getAttribute("loginUser");
		if(uri.endsWith("index.jsp")||uri.endsWith("login.jsp"))
			chain.doFilter(request, response);
		else {
			if(user!=null) {
				chain.doFilter(request, response);
			}else {
				session.setAttribute("msg", "请先登录");
				hresp.sendRedirect(hreq.getContextPath()+"/login/login.jsp");
			}
		}
	}


	public void destroy() {
		// TODO Auto-generated method stub
	}

}
