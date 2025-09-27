<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<h2>Danh sách Video theo Category</h2>
<c:forEach var="cat" items="${categories}">
    <div style="margin-bottom:32px;">
        <h3>${cat.name} (${cat.videoCount})</h3>
        <c:if test="${not empty cat.videos}">
            <div style="display:grid;grid-template-columns:repeat(3,1fr);gap:16px;">
                <c:forEach var="video" items="${cat.videos}">
                    <div style="border:1px solid #ddd;padding:8px;">
                        <img src="${pageContext.request.contextPath}/assets/posters/${video.poster}" alt="${video.title}" style="width:100%;height:150px;object-fit:cover"/>
                        <h4><a href="${pageContext.request.contextPath}/products/${video.id}">${video.title}</a></h4>
                        <div><b>Mã video:</b> ${video.id}</div>
                        <div><b>Category name:</b> ${cat.name}</div>
                        <div><b>View:</b> ${video.views}</div>
                        <div><b>Share:</b> (${video.shareCount})</div>
                        <div><b>Like:</b> (${video.likeCount})</div>
                    </div>
                </c:forEach>
            </div>
        </c:if>
        <c:if test="${empty cat.videos}">
            <div>Không có video nào trong category này.</div>
        </c:if>
    </div>
</c:forEach>