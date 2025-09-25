<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<%@ include file="/WEB-INF/includes/header-user.jsp" %>
<h2>Đăng nhập</h2>
<form method="post" action="${pageContext.request.contextPath}/login">
    <label>Email: <input name="email" type="email" required/></label><br/>
    <label>Mật khẩu: <input name="password" type="password" required/></label><br/>
    <button type="submit">Đăng nhập</button>
</form>
<c:if test="${not empty error}">
    <p style="color:red">${error}</p>
</c:if>
<c:if test="${not empty msg}">
    <p style="color:green">${msg}</p>
</c:if>
<%@ include file="/WEB-INF/includes/footer.jsp" %>