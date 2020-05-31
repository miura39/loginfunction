<%@page import="model.Login"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<p>welocom:<%=request.getAttribute("userId")%> </p>
<a href ="/loginfunction/WelcomeServlet">トップへ</a>
</body>
</html>