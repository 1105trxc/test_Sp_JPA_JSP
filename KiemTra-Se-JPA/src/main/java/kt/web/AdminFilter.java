package kt.web;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import kt.entity.User;

import java.io.IOException;

public class AdminFilter implements Filter {
  @Override
  public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
    HttpServletRequest request = (HttpServletRequest) req;
    HttpServletResponse response = (HttpServletResponse) res;
    HttpSession session = request.getSession(false);
    User u = (session != null) ? (User) session.getAttribute("currentUser") : null;

    boolean isAdmin = u != null && u.getRole() != null && "ADMIN".equalsIgnoreCase(u.getRole().getRoleName());
    if (!isAdmin) {
      response.sendRedirect(request.getContextPath() + "/login");
      return;
    }
    chain.doFilter(req, res);
  }
}