<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<%@ include file="/WEB-INF/includes/header-user.jsp" %>
<h2>Đăng ký</h2>
<form method="post" action="/register">
    <label>Họ tên: <input name="fullname" required/></label><br/>
    <label>Email: <input name="email" type="email" required/></label><br/>
    <label>Phone: <input name="phone" type="number"/></label><br/>
    <label>Mật khẩu: <input name="passwd" type="password" required/></label><br/>
    <button type="submit">Đăng ký</button>
</form>
<%@ include file="/WEB-INF/includes/footer.jsp" %>