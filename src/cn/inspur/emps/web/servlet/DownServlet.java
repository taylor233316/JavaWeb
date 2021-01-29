package cn.inspur.emps.web.servlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DownServlet
 */
public class DownServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// 下面的方法用于解决post请求中带中文的乱码问题，但，解决不了get请求带中文参数的乱码问题！！！
				//request.setCharacterEncoding("utf-8");
				String filename = request.getParameter("filename");
				System.out.println("filename:"+filename);
				String filePath=getServletContext().getRealPath("/")+"/up"+"/"+filename;
				File file=new File(filePath);
				FileInputStream fis=new FileInputStream(file);
				ServletOutputStream os = response.getOutputStream();
				int len=0;
				byte[] b=new byte[1024];
				filename=URLEncoder.encode(filename, "utf-8");
				response.setHeader("content-disposition", "attachment;filename="+filename);
				while((len=fis.read(b))!=-1) {
					os.write(b, 0, len);
		}
		fis.close();
	}

}
