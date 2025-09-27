<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:if test="${not empty error}">
    <div style="color:#dc3545;margin-bottom:8px;">${error}</div>
</c:if>
<c:if test="${not empty video}">
    <div style="display:flex;gap:24px;align-items:flex-start;">
        <img src="${pageContext.request.contextPath}/assets/posters/${video.poster}" alt="${video.title}" style="width:300px;height:200px;object-fit:cover;border:1px solid #ddd;"/>
        <div>
            <h2>${video.title}</h2>
            <div><b>Mã video:</b> ${video.id}</div>
            <div><b>Category name:</b> ${video.category != null ? video.category.name : ''}</div>
            <div><b>View:</b> ${video.views}</div>
            <div><b>Share:</b> (${shareCount})</div>
            <div><b>Like:</b> (${likeCount})</div>
            <div style="margin-top:12px;"><b>Description:</b><br/>${video.description}</div>
        </div>
    </div>
</c:if>
