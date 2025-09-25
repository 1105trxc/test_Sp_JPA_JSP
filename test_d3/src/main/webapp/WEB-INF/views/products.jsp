<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<%@ include file="/WEB-INF/includes/header-user.jsp" %>
<h2>Danh sách Sách</h2>
<table border="1" cellpadding="5" cellspacing="0">
    <tr>
        <th>Ảnh</th>
        <th>Tiêu đề</th>
        <th>Tác giả</th>
        <th>NXB</th>
        <th>Giá</th>
        <th>Số lượng</th>
        <th>Điểm TB</th>
    </tr>
    <c:forEach var="b" items="${books}">
        <tr>
            <td>
                <c:if test="${not empty b.cover_image}">
                    <img src="/images/${b.cover_image}" alt="${b.title}" style="height:60px"/>
                </c:if>
            </td>
            <td>${b.title}</td>
            <td>
                <c:forEach var="a" items="${b.authors}" varStatus="st">
                    ${a.author_name}<c:if test="${!st.last}">, </c:if>
                </c:forEach>
            </td>
            <td>${b.publisher}</td>
            <td>${b.price}</td>
            <td>${b.quantity}</td>
            <td><fmt:formatNumber value="${b.averageRating}" maxFractionDigits="1"/></td>
        </tr>
    </c:forEach>
</table>
<%@ include file="/WEB-INF/includes/footer.jsp" %>