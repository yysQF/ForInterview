<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath %>">
<meta charset="UTF-8">
<title>页面偷跑了～</title>
<link rel="stylesheet" href="<%=basePath+"css/main.css"%>" />
</head>
<body>
	<div class="error">
		当前页面找不到，可能发生了${error}的错误！
	</div>
</body>
</html>