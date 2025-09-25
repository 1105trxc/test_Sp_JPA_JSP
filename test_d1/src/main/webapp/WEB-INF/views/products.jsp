<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<h2>Danh sách Video</h2>
<c:set var="p" value="${page}"/>
<div style="display:grid;grid-template-columns:repeat(3,1fr);gap:12px;">
    <c:forEach var="v" items="${p.content}">
        <div style="border:1px solid #ddd;padding:8px;">
            <img src="${pageContext.request.contextPath}/assets/posters/${v.poster}" alt="${v.title}" style="width:100%;height:150px;object-fit:cover"/>
            <h4>${v.title}</h4>
            <p>${v.description}</p>
            <small>Lượt xem: ${v.views}</small>
        </div>
    </c:forEach>
</div>

<div style="margin-top:16px;">
    <c:forEach var="i" begin="0" end="${p.totalPages - 1}">
        <a style="margin-right:6px; ${i==p.number?'font-weight:bold;':''}"
           href="?page=${i}">${i + 1}</a>
    </c:forEach>
</div>