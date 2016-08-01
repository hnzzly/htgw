<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>欢腾购物频道MARS信息系统</title>
</head>
<body>
<h1>欢腾购物频道MARS信息系统</h1>
<h3>修改用户信息</h3>
<s:form action="updateUser">
	<s:textfield label="用户编号" name="user.userId" readonly="true" />
	<s:textfield label="用户名" name="user.name" />
	<s:textfield label="年龄"  name="user.age" />
	<s:textfield label="手机"  name="user.cellphone" />
	<s:textfield label="密码"  name="user.password" />
	<s:submit value="提交"/>
</s:form>
</body>
</html>