<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<h2>Đăng ký</h2>
<c:if test="${not empty error}">
    <div style="color:#dc3545;margin-bottom:8px;">${error}</div>
</c:if>
<form method="post" action="${pageContext.request.contextPath}/register">
    <div>
        <label>Username:</label>
        <input name="username" value="${user.username}" required maxlength="50"/>
    </div>
    <div>
        <label>Password:</label>
        <input type="password" name="password" required maxlength="50"/>
    </div>
    <div>
        <label>Họ tên:</label>
        <input name="fullname" value="${user.fullname}" maxlength="50"/>
    </div>
    <div>
        <label>Email:</label>
        <input name="email" value="${user.email}" maxlength="150"/>
    </div>
    <div>
        <label>Số điện thoại:</label>
        <input name="phone" value="${user.phone}" maxlength="15"/>
    </div>
    <button type="submit">Đăng ký</button>
</form>
<p>Đã có tài khoản? <a href="${pageContext.request.contextPath}/login">Đăng nhập</a></p>