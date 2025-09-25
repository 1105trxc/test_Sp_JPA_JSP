<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<%@ include file="/WEB-INF/includes/header-user.jsp" %>
<h1>Chào mừng đến Book Store</h1>
<p>Đây là trang chủ.</p>
<c:if test="${not empty sessionScope.currentUser}">
    <p>Bạn đang đăng nhập với email: ${sessionScope.currentUser.email}</p>
</c:if>
<%@ include file="/WEB-INF/includes/footer.jsp" %>