package cn.inspur.emps.web.servlet;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;

import cn.inspur.emps.dao.UserDao;
import cn.inspur.emps.pojo.User;
/**
 * Servlet implementation class AddServlet
 */
public class AddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String uppath = getServletContext().getRealPath("/up");
		MultipartRequest mreq = new MultipartRequest(request, uppath,1024*1024*5,"utf-8");
		String logonName = mreq.getParameter("logonName");
		String logonPwd = mreq.getParameter( "logonPwd");
		String userName = mreq.getParameter( "userName" );
		String sex = mreq.getParameter( "sex");
				
		String education = mreq.getParameter("education");
		String birthday = mreq.getParameter( "birthday");
		String telephone = mreq.getParameter( "telephone");
		String[] values = mreq.getParameterValues("interest");
		String interest = Arrays.toString(values).replace("[", "").replace("]", "");
		String filename = mreq.getFilesystemName("upload");
		String path = "";
		if(filename==null) {
			//判断用户是否上传文件，如果没有上传，则在数据库相应字段中保存空字符串
			filename="";
			path = "";
		}else {
			File file = mreq.getFile("upload");
			path = file.getParent();
		}
		
		String remark = mreq.getParameter("remark");
	    User user = new User();
	    user.setBirthday(birthday);
	    user.setEducation(education);
	    user.setFilename(filename);
	    user.setInterest(interest);
	    user.setLogonName(logonName);
	    user.setLogonPwd(logonPwd);
	    user.setPath(path);
	    user.setRemark(remark);
	    user.setSex(sex);
	    user.setTelephone(telephone);
	    user.setUserName(userName);
	    
	    UserDao dao = new UserDao();
	    dao.addUser(user);
	    
	    response.sendRedirect(request.getContextPath()+"/list");
	}

}
