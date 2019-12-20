<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<%
	String path=request.getScheme()+"://"+
				request.getServerName()+":"+
				request.getServerPort()+
				request.getContextPath()+"/";
%>
<base href="<%=path %>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>briup电子商务-注册页</title>
<link rel="stylesheet" href="css/common.css"/>
<link rel="stylesheet" href="css/style.css" />
</head>
<body>
	<div class="container2">
    	<div class="header2">
        	<div>
            	<a href="index.jsp"><img class="logo" src="images/logon_register.png"></a>
            </div>
            <div>
            	<ul class="tabs">
                	<li class="phone current">用手机登陆</li>
                </ul>
            </div>
            <div class="tlg">
            	已有账号 <a href="toLogin">登陆</a>
            </div>
        </div>
        <div class="content2">
        	<!-- 显示错误信息 -->
        	<div style="width: 500px;height: 30px;text-align: center;
        			margin-left: 100px;">
        		<span style="color: red;font-size: 20px">${requestScope.msg }</span>
        	</div>
        <form action="register_Form" method="post">
			<ul class="reg_box">
            	<li>
                	<span><b>*</b>用户名：</span>
                    <input type="text" name="name" required="required"/>
                </li>
               <li>
                	<span><b>*</b>密码：</span>
                    <input type="password" name="password" required="required"/>
                </li>
                <li>
                	<span><b>*</b>邮编：</span>
                    <input type="text" name="zipCode" required="required"/>
                </li>
                <li>
                	<span><b>*</b>地址：</span>
                    <input type="text" name="address" placeholder="国家-城市-街道" pattern=".+-.+-.+"/>
                </li>
                <li>
                	<span><b>*</b>电话：</span>
                    <input type="text" name="telephone" required="required"/>
                </li>
                <li>
                	<span><b>*</b>电子邮箱：</span>
                    <input type="text" name="email" required="required"/>
                </li>
            </ul>
			<p>
            	<input type="checkbox" checked/>
               	 我已阅读并同意
                <a href="#">用户注册协议</a>
            </p>
            <input class="btn_submit" type="submit" value="立即注册"/>
           </form>
        </div>
   	</div>
</body>
</html>
