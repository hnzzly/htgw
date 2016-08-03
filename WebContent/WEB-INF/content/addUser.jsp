<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<s:head></s:head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>欢腾购物频道MARS信息系统</title>
</head>
<body>
<h1>欢腾购物频道MARS信息系统</h1>
<h3>添加用户</h3>
<s:form action="addUser" >

	<s:textfield label="用户名" name="user.name" />
	<s:textfield label="年龄"  name="user.age" />
	<s:textfield label="手机"  name="user.cellphone" />
	<s:textfield label="密码"  name="user.password" />
	
	<s:optiontransferselect label="请选择角色" name="select1"  list="roles" listKey="roleId" listValue="name" doubleName="sRoles"
                           doubleList="" addAllToLeftLabel="全部不选" addAllToRightLabel="全选" addToLeftLabel="不选"
                           addToRightLabel="选择" allowAddAllToLeft="true" allowAddToLeft="true" allowAddToRight="true"
                           allowAddAllToRight="true" allowUpDownOnLeft="false" allowUpDownOnRight="false"  allowSelectAll="true"
                           cssStyle="width:120px;height:230px;" doubleCssStyle="width:120px;height:230px"
      />
	<s:optiontransferselect label="请选择用户权限" name="select3"  list="authorities" listKey="authorityId" listValue="name" doubleName="sAuthorities"
                           doubleList="" addAllToLeftLabel="全部不选" addAllToRightLabel="全选" addToLeftLabel="不选"
                           addToRightLabel="选择" allowAddAllToLeft="true" allowAddToLeft="true" allowAddToRight="true"
                           allowAddAllToRight="true" allowUpDownOnLeft="false" allowUpDownOnRight="false"  allowSelectAll="true"
                           cssStyle="width:120px;height:230px;" doubleCssStyle="width:120px;height:230px"
      />
	<s:submit value="提交" align="left"/>
</s:form>
</body>
</html>