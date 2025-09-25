<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<h2>Quản trị Videos</h2>

<div style="display:grid;grid-template-columns:1fr 2fr;gap:16px;">
    <div style="border:1px solid #ddd;padding:12px;">
        <h3>Thêm / Sửa Video</h3>
        <form method="post" action="${pageContext.request.contextPath}/admin/videos/save">
            <div>
                <label>VideoId:</label>
                <input name="id" value="${video.id}" maxlength="50" required/>
            </div>
            <div>
                <label>Title:</label>
                <input name="title" value="${video.title}" maxlength="200" required/>
            </div>
            <div>
                <label>Poster (tên file):</label>
                <input name="poster" value="${video.poster}" maxlength="50"/>
            </div>
            <div>
                <label>Views:</label>
                <input type="number" name="views" value="${video.views}"/>
            </div>
            <div>
                <label>Description:</label>
                <textarea name="description" maxlength="500" rows="3">${video.description}</textarea>
            </div>
            <div>
                <label>Active:</label>
                <input type="checkbox" name="active" value="true" <c:if test="${video.active}">checked</c:if> />
            </div>
            <div>
                <label>Category:</label>
                <select name="category.id">
                    <c:forEach var="c" items="${categories}">
                        <option value="${c.id}" <c:if test="${video.category != null && video.category.id == c.id}">selected</c:if>>${c.name}</option>
                    </c:forEach>
                </select>
            </div>
            <button type="submit">Lưu</button>
        </form>
    </div>

    <div>
        <h3>Danh sách</h3>
        <c:set var="p" value="${page}"/>
        <table border="1" cellpadding="6" cellspacing="0" width="100%">
            <thead>
            <tr>
                <th>ID</th><th>Title</th><th>Views</th><th>Active</th><th>Category</th><th>Actions</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="v" items="${p.content}">
                <tr>
                    <td>${v.id}</td>
                    <td>${v.title}</td>
                    <td>${v.views}</td>
                    <td><c:out value="${v.active}"/></td>
                    <td><c:out value="${v.category != null ? v.category.name : ''}"/></td>
                    <td>
                        <a href="${pageContext.request.contextPath}/admin/videos/edit/${v.id}">Sửa</a>
                        <form method="post" action="${pageContext.request.contextPath}/admin/videos/delete/${v.id}" style="display:inline" onsubmit="return confirm('Xoá video?')">
                            <button type="submit">Xoá</button>
                        </form>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>

        <div style="margin-top:12px;">
            <c:forEach var="i" begin="0" end="${p.totalPages - 1}">
                <a style="margin-right:6px; ${i==p.number?'font-weight:bold;':''}"
                   href="?page=${i}">${i + 1}</a>
            </c:forEach>
        </div>
    </div>
</div>