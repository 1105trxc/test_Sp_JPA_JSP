<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html lang="vi">
<head>
  <title>Tất cả sản phẩm</title>
</head>
<body>
<h2>Danh sách sản phẩm theo từng cửa hàng (Seller)</h2>

<c:forEach var="s" items="${sellers}">
  <div class="seller-block">
    <h3>Mã cửa hàng: <span>${s.sellerId}</span> — <span>${s.sellerName}</span></h3>
    <div class="product-grid">
      <c:forEach var="p" items="${s.products}">
        <div class="product-card">
          <img src="${pageContext.request.contextPath}/assets/images/${p.images}" alt="${p.productName}"
               onerror="this.src='${pageContext.request.contextPath}/assets/images/placeholder.jpg'"/>
          <div class="product-info">
            <div><b>Tên sản phẩm:</b> ${p.productName}</div>
            <div><b>Mã sản phẩm:</b> ${p.productId}</div>
            <div><b>Danh mục:</b> <c:out value="${p.category != null ? p.category.categoryName : ''}"/></div>
            <div><b>Giá:</b> ${p.price}</div>
            <div><b>Amount:</b> ${p.amount}</div>
          </div>
        </div>
      </c:forEach>
    </div>
  </div>
</c:forEach>
</body>
</html>