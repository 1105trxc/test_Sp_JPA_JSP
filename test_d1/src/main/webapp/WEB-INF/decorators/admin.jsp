<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <title><sitemesh:write property='title'>Admin - DS1</sitemesh:write></title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/site.css"/>
    <sitemesh:write property='head'/>
</head>
<body>
<header style="padding:12px;background:#212529;color:#fff;">
    <nav>
        <a style="color:#fff;margin-right:12px" href="${pageContext.request.contextPath}/">Trang Chủ</a>
        <a style="color:#fff;margin-right:12px" href="${pageContext.request.contextPath}/products">Sản phẩm</a>
        <a style="color:#fff;margin-right:12px" href="${pageContext.request.contextPath}/categories">Categories</a>
        <a style="color:#fff;margin-right:12px" href="${pageContext.request.contextPath}/admin/videos">Quản trị Video</a>
        <a style="color:#fff" href="${pageContext.request.contextPath}/logout">Đăng xuất</a>
    </nav>
</header>

<main style="min-height:70vh;padding:16px;">
    <sitemesh:write property='body'/>
</main>

<footer style="padding:16px;background:#f1f1f1;text-align:center;">
    Họ tên: Trác Ngọc Đăng Khoa, MSSV: 23110243, Mã đề: DS1
</footer>
</body>
</html>