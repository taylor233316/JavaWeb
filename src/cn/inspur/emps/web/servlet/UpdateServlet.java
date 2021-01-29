package cn.inspur.emps.web.servlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import cn.inspur.emps.dao.UserDao;
import cn.inspur.emps.pojo.User;


/**
 * Servlet implementation class UpdateServlet
 */
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String uppath=getServletContext().getRealPath("/up");
		MultipartRequest mreq=new MultipartRequest(request,uppath,1024*1024*5,"utf-8",new DefaultFileRenamePolicy() );

		String userID = mreq.getParameter("userID");
		String logonName = mreq.getParameter( "logonName" );
		String logonPwd = mreq.getParameter( "logonPwd");
		String userName = mreq.getParameter( "userName" );
		String sex = mreq.getParameter("sex");
		String education = mreq.getParameter("education") ;
		String birthday = mreq.getParameter( "birthday" ) ;
		String telephone = mreq.getParameter( "telephone") ;
		String[] values = mreq.getParameterValues( "interest" ) ;
		String interest=Arrays.toString(values).replace("[","").replace("]","");
		String remark = mreq.getParameter( "remark" );
		String filename="";
		String path="";
		String delFilePath="";
		String delFileName="";
		String newfile = mreq.getFilesystemName("file");
		
		String myfilename = mreq.getParameter("myfilename");
		String myfilepath = mreq.getParameter("myfilepath");
		if(newfile!=null) {						//修改文件，传入新文件
			File file = mreq.getFile("file");
			path = file.getParent();
			filename=newfile;
			delFileName = myfilename;
			delFilePath = myfilepath;
			
		}else {
			filename = myfilename;
			path = myfilepath;
		}
			
		System.out.println();
		User user=new User(); 
		user.setUserID(Integer.valueOf(userID)) ;
		user.setLogonName( logonName) ;
		user.setLogonPwd ( logonPwd ) ;
		user.setUserName(userName ) ;
		user.setSex( sex) ;
		user.setEducation( education) ;
		user.setBirthday(birthday ) ;
		user.setTelephone(telephone);
		user.setInterest(interest);
		user.setRemark( remark );
		
		user.setFilename(filename);
		user.setPath(path);
		
		if(!delFilePath.equals("")) {
			String dfp = getServletContext().getRealPath("/")+"up"+"/"+delFileName;
			System.out.println("要删除的文件"+dfp);
			System.out.println("要删除的路径"+delFilePath);
			File f = new File(dfp);
			if(f.exists())
				f.delete();
		}
		UserDao dao = new UserDao();
		dao.update(user);
		response.sendRedirect(request.getContextPath()+"/list");
		
		
	}

}
