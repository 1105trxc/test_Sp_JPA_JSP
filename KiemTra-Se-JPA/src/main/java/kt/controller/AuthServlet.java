package kt.controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import kt.entity.User;
import kt.service.AuthService;
import kt.service.impl.AuthServiceImpl;
import java.io.IOException;

@WebServlet(urlPatterns = {"/login", "/register", "/logout"})
public class AuthServlet extends HttpServlet {
  private final AuthService authService = new AuthServiceImpl();

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String path = req.getServletPath();
    if ("/logout".equals(path)) {
      req.getSession().invalidate();
      resp.sendRedirect(req.getContextPath() + "/home");
      return;
    }
    String view = "/login".equals(path) ? "/WEB-INF/views/auth/login.jsp" : "/WEB-INF/views/auth/register.jsp";
    req.getRequestDispatcher(view).forward(req, resp);
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String path = req.getServletPath();
    if ("/login".equals(path)) {
      String username = req.getParameter("username");
      String password = req.getParameter("password");
      User u = authService.login(username, password);
      if (u == null) {
        req.setAttribute("error", "Sai username hoặc mật khẩu");
        req.getRequestDispatcher("/WEB-INF/views/auth/login.jsp").forward(req, resp);
        return;
      }
      req.getSession().setAttribute("currentUser", u);
      // Nếu là admin thì vào trang admin, còn lại user
      if (u.getRole() != null && "ADMIN".equalsIgnoreCase(u.getRole().getRoleName())) {
        resp.sendRedirect(req.getContextPath() + "/admin");
      } else {
        resp.sendRedirect(req.getContextPath() + "/home");
      }
      return;
    }
    if ("/register".equals(path)) {
      String username = req.getParameter("username");
      String email = req.getParameter("email");
      String fullname = req.getParameter("fullname");
      String password = req.getParameter("password");
      User u = authService.register(username, email, fullname, password);
      if (u == null) {
        req.setAttribute("error", "Username đã tồn tại");
        req.getRequestDispatcher("/WEB-INF/views/auth/register.jsp").forward(req, resp);
        return;
      }
      req.getSession().setAttribute("currentUser", u);
      resp.sendRedirect(req.getContextPath() + "/home");
    }
  }
}