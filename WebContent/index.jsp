<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.listener.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>游客页面</h1>
	<a href="<c:url value='/index.jsp'></c:url>">游客入口</a>
	<br>
	<a href="<c:url value='/users/user.jsp'></c:url>">会员入口</a>
	<br>
	<a href="<c:url value='/admin/admin.jsp'></c:url>">管理员入口</a>
	<br>
</body>
</html>