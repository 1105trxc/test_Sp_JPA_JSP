<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<%
  String ctx = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8"/>
  <title><c:out value="${title != null ? title : 'BookStore'}"/></title>
  <style>
    body { font-family: Arial, sans-serif; margin:0; padding:0;}
    header, footer { background:#0d6efd; color:#fff; padding:10px 20px;}
    nav a { color:#fff; margin-right:15px; text-decoration:none; }
    nav a:hover { text-decoration:underline; }
    .container { padding:20px;}
  </style>
</head>
<body>
<header>
  <nav>
    <a href="<%=ctx%>/">Trang Chủ</a>
    <a href="<%=ctx%>/products">Sản phẩm</a>
    <c:choose>
      <c:when test="${empty sessionScope.currentUser}">
        <a href="<%=ctx%>/login">Đăng nhập</a>
        <a href="<%=ctx%>/register">Đăng ký</a>
      </c:when>
      <c:otherwise>
        <c:if test="${sessionScope.currentUser.is_admin}">
          <a href="<%=ctx%>/admin">Trang quản trị</a>
        </c:if>
        <a href="<%=ctx%>/logout">Đăng xuất (${sessionScope.currentUser.fullname})</a>
      </c:otherwise>
    </c:choose>
  </nav>
</header>
<div class="container">