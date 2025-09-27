<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <title><sitemesh:write property='title'>DS1 - User</sitemesh:write></title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/site.css"/>
    <sitemesh:write property='head'/>
</head>
<body>
<header style="padding:12px;background:#0d6efd;color:#fff;">
    <nav>
        <a style="color:#fff;margin-right:12px" href="${pageContext.request.contextPath}/">Trang Chủ</a>
        <a style="color:#fff;margin-right:12px" href="${pageContext.request.contextPath}/products">Sản phẩm</a>
        <c:if test="${not empty sessionScope.currentUser}">
            <a style="color:#fff;margin-right:12px" href="${pageContext.request.contextPath}/categories">Categories</a>
        </c:if>
        <c:choose>
            <c:when test="${empty sessionScope.currentUser}">
                <a style="color:#fff;margin-right:12px" href="${pageContext.request.contextPath}/login">Đăng nhập</a>
                <a style="color:#fff" href="${pageContext.request.contextPath}/register">Đăng ký</a>
            </c:when>
            <c:otherwise>
                <span style="margin-right:12px">Xin chào, ${sessionScope.currentUser.fullname}</span>
                <a style="color:#fff;margin-right:12px" href="${pageContext.request.contextPath}/logout">Đăng xuất</a>
            </c:otherwise>
        </c:choose>
        <c:if test="${sessionScope.isAdmin}">
            <a style="color:#ffc107;margin-left:20px" href="${pageContext.request.contextPath}/admin/videos">Trang quản trị</a>
        </c:if>
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