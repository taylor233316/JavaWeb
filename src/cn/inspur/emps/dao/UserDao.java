package cn.inspur.emps.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import cn.inspur.emps.common.JdbcUtils;
import cn.inspur.emps.pojo.User;



public class UserDao {

	public User login(String logonName,String logonPwd) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			
			con = (Connection) JdbcUtils.getConnection();
			String sql = "select * from S_User where logonName=? and logonPwd =?";
			pstmt=(PreparedStatement) con.prepareStatement(sql);
			pstmt.setString(1, logonName);
			pstmt.setString(2, logonPwd);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				User user = new User();
				user.setUserID(rs.getInt( "userID"));
				user.setUserName(rs.getString( "userName"));
				user.setLogonName(rs.getString( "logonName" ));
				user.setLogonPwd(rs.getString( "logonPwd"));
				user.setBirthday(rs.getString("birthday"));
				user.setEducation(rs.getString("education"));
				user.setFilename(rs.getString("filename"));
				user.setInterest(rs.getString( "interest"));
				user.setPath(rs.getString( "path"));
				user.setRemark(rs.getString("remark"));
				user.setSex(rs.getString("sex"));
				user.setTelephone(rs.getString( "telephone" ));
				return user;
				
			}
				
			else
				return null;
		
		
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally {

			JdbcUtils.close(con, pstmt,rs);
		}
	}

	public List<User> list() {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<User> list = new ArrayList<User>();
		try {
			
			con = (Connection) JdbcUtils.getConnection();
			String sql = "select * from S_User";
			pstmt=(PreparedStatement) con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				User user = new User();
				user.setUserID(rs.getInt( "userID"));
				user.setUserName(rs.getString( "userName"));
				user.setLogonName(rs.getString( "logonName" ));
				user.setLogonPwd(rs.getString( "logonPwd"));
				user.setBirthday(rs.getString("birthday"));
				user.setEducation(rs.getString("education"));
				user.setFilename(rs.getString("filename"));
				user.setInterest(rs.getString( "interest"));
				user.setPath(rs.getString( "path"));
				user.setRemark(rs.getString("remark"));
				user.setSex(rs.getString("sex"));
				user.setTelephone(rs.getString( "telephone" ));
				list.add(user);
				System.out.println(list);
			}
				return list;

		
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally {

			JdbcUtils.close(con, pstmt,rs);
		}
	}

	public void addUser(User user) {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<User> list = new ArrayList<User>();
		try {
			
			con = (Connection) JdbcUtils.getConnection();
			String sql = "insert into S_User (userName, logonName ,logonPwd, sex,birthday,education, telephone,"
					+ "interest,path,filename,remark) values(?,?,?,?,?,?,?,?,?,?,?)";
			pstmt = (PreparedStatement) con.prepareStatement(sql);
			pstmt.setString(1,user.getUserName());
			pstmt.setString(2,user.getLogonName());
			pstmt.setString(3,user.getLogonPwd());
			pstmt.setString(4,user.getSex());
			pstmt.setString(5,user.getBirthday());
			pstmt.setString(6,user.getEducation());
			pstmt.setString(7,user.getTelephone());
			pstmt.setString(8,user.getInterest());
			pstmt.setString(9,user.getPath());
			pstmt.setString(10,user.getFilename());
			pstmt.setString(11,user.getRemark());
			pstmt.executeUpdate();
			
		
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally {

			JdbcUtils.close(con, pstmt,rs);
		}
	}

	public User findById(String userID) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<User> list = new ArrayList<User>();
		try {
			
			con = (Connection) JdbcUtils.getConnection();
			String sql = "select * from S_User where userID =?";
			pstmt = (PreparedStatement) con.prepareStatement(sql);
			pstmt.setInt(1, Integer.valueOf(userID));
			rs=pstmt.executeQuery();
			rs.next();
			User user=new User();
			user.setUserID(rs.getInt( "userID"));
			user.setUserName(rs.getString( "userName"));
			user.setLogonName(rs.getString("logonName"));
			user.setLogonPwd(rs.getString("logonPwd"));
			user.setBirthday(rs.getString("birthday"));
			user.setEducation(rs.getString( "education"));
			user.setFilename(rs.getString("filename"));
			user.setInterest(rs.getString("interest"));
			user.setPath(rs.getString("path"));
			user.setRemark(rs.getString("remark"));
			user.setSex(rs.getString("sex"));
			user.setTelephone(rs.getString( "telephone"));
			return user;
					
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally {

			JdbcUtils.close(con, pstmt,rs);
		}
	}

	public void delete(String userID) {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<User> list = new ArrayList<User>();
		try {
			
			con = (Connection) JdbcUtils.getConnection();
			String sql = "delete from S_User where userID =?";
			pstmt = (PreparedStatement) con.prepareStatement(sql);
			pstmt.setInt(1, Integer.valueOf(userID));
			pstmt.executeUpdate();
	
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally {

			JdbcUtils.close(con, pstmt,rs);
		}
	}

	public void update(User user) {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			
			con = (Connection) JdbcUtils.getConnection();
			String sql="update S_User set logonName=? , logonPwd=? , userName=? ,sex=? , education=? , birthday=? , telephone=? "
					    +", interest=? , remark=? ,path=? ,filename=?"
					    +"where userID=?";
			pstmt = (PreparedStatement) con.prepareStatement(sql);
			pstmt.setString(1,user.getLogonName());
			pstmt.setString(2,user.getLogonPwd());
			pstmt.setString(3,user.getUserName( ));
			pstmt.setString(4,user.getSex());		
			pstmt.setString(5,user.getEducation());
			pstmt.setString(6,user.getBirthday());
			pstmt.setString(7, user.getTelephone());
			pstmt.setString(8,user.getInterest());
			pstmt.setString(9,user.getRemark());
			
			pstmt.setString(10, user.getPath());
			pstmt.setString(11, user.getFilename());
			
			pstmt.setInt(12,user.getUserID());
			pstmt.executeUpdate();
			
		
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally {

			JdbcUtils.close(con, pstmt,rs);
		}
	}

	public List<User> query(String username, String sex, String education, String isUpload) {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<User> list = new ArrayList<User>();
		try {
			
			con = (Connection) JdbcUtils.getConnection();
			String sql = "select * from S_User where "+username+" and "+sex+" and "+education+" and "+isUpload;
			System.out.println("sql:"+sql);
			pstmt=(PreparedStatement) con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				User user = new User();
				user.setUserID(rs.getInt( "userID"));
				user.setUserName(rs.getString( "userName"));
				user.setLogonName(rs.getString( "logonName" ));
				user.setLogonPwd(rs.getString( "logonPwd"));
				user.setBirthday(rs.getString("birthday"));
				user.setEducation(rs.getString("education"));
				user.setFilename(rs.getString("filename"));
				user.setInterest(rs.getString( "interest"));
				user.setPath(rs.getString( "path"));
				user.setRemark(rs.getString("remark"));
				user.setSex(rs.getString("sex"));
				user.setTelephone(rs.getString( "telephone" ));
				list.add(user);
				
			}
				return list;

		
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally {

			JdbcUtils.close(con, pstmt,rs);
		}
	}
	
	
	
	}


	


