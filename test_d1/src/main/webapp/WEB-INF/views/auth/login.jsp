<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<h2>Đăng nhập</h2>
<c:if test="${not empty param.required}">
    <div style="color:#dc3545;margin-bottom:8px;">Bạn cần đăng nhập quyền Admin để truy cập.</div>
</c:if>
<c:if test="${not empty error}">
    <div style="color:#dc3545;margin-bottom:8px;">${error}</div>
</c:if>
<c:if test="${param.logout != null}">
    <div style="color:#198754;margin-bottom:8px;">Đã đăng xuất.</div>
</c:if>
<form method="post" action="${pageContext.request.contextPath}/login">
    <div>
        <label>Username:</label>
        <input name="username" required maxlength="50"/>
    </div>
    <div>
        <label>Password:</label>
        <input type="password" name="password" required maxlength="50"/>
    </div>
    <button type="submit">Đăng nhập</button>
</form>
<p>Chưa có tài khoản? <a href="${pageContext.request.contextPath}/register">Đăng ký</a></p>