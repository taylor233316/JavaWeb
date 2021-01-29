<%@page import="cn.inspur.emps.pojo.User"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<HTML>
	<HEAD>
		<meta http-equiv="Content-Language" content="zh-cn">
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<LINK href="${pageContext.request.contextPath}/css/Style.css" type="text/css" rel="stylesheet">
		<script language="javascript" src="${pageContext.request.contextPath}/js/public.js"></script>
		<script language="javascript" src="${pageContext.request.contextPath}/js/check.js"></script>
		<script language="javascript" src="${pageContext.request.contextPath}/js/mytest.js"></script>
		<!-- 日期插件，使用jquery -->
		<script type="text/javascript" src="${pageContext.request.contextPath}/jquery/jquery-1.4.2.js"></script>
		<link rel="stylesheet" href="${pageContext.request.contextPath}/jquery/jquery.datepick.css" type="text/css">
		<script type="text/javascript" src="${pageContext.request.contextPath}/jquery/jquery.datepick.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/jquery/jquery.datepick-zh-CN.js"></script>
	</HEAD>
	<script type="text/javascript">
		$(document).ready(function(){
			//使用class属性处理  'yy-mm-dd' 设置格式"yyyy/mm/dd"
			$('#birthday').datepick({dateFormat: 'yy-mm-dd'}); 
		});
	</script>
	<body>
	<% User user = (User)request.getAttribute("user"); %>
		<form id="userAction_save_do" name="Form1" action="${pageContext.request.contextPath}/update" method="post" enctype="multipart/form-data">
			&nbsp;
			<table cellSpacing="1" cellPadding="5" width="100%" align="center" bgColor="#eeeeee" style="border: 1px solid #8ba7e3" border="0">
				<input type="hidden" name="userID" value="<%=user.getUserID() %>" id="userID"/>
				<input type="hidden" name="path" value="D:\apache-tomcat-6.0.18\webapps\itcastStrutsProject\upload/2012/03/29/&#36153;&#29992;&#25253;&#38144;&#21333;&#27169;&#26495;.doc" id="path"/>
				<input type="hidden" name="filename1" value="<%=user.getFilename() %>" id="filename"/>
				<tr>
					<td class="ta_01" align="center" bgColor="#afd1f3" colSpan="4"
						height="26">
						<strong><STRONG>编辑用户</STRONG>
						</strong>
					</td>
				</tr>
				
				<tr>
					<td width="18%" align="center" bgColor="#f5fafe" class="ta_01">
						登录名：
					</td>
					<td class="ta_01" bgColor="#ffffff" colspan="3">
						<input type="text" name="logonName" value="<%=user.getLogonName() %>" id="userAction_save_do_logonName" class="bg" onblur="blur_loginname()" onfocus="focus_loginname()"/>
						<span  id="result_loginname"></span>  
					</td>
				</tr>
				<tr>
					<td align="center" bgColor="#f5fafe" class="ta_01">
						 密码：
					</td>
					<td class="ta_01" bgColor="#ffffff">
						<input type="password" name="logonPwd" value="<%=user.getLogonPwd() %>" id="logonPwd"  onblur="blur_pwd()" onfocus="focus_pwd()"/>
						<span  id="result_pwd"></span>
					</td>
					<td align="center" bgColor="#f5fafe" class="ta_01">
						用户姓名：
					</td>
					<td class="ta_01" bgColor="#ffffff">
						<input type="text" name="userName" value="<%=user.getUserName() %>" id="userAction_save_do_userName" class="bg" onblur="blur_username()" onfocus="focus_username()"/>
						<span  id="result_name"></span>
					</td>
				</tr>
				<tr>
					<td align="center" bgColor="#f5fafe" class="ta_01">
						性别：
					</td>
					<td class="ta_01" bgColor="#ffffff">
						<input type="radio" name="sex" id="sex男" value="男"<%=(user.getSex()==null?"":user.getSex()).equals("男")?"checked='checked'":"" %>/><label for="sex男">男</label>
						<input type="radio" name="sex" id="sex女" value="女"<%=(user.getSex()==null?"":user.getSex()).equals("女")?"checked='checked'":"" %>/><label for="sex女">女</label>

					</td>
					<td align="center" bgColor="#f5fafe" class="ta_01">
						学历：
					</td>
					<td class="ta_01" bgColor="#ffffff">
						
						
						<select name="education" id="education">
						    <option value=""
						    >--选择学历--</option>
						    <option value="博士"<%=(user.getEducation()==null?"":user.getEducation()).equals("博士")?"selected='selected'":"" %>>博士</option>
						    <option value="硕士"<%=(user.getEducation()==null?"":user.getEducation()).equals("硕士")?"selected='selected'":"" %>>硕士</option>
						    <option value="研究生" <%=(user.getEducation()==null?"":user.getEducation()).equals("研究生")?"selected='selected'":"" %>>研究生</option>
						    <option value="本科"<%=(user.getEducation()==null?"":user.getEducation()).equals("本科")?"selected='selected'":"" %>>本科</option>
						    <option value="专科"<%=(user.getEducation()==null?"":user.getEducation()).equals("专科")?"selected='selected'":"" %>>专科</option>
						    <option value="高中"<%=(user.getEducation()==null?"":user.getEducation()).equals("高中")?"selected='selected'":"" %>>高中</option>
						
						
						</select>

					</td>
				</tr>
				<tr>
					<td align="center" bgColor="#f5fafe" class="ta_01">
						出生日期：
					</td>
					<td class="ta_01" bgColor="#ffffff">
						<input type="text" name="birthday" size="20" value="<%=user.getBirthday() %>" readonly="readonly" id="birthday"/>
					</td>
					<td align="center" bgColor="#f5fafe" class="ta_01">
						电话：
					</td>
					<td class="ta_01" bgColor="#ffffff">
						<input type="text" name="telephone" value="<%=user.getTelephone() %>" id="telephone" onblur="blur_tel()" onfocus="focus_tel()"/>
						<span  id="result_tel"></span>
					</td>
				</tr>
				<tr>
					<td align="center" bgColor="#f5fafe" class="ta_01">
						兴趣爱好：
					</td>
					<td class="ta_01" bgColor="#ffffff" colSpan="3">
						 <input type="checkbox" name="interest" value="看电影" id="interest-1"<%=(user.getInterest()==null?"":user.getInterest()).contains("看电影")?"checked='checked'":"" %>/>
						<label for="interest-1" class="checkboxLabel">看电影</label>
						<input type="checkbox" name="interest" value="旅游" id="interest-2" <%=(user.getInterest()==null?"":user.getInterest()).contains("旅游")?"checked='checked'":"" %>/>
						<label for="interest-2" class="checkboxLabel">旅游</label>
						<input type="checkbox" name="interest" value="健身" id="interest-3" <%=(user.getInterest()==null?"":user.getInterest()).contains("健身")?"checked='checked'":"" %>/>
						<label for="interest-3" class="checkboxLabel">健身</label>
						<input type="checkbox" name="interest" value="购物" id="interest-4" <%=(user.getInterest()==null?"":user.getInterest()).contains("购物")?"checked='checked'":"" %>/>
						<label for="interest-4" class="checkboxLabel">购物</label>
						<input type="checkbox" name="interest" value="睡觉" id="interest-5" <%=(user.getInterest()==null?"":user.getInterest()).contains("睡觉")?"checked='checked'":"" %>/>
						<label for="interest-5" class="checkboxLabel">睡觉</label>
						<input type="hidden" id="__multiselect_userAction_save_do_interest" name="__multiselect_interest" value="" /> 
					</td>
				</tr>
				<tr>
					<td align="center" bgColor="#f5fafe" class="ta_01">
						简历资料：
					</td>
					<td class="ta_01" bgColor="#ffffff" colSpan="3">				
						
						<input type="button" value="修改文件" onclick="javascript:$('input[name=\'file\']').click();" />
						<input name="upload"  value=<%=user.getFilename() %> />
						<input type="file" name="file" style="display: none;" onchange="javascript:$('input[name=\'upload\']').val(this.files[0].name);" />
						<input type="hidden" name="myfilename" value="<%=user.getFilename()%>">
						<input type="hidden" name="myfilepath" value="<%=user.getPath()%>">

						
						
					</td>
				</tr>
				<TR>
					<TD class="ta_01" align="center" bgColor="#f5fafe">
						备注：
					</TD>
					<TD class="ta_01" bgColor="#ffffff" colSpan="3">
						<textarea name="remark" cols="30" rows="3" id="userAction_save_do_remark" style="WIDTH: 96%"><%=user.getRemark() %></textarea>
					</TD>
				</TR>
				<TR>
					<td align="center" colSpan="4" class="sep1">
						<img src="${pageContext.request.contextPath}/images/shim.gif">
					</td>
				</TR>
				<tr>
					<td class="ta_01" style="WIDTH: 100%" align="center"
						bgColor="#f5fafe" colSpan="4">
						<button type="submit" id="userAction_save_do_submit" name="submit" value="&#30830;&#23450;" class="button_ok">
							&#30830;&#23450;
						</button>

						<FONT face="宋体">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</FONT>
						<button type="reset" value="&#37325;&#32622;" class="button_cancel">&#37325;&#32622;</button>

						<FONT face="宋体">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</FONT>
						<INPUT class="button_ok" type="button" onclick="history.go(-1)" value="返回"/>
						<span id="Label1"></span>
					</td>
				</tr>
			</table>
		</form>




	</body>
</HTML>