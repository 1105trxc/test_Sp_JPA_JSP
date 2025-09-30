<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html lang="vi">
<head>
  <title>Đăng nhập</title>
</head>
<body>
<h2>Đăng nhập</h2>
<c:if test="${not empty error}">
  <div class="alert-error">${error}</div>
</c:if>
<form method="post" action="${pageContext.request.contextPath}/login">
  <label>Username</label><br/>
  <input type="text" name="username" required/><br/>
  <label>Password</label><br/>
  <input type="password" name="password" required/><br/><br/>
  <button type="submit">Đăng nhập</button>
</form>
<p>Chưa có tài khoản? <a href="${pageContext.request.contextPath}/register">Đăng ký</a></p>
</body>
</html>