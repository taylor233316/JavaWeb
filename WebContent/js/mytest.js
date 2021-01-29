var flag_usename = false;  
var flag_logname = false;
var flag_logpwd = false;

// flag 如果为true（即用户名合法）就允许表单提交， 如果为false（即用户名不合法）阻止提交
// 当鼠标聚焦于用户名
function focus_username()
{
    // 找到后面的div, id = result_name
    var nameObj = document.getElementById("result_name");
    nameObj.innerHTML = "用户名只能有字母，数字和下划线且为4~20位";
    nameObj.style.color="#999";
}
// 当鼠标不聚焦于用户名input
function blur_username()
{
    // 找到id=result_name的div
    var nameObj = document.getElementById("result_name");
    // 判断用户名是否合法
    var str2 = check_user_name(document.Form1.userName.value);
    nameObj.style.color="red";
    if ("该名称合法" ==  str2)
    {
        flag_usename = true;
        nameObj.innerHTML = str2;
    }
    else
    {
        nameObj.innerHTML = str2;
		
    }

}   
// 检查用户名是否合法        合法就返回"该用户名合法"
function check_user_name(str)
{
    var str2 = "该名称合法";
    if ("" == str)
    {
        str2 = "名称为空";
        return str2;
    }
    else if ((str.length < 4) || (str.length > 20))
    {
        str2 = "名称必须为4 ~ 20位";
        return str2;
    }
    else if (check_other_char(str))
    {
        str2 = "只能有字母，数字和下划线";
        return str2;
    }
    return str2;
}


function check_other_char(str)
{
	var re = /^[0-9a-zA-Z_]{1,}$/;
	if (re.test(str)) {	
       return false;
    } else {
        return true;
    } 
}

//---------------------------------------密码---------------------------------
function focus_pwd()
{
    // 找到后面的div, id = result_name
    var pwdObj = document.getElementById("result_pwd");
    pwdObj.innerHTML = "密码为5~15位且只能有字母，数字和下划线";
    pwdObj.style.color="#999";
}
// 当鼠标不聚焦于密码input
function blur_pwd()
{
    // 找到id=result_name的div
    var pwdObj = document.getElementById("result_pwd");
    // 判断密码是否合法
    var str2 = check_user_pwd(document.Form1.logonPwd.value);
    pwdObj.style.color="red";
    if ("密码合法" ==  str2)
    {
        flag_logpwd = true;
        pwdObj.innerHTML = str2;
    }
    else
    {
        pwdObj.innerHTML = str2;
    }

}   
// 检查密码是否合法        合法就返回"密码合法"
function check_user_pwd(str)
{
    var str2 = "密码合法";
    if ("" == str)
    {
        str2 = "密码为空";
        return str2;
    }
    else if ((str.length < 5) || (str.length > 15))
    {
        str2 = "密码必须为5 ~ 15位";
        return str2;
    }
	else if (check_other_char(str))
    {
        str2 = "只能有字母，数字和下划线";
        return str2;
    }
    return str2;
}


//---------------------------------------电话---------------------------------
function focus_tel()
{
    // 找到后面的div, id = result_name
    var telObj = document.getElementById("result_tel");
    telObj.innerHTML = "手机号应为11位数字且以13-19开头";
    telObj.style.color="#999";
}
// 当鼠标不聚焦于密码input
function blur_tel()
{
    // 找到id=result_name的div
    var telObj = document.getElementById("result_tel");
    // 判断密码是否合法
    var str2 = check_user_tel(document.Form1.telephone.value);
    telObj.style.color="red";
    if ("号码合法" ==  str2)
    {
        flag = true;
        telObj.innerHTML = str2;
    }
    else
    {
        telObj.innerHTML = str2;
    }

}   
// 检查密码是否合法        合法就返回"密码合法"
function check_user_tel(str)
{
    var str2 = "号码合法";
	var re = /^1[345678]\d{9}$/ ;
    if ("" == str)
    {
        str2 = "号码为空";
        return str2;
    }
   
	else if (str.length!=11)
    {
        str2 = "号码必须是11位";
        return str2;
    }
	else if(!re.test(str))
	{
		str2 = "号码必须是13-19开头，必须是数字";
        return str2;
	}
    return str2;
}

function check_other_tel(str)
{
	var re = /^1[345678]\d{9}$/ ;
	if(re.test(str) && str.length==11) {
       return false;
    } else {
        return true;
    }
}
//------------------------------------------------------登录名----------------------------
function focus_loginname()
{
    // 找到后面的div, id = result_name
    var lognameObj = document.getElementById("result_loginname");
    lognameObj.innerHTML = "登录名只能有字母，数字和下划线且为4~20位";
    lognameObj.style.color="#999";
}
// 当鼠标不聚焦于用户名input
function blur_loginname()
{
    // 找到id=result_name的div
    var lognameObj = document.getElementById("result_loginname");
    // 判断用户名是否合法
    var str2 = check_user_name(document.Form1.logonName.value);
    lognameObj.style.color="red";
    if ("该名称合法" ==  str2)
    {
        flag_logname = true;
        lognameObj.innerHTML = str2;
		
    }
    else
    {
        lognameObj.innerHTML = str2;
    }

}   
// 根据验证结果确认是否提交
function check_submit()
{
	 if(flag_logname == false){
		alert("请填写登录名");
		return false;
	}
	else if(flag_logpwd == false){
		alert("请填写密码");
		return false;
	}
	 else if(flag_usename == false )
    {
        
		alert("请填写用户名");
		return false;
    }
	
    return true;
}