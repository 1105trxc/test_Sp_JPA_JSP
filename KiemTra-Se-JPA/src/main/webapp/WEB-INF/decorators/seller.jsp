<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html lang="vi">
<head>
  <meta charset="UTF-8"/>
  <title><sitemesh:write property="title">Admin - DS10</sitemesh:write></title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/site.css"/>
  <sitemesh:write property="head"/>
</head>
<body>
<header class="header admin">
  <nav>
    <a href="${pageContext.request.contextPath}/home">Trang Chủ</a>
    <a href="${pageContext.request.contextPath}/products">Sản phẩm</a>
    <a href="${pageContext.request.contextPath}/admin">Trang quản trị</a>
    <a href="${pageContext.request.contextPath}/logout">Đăng xuất</a>
  </nav>
</header>
<main class="container">
  <sitemesh:write property="body"/>
</main>
<footer class="footer">
  Họ tên: Trác Ngọc Đăng Khoa — MSSV: 23110243 — Mã đề: Đề số 10
</footer>
</body>
</html>