<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html lang="vi">
<head>
  <title>Đăng ký</title>
</head>
<body>
<h2>Đăng ký</h2>
<c:if test="${not empty error}">
  <div class="alert-error">${error}</div>
</c:if>
<form method="post" action="${pageContext.request.contextPath}/register">
  <label>Username</label><br/>
  <input type="text" name="username" required/><br/>
  <label>Họ tên</label><br/>
  <input type="text" name="fullname"/><br/>
  <label>Email</label><br/>
  <input type="email" name="email"/><br/>
  <label>Password</label><br/>
  <input type="password" name="password" required/><br/><br/>
  <button type="submit">Đăng ký</button>
</form>
</body>
</html>