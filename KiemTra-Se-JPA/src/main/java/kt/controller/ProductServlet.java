package kt.controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import kt.entity.Seller;
import jakarta.servlet.annotation.*;
import kt.service.ProductService;
import kt.service.impl.ProductServiceImpl;

import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/products")
public class ProductServlet extends HttpServlet {
  private final ProductService productService = new ProductServiceImpl();

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    List<Seller> sellers = productService.listBySeller();
    req.setAttribute("sellers", sellers);
    req.getRequestDispatcher("/WEB-INF/views/products.jsp").forward(req, resp);
  }
}