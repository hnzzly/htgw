<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>huan teng</title>
</head>
<body>
<h1>欢腾购物频道MARS信息系统</h1>
<h3>${tip}</h3>
<s:form action="login">
	<s:textfield name="userName" label="用户名"/>
	<s:password name="password" label="密码"/>
	<s:submit value="登录"/>




</s:form>
</body>
</html>